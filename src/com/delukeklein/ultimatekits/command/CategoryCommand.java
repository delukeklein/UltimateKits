package com.delukeklein.ultimatekits.command;

import java.util.Arrays;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.delukeklein.ultimatekits.command.create.CreateCategoryCommand;
import com.delukeklein.ultimatekits.configuration.CategoryConfiguration;

public class CategoryCommand implements CommandExecutor {

	private final static String CREATE = "create";

	private final Map<String, SubCommand> commandMap;
	
	public CategoryCommand(final CategoryConfiguration categoryConfig) {
		commandMap = Map.of(
					CREATE, new CreateCategoryCommand(categoryConfig)			
				);
	}

	@Override
	public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
		final SubCommand subCommand = commandMap.get(args[0].toLowerCase());

		if (subCommand != null) {
			subCommand.execute(sender, Arrays.copyOfRange(args, 1, args.length));
		} else {
			// TODO Error message
		}
		
		return true;
	}

}
