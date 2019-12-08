package com.delukeklein.ultimatekits.command;

import org.bukkit.command.CommandSender;

public interface SubCommand {

	void execute(CommandSender sender, String[] args);
	
}
