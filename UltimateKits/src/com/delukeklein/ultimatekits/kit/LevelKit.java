package com.delukeklein.ultimatekits.kit;

import java.util.List;
import java.util.Map;

import org.bukkit.entity.Player;

final class LevelKit extends AbstractKit {
	
	private final List<Level> levels;
	
	@SuppressWarnings("unchecked")
	public LevelKit(final Map<String, Object> map) {
		super(map);
		
		this.levels = (List<Level>) map.get("levels");
	}
	
	@Override
	public void giveKit(final Player player) {
		
	}
	
	public void addLevel(Level level) {
		levels.add(level);
	}
	
	public boolean removeLevel(String levelName) {
		return levels.removeIf(l -> l.getName() == levelName);
	}

	@Override
	public Map<String, Object> serialize() {
		final Map<String, Object> map = super.serialize();
		
		map.put("levels", levels);
		
		return map;
	}
}