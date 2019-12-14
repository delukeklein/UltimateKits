package com.delukeklein.ultimatekits.command;

import com.delukeklein.ultimatekits.command.create.CreateCategoryCommand;
import com.delukeklein.ultimatekits.configuration.CategoryConfiguration;
import org.bukkit.command.CommandSender;

public class CategoryCommand extends CompositeCommand {

	private final static String CATEGORY = "category";

	private final static String CREATE = "create";

	public CategoryCommand(final CategoryConfiguration categoryConfig) {
		super(CATEGORY);

		registerSubCommand(CREATE, new CreateCategoryCommand(categoryConfig));
	}

	@Override
	public void onNoArgument(final CommandSender sender) {

	}
}
