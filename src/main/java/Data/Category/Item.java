package Data.Category;

import Data.Action.Crafting;

public class Item {
    private String name;
    private String icon;
    private Crafting crafting;

    public Item(String name, String icon, Crafting crafting) {
        this.name = name;
        this.icon = icon;
        this.crafting = crafting;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public Crafting getCrafting() {
        return crafting;
    }
}