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
    private String turn = "Turn: " + currentPlayer;
    private String gameOver = "The end!";

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(20));

        Label gameStatus = new Label(turn); // update to O and when Game Over -> X wins!
        gameStatus.setStyle("-fx-font: 48 arial");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                Button current = new Button();
                current.setPrefSize(200,200);


                current.setOnAction(click -> {
                    if (!current.getText().isEmpty()) {
                        return;
                    }

                    current.setText(currentPlayer);
                    current.setStyle("-fx-font: 80 arial");
                    // check for win

                    currentPlayer = currentPlayer.equals("X") ? "O" : "X";

                });
                buttons[row][col] = current;
                grid.add(current, col, row);

            }
        }

        layout.setTop(gameStatus);
        layout.setCenter(grid);


        Scene scene = new Scene(layout, 640, 700);

        stage.setScene(scene);
        stage.show();


    }

    public boolean checkForWin() {
        // row
        // column
        // diagonal
        return false;
    }



    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }
}
