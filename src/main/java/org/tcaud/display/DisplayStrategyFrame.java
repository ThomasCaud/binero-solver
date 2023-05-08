package org.tcaud.display;

import org.tcaud.grid.Board;

import javax.swing.*;
import java.awt.*;

public class DisplayStrategyFrame implements DisplayStrategy {
    private final JFrame jFrame;
    private JTextField[][] textFields;

    public DisplayStrategyFrame() {
        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(500, 500);
    }

    @Override
    public void display(Board board) {
        jFrame.setLayout(new GridLayout(board.getDimension(), board.getDimension()));

        initializeTextFields(board);
        updateDigits(board);

        jFrame.setVisible(true);
    }

    private void initializeTextFields(Board board) {
        if (textFields == null) {
            textFields = new JTextField[board.getDimension()][board.getDimension()];
            for (int i = 0; i < board.getDimension(); i++) {
                for (int j = 0; j < board.getDimension(); j++) {
                    var textField = new JTextField();
                    textField.setHorizontalAlignment(JTextField.CENTER);
                    textField.setEditable(false);
                    jFrame.add(textField);
                    textFields[i][j] = textField;
                }
            }
        }
    }

    private void updateDigits(Board board) {
        for (int i = 0; i < board.getDimension(); i++) {
            for (int j = 0; j < board.getDimension(); j++) {
                var textField = textFields[i][j];
                if (board.getGrid()[i][j] != Board.VALUE_EMPTY_CELL) {
                    textField.setText(Integer.toString(board.getGrid()[i][j]));
                } else {
                    textField.setText("");
                }
            }
        }
    }
}
