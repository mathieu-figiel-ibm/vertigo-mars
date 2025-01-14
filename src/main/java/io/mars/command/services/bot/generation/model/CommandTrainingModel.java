package io.mars.command.services.bot.generation.model;

import java.util.List;

import io.vertigo.commons.command.definitions.CommandDefinition;
import io.vertigo.core.lang.Assertion;

public class CommandTrainingModel {

	private final CommandDefinition commandDefinition;
	private final List<String> examples;

	public CommandTrainingModel(final CommandDefinition commandDefinition, final List<String> examples) {
		Assertion.check()
				.isNotNull(commandDefinition)
				.isNotNull(examples);
		//---
		this.commandDefinition = commandDefinition;
		this.examples = examples;
	}

	public String getCommandName() {
		return commandDefinition.getCommand();
	}

	public List<String> getExamples() {
		return examples;
	}

}
