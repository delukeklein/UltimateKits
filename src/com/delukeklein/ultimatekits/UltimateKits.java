package com.delukeklein.ultimatekits;

import java.util.Arrays;

import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

import com.delukeklein.ultimatekits.configuration.KitConfiguration;
import com.delukeklein.ultimatekits.kit.BasicKit;
import com.delukeklein.ultimatekits.kit.KitFactory;
import com.delukeklein.ultimatekits.kit.LevelKit;


public class UltimateKits extends JavaPlugin {

	private KitConfiguration kitConfig;
	
	@Override
	public void onEnable() {

		initSerializables();
		
		kitConfig = new KitConfiguration(this);
		
		kitConfig.setKit(new KitFactory()
				.setPrice(100)
				.isLevelable(false)
				.setName("Sample Kit")
				.setCategory("Basic Kit")
				.setDescription(Arrays.asList(new String[] {"This is a description"}))
				.build());
		kitConfig.save();
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
	private void initSerializables() {
		ConfigurationSerialization.registerClass(BasicKit.class);
		ConfigurationSerialization.registerClass(LevelKit.class);
	}
}
