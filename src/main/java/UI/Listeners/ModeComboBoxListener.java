package UI.Listeners;

import Data.Category.Block;
import Data.Category.Item;
import Data.LogicMC;

import UI.Interface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModeComboBoxListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String mode = (String) Interface.modeComboBox.getSelectedItem();
        Interface.itemComboBox.removeAllItems();
        if (mode.equals("Mining")) {
            for (Block block : LogicMC.blocks) {
                Interface.itemComboBox.addItem(block.getName());
            }
        } else if (mode.equals("Crafting")) {
            for (Item item : LogicMC.items) {
                Interface.itemComboBox.addItem(item.getName());
            }
        } else if (mode.equals("Both")) {
            for (Block block : LogicMC.blocks) {
                Interface.itemComboBox.addItem(block.getName());
            }
            for (Item item : LogicMC.items) {
                Interface.itemComboBox.addItem(item.getName());
            }
        }
    }
}
