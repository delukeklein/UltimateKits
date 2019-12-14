package com.delukeklein.ultimatekits.configuration;

import com.delukeklein.ultimatekits.UltimateKits;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

abstract class AbstractConfiguration {

	protected final FileConfiguration config;
	
	private final static String EXTENSION = ".yml";
	
	private final File file;

	protected AbstractConfiguration(final UltimateKits plugin, final String name) {
		config = new YamlConfiguration();
		
        file = new File(plugin.getDataFolder(), name + EXTENSION);
        
        if (!file.exists()) {
            if(file.getParentFile().mkdirs()) {
				plugin.saveResource(name + EXTENSION, false);
			}
         }

        reload();
	}
	
	public final void reload() {
		try {
			config.load(file);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();	
		}
	}

	public final void save() {
		try {
			config.save(file);
		} catch (IOException e) {		
			e.printStackTrace();
		}	
	}
	
	
	public final String parseToKey(final String str) {
		return str.replace(' ', '_').toLowerCase();
	}
}
