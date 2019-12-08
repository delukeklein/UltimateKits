package com.delukeklein.ultimatekits.kit.equipment;

import org.bukkit.inventory.ItemStack;

public interface Equipment {

	public void setArmor(ItemStack[] armor);

	public void setStorage(ItemStack[] storage);
	
	public ItemStack[] getArmor();
	
	public ItemStack[] getStorage();
		
}
