package com.example.part13_javafx_projects.part_13;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeChatGPT extends Application {

    private Button[][] buttons = new Button[3][3];
    private String currentPlayer = "X";

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button button = new Button();
                button.setFont(Font.font("Arial", 40));
                button.setOnAction(event -> {
                    if (!button.getText().isEmpty()) {
                        return;
                    }
                    button.setText(currentPlayer);
                    if (checkForWin()) {
                        System.out.println(currentPlayer + " wins!");
                        System.exit(0);
                    }
                    currentPlayer = currentPlayer.equals("X") ? "O" : "X";
                });
                buttons[row][col] = button;
                gridPane.add(button, col, row);
            }
        }

        Scene scene = new Scene(gridPane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private boolean checkForWin() {
        // Check rows
        for (int row = 0; row < 3; row++) {
            if (buttons[row][0].getText().equals(currentPlayer) &&
                    buttons[row][1].getText().equals(currentPlayer) &&
                    buttons[row][2].getText().equals(currentPlayer)) {
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (buttons[0][col].getText().equals(currentPlayer) &&
                    buttons[1][col].getText().equals(currentPlayer) &&
                    buttons[2][col].getText().equals(currentPlayer)) {
                return true;
            }
        }

        // Check diagonals
        if (buttons[0][0].getText().equals(currentPlayer) &&
                buttons[1][1].getText().equals(currentPlayer) &&
                buttons[2][2].getText().equals(currentPlayer)) {
            return true;
        }
        if (buttons[0][2].getText().equals(currentPlayer) &&
                buttons[1][1].getText().equals(currentPlayer) &&
                buttons[2][0].getText().equals(currentPlayer)) {
            return true;
        }

        return false;
    }
}
