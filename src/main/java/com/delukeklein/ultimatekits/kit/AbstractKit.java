package com.delukeklein.ultimatekits.kit;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractKit implements Kit, ConfigurationSerializable {

    private final static String PRICE = "price";
    private final static String NAME = "name";
    private final static String CATEGORY = "category";
    private final static String DESCRIPTION = "description";

    private int price;

    private String name;
    private String category;

    private List<String> description;

    public AbstractKit(final String name) {
        this.price = 0;
        this.name = name;
        this.category = null;
        this.description = List.of();
    }

    @SuppressWarnings("unchecked")
    public AbstractKit(Map<String, Object> map) {
        this.price = (int) map.get(PRICE);
        this.name = (String) map.get(NAME);
        this.category = (String) map.get(CATEGORY);
        this.description = (List<String>) map.get(DESCRIPTION);
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setPrice(final int price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public void setCategory(final String category) {
        this.category = category;
    }

    @Override
    public List<String> getDescription() {
        return description;
    }

    @Override
    public void setDescription(final List<String> description) {
        this.description = description;
    }

    @Override
    public Map<String, Object> serialize() {
        final Map<String, Object> map = new LinkedHashMap<>();

        map.put(PRICE, price);
        map.put(NAME, name);
        map.put(CATEGORY, category);
        map.put(DESCRIPTION, description);

        return map;
    }
}
