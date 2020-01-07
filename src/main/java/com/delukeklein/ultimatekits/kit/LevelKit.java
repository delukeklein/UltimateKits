package com.delukeklein.ultimatekits.kit;

import com.delukeklein.ultimatekits.kit.data.Upgradeable;
import com.delukeklein.ultimatekits.kit.equipment.Level;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class LevelKit extends AbstractKit implements Upgradeable {
	
	private final List<Level> levels;
	
	public LevelKit(final String name) {
		super(name);

		this.levels = new ArrayList<>();
	}
	
	@SuppressWarnings("unchecked")
	public LevelKit(Map<String, Object> map) {
		super(map);
		
		this.levels = (List<Level>) map.get("levels");
	}

	@Override
	public void give(final Player player) {
		//TODO Give kit to player.
	}

	@Override
	public boolean add(final Level level) {
		return levels.add(level);
	}

	@Override
	public boolean remove(final String name) {
		return levels.removeIf(l -> name.equalsIgnoreCase(l.getName()));
	}

	@Override
	public Map<String, Object> serialize() {
		final Map<String, Object> map = super.serialize();
		
		map.put("levels", levels);
		
		return map;
	}
}