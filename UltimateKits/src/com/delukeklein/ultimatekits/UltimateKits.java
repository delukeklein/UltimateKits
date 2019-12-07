package com.delukeklein.ultimatekits;

import java.util.Arrays;

import org.bukkit.plugin.java.JavaPlugin;

import com.delukeklein.ultimatekits.configuration.KitConfiguration;
import com.delukeklein.ultimatekits.kit.KitFactory;


public class UltimateKits extends JavaPlugin {

	private KitConfiguration kitConfig;
	
	@Override
	public void onEnable() {

		kitConfig = new KitConfiguration(this);
		
		kitConfig.setKit(new KitFactory()
				.setPrice(100)
				.setName("Sample Kit")
				.setCategory("Basic Kit")
				.isLevelable(false)
				.setDescription(Arrays.asList(new String[] {"this is a description"}))
				.build());
		kitConfig.save();
		
	}
	
	@Override
	public void onDisable() {
		
	}
}
