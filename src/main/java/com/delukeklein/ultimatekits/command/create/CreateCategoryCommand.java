package com.delukeklein.ultimatekits.command.create;

import com.delukeklein.ultimatekits.command.SubCommand;
import com.delukeklein.ultimatekits.configuration.CategoryConfiguration;
import org.bukkit.command.CommandSender;

import java.util.Collections;
import java.util.List;

public class CreateCategoryCommand implements SubCommand {

	private final CategoryConfiguration categoryConfig;

	public CreateCategoryCommand(final CategoryConfiguration categoryConfig) {
		this.categoryConfig = categoryConfig;
	}

	@Override
	public void severe(final CommandSender sender, final String label, final String[] args) {

	}

	@Override
	public boolean execute(final CommandSender sender, final String label, final String[] args) {
		final String category = String.join(" ", args);

		if (!categoryConfig.contains(category)) {
			categoryConfig.set(category, null);
			categoryConfig.save();
		}

		return !categoryConfig.contains(category);
	}

	@Override
	public List<String> tabComplete(final CommandSender sender, final String label, final String[] args) {
		return args.length == 0 ? Collections.EMPTY_LIST : List.of("[<name>]");
	}
}
