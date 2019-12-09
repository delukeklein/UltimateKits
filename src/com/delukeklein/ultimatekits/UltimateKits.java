package com.delukeklein.ultimatekits;

import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

import com.delukeklein.ultimatekits.command.KitCommand;
import com.delukeklein.ultimatekits.configuration.KitConfiguration;
import com.delukeklein.ultimatekits.kit.BasicKit;
import com.delukeklein.ultimatekits.kit.LevelKit;


public class UltimateKits extends JavaPlugin {

	@Override
	public void onLoad() {
		initSerializables();
	}
	
	@Override
	public void onEnable() {
		final KitConfiguration kitConfig = new KitConfiguration(this);

		getCommand("kit").setExecutor(new KitCommand(kitConfig));		
	}
	
	@Override
	public void onDisable() {
		
	}
	
	private void initSerializables() {
		ConfigurationSerialization.registerClass(BasicKit.class);
		ConfigurationSerialization.registerClass(LevelKit.class);
	}
}
