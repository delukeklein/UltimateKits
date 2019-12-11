package com.delukeklein.ultimatekits.configuration;

import com.delukeklein.ultimatekits.UltimateKits;

import java.util.List;

public class CategoryConfiguration extends AbstractConfiguration {
	
	public CategoryConfiguration(UltimateKits plugin) {
		super(plugin, "categories");
	}
	
	public void addCategory(final String category) {
		final List<String> categories = getCategories();
		
		categories.add(category);

		config.set("categories", categories);
	}
	
	public boolean contains(final String category) {
		return getCategories().contains(category);
	}
	
	public List<String> getCategories() {
		return config.getStringList("categories");
	}
}
