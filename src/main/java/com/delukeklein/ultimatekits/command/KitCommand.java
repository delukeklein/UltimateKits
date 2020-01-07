package com.delukeklein.ultimatekits.command;

import com.delukeklein.ultimatekits.command.composite.CompositeRootCommand;
import com.delukeklein.ultimatekits.command.create.CreateKitCommand;
import com.delukeklein.ultimatekits.command.edit.EditKitCommand;
import com.delukeklein.ultimatekits.configuration.CategoryConfiguration;
import com.delukeklein.ultimatekits.configuration.KitConfiguration;
import org.bukkit.command.CommandSender;

public final class KitCommand extends CompositeRootCommand {

    private final static String CREATE = "create";
    private final static String EDIT = "edit";

    public KitCommand(final KitConfiguration kitConfig, final CategoryConfiguration categoryConfig) {
        super(
                new Entry(CREATE, new CreateKitCommand(kitConfig)),
                new Entry(EDIT, new EditKitCommand(kitConfig, categoryConfig))
        );
    }

    @Override
    public void severe(final CommandSender sender, final String label, final String[] args) {

    }
}
