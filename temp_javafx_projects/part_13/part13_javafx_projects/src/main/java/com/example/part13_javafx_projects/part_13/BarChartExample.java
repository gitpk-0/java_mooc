package com.example.part13_javafx_projects.part_13;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.Comparator;

public class BarChartExample extends Application {

    @Override
    public void start(Stage stage) {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

        barChart.setTitle("Populations of the Nordic countries");
        barChart.setLegendVisible(false);

        XYChart.Series populations = new XYChart.Series();
        XYChart.Series sortedPopulations = new XYChart.Series();
        populations.getData().add(new XYChart.Data("Sweden", 10313447));
        populations.getData().add(new XYChart.Data("Denmark", 5809502));
        populations.getData().add(new XYChart.Data("Finland", 5537364));
        populations.getData().add(new XYChart.Data("Norway", 5372191));
        populations.getData().add(new XYChart.Data("Iceland", 343518));

        // sort populations data by country name alphabetically -> add it to sortedPopulations series
        populations.getData().stream().map(data -> data.toString().substring(5))
                .map(data -> data.toString().substring(0, data.toString().length() - 6))
                .sorted()
                .forEach(obj -> sortedPopulations.getData().add(new XYChart.Data(String.valueOf(obj.toString().substring(0, obj.toString().indexOf(","))), Integer.valueOf(obj.toString().substring(obj.toString().indexOf(",") +1, obj.toString().length() -1)))));



        barChart.getData().add(sortedPopulations);
        Scene view = new Scene(barChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) {
        launch(BarChartExample.class);
    }
}
