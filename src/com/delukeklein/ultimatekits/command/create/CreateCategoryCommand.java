package com.delukeklein.ultimatekits.command.create;

import com.delukeklein.ultimatekits.command.SubCommand;
import com.delukeklein.ultimatekits.configuration.CategoryConfiguration;
import org.bukkit.command.CommandSender;

public class CreateCategoryCommand implements SubCommand {

	private final CategoryConfiguration categoryConfig;

	public CreateCategoryCommand(final CategoryConfiguration categoryConfig) {
		this.categoryConfig = categoryConfig;
	}

	@Override
	public void severe(final CommandSender sender, final String label, final String[] args) {
		//TODO Message the sender the syntax error.
	}

	@Override
	public boolean onExecute(final CommandSender sender, final String label, final String[] args) {
		final String category = String.join("", args);
		
		final boolean contains = categoryConfig.contains(category);

		if (!contains) {
			categoryConfig.addCategory(category);
			categoryConfig.save();
		}
		
		return !contains;
	}
}
