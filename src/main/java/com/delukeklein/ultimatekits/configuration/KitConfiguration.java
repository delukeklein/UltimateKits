package com.delukeklein.ultimatekits.configuration;

import com.delukeklein.ultimatekits.kit.Kit;

import com.delukeklein.ultimatekits.UltimateKits;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class KitConfiguration extends AbstractConfiguration {
	
	public KitConfiguration(UltimateKits plugin) {
		super(plugin, "kits");
	}

	public Kit getKit(final String kitName) {
		return (Kit) config.get(kitName);
	}
	
	public void setKit(final Kit kit) {
		config.set(parseToKey(kit.getName()), kit);
	}
	
	public boolean contains(final String name) {
		return getKitKeys().contains(parseToKey(name));
	}
	
	public Set<String> getKitKeys() {
		return config.getKeys(false);
	}
	
	public List<String> getKitNames() {
		final ArrayList<String> names = new ArrayList<>(List.copyOf(getKitKeys()));

		names.replaceAll(s -> getKit(s).getName());
				
		return names;
	}
}