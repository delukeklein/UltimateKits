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
	public void execute(CommandSender sender, String[] args) {
		kitConfig.setKit(new BasicKit(String.join(" ", args)));		
		kitConfig.save();	
	}
}
