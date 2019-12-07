package com.delukeklein.ultimatekits;

import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

//import com.delukeklein.ultimatekits.configuration.KitConfiguration;
import com.delukeklein.ultimatekits.kit.KitFactory;
import com.delukeklein.ultimatekits.kit.Level;

public class UltimateKits extends JavaPlugin {

	//private KitConfiguration kitConfig;
	
	@Override
	public void onEnable() {
		
		initSerializables();
		
		//kitConfig = new KitConfiguration(this);
	}
	
	@Override
	public void onDisable() {
		
	}
	
	private void initSerializables() {
		KitFactory.initSerializable();
		
		ConfigurationSerialization.registerClass(Level.class);
	}
}
