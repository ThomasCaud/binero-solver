package org.tcaud.display;

import org.tcaud.grid.BineroGrid;
import org.tcaud.grid.Grid;

import javax.swing.*;
import java.awt.*;

public class DisplayStrategyFrame implements DisplayStrategy {
    private final JFrame jFrame;
    private JTextField[][] textFields;

    public DisplayStrategyFrame() {
        jFrame = new JFrame("Binero grid");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(500, 500);
    }

    @Override
    public void display(Grid grid) {
        jFrame.setLayout(new GridLayout(grid.getDimension(), grid.getDimension()));

        initializeTextFields(grid);
        updateDigits(grid);

        jFrame.setVisible(true);
    }

    private void initializeTextFields(Grid grid) {
        if (textFields == null) {
            textFields = new JTextField[grid.getDimension()][grid.getDimension()];
            for (int i = 0; i < grid.getDimension(); i++) {
                for (int j = 0; j < grid.getDimension(); j++) {
                    var textField = new JTextField();
                    textField.setHorizontalAlignment(JTextField.CENTER);
                    textField.setEditable(false);
                    jFrame.add(textField);
                    textFields[i][j] = textField;
                }
            }
        }
    }

    private void updateDigits(Grid grid) {
        for (int i = 0; i < grid.getDimension(); i++) {
            for (int j = 0; j < grid.getDimension(); j++) {
                var textField = textFields[i][j];
                if (grid.getGrid()[i][j] != BineroGrid.VALUE_EMPTY_CELL) {
                    textField.setText(Integer.toString(grid.getGrid()[i][j]));
                } else {
                    textField.setText("");
                }
            }
        }
    }
}
