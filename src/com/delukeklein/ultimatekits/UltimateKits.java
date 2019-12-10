package com.delukeklein.ultimatekits;

import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

import com.delukeklein.ultimatekits.command.KitCommand;
import com.delukeklein.ultimatekits.configuration.KitConfiguration;
import com.delukeklein.ultimatekits.kit.BasicKit;
import com.delukeklein.ultimatekits.kit.LevelKit;


public class UltimateKits extends JavaPlugin {

	@Override
	public void onLoad() {
		initSerializable();
	}
	
	@Override
	public void onEnable() {
		final KitConfiguration kitConfig = new KitConfiguration(this);

		registerCommand("kit", new KitCommand(kitConfig));
	}
	
	@Override
	public void onDisable() {
		
	}
	
	private void initSerializable() {
		ConfigurationSerialization.registerClass(BasicKit.class);
		ConfigurationSerialization.registerClass(LevelKit.class);
	}

	private void registerCommand(final String name, final CommandExecutor executor) {
		if(executor != null) {
			getCommand(name).setExecutor(executor);
		}
	}
}
