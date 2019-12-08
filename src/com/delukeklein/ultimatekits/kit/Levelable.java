package com.delukeklein.ultimatekits.kit;

import com.delukeklein.ultimatekits.kit.equipment.Level;

public interface Levelable {

	public void addLevel(Level level);
	
	public boolean removeLevel(String levelName);
	
}
