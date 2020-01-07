package com.delukeklein.ultimatekits;

import com.delukeklein.ultimatekits.command.CategoryCommand;
import com.delukeklein.ultimatekits.command.composite.CompositeRootCommand;
import com.delukeklein.ultimatekits.command.KitCommand;
import com.delukeklein.ultimatekits.configuration.CategoryConfiguration;
import com.delukeklein.ultimatekits.configuration.KitConfiguration;
import com.delukeklein.ultimatekits.kit.BasicKit;
import com.delukeklein.ultimatekits.kit.LevelKit;

import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

public class UltimateKits extends JavaPlugin {

    private final static String KIT = "kit";
    private final static String CATEGORY = "category";
    private final static String FALLBACK_PREFIX = "ultimate-kits";

    private CommandService commandService;

    @Override
    public void onLoad() {
        initializeSerializable();
    }

    @Override
    public void onEnable() {
        final KitConfiguration kitConfig = new KitConfiguration(this);
        final CategoryConfiguration categoryConfig = new CategoryConfiguration(this);

        commandService = new CommandService(FALLBACK_PREFIX);

        commandService.registerCommand(KIT, new KitCommand(kitConfig, categoryConfig));
        commandService.registerCommand(CATEGORY, new CategoryCommand(categoryConfig));
    }

    @Override
    public void onDisable() {

    }

    private void initializeSerializable() {
        ConfigurationSerialization.registerClass(BasicKit.class);
        ConfigurationSerialization.registerClass(LevelKit.class);
    }
}
