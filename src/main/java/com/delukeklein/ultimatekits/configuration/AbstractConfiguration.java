package com.delukeklein.ultimatekits.configuration;

import com.delukeklein.ultimatekits.UltimateKits;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Set;

abstract class AbstractConfiguration<T> {

	protected final FileConfiguration config;
	
	private final static String EXTENSION = ".yml";
	
	private final File file;

	protected AbstractConfiguration(final UltimateKits plugin, final String name) {
		config = new YamlConfiguration();
		
        file = new File(plugin.getDataFolder(), name + EXTENSION);
        
        if (!file.exists()) {
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdir();
			}

			plugin.saveResource(name + EXTENSION, false);
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

		reload();
	}

	public void set(final String name, final T t) {
		config.set(parseToKey(name), t);
	}

	public void remove(final String name) {
		config.set(parseToKey(name), null);
	}

	public boolean contains(final String name) {
		return config.contains(parseToKey(name));
	}

	public T get(final String name) {
		return (T) config.get(parseToKey(name));
	}

	public Set<String> getKeys() {
		return config.getKeys(false);
	}

	protected final String parseToKey(final String str) {
		return str.replace(' ', '_').toLowerCase();
	}
}
