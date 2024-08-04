package Data;

import Data.Category.Block;
import Data.Category.Item;
import Data.Category.Tool;

import java.util.ArrayList;
import java.util.List;

public class LogicMC {

    public static List<Block> blocks;
    public static List<Tool> tools;
    public static List<Item> items;

    public static Block getBlockByName(String name) {
        for (Block block : blocks) {
            if (block.getName().equals(name)) {
                return block;
            }
        }
        return null;
    }

    public static Item getItemByName(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public static List<Tool> getSuitableTools(Block block) {
        List<Tool> suitableTools = new ArrayList<>();
        for (Tool tool : tools) {
            if (tool.getMiningLevel() >= block.getMining().getLevel()) {
                suitableTools.add(tool);
            }
        }
        return suitableTools;
    }

    public static int getToolResourceCost(Tool tool) {
        // Implement logic to calculate resource cost for a tool
        return 0;
    }
}
