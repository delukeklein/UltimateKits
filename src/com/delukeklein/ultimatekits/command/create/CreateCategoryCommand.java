package com.delukeklein.ultimatekits.command.create;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.delukeklein.ultimatekits.command.SubCommand;
import com.delukeklein.ultimatekits.configuration.CategoryConfiguration;

public class CreateCategoryCommand implements SubCommand {

	private final CategoryConfiguration categoryConfig;

	public CreateCategoryCommand(final CategoryConfiguration categoryConfig) {
		this.categoryConfig = categoryConfig;
	}

	@Override
	public boolean execute(final CommandSender sender, final String[] args) {
		final String category = String.join("", args);
		
		final boolean contains = categoryConfig.contains(category);

		if (!contains) {
			categoryConfig.addCategory(category);
			categoryConfig.save();
		}
		
		return contains;
	}

	@Override
	public void severe(final CommandSender sender, final String[] args) {
		sender.sendMessage("OI");
	}

}
