package com.delukeklein.ultimatekits.command;

import org.bukkit.command.CommandSender;

import com.delukeklein.ultimatekits.command.create.CreateCategoryCommand;
import com.delukeklein.ultimatekits.configuration.CategoryConfiguration;

public class CategoryCommand extends AbstractCommand {

	private final static String CREATE = "create";

	public CategoryCommand(final CategoryConfiguration categoryConfig) {
		super();
		
		register(CREATE, new CreateCategoryCommand(categoryConfig));
	}

	@Override
	protected void execute(CommandSender sender, SubCommand subCommand, String[] args) {	
		if(!subCommand.execute(sender, args)) {	
			subCommand.severe(sender, args);
		}
	}

}
