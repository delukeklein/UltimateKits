package com.delukeklein.ultimatekits.command.create;

import org.bukkit.command.CommandSender;

import com.delukeklein.ultimatekits.command.SubCommand;
import com.delukeklein.ultimatekits.configuration.CategoryConfiguration;

public class CreateCategoryCommand implements SubCommand {

	private final CategoryConfiguration categoryConfig;
	
	public CreateCategoryCommand(final CategoryConfiguration categoryConfig) {
		this.categoryConfig = categoryConfig;
	}
	
	@Override
	public void execute(final CommandSender sender, final String[] args) {
		categoryConfig.addCategory(String.join("", args));
		categoryConfig.save();
	}
}
