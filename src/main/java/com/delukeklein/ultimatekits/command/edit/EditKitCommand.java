package com.delukeklein.ultimatekits.command.edit;

import com.delukeklein.ultimatekits.command.composite.CompositeSubCommand;
import com.delukeklein.ultimatekits.configuration.CategoryConfiguration;
import com.delukeklein.ultimatekits.configuration.KitConfiguration;

import com.delukeklein.ultimatekits.kit.data.Describable;
import org.apache.commons.lang3.math.NumberUtils;
import org.bukkit.command.CommandSender;

public final class EditKitCommand extends CompositeSubCommand {

    private final static String NAME = "name";
    private final static String DESCRIPTION = "description";
    private final static String PRICE = "price";
    private final static String CATEGORY = "category";

    public EditKitCommand(final KitConfiguration kitConfig, final CategoryConfiguration categoryConfig) {
        super(
                new Entry(NAME, new EditKitSubCommand(kitConfig,
                    (kit, input) -> kit.setName(input)
                )),

                new Entry(PRICE, new EditKitSubCommand(kitConfig,
                    (kit, input) -> kit.setPrice(NumberUtils.toInt(input, 0))
                )),

                new Entry(DESCRIPTION, new EditKitSubCommand(kitConfig,
                    (kit, data) -> kit.setDescription(Describable.fromLineSeparator(data))
                )),

                new Entry(CATEGORY, new EditKitSubCommand(kitConfig,
                    (kit, data) -> kit.setCategory(categoryConfig.findFirstByName(data))
                ))
        );
    }

    @Override
    public void severe(final CommandSender sender, final String label, final String[] args) {

    }
}
