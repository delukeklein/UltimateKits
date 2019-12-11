package com.delukeklein.ultimatekits;

import com.delukeklein.ultimatekits.command.CategoryCommand;
import com.delukeklein.ultimatekits.command.KitCommand;
import com.delukeklein.ultimatekits.configuration.CategoryConfiguration;
import com.delukeklein.ultimatekits.configuration.KitConfiguration;
import com.delukeklein.ultimatekits.kit.BasicKit;
import com.delukeklein.ultimatekits.kit.LevelKit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

public class UltimateKits extends JavaPlugin {

	@Override
	public void onLoad() {
		initSerializable();
	}
	
	@Override
	public void onEnable() {
		final KitConfiguration kitConfig = new KitConfiguration(this);
		final CategoryConfiguration categoryConfig = new CategoryConfiguration(this);

		registerCommand("kit", new KitCommand(kitConfig));
		registerCommand("category", new CategoryCommand(categoryConfig));
	}
	
	@Override
	public void onDisable() {
		
	}
	
	private void initSerializable() {
		ConfigurationSerialization.registerClass(BasicKit.class);
		ConfigurationSerialization.registerClass(LevelKit.class);
	}

	private void registerCommand(final String name, final CommandExecutor executor) {
		final PluginCommand pluginCommand = getCommand(name);

		if(pluginCommand != null) {
			pluginCommand.setExecutor(executor);
		}
	}
}
