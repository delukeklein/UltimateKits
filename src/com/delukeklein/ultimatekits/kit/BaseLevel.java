package com.delukeklein.ultimatekits.kit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;

import com.delukeklein.ultimatekits.kit.equipment.Level;

public class BaseLevel implements Level, ConfigurationSerializable {

	private int price;
	
	private String name;
	
	private ItemStack[] armor;
	private ItemStack[] storage;
	
	@Override
	public void setPrice(final int price) {
		this.price = price;
	}
	
	@Override
	public void setName(final String name) {
		this.name = name;
	}
	
	@Override
	public void setArmor(final ItemStack[] armor) {
		this.armor = armor;	
	}

	@Override
	public void setStorage(final ItemStack[] storage) {
		this.storage = storage;	
	}
	
	@Override
	public int getPrice() {
		return price;
	}

	@Override
	public boolean hasName(final String name) {
		return name.equalsIgnoreCase(this.name);
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public ItemStack[] getArmor() {
		return armor;
	}

	@Override
	public ItemStack[] getStorage() {
		return storage;
	}

	@Override
	public Map<String, Object> serialize() {
		final Map<String, Object> map = new HashMap<>();
		
		map.put("price", price);
		map.put("name", name);
		map.put("armor", Arrays.asList(armor));
		map.put("storage", Arrays.asList(storage));
		
		return map;
	}
}
