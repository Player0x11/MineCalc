package UI;

import Data.Category.Block;
import Data.Category.Item;
import Data.Category.Tool;

import UI.Listeners.CalculateButtonListener;
import UI.Listeners.ItemComboBoxListener;
import UI.Listeners.ModeComboBoxListener;
import Data.LogicMC;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class Interface {
    public JFrame frame;
    public static JTextField quantityTextField;
    public static JTextArea resultTextArea;
    public static JComboBox<String> modeComboBox;
    public static JComboBox<String> itemComboBox;


    public Interface(List<Block> blocks, List<Tool> tools, List<Item> items) {
        LogicMC.blocks = blocks;
        LogicMC.tools = tools;
        LogicMC.items = items;

        frame = new JFrame("Crafting and Mining Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setMaximumSize(new Dimension(800, 600));
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        modeComboBox = new JComboBox<>(new String[]{"Mining", "Crafting", "Both"});
        modeComboBox.addActionListener(new ModeComboBoxListener());
        topPanel.add(modeComboBox);

        itemComboBox = new JComboBox<>();
        itemComboBox.addActionListener(new ItemComboBoxListener());
        topPanel.add(itemComboBox);

        quantityTextField = new JTextField(5);
        topPanel.add(quantityTextField);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        topPanel.add(calculateButton);

        frame.add(topPanel, BorderLayout.NORTH);

        resultTextArea = new JTextArea(10, 20);
        resultTextArea.setEditable(false);
        frame.add(new JScrollPane(resultTextArea), BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }
}