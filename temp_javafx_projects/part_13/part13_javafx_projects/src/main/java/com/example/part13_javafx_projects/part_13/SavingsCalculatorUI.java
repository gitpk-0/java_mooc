package com.example.part13_javafx_projects.part_13;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class SavingsCalculatorUI {

    public Parent getView() {

        // Main Layout
        BorderPane layout = new BorderPane();


        // Savings Slider Pane
        BorderPane savingsPane = new BorderPane();
        Label saveInfo = new Label();
        Slider saveSlider = new Slider(25, 250, 25);
        saveSlider.setShowTickMarks(true);
        saveSlider.setShowTickLabels(true);
        saveSlider.setMajorTickUnit(25);
        saveSlider.setValue(50);
        savingsPane.setLeft(new Label("Monthly savings"));
        savingsPane.setCenter(saveSlider);
        saveInfo.setText("" + saveSlider.getValue());
        savingsPane.setRight(saveInfo);
        saveSlider.setPadding(new Insets(0, 20, 0, 20));
        savingsPane.setPadding(new Insets(10));


        // Interest Slider Pane
        BorderPane interestPane = new BorderPane();
        Label interestInfo = new Label();
        Slider interestSlider = new Slider(0, 10, 0);
        interestSlider.setMinorTickCount(10);
        interestSlider.setShowTickMarks(true);
        interestSlider.setShowTickLabels(true);
        interestSlider.setValue(2.5);
        interestPane.setLeft(new Label("Yearly Interest Rate"));
        interestPane.setCenter(interestSlider);
        interestInfo.setText("" + interestSlider.getValue());
        interestPane.setRight(interestInfo);
        interestSlider.setPadding(new Insets(0, 20, 0, 20));
        interestPane.setPadding(new Insets(10));


        // Line Chart
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings Calculator");

        // event listeners
        saveSlider.valueProperty().addListener((observable, oldVal, newVal) -> {
            double savings = newVal.intValue();
            saveInfo.setText("" + savings);

            updateChart(lineChart, interestSlider.getValue(), savings);
        });

        interestSlider.valueProperty().addListener((observable, oldVal, newVal) -> {
            double interest = Math.round(newVal.doubleValue() * 100);
            interestInfo.setText("" + interest / 100);

            updateChart(lineChart, interest, saveSlider.getValue());
        });


        VBox sliders = new VBox();
        sliders.getChildren().addAll(savingsPane, interestPane);

        layout.setTop(sliders);
        layout.setCenter(lineChart);

        return layout;
    }

    private LineChart updateChart(LineChart lineChart, double interestSlider, double saveSlider) {
        lineChart.getData().clear();

        // Chart Data
        XYChart.Series savingsData = new XYChart.Series();
        savingsData.setName("Savings");
        XYChart.Series interestData = new XYChart.Series();
        interestData.setName("Savings with Interest");

        int year = 0;
        int months = 12;
        double savings = 0.0;
        double interest = 0.0;

        while (year <= 30) {
            savings += saveSlider * months;
            interest = (interest + saveSlider * months) * (1.0 + interestSlider / 100);

            savingsData.getData().add(new XYChart.Data(year, savings));
            interestData.getData().add(new XYChart.Data(year, interest));

            year++;
        }

        lineChart.getData().addAll(savingsData, interestData);
        return lineChart;
    }

}