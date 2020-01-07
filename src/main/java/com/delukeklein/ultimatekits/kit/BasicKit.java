package com.delukeklein.ultimatekits.kit;

import com.delukeklein.ultimatekits.kit.equipment.Equipment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class BasicKit extends AbstractKit implements Equipment {

	private final static String ARMOR = "armor";
	private final static String STORAGE = "storage";

	private ItemStack[] armor;
	private ItemStack[] storage;

	public BasicKit(final String name) {
		super(name);

		armor = new ItemStack[0];
		storage = new ItemStack[0];
	}

	@SuppressWarnings("unchecked")
	public BasicKit(Map<String, Object> map) {
		super(map);

		armor = ((List<ItemStack>) map.get(ARMOR)).toArray(new ItemStack[0]);
		storage = ((List<ItemStack>) map.get(STORAGE)).toArray(new ItemStack[0]);
	}

	@Override
	public void give(final Player player) {
		//TODO give player the kit;
	}

	@Override
	public void setArmor(final ItemStack[] armor) {
		this.armor = Arrays.copyOf(armor, armor.length);
	}

	@Override
	public void setStorage(final ItemStack[] storage) {
		this.storage = Arrays.copyOf(storage, storage.length);
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

		map.put(ARMOR, armor);
		map.put(STORAGE, storage);

		return map;
	}
}
