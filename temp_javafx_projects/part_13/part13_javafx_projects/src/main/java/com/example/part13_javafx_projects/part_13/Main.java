package com.example.part13_javafx_projects.part_13;


import javafx.application.Application;

public class Main {

    public static void main(String[] args) {
        Application.launch(GetParameters.class,
                "--organization=Once upon a time",
                "--course=Title");
    }

}
