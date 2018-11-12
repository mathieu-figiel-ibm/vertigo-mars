package io.mars.boot;

import org.springframework.context.annotation.ComponentScan;

import io.vertigo.ui.impl.springmvc.config.VSpringWebConfig;

@ComponentScan({
		"io.mars.basemanagement.controllers.base",
		"io.mars.humanresources.controllers.person" })
public class MarsVSpringWebConfig extends VSpringWebConfig {
	// nothing basic config is enough
}
