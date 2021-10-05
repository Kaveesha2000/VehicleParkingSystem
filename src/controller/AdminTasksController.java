package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AdminTasksController {
    public AnchorPane adminTasksContext;
    public AnchorPane windowContext;

    public void goToHomePage(ActionEvent actionEvent) throws IOException {
        try {
            Stage stage = (Stage) adminTasksContext.getScene().getWindow();
            stage.close();
        }catch (Exception e) {}

    }

    public void goToViewInsideVehicle(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ParkedVehicles.fxml");
        Parent load = FXMLLoader.load(resource);
        windowContext.getChildren().clear();
        windowContext.getChildren().add(load);
    }

    public void goToOutsideVehicles(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/OnDeliveryVehicles.fxml");
        Parent load = FXMLLoader.load(resource);
        windowContext.getChildren().clear();
        windowContext.getChildren().add(load);
    }

    public void goToAddVehicles(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddVehicles.fxml");
        Parent load = FXMLLoader.load(resource);
        windowContext.getChildren().clear();
        windowContext.getChildren().add(load);
    }

    public void goToAddDriver(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DriverForm.fxml");
        Parent load = FXMLLoader.load(resource);
        windowContext.getChildren().clear();
        windowContext.getChildren().add(load);
    }
}
