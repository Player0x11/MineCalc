package UI.Listeners;

import Data.Action.Crafting;
import Data.Category.Block;
import Data.Category.Item;
import Data.Category.Recipe;
import Data.Category.Tool;

import UI.Interface;
import Data.LogicMC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CalculateButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String mode = (String) Interface.modeComboBox.getSelectedItem();
        String itemName = (String) Interface.itemComboBox.getSelectedItem();
        int quantity = Integer.parseInt(Interface.quantityTextField.getText());

        if (mode.equals("Mining")) {
            Block block = LogicMC.getBlockByName(itemName);
            List<Tool> suitableTools = LogicMC.getSuitableTools(block);
            Interface.resultTextArea.setText("Suitable tools for mining " + quantity + " " + block.getName() + ":\n");
            for (Tool tool : suitableTools) {
                int toolQuantity = (int) Math.ceil((double) quantity / tool.getDurability());
                Interface.resultTextArea.append(tool.getName() + ": " + toolQuantity + " (resources: " + toolQuantity * LogicMC.getToolResourceCost(tool) + ")\n");
            }
        } else if (mode.equals("Crafting")) {
            Item item = LogicMC.getItemByName(itemName);
            Crafting crafting = item.getCrafting();
            Interface.resultTextArea.setText("Resources needed for crafting " + quantity + " " + item.getName() + ":\n");
            for (Recipe recipe : crafting.getRecipe()) {
                Interface.resultTextArea.append(recipe.getItem() + ": " + recipe.getQuantity() * quantity + "\n");
            }
        } else if (mode.equals("Both")) {
            // не сегодня
        }
    }
}
