package com.delukeklein.ultimatekits.command;

import org.bukkit.command.CommandSender;

public interface SubCommand extends SyntaxError {

	boolean execute(CommandSender sender, String[] args);
	
}
