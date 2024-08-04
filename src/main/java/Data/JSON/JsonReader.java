package Data.JSON;
import Data.Action.Crafting;
import Data.Action.Mining;
import Data.Category.Block;
import Data.Category.Item;
import Data.Category.Tool;

// https://github.com/stleary/JSON-java

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {
    public static List<Block> readBlocks(File file) throws FileNotFoundException {
        List<Block> blocks = new ArrayList<>();

        JSONObject jsonObject = new JSONObject(new java.util.Scanner(file).useDelimiter("\\Z").next());
        JSONArray jsonArray = jsonObject.getJSONArray("blocks");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject blockObject = jsonArray.getJSONObject(i);
            Mining mining = new Mining(blockObject.getJSONObject("mining").getInt("level"), blockObject.getJSONObject("mining").optString("tool", ""));
            Crafting crafting = blockObject.has("crafting")? new Crafting(blockObject.getJSONObject("crafting").getJSONArray("recipe")) : null;
            Block block = new Block(
                    blockObject.getString("name"),
                    blockObject.getString("icon"),
                    mining,
                    crafting
            );
            blocks.add(block);
        }
        return blocks;
    }

    public static List<Tool> readTools(File file) throws FileNotFoundException {
        List<Tool> tools = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(new java.util.Scanner(file).useDelimiter("\\Z").next());
        JSONArray jsonArray = jsonObject.getJSONArray("tools");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject toolObject = jsonArray.getJSONObject(i);
            Crafting crafting = toolObject.has("crafting")? new Crafting(toolObject.getJSONObject("crafting").getJSONArray("recipe")) : null;
            Tool tool = new Tool(
                    toolObject.getString("name"),
                    toolObject.getString("icon"),
                    toolObject.getInt("miningLevel"),
                    crafting,
                    toolObject.getInt("durability")
            );
            tools.add(tool);
        }
        return tools;
    }

    public static List<Item> readItems(File file) throws FileNotFoundException {
        List<Item> items = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(new java.util.Scanner(file).useDelimiter("\\Z").next());
        JSONArray jsonArray = jsonObject.getJSONArray("items");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject itemObject = jsonArray.getJSONObject(i);
            Crafting crafting = itemObject.has("crafting")? new Crafting(itemObject.getJSONObject("crafting").getJSONArray("recipe")) : null;
            Item item = new Item(
                    itemObject.getString("name"),
                    itemObject.getString("icon"),
                    crafting
            );
            items.add(item);
        }
        return items;
    }

}