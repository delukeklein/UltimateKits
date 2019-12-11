package com.delukeklein.ultimatekits.command;

import org.bukkit.command.CommandSender;

import com.delukeklein.ultimatekits.command.create.CreateCategoryCommand;
import com.delukeklein.ultimatekits.configuration.CategoryConfiguration;
import org.bukkit.entity.Player;

public class CategoryCommand extends AbstractCommand implements NoArgumentCommand {

	private final static String CREATE = "create";

	public CategoryCommand(final CategoryConfiguration categoryConfig) {
		super();
		
		register(CREATE, new CreateCategoryCommand(categoryConfig));
	}

	@Override
	public void severe(final CommandSender sender, final String label, final String[] args) {
		//TODO Message the sender the syntax error.
	}

	@Override
	public boolean execute(final CommandSender sender) {
		final boolean isPlayer = sender instanceof Player;

		if(isPlayer) {
			//TODO Open create category inventory.
		}

		return isPlayer;
	}
}
