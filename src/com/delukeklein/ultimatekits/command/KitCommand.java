package com.delukeklein.ultimatekits.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.delukeklein.ultimatekits.command.create.CreateKitCommand;
import com.delukeklein.ultimatekits.configuration.KitConfiguration;
import org.bukkit.entity.Player;

public final class KitCommand extends ArgumentCommand implements CommandExecutor, NoArgumentCommand {

	private final static String CREATE = "create";

	public KitCommand(final KitConfiguration kitConfig) {
		register(CREATE, new CreateKitCommand(kitConfig));
	}

	@Override
	public void severe(final CommandSender sender, final String label, final String[] args) {
		//TODO Message the sender the syntax error.
	}

	@Override
	public boolean onNoArgument(final CommandSender sender) {
		final boolean isPlayer = sender instanceof Player;

		if(isPlayer) {
			//TODO Open create category inventory.
		}

		return isPlayer;
	}

}
