package com.delukeklein.ultimatekits.kit.equipment;

public interface Level extends Equipment {

	public void setPrice(int price);
	
	public void setName(String name);
	
	public int getPrice();
	
	public String getName();
}
