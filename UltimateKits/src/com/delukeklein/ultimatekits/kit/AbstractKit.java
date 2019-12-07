package com.delukeklein.ultimatekits.kit;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

abstract class AbstractKit implements Kit, ConfigurationSerializable {

	private int price;
	
	private String name;
	
	private String category;
	
	private List<String> description;
	
	public AbstractKit() {
		super();
	}
	
	@SuppressWarnings("unchecked")
	public AbstractKit(Map<String, Object> map) {
		 this.price = (int) map.get("price");
		 
		 this.name = (String) map.get("name");
		 
		 this.category = (String) map.get("category");
		 
		 this.description = (List<String>) map.get("description");
	}
	
	@Override
	public final void setPrice(final int price) {
		this.price = price;
	}

	@Override
	public final  void setName(final String name) {
		this.name = name;
	}

	@Override
	public final void setCategory(final String category) {
		this.category = category;
	}
	
	@Override
	public final void setDescription(final List<String> description) {
		this.description = description;
	}

	@Override
	public final int getPrice() {
		return price;
	}

	@Override
	public final  String getName() {
		return name;
	}
	
	@Override
	public final String getCategory() {
		return category;
	}

	@Override
	public final List<String> getDescription() {
		return description;
	}
	
	@Override
	public Map<String, Object> serialize() {
		final Map<String, Object> map = new LinkedHashMap<>();
		
		map.put("price", price);
		map.put("name", name);
		map.put("category", category);
		map.put("description", description);
		
		return map;
	}
}
