package com.example.part13_javafx_projects.part_13;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        NumberAxis xAxis = new NumberAxis(2006, 2018, 2);
        NumberAxis yAxis = new NumberAxis(0, 100, 10);

        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");



        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai ranking");

        XYChart.Series rankingData = new XYChart.Series();
        rankingData.setName("");
        rankingData.getData().add(new XYChart.Data(2007, 73));
        rankingData.getData().add(new XYChart.Data(2008, 68));
        rankingData.getData().add(new XYChart.Data(2009, 72));
        rankingData.getData().add(new XYChart.Data(2010, 72));
        rankingData.getData().add(new XYChart.Data(2011, 74));
        rankingData.getData().add(new XYChart.Data(2012, 73));
        rankingData.getData().add(new XYChart.Data(2013, 76));
        rankingData.getData().add(new XYChart.Data(2014, 73));
        rankingData.getData().add(new XYChart.Data(2015, 67));
        rankingData.getData().add(new XYChart.Data(2016, 56));
        rankingData.getData().add(new XYChart.Data(2017, 56));


        lineChart.getData().add(rankingData);

        Scene scene = new Scene(lineChart, 440, 280);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }
}
