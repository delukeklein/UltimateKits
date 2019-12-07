package com.delukeklein.ultimatekits.kit;

import java.util.Arrays;
import java.util.List;

public final class KitFactory {

	private int price;

	private boolean levelable;

	private String name;

	private String category;

	private List<String> description;
	
	public KitFactory() {
		this.price = 0;
		this.levelable = false;
		this.name = "";
		this.category = "";
		this.description = Arrays.asList(new String[] { "" });
	}

	public final KitFactory setPrice(final int price) {
		this.price = price;
		return this;
	}

	public final KitFactory isLevelable(final boolean levelable) {
		this.levelable = levelable;
		return this;
	}

	public final KitFactory setName(final String name) {
		this.name = name;
		return this;
	}

	public final KitFactory setCategory(final String category) {
		this.category = category;
		return this;
	}

	public final KitFactory setDescription(final List<String> description) {
		this.description = description;
		return this;
	}

	public Kit build() {
		final Kit kit = (levelable) ? new LevelKit() : new BasicKit();

		kit.setPrice(price);
		kit.setName(name);
		kit.setCategory(category);
		kit.setDescription(description);

		return kit;
	}

}
