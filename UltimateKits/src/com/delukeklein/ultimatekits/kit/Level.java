package com.delukeklein.ultimatekits.kit;

public interface Level {
	
	public void setPrice(int price);
	
	public void setName(String name);
	
	public int getPrice();

	public boolean hasName(String name);
	
	public String getName();

}
