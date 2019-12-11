package com.delukeklein.ultimatekits.kit;

import com.delukeklein.ultimatekits.kit.equipment.Equipment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class BasicKit extends AbstractKit implements Equipment {
	
	private ItemStack[] armor;
	private ItemStack[] storage;

	public BasicKit(final String name) {
		super(name);
		
		this.armor = new ItemStack[0];
		this.storage = new ItemStack[0];
	}
	
	@SuppressWarnings("unchecked")
	public BasicKit(Map<String, Object> map) {
		super(map);
		
		armor = ((List<ItemStack>) map.get("armor")).toArray(new ItemStack[0]);
		storage = ((List<ItemStack>) map.get("storage")).toArray(new ItemStack[0]);
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
