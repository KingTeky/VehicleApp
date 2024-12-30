package com.carrental;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class VehicleApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Vehicle Management System");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Vehicle Type
        Label vehicleTypeLabel = new Label("Vehicle Type:");
        GridPane.setConstraints(vehicleTypeLabel, 0, 0);
        ChoiceBox<String> vehicleTypeChoice = new ChoiceBox<>();
        vehicleTypeChoice.getItems().addAll("Car", "Motorcycle", "Truck");
        GridPane.setConstraints(vehicleTypeChoice, 1, 0);

        // Make
        Label makeLabel = new Label("Make:");
        GridPane.setConstraints(makeLabel, 0, 1);
        TextField makeInput = new TextField();
        GridPane.setConstraints(makeInput, 1, 1);

        // Model
        Label modelLabel = new Label("Model:");
        GridPane.setConstraints(modelLabel, 0, 2);
        TextField modelInput = new TextField();
        GridPane.setConstraints(modelInput, 1, 2);

        // Year
        Label yearLabel = new Label("Year:");
        GridPane.setConstraints(yearLabel, 0, 3);
        TextField yearInput = new TextField();
        GridPane.setConstraints(yearInput, 1, 3);

        // Additional Fields
        Label additionalLabel = new Label("Additional Info:");
        GridPane.setConstraints(additionalLabel, 0, 4);
        TextField additionalInput = new TextField();
        GridPane.setConstraints(additionalInput, 1, 4);

        // Submit Button
        Button submitButton = new Button("Submit");
        GridPane.setConstraints(submitButton, 1, 5);

        // Output Area
        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);
        GridPane.setConstraints(outputArea, 0, 6, 2, 1);

        submitButton.setOnAction(e -> {
            String vehicleType = vehicleTypeChoice.getValue();
            String make = makeInput.getText();
            String model = modelInput.getText();
            int year = Integer.parseInt(yearInput.getText());
            String additionalInfo = additionalInput.getText();

            Vehicle vehicle;
            switch (vehicleType) {
                case "Car":
                    Car car = new Car(make, model, year);
                    car.setNumberOfDoors(Integer.parseInt(additionalInfo.split(",")[0]));
                    car.setFuelType(additionalInfo.split(",")[1]);
                    vehicle = car;
                    break;
                case "Motorcycle":
                    Motorcycle motorcycle = new Motorcycle(make, model, year);
                    motorcycle.setNumberOfWheels(Integer.parseInt(additionalInfo.split(",")[0]));
                    motorcycle.setMotorcycleType(additionalInfo.split(",")[1]);
                    vehicle = motorcycle;
                    break;
                case "Truck":
                    Truck truck = new Truck(make, model, year);
                    truck.setCargoCapacity(Double.parseDouble(additionalInfo.split(",")[0]));
                    truck.setTransmissionType(additionalInfo.split(",")[1]);
                    vehicle = truck;
                    break;
                default:
                    vehicle = null;
            }

            if (vehicle != null) {
                outputArea.setText("Vehicle Details:\n" +
                        "Make: " + vehicle.getMake() + "\n" +
                        "Model: " + vehicle.getModel() + "\n" +
                        "Year: " + vehicle.getYear() + "\n" +
                        "Additional Info: " + additionalInfo);
            }
        });

        grid.getChildren().addAll(vehicleTypeLabel, vehicleTypeChoice, makeLabel, makeInput, modelLabel, modelInput, yearLabel, yearInput, additionalLabel, additionalInput, submitButton, outputArea);

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
