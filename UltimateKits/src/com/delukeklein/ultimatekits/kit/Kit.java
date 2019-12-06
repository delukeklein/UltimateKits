package com.delukeklein.ultimatekits.kit;

import java.util.List;

import org.bukkit.entity.Player;

import com.delukeklein.ultimatekits.kit.category.BaseCategory;

public interface Kit {

	void giveKit(final Player player);
	
	void setPrice(final int price);
	
	void setName(final String name);
	
	void setCategory(final BaseCategory category);
	
	void setDescription(final List<String> description);
	
	int getPrice();
	
	String getName();
	
	BaseCategory getCategory();
	
	List<String> getDescription();
	
}
