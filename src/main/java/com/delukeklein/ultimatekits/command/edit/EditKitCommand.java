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
    public void onNoArgument(CommandSender sender) {

    }

    @Override
    public void severe(CommandSender sender, String label, String[] args) {

    }
}
