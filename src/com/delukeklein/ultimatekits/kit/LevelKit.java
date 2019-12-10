package com.delukeklein.ultimatekits.kit;

import java.util.List;
import java.util.Map;

import org.bukkit.entity.Player;

import com.delukeklein.ultimatekits.kit.equipment.Level;

public final class LevelKit extends AbstractKit implements Levelable {
	
	private final List<Level> levels;
	
	public LevelKit(final String name) {
		super(name);

		this.levels = List.of();
	}
	
	@SuppressWarnings("unchecked")
	public LevelKit(final Map<String, Object> map) {
		super(map);
		
		this.levels = (List<Level>) map.get("levels");
	}

	@Override
	public void giveKit(final Player player) {
		
	}
	
	@Override
	public void addLevel(final Level level) {
		levels.add(level);
	}
	
	@Override
	public boolean removeLevel(final String levelName) {
		return levels.removeIf(l -> l.getName() == levelName);
	}

	@Override
	public Map<String, Object> serialize() {
		final Map<String, Object> map = super.serialize();
		
		map.put("levels", levels);
		
		return map;
	}
}