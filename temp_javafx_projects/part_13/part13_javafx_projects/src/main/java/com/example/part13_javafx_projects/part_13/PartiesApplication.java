package com.example.part13_javafx_projects.part_13;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.nio.file.Paths;
import java.util.*;

public class PartiesApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // String = Party, Int = Year, Dbl = data
        Map<String, Map<Integer, Double>> values = new HashMap<>();
        String file = "partiesdata.tsv";


        ArrayList<String> headers = new ArrayList<>();

        try (Scanner reader = new Scanner(Paths.get(file))) {
            int count = 0;
            while (count == 0 && reader.hasNextLine()) {
                String row = reader.nextLine();
                String[] parts = row.split("\t");

                for (String part : parts) {
                    headers.add(part);
                }

                count++;
            }
            while (count > 0 && reader.hasNextLine()) {
                int index = 1;

                String row = reader.nextLine();
                String[] parts = row.split("\t");

                values.put(parts[0], new HashMap<>());

                for (String part : parts) {
                    if (index > 11) break;
                    int year = Integer.valueOf(headers.get(index));

                    if (!parts[index].equals("-")) {
                        double supportPerc = Double.valueOf(parts[index]);
                        values.get(parts[0]).put(year, supportPerc);
                    }
                    index++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);

        xAxis.setLabel("Year");
        yAxis.setLabel("Relative Support (%)");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative Support of the parties");

        values.keySet().forEach(party -> {
            XYChart.Series data = new XYChart.Series();
            data.setName(party);

            values.get(party).entrySet()
                    .forEach(pair -> {
                        data.getData()
                                .add(new XYChart.Data(pair.getKey(), pair.getValue()));
                    });

            lineChart.getData().add(data);
        });

        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }
}
