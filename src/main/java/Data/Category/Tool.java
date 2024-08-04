package Data.Category;

import Data.Action.Crafting;

public class Tool {
    private String name;
    private String icon;
    private int miningLevel;
    private Crafting crafting;
    private int durability;

    public Tool(String name, String icon, int miningLevel, Crafting crafting, int durability) {
        this.name = name;
        this.icon = icon;
        this.miningLevel = miningLevel;
        this.crafting = crafting;
        this.durability = durability;
    }
    public String getName() {
        return name;
    }

    public int getMiningLevel() {
        return miningLevel;
    }

    public Crafting getCrafting() {
        return crafting;
    }

    public int getDurability() {
        return durability;
    }
}