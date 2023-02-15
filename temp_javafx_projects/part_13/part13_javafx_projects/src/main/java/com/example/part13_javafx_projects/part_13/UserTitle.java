package com.example.part13_javafx_projects.part_13;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Scanner;

public class UserTitle extends Application {

    @Override
    public void start(Stage window) {
        Parameters p = getParameters();
        String input = p.getNamed().get("title");

        window.setTitle(input);
        window.show();
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a title: ");
        String input = scanner.nextLine();

        String runTimeParam = "--title=" + input;

        Application.launch(UserTitle.class,
                runTimeParam);
    }
}
