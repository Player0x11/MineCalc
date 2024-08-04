import Data.Category.Block;
import Data.Category.Item;
import Data.JSON.JsonReader;
import Data.Category.Tool;
import UI.Interface;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Current working directory: " + System.getProperty("user.dir"));

        File json = new File("data.json");
        List<Block> blocks = JsonReader.readBlocks(json);
        List<Tool> tools = JsonReader.readTools(json);
        List<Item> items = JsonReader.readItems(json);

        Interface Interface = new Interface(blocks, tools, items);
    }
}