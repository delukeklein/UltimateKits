package com.delukeklein.ultimatekits.command;

import java.util.Arrays;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.delukeklein.ultimatekits.command.create.CreateKitCommand;
import com.delukeklein.ultimatekits.configuration.KitConfiguration;

public class KitCommand implements CommandExecutor {

	private final static String CREATE = "create";

	private final Map<String, SubCommand> commandMap;
	
	public KitCommand(final KitConfiguration kitConfig) {
		commandMap = Map.of(
					CREATE, new CreateKitCommand(kitConfig)			
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
