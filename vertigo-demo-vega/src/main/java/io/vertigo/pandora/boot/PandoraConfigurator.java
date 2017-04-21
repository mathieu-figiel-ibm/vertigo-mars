package io.vertigo.pandora.boot;

import org.h2.Driver;

import io.vertigo.app.config.AppConfig;
import io.vertigo.app.config.AppConfigBuilder;
import io.vertigo.app.config.DefinitionProviderConfigBuilder;
import io.vertigo.app.config.LogConfig;
import io.vertigo.app.config.ModuleConfigBuilder;
import io.vertigo.commons.impl.CommonsFeatures;
import io.vertigo.commons.plugins.cache.memory.MemoryCachePlugin;
import io.vertigo.core.param.Param;
import io.vertigo.core.plugins.resource.classpath.ClassPathResourceResolverPlugin;
import io.vertigo.core.plugins.resource.local.LocalResourceResolverPlugin;
import io.vertigo.dynamo.impl.DynamoFeatures;
import io.vertigo.dynamo.impl.database.vendor.h2.H2DataBase;
import io.vertigo.dynamo.plugins.database.connection.c3p0.C3p0ConnectionProviderPlugin;
import io.vertigo.dynamo.plugins.environment.DynamoDefinitionProvider;
import io.vertigo.dynamo.plugins.search.elasticsearch.embedded.ESEmbeddedSearchServicesPlugin;
import io.vertigo.dynamo.plugins.store.datastore.sql.SqlDataStorePlugin;
import io.vertigo.pandora.dao.movies.MovieDAO;
import io.vertigo.pandora.dao.movies.MoviesPAO;
import io.vertigo.pandora.dao.persons.ActorRoleDAO;
import io.vertigo.pandora.dao.persons.PersonDAO;
import io.vertigo.pandora.dao.persons.PersonsPAO;
import io.vertigo.pandora.domain.DtDefinitions;
import io.vertigo.pandora.services.common.CommonServices;
import io.vertigo.pandora.services.common.CommonServicesImpl;
import io.vertigo.pandora.services.masterdata.MasterdataServices;
import io.vertigo.pandora.services.masterdata.MasterdataServicesImpl;
import io.vertigo.pandora.services.movies.MovieSearchLoader;
import io.vertigo.pandora.services.movies.MovieServices;
import io.vertigo.pandora.services.movies.MovieServicesImpl;
import io.vertigo.pandora.services.persons.PersonSearchLoader;
import io.vertigo.pandora.services.persons.PersonServices;
import io.vertigo.pandora.services.persons.PersonServicesImpl;
import io.vertigo.pandora.user.LollipopUserSession;
import io.vertigo.pandora.webservices.common.CommonWebServices;
import io.vertigo.pandora.webservices.masterdata.MasterdataWebservices;
import io.vertigo.pandora.webservices.movies.MovieWebServices;
import io.vertigo.pandora.webservices.persons.PersonWebServices;
import io.vertigo.persona.impl.security.PersonaFeatures;
import io.vertigo.studio.impl.mda.MdaManagerImpl;
import io.vertigo.studio.mda.MdaManager;
import io.vertigo.studio.plugins.mda.domain.DomainGeneratorPlugin;
import io.vertigo.studio.plugins.mda.domain.JSGeneratorPlugin;
import io.vertigo.studio.plugins.mda.domain.SqlGeneratorPlugin;
import io.vertigo.studio.plugins.mda.task.TaskGeneratorPlugin;
import io.vertigo.studio.plugins.mda.webservice.WsJsGeneratorPlugin;
import io.vertigo.vega.VegaFeatures;
import io.vertigo.x.account.AccountFeatures;
import io.vertigo.x.account.plugins.memory.MemoryAccountStorePlugin;
import io.vertigo.x.notification.NotificationFeatures;
import io.vertigo.x.notification.plugins.memory.MemoryNotificationPlugin;
import io.vertigo.x.notification.webservices.NotificationWebServices;

public final class PandoraConfigurator {
	public static AppConfig config(final boolean activeStudio) {
		final String pandoraHome = System.getProperty("pandora.home", "d:/pandora");
		final int pandoraPort = Integer.parseInt(System.getProperty("pandora.port", "8080"));

		final AppConfigBuilder appConfigBuilder = new AppConfigBuilder()
				.beginBoot()
				.withLocales("fr")
				.addPlugin(ClassPathResourceResolverPlugin.class)
				.addPlugin(LocalResourceResolverPlugin.class)
				.withLogConfig(new LogConfig("/log4j.xml"))
				.endBoot();

		if (!activeStudio) {
			appConfigBuilder
					.addModule(new PersonaFeatures()
							.withUserSession(LollipopUserSession.class).build())
					.addModule(new CommonsFeatures().withCache(MemoryCachePlugin.class).withScript().build())
					.addModule(new DynamoFeatures()
							.withStore()
							.addDataStorePlugin(SqlDataStorePlugin.class,
									Param.create("sequencePrefix", "SEQ_"))
							.withSqlDataBase()
							.addSqlConnectionProviderPlugin(C3p0ConnectionProviderPlugin.class,
									Param.create("dataBaseClass", H2DataBase.class.getName()),
									Param.create("jdbcDriver", Driver.class.getName()),
									Param.create("jdbcUrl", "jdbc:h2:" + pandoraHome + "/data/demo"))
							.withSearch(ESEmbeddedSearchServicesPlugin.class,
									Param.create("home", pandoraHome + "/search"), //usage d'url impropre
									Param.create("envIndex", "test"),
									Param.create("rowsPerQuery", "50"),
									Param.create("config.file", "io/vertigo/pandora/boot/elasticsearch.yml"))
							/*.addComponent(KVStoreManager.class, KVStoreManagerImpl.class)
							.beginPlugin(BerkeleyKVStorePlugin.class)
								.addParam("collections", "allocine-movies,allocine-persons,allocine-queue-persons,allocine-queue-movies")
								.addParam("dbFilePath", pandoraHome+"/data")
							.endPlugin()*/
							.build())
					.addModule(new VegaFeatures()
							.withSecurity()
							//.withTokens("vega")
							.withMisc()
							.withEmbeddedServer(pandoraPort)
							.build())
					.addModule(new AccountFeatures()
							.withAccountStorePlugin(MemoryAccountStorePlugin.class)
							.build())
					.addModule(new NotificationFeatures()
							.withNotificationPlugin(MemoryNotificationPlugin.class)
							.build())
					//-----
					.addModule(new ModuleConfigBuilder("pandora-dao")
							.addComponent(MovieDAO.class)
							.addComponent(MoviesPAO.class)
							.addComponent(PersonDAO.class)
							.addComponent(PersonsPAO.class)
							.addComponent(ActorRoleDAO.class)
							.build())
					.addModule(new ModuleConfigBuilder("pandora-services")
							.addComponent(MasterdataServices.class, MasterdataServicesImpl.class)
							.addComponent(MovieServices.class, MovieServicesImpl.class)
							.addComponent(PersonServices.class, PersonServicesImpl.class)
							.addComponent(CommonServices.class, CommonServicesImpl.class)
							.build())

					.addModule(new ModuleConfigBuilder("pandora-webservices")
							.addComponent(MasterdataWebservices.class)
							.addComponent(MovieWebServices.class)
							.addComponent(PersonWebServices.class)
							.addComponent(CommonWebServices.class)
							.addComponent(NotificationWebServices.class)
							.build())
					.addModule(new ModuleConfigBuilder("pandora-searchloader")
							.addComponent(MovieSearchLoader.class)
							.addComponent(PersonSearchLoader.class)
							.build())
					.addModule(new ModuleConfigBuilder("myApp")
							.addDefinitionProvider(new DefinitionProviderConfigBuilder(DynamoDefinitionProvider.class)
									.addDefinitionResource("classes", ProvidedDtDefinitions.class.getName())
									.addDefinitionResource("classes", DtDefinitions.class.getName())
									.addDefinitionResource("kpr", "io/vertigo/pandora/boot/application.kpr")
									.build())
							.build());
		} else {
			appConfigBuilder
					.addModule(new ModuleConfigBuilder("studio")
							.addComponent(MdaManager.class, MdaManagerImpl.class,
									Param.create("projectPackageName", "io.vertigo.pandora"),
									Param.create("targetGenDir", "src/main/"),
									Param.create("encoding", "utf8"))
							.addPlugin(DomainGeneratorPlugin.class,
									Param.create("targetSubDir", "javagen"),
									Param.create("generateDtResources", "false"),
									Param.create("generateJpaAnnotations", "false"),
									Param.create("generateDtDefinitions", "true"),
									Param.create("generateDtObject", "true"))
							.addPlugin(TaskGeneratorPlugin.class,
									Param.create("targetSubDir", "javagen"))
							.addPlugin(SqlGeneratorPlugin.class,
									Param.create("targetSubDir", "sqlgen"),
									Param.create("generateDrop", "false"),
									Param.create("baseCible", "H2"))
							.addPlugin(JSGeneratorPlugin.class,
									Param.create("targetSubDir", "jsgen"),
									Param.create("generateDtResourcesJS", "false"),
									Param.create("generateJsDtDefinitions", "true"))
							.addPlugin(WsJsGeneratorPlugin.class,
									Param.create("targetSubDir", "wsjsgen"))
							.build())
					.addModule(new ModuleConfigBuilder("myAppGen")
							.addDefinitionProvider(new DefinitionProviderConfigBuilder(DynamoDefinitionProvider.class)
									.addDefinitionResource("kpr", "io/vertigo/pandora/boot/application.kpr")
									.addDefinitionResource("oom", "io/vertigo/pandora/mda/pandora.oom")
									.addDefinitionResource("kpr", "io/vertigo/pandora/mda/generation.kpr")
									.build())
							.build());
		}
		return appConfigBuilder.build();
	}
}
