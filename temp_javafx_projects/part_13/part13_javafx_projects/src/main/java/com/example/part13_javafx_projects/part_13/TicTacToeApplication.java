package com.example.part13_javafx_projects.part_13;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    private Button[][] buttons = new Button[3][3];
    private String currentPlayer = "X";
    private String turn = "Turn: " + getCurrentPlayer();
    private String gameEnd = "";
    private boolean gameOver = false;

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(20));

        Label gameStatus = new Label(turn);
        gameStatus.setStyle("-fx-font: 48 arial");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Button reset = new Button("Reset");
        reset.setPadding(new Insets(20));
        reset.setStyle("-fx-text-fill: black;"+
                "-fx-background-color: #c21f1f;"+
                "-fx-font-weight: bold;"+
                "-fx-font-size: 30;");

        reset.setOnAction((click) -> {
            try {
                resetGame(stage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        // BOARD LOGIC
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                Button current = new Button();
                current.setPrefSize(200, 200);
                // current.setText(row + "," + col);

                current.setOnAction(click -> {
                    if (gameOver) return;
                    if (!current.getText().isEmpty()) return;

                    current.setText(getCurrentPlayer());
                    current.setStyle("-fx-font: 80 arial");

                    if (checkForWin() > 0) {
                        gameStatus.textProperty().setValue("The end, " + getCurrentPlayer() + " wins!");
                        reset.textProperty().setValue("Play Again");
                        reset.setStyle("-fx-text-fill: white;"+
                                "-fx-background-color: green;"+
                                "-fx-font-weight: bold;"+
                                "-fx-font-size: 30;");
                    } else if (checkForWin() < 0) {
                        gameStatus.textProperty().setValue("The end, its a draw!");
                        reset.textProperty().setValue("Play Again");
                        reset.setStyle("-fx-text-fill: white;"+
                                "-fx-background-color: green;"+
                                "-fx-font-weight: bold;"+
                                "-fx-font-size: 30;");
                    } else {
                        changeTurn();
                        gameStatus.textProperty().setValue("Turn: " + getCurrentPlayer());
                    }
                });

                buttons[row][col] = current;
                grid.add(current, col, row);
            }
        }

        layout.setTop(gameStatus);
        layout.setCenter(grid);
        layout.setBottom(reset);
        BorderPane.setMargin(grid, new Insets(20));

        Scene scene = new Scene(layout, 740, 800);

        stage.setScene(scene);
        stage.show();
    }

    // BOARD LOGIC
    public int checkForWin() {
        // draw
        boolean draw = false;
        while (true) {
            int count = 0;
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (!buttons[row][col].getText().isEmpty()) {
                        count++;
                    }
                }
            }

            if (count > 8) {
                draw = true;
            }
            break;
        }

        // row
        boolean rowCheck = false;
        for (int row = 0; row < 3; row++) {
            String tic = buttons[row][0].getText();
            String tac = buttons[row][1].getText();
            String toe = buttons[row][2].getText();

            if (tic.isEmpty() || tac.isEmpty() || toe.isEmpty()) {
                continue;
            }

            if (tic.equals(tac) && tac.equals(toe)) {
                rowCheck = true;
                break;
            }
        }

        // column
        boolean columnCheck = false;
        for (int col = 0; col < 3; col++) {
            String tic = buttons[0][col].getText();
            String tac = buttons[1][col].getText();
            String toe = buttons[2][col].getText();

            if (tic.isEmpty() || tac.isEmpty() || toe.isEmpty()) {
                continue;
            }

            if (tic.equals(tac) && tac.equals(toe)) {
                System.out.println("column win");
                System.out.println(tic + ": " + col);
                columnCheck = true;
                break;
            }
        }

        // diagonal
        boolean diagonal = false;
        while (true) {
            // forward
            String tic = buttons[0][0].getText();
            String tac = buttons[1][1].getText();
            String toe = buttons[2][2].getText();

            if (tac.isEmpty()) {
                break;
            }

            if (tic.equals(tac) && tac.equals(toe)) {
                diagonal = true;
                break;
            }

            // backward
            tic = buttons[2][0].getText();
            toe = buttons[0][2].getText();

            if (tic.equals(tac) && tac.equals(toe)) {
                diagonal = true;
                break;
            }
            break;
        }

        if (rowCheck || columnCheck || diagonal) {
            gameOver = true;
            return 1;
        }

        if (draw) {
            gameOver = true;
            return -1;
        }

        gameOver = false;
        return 0;
    }

    // BOARD LOGIC
    public void changeTurn() {
        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
    }

    // BOARD LOGIC
    public void resetGame(Stage stage) throws Exception {
        currentPlayer = "X";
        turn = "Turn: " + currentPlayer;
        gameOver = false;
        start(stage);
    }

    // BOARD LOGIC
    public String getCurrentPlayer() {
        return currentPlayer;
    }


    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }
}
