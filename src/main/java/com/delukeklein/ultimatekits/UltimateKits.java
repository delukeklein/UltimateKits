package com.delukeklein.ultimatekits;

import com.delukeklein.ultimatekits.command.CategoryCommand;
import com.delukeklein.ultimatekits.command.KitCommand;
import com.delukeklein.ultimatekits.configuration.CategoryConfiguration;
import com.delukeklein.ultimatekits.configuration.KitConfiguration;
import com.delukeklein.ultimatekits.kit.BasicKit;
import com.delukeklein.ultimatekits.kit.LevelKit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

public class UltimateKits extends JavaPlugin {

    private final static String FALLBACK_PREFIX = "ultimate-kits";

    private CommandMap commandMap;

    @Override
    public void onLoad() {
        initSerializable();
        initCommandMap();
    }

    @Override
    public void onEnable() {
        final KitConfiguration kitConfig = new KitConfiguration(this);
        final CategoryConfiguration categoryConfig = new CategoryConfiguration(this);

        registerCommand(new KitCommand(kitConfig));
        registerCommand(new CategoryCommand(categoryConfig));
    }

    @Override
    public void onDisable() {

    }

    private void registerCommand(final Command command) {
        commandMap.register(FALLBACK_PREFIX, command);
    }

    private void initSerializable() {
        ConfigurationSerialization.registerClass(BasicKit.class);
        ConfigurationSerialization.registerClass(LevelKit.class);
    }

    private void initCommandMap() {
        try {
            final Field commandMapField = getServer().getClass().getDeclaredField("commandMap");

            commandMapField.setAccessible(true);

            commandMap = (CommandMap) commandMapField.get(getServer());

        } catch (NoSuchFieldException | IllegalAccessException e) {
            getServer().shutdown();
            e.printStackTrace();
        }
    }
}
