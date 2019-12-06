package com.delukeklein.ultimatekits.kit;

import java.util.List;
import java.util.Map;

import org.bukkit.entity.Player;

final class BaseLevelKit extends AbstractKit implements LevelKit {
	
	private final List<Level> levels;
	
	@SuppressWarnings("unchecked")
	public BaseLevelKit(final Map<String, Object> map) {
		super(map);
		
		this.levels = (List<Level>) map.get("levels");
	}
	
	@Override
	public void giveKit(final Player player) {
		
	}

	@Override
	public void addLevel(Level level) {
		levels.add(level);
	}

	@Override
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