package com.delukeklein.ultimatekits.command.create;

import org.bukkit.command.CommandSender;

import com.delukeklein.ultimatekits.command.SubCommand;
import com.delukeklein.ultimatekits.configuration.KitConfiguration;
import com.delukeklein.ultimatekits.kit.BasicKit;

public class CreateKitCommand implements SubCommand {

	private final KitConfiguration kitConfig;
	
	public CreateKitCommand(final KitConfiguration kitConfig) {
		this.kitConfig = kitConfig;
	}
	
	@Override
	public boolean execute(CommandSender sender, String[] args) {		
		final String name = String.join(" ", args);
		
		final boolean contains = kitConfig.contains(name);
		
		if(!contains) {
			kitConfig.setKit(new BasicKit(name));		
			kitConfig.save();	
		}
		
		return contains;
	}

	@Override
	public void severe(CommandSender sender, String[] args) {
		// TODO Auto-generated method stub
		
	}
}
