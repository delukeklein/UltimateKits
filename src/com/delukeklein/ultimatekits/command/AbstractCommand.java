package com.delukeklein.ultimatekits.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.Map;

public abstract class AbstractCommand implements CommandExecutor {

	private final Map<String, SubCommand> commandMap = Map.of();
	
	@Override
	public final boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		final SubCommand subCommand = commandMap.get(args[0].toLowerCase());

		if (subCommand != null) {
			execute(sender, subCommand, Arrays.copyOfRange(args, 1, args.length));
		}
		
		return true;
	}
	
	protected abstract void execute(CommandSender sender, SubCommand subCommand,  String[] args);
	
	protected final void register(final String argument,  final SubCommand subCommand) {
		commandMap.put(argument, subCommand);
	}
}
