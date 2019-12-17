package com.delukeklein.ultimatekits.command;

import com.delukeklein.ultimatekits.command.create.CreateKitCommand;
import com.delukeklein.ultimatekits.command.edit.EditKitCommand;
import com.delukeklein.ultimatekits.configuration.KitConfiguration;
import org.bukkit.command.CommandSender;

public final class KitCommand extends CompositeCommand {

	private final static String KIT = "kit";

	private final static String CREATE = "create";
	private final static String EDIT = "edit";

	public KitCommand(final KitConfiguration kitConfig) {
		super(KIT);

		registerSubCommand(CREATE, new CreateKitCommand(kitConfig));
		registerSubCommand(EDIT, new EditKitCommand(kitConfig));
	}

	@Override
	public void onArgumentless(final CommandSender commandSender) {

	}
}
