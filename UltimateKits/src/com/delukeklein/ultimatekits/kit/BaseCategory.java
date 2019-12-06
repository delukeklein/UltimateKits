package com.delukeklein.ultimatekits.kit;

import com.delukeklein.ultimatekits.api.kit.Category;

public final class BaseCategory implements Category {

	private String name;
	
	public BaseCategory(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}
	
}
