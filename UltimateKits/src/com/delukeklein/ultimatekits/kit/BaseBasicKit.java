package com.delukeklein.ultimatekits.kit;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class BaseBasicKit extends AbstractKit implements BasicKit {
	
	private ItemStack[] armor;
	private ItemStack[] storage;
	
	@Override
	public void giveKit(Player player) {
		// TODO Auto-generated method stub
	}
	
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
}
