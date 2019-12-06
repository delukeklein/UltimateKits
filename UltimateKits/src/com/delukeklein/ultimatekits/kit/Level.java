package com.delukeklein.ultimatekits.kit;

import com.delukeklein.ultimatekits.kit.equipment.Equipment;

public interface Level {
	
	public void setPrice(int price);
	
	public void setEquipment(Equipment equipment);
	
	public void setName(String name);
	
	public int getPrice();

	public boolean hasName(String name);
	
	public Equipment getEquipment();
	
	public String getName();
	
}
