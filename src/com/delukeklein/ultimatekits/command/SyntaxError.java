package com.delukeklein.ultimatekits.command;

import org.bukkit.command.CommandSender;

public interface SyntaxError {
	
	void severe(CommandSender sender, String[] args);
	
}
