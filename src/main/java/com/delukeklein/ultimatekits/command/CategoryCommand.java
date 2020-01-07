package com.delukeklein.ultimatekits.command;

import com.delukeklein.ultimatekits.command.composite.CompositeRootCommand;
import com.delukeklein.ultimatekits.command.create.CreateCategoryCommand;
import com.delukeklein.ultimatekits.configuration.CategoryConfiguration;
import org.bukkit.command.CommandSender;

public class CategoryCommand extends CompositeRootCommand {

    private final static String CREATE = "create";

    public CategoryCommand(final CategoryConfiguration categoryConfig) {
        super(
                new Entry(CREATE, new CreateCategoryCommand(categoryConfig)));
    }

    @Override
    public void severe(final CommandSender sender, final String label, final String[] args) {

    }
}
