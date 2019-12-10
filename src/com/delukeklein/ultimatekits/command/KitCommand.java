package com.delukeklein.ultimatekits.command;

import org.bukkit.command.CommandSender;

import com.delukeklein.ultimatekits.command.create.CreateKitCommand;
import com.delukeklein.ultimatekits.configuration.KitConfiguration;

public class KitCommand extends AbstractCommand {

	private final static String CREATE = "create";

	public KitCommand(final KitConfiguration kitConfig) {
		register(CREATE, new CreateKitCommand(kitConfig));
	}

	@Override
	protected void execute(final  CommandSender sender, final SubCommand subCommand, final String[] args) {
		if (subCommand.execute(sender, args)) {
			subCommand.severe(sender, args);
		}
	}

}
