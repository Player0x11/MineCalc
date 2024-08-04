package Data.Category;

import Data.Action.Crafting;
import Data.Action.Mining;

public class Block {
    private String name;
    private String icon;
    private Mining mining;
    private Crafting crafting;

    public Block(String name, String icon, Mining mining, Crafting crafting) {
        this.name = name;
        this.icon = icon;
        this.mining = mining;
        this.crafting = crafting;
    }


    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public Mining getMining() {
        return mining;
    }
}