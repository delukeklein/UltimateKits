package com.delukeklein.ultimatekits;

import com.delukeklein.ultimatekits.command.RootCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;

import java.lang.reflect.Field;
import java.util.List;

public class CommandService {

    private final CommandMap commandMap;

    private String fallbackPrefix;

    public CommandService(final String fallbackPrefix) {
        try {
            final Field commandMapField = Bukkit.getServer().getClass().getDeclaredField("commandMap");

            commandMapField.setAccessible(true);

            commandMap = (CommandMap) commandMapField.get( Bukkit.getServer());

        } catch (NoSuchFieldException | IllegalAccessException e) {
            Bukkit.getServer().shutdown();
            e.printStackTrace();

            commandMap = null;
        }
    }

    /**
     * Registers this command to the specified {@link CommandMap}.
     *
     * @param label the label of the root command, without the '/'-prefix.
     * @param rootCommand the {@link RootCommand} to register.
     */
    public void registerCommand(final String label, final RootCommand rootCommand) {
        final Command command = new Command(label) {

            @Override
            public boolean execute(CommandSender sender, String label, String[] args) {
                if(!rootCommand.execute(sender, label, args)) {
                    rootCommand.severe(sender, label, args);
                }

                return true;
            }

            @Override
            public List<String> tabComplete(CommandSender sender, String label, String[] args) {
                return rootCommand.tabComplete(sender, label, args);
            }
        };

        command.setAliases(List.of(label));

        commandMap.register(fallbackPrefix, command);
    }

    /**
     *
     * @param fallbackPrefix
     */
    public void setFallbackPrefix(String fallbackPrefix) {
        this.fallbackPrefix = fallbackPrefix;
    }

    /**
     *
     */
    public String getFallbackPrefix() {
        return fallbackPrefix;
    }
}
