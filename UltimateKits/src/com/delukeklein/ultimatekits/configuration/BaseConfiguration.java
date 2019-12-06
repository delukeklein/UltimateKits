package com.delukeklein.ultimatekits.configuration;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.delukeklein.ultimatekits.UltimateKits;

class BaseConfiguration {

	protected FileConfiguration config;
	
	private final static String EXTENSION = ".yml";
	
	private File file;

	protected BaseConfiguration(final UltimateKits plugin, final String name, final String folder, final boolean saveResource) {
		config = new YamlConfiguration();
		
        file = new File(plugin.getDataFolder() + folder, name + EXTENSION);
        
        if (!file.exists()) {
            file.getParentFile().mkdirs();
      
            if(saveResource) {
            	plugin.saveResource(name + EXTENSION, false);
            }
            else {
            	try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
         }

        reload();
	}
	
	public void reload() {
		try {
			config.load(file);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();	
		}
	}

	public void save() {
		try {
			config.save(file);
		} catch (IOException e) {
			
			e.printStackTrace();
		}	
	}

}