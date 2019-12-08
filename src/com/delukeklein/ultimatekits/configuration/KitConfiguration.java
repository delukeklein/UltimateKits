package com.delukeklein.ultimatekits.configuration;

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
		config.set(kit.getName(), kit);
	}
}
