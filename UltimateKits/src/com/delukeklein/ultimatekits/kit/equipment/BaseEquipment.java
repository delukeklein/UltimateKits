package com.delukeklein.ultimatekits.kit.equipment;

import org.bukkit.inventory.ItemStack;

public final class BaseEquipment implements Equipment {

	private ItemStack[] armor;
	private ItemStack[] storage;
	
	public void setArmor(final ItemStack[] armor) {
		this.armor = armor;
	}

	public void setStorage(final ItemStack[] storage) {
		this.storage = storage;
	}
	
	public ItemStack[] getArmor() {
		return armor;
	}
	
	public ItemStack[] getStorage() {
		return storage;
	}

}
