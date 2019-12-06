package com.delukeklein.ultimatekits.kit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

import com.delukeklein.ultimatekits.kit.category.BaseCategory;

public abstract class AbstractKit implements Kit, ConfigurationSerializable {

	private int price;
	
	private String name;
	
	private BaseCategory category;
	
	private List<String> description;
	
	@SuppressWarnings("unchecked")
	public AbstractKit(Map<String, Object> map) {
		 this.price = (int) map.get("price");
		 
		 this.name = (String) map.get("name");
		 
		 this.category = (BaseCategory) map.get("category");
		 
		 this.description = (List<String>) map.get("description");
	}
	
	@Override
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setCategory(final BaseCategory category) {
		this.category = category;
	}
	
	@Override
	public void setDescription(List<String> description) {
		this.description = description;
	}

	@Override
	public int getPrice() {
		return price;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public BaseCategory getCategory() {
		return category;
	}

	@Override
	public List<String> getDescription() {
		return description;
	}
	
	@Override
	public Map<String, Object> serialize() {
		final Map<String, Object> map = new HashMap<>();
		
		map.put("price", price);
		map.put("name", name);
		map.put("category", category);
		map.put("description", description);
		
		return map;
	}
}
