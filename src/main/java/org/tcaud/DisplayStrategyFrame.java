package org.tcaud;

import javax.swing.*;
import java.awt.*;

public class DisplayStrategyFrame implements DisplayStrategy {
    private final JFrame jFrame;

    public DisplayStrategyFrame() {
        jFrame = new JFrame("Binero grid");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(500, 500);
    }

    @Override
    public void display(Grid grid) {
        jFrame.setLayout(new GridLayout(grid.getDimension(), grid.getDimension()));

        deleteExistingComponents();
        displayDigits(grid);

        jFrame.setVisible(true);
    }

    private void displayDigits(Grid grid) {
        for (int i = 0; i < grid.getDimension(); i++) {
            for (int j = 0; j < grid.getDimension(); j++) {
                JTextField textField = new JTextField();
                textField.setHorizontalAlignment(JTextField.CENTER);
                if (grid.getGrid()[i][j] != Grid.VALUE_EMPTY_CELL) {
                    textField.setText(Integer.toString(grid.getGrid()[i][j]));
                }
                textField.setEditable(false);

                jFrame.add(textField);
            }
        }
    }

    private void deleteExistingComponents() {
        Container contentPane = jFrame.getContentPane();
        Component[] components = contentPane.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                contentPane.remove(component);
            }
        }
    }
}
