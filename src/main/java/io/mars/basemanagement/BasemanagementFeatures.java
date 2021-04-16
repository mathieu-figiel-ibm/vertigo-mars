/**
 * vertigo - simple java starter
 *
 * Copyright (C) 2013-2018, KleeGroup, direction.technique@kleegroup.com (http://www.kleegroup.com)
 * KleeGroup, Centre d'affaire la Boursidiere - BP 159 - 92357 Le Plessis Robinson Cedex - France
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.mars.basemanagement;

import io.mars.basemanagement.services.equipment.iot.MqttShield;
import io.vertigo.account.plugins.authorization.loaders.JsonSecurityDefinitionProvider;
import io.vertigo.core.node.config.DefinitionProviderConfig;
import io.vertigo.core.node.config.Feature;
import io.vertigo.core.node.config.discovery.ModuleDiscoveryFeatures;
import io.vertigo.core.param.Param;

public class BasemanagementFeatures extends ModuleDiscoveryFeatures<BasemanagementFeatures> {

	public BasemanagementFeatures() {
		super("basemanagement");
	}

	@Feature("mqtt")
	public BasemanagementFeatures withMqtt(final Param... params) {
		getModuleConfigBuilder().addComponent(MqttShield.class, params);
		return this;
	}

	@Feature("auth")
	public BasemanagementFeatures withAuth(final Param... params) {
		getModuleConfigBuilder()
				.addDefinitionProvider(DefinitionProviderConfig.builder(JsonSecurityDefinitionProvider.class)
						.addDefinitionResource("security", "io/mars/basemanagement/base-auth-config.json")
						.build());
		return this;
	}

	@Override
	protected String getPackageRoot() {
		return this.getClass().getPackage().getName();
	}

}
