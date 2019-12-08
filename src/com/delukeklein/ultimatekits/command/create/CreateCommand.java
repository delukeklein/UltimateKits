package com.delukeklein.ultimatekits.command.create;

import java.util.Arrays;
import java.util.Map;

import org.bukkit.command.CommandSender;

import com.delukeklein.ultimatekits.command.SubCommand;
import com.delukeklein.ultimatekits.configuration.CategoryConfiguration;
import com.delukeklein.ultimatekits.configuration.KitConfiguration;

public class CreateCommand implements SubCommand {

	private final static String CATEGORY = "catagory";
	private final static String KIT = "kit";

	private final Map<String, SubCommand> commandMap;

	public CreateCommand(final CategoryConfiguration categoryConfig, final KitConfiguration kitConfig) {
		this.commandMap = Map.of(
				CATEGORY, new CreateCategoryCommand(categoryConfig),

				KIT, new CreateKitCommand(kitConfig)
			);
	}

	@Override
	public void execute(final CommandSender sender, final String[] args) {
		final SubCommand command = commandMap.get(args[0]);

		if (command != null) {
			command.execute(sender, Arrays.copyOfRange(args, 1, args.length - 1));
		} else {
			// TODO Error message
		}
	}
}
