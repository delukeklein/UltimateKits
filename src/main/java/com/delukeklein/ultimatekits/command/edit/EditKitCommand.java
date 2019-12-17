package com.delukeklein.ultimatekits.command.edit;

import com.delukeklein.ultimatekits.command.*;
import com.delukeklein.ultimatekits.configuration.KitConfiguration;
import org.bukkit.command.CommandSender;

public class EditKitCommand extends CompositeSubCommand {

    private final KitConfiguration kitConfig;

    public EditKitCommand(KitConfiguration kitConfig) {
        this.kitConfig = kitConfig;
    }

    @Override
    public void severe(final CommandSender sender, final String label, final String[] args) {
        //TODO Message the sender the syntax error.
    }

    @Override
    public void onArgumentless(final CommandSender commandSender) {

    }
}
