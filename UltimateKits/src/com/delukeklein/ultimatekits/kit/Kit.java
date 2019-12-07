package com.delukeklein.ultimatekits.kit;

import java.util.List;

import org.bukkit.entity.Player;

public interface Kit {

	void setPrice(int price);

	void setName(String name);

	void setCategory(String category);
	
	void setDescription(List<String> description);
	
	void giveKit(Player player);

	int getPrice();

	String getName();

	String getCategory();

	List<String> getDescription();

}
