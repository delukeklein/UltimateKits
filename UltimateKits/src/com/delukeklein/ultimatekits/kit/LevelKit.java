package com.delukeklein.ultimatekits.kit;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

import com.delukeklein.ultimatekits.kit.equipment.Equipment;

final class LevelKit extends AbstractKit {
	
	private final Map<Level, Equipment> levels;
	
	private LevelKit() {
		super();
		
		this.levels = new HashMap<>();
	}
	
	@SuppressWarnings("unchecked")
	public LevelKit(final Map<String, Object> map) {
		super(map);
		
		this.levels = (Map<Level, Equipment>) map.get("levels");
	}
	
	@Override
	public void giveKit(final Player player) {
		// TODO Auto-generated method stub
	}

	@Override
	public Map<String, Object> serialize() {
		final Map<String, Object> map = super.serialize();
		
		map.put("levels", levels);
		
		return map;
	}

}