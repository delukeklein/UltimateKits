package com.delukeklein.ultimatekits.kit;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.delukeklein.ultimatekits.kit.equipment.Equipment;

final class BasicKit extends AbstractKit implements Equipment {
	
	private ItemStack[] armor;
	private ItemStack[] storage;
	
	@SuppressWarnings("unchecked")
	public BasicKit(final Map<String, Object> map) {
		super(map);
		
		armor = ((List<ItemStack>) map.get("armor")).toArray(armor);
		storage = ((List<ItemStack>) map.get("storage")).toArray(storage);
	}
	
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
	
	@Override
	public Map<String, Object> serialize() {
		final Map<String, Object> map = super.serialize();

		map.put("armor", Arrays.asList(armor));
		map.put("storage", Arrays.asList(storage));
		
		return map;
	}
}
