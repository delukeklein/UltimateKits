package com.delukeklein.ultimatekits.kit;

import org.bukkit.inventory.ItemStack;

import com.delukeklein.ultimatekits.kit.equipment.Equipment;

public class Level implements Equipment {

	private int price;
	
	private String name;
	
	private ItemStack[] armor;
	private ItemStack[] storage;
	
	@Override
	public void setArmor(ItemStack[] armor) {
		this.armor = armor;	
	}

	@Override
	public void setStorage(ItemStack[] storage) {
		this.storage = storage;	
	}
	
	@Override
	public ItemStack[] getArmor() {
		return armor;
	}

	@Override
	public ItemStack[] getStorage() {
		return storage;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}
	
}
