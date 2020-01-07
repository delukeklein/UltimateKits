package com.delukeklein.ultimatekits.command.edit;

import com.delukeklein.ultimatekits.command.SubCommand;
import com.delukeklein.ultimatekits.configuration.KitConfiguration;
import com.delukeklein.ultimatekits.kit.Kit;
import com.google.common.collect.ImmutableList;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.command.CommandSender;

import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

public final class EditKitSubCommand implements SubCommand {

    private final KitConfiguration kitConfig;

    private final BiConsumer<Kit, String> editKit;

    public EditKitSubCommand(final KitConfiguration kitConfig, final BiConsumer<Kit, String> edit) {
        this.kitConfig = kitConfig;
        this.editKit = edit;
    }

    @Override
    public void severe(final CommandSender sender, final String label, final String[] args) {

    }

    @Override
    public boolean execute(final CommandSender sender, final String label, final String[] args) {
        final String arguments = String.join(" ", args);

        final Optional<String> name = kitConfig.findFirstByName(s -> StringUtils.startsWithIgnoreCase(arguments, s));

        if (name.isPresent()) {
            final String input = StringUtils.removeIgnoreCase(arguments.toLowerCase(), name.get() + " ");

            final Kit kit = kitConfig.get(name.get());

            editKit.accept(kit, input);

            kitConfig.replace(name.get(), kit);
        }

        return name.isPresent();
    }

    @Override
    public List<String> tabComplete(final CommandSender sender, final String label, final String[] args) {
        return args.length == 1 ? kitConfig.getKitNames() : ImmutableList.of("[<" + label + ">]");
    }
}