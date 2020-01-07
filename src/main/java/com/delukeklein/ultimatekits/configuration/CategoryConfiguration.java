package com.delukeklein.ultimatekits.configuration;

import com.delukeklein.ultimatekits.UltimateKits;
import com.delukeklein.ultimatekits.kit.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryConfiguration extends AbstractConfiguration<Category> {

    public CategoryConfiguration(final UltimateKits plugin) {
        super(plugin, "categories");
    }

    public String getDefaultCategory() {
        return getKeys().isEmpty() ? "" : getCategoryNames().get(0);
    }

    public String findFirstByName(final String name) {
        String result = getDefaultCategory();

        for (final String key : getKeys()) {
            result = get(key).getName();

            if(result.equalsIgnoreCase(name)) {
                break;
            }
        }

        return result;
    }

    public List<String> getCategoryNames() {
        final ArrayList<String> names = new ArrayList<>();

        for (final String key : getKeys()) {
            names.add(get(key).getName());
        }

        return names;
    }
}
