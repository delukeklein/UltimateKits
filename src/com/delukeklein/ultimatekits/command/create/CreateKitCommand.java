package com.delukeklein.ultimatekits.command.create;

import com.delukeklein.ultimatekits.command.SubCommand;
import com.delukeklein.ultimatekits.configuration.KitConfiguration;
import com.delukeklein.ultimatekits.kit.BasicKit;
import org.bukkit.command.CommandSender;

public class CreateKitCommand implements SubCommand {

	private final KitConfiguration kitConfig;
	
	public CreateKitCommand(final KitConfiguration kitConfig) {
		this.kitConfig = kitConfig;
	}

	@Override
	public void severe(final CommandSender sender, final String label, final String[] args) {
		//TODO Message the sender the syntax error.
	}
	
	@Override
	public boolean onExecute(final CommandSender sender, final String label, final String[] args) {
		final String name = String.join(" ", args);
		
		final boolean containsKit = kitConfig.contains(name);
		
		if(!containsKit) {
			kitConfig.setKit(new BasicKit(name));		
			kitConfig.save();	
		}
		
		return !containsKit;
	}
}
