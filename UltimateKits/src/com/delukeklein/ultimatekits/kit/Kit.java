package com.delukeklein.ultimatekits.kit;

import java.util.List;

import org.bukkit.entity.Player;

public interface Kit {

	void giveKit(final Player player);
	
	void setPrice(final int price);
	
	void setName(final String name);
	
	void setCategory(final String category);
	
	void setDescription(final List<String> description);
	
	int getPrice();
	
	String getName();
	
	String getCategory();
	
	List<String> getDescription();
	
}
