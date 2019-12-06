package com.delukeklein.ultimatekits.kit.equipment;

import org.bukkit.inventory.ItemStack;

public interface Equipment {

	public void setArmor(final ItemStack[] armor);

	public void setStorage(final ItemStack[] storage);
	
	public ItemStack[] getArmor();
	
	public ItemStack[] getStorage();
		
}
