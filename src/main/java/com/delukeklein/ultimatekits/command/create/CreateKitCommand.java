package com.delukeklein.ultimatekits.command.create;

import com.delukeklein.ultimatekits.command.SubCommand;
import com.delukeklein.ultimatekits.configuration.KitConfiguration;
import com.delukeklein.ultimatekits.kit.BasicKit;

import org.bukkit.command.CommandSender;

import java.util.Collections;
import java.util.List;

public class CreateKitCommand implements SubCommand {

    private final KitConfiguration kitConfig;

    public CreateKitCommand(final KitConfiguration kitConfig) {
        this.kitConfig = kitConfig;
    }

    @Override
    public void severe(final CommandSender sender, final String label, final String[] args) {

    }

    @Override
    public boolean execute(final CommandSender sender, final String label, final String[] args) {
        final String name = String.join(" ", args);

        if (!kitConfig.contains(name)) {
            kitConfig.set(name, new BasicKit(name));
            kitConfig.save();
        }

        return !kitConfig.contains(name);
	}

    @Override
    public List<String> tabComplete(final CommandSender sender, final String label, final String[] args) {
        return args.length == 0 ? Collections.EMPTY_LIST : List.of("[<name>]");
    }
}
