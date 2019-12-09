package com.delukeklein.ultimatekits.configuration;

import java.util.List;

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
		config.set(getYamlName(kit), kit);
	}
	
	public List<String> getKitList() {
		List<String> list = List.copyOf(config.getKeys(false));
		
		for(int i = 0; i < list.size(); i++) {
			list.set(i, getKit(list.get(i)).getName());
		}
				
		return list;
	}
	
	private String getYamlName(final Kit kit) {
		return kit.getName().replace(' ', '_').toLowerCase();
	}
}
