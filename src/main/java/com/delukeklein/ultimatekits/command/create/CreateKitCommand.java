package com.delukeklein.ultimatekits.command.create;

import com.delukeklein.ultimatekits.command.SubCommand;
import com.delukeklein.ultimatekits.configuration.KitConfiguration;
import com.delukeklein.ultimatekits.kit.BasicKit;
import org.bukkit.command.CommandSender;

import java.util.List;

public class CreateKitCommand implements SubCommand {

	private final KitConfiguration kitConfig;
	
	public CreateKitCommand(final KitConfiguration kitConfig) {
		this.kitConfig = kitConfig;
	}

	@Override
	public void severe(final CommandSender sender, final String label, final String[] args) {
		//TODO Message the sender the syntax error.
	}

    @Override
    public void onNoArgument(CommandSender sender) {

    }

    @Override
    public boolean onCommand(CommandSender sender, String label, String[] args) {
        final String name = String.join(" ", args);

        final boolean containsKit = kitConfig.contains(name);

        if (!containsKit) {
            kitConfig.setKit(new BasicKit(name));
            kitConfig.save();
        }

        return !containsKit;
	}

    @Override
    public List<String> tabComplete(CommandSender sender, String label, String[] args) {
        return List.of("<name>");
    }

}
