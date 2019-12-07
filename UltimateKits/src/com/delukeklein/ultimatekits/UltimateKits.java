package com.delukeklein.ultimatekits;

import org.bukkit.plugin.java.JavaPlugin;

import com.delukeklein.ultimatekits.configuration.KitConfiguration;

public class UltimateKits extends JavaPlugin {

	private KitConfiguration kitConfig;
	
	@Override
	public void onEnable() {
		kitConfig = new KitConfiguration(this);
	}
	
	@Override
	public void onDisable() {
		
	}
}
