package controller;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ViewVehicleDetailsController {
    public AnchorPane vehicleContext;
    public TableView vehicleTbl;
    public TableColumn colVehicleNo;
    public TableColumn colVehicleType;
    public TableColumn colMaxWeight;
    public TableColumn colNoOfPassengers;

    public void initialize(){
        vehicleTbl.setItems(FXCollections.observableArrayList(AddVehiclesController.vehicleList));
        colVehicleNo.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colMaxWeight.setCellValueFactory(new PropertyValueFactory<>("maxWeight"));
        colNoOfPassengers.setCellValueFactory(new PropertyValueFactory<>("noOfPassengers"));
    }

}
