package com.delukeklein.ultimatekits.configuration;

import com.delukeklein.ultimatekits.UltimateKits;
import com.delukeklein.ultimatekits.kit.Kit;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public final class KitConfiguration extends AbstractConfiguration<Kit> {

	public KitConfiguration(final UltimateKits plugin) {
		super(plugin, "kits");
	}

	public void replace(final String oldKitName, final Kit kit) {
		remove(oldKitName);
		set(kit.getName(), kit);
		save();
	}

	public Optional<String> findFirstByName(final Predicate<? super String> predicate) {
		Optional<String> optional = Optional.empty();

		for (final String key : getKeys()) {
			final String name = get(key).getName();

			if(predicate.test(name)) {
				optional = Optional.of(name);
				break;
			}
		}

		return optional;
	}

	public List<String> getKitNames() {
		final List<String> names = new ArrayList<>();

		for (final String key : getKeys()) {
			names.add(get(key).getName());
		}

		return names;
	}
}
