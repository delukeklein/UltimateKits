package com.delukeklein.ultimatekits.configuration;

import java.util.List;
import java.util.Set;

import com.delukeklein.ultimatekits.UltimateKits;
import com.delukeklein.ultimatekits.kit.Kit;

public class KitConfiguration extends AbstractConfiguration {
	
	public KitConfiguration(UltimateKits plugin) {
		super(plugin, "kits", "", true);
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
		final List<String> names = List.copyOf(getKitKeys());
		
		names.replaceAll(s -> getKit(s).getName());
				
		return names;
	}
}
