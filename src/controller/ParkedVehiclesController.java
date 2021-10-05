package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.ParkedVehiclesTM;

public class ParkedVehiclesController {
    public TableView parkedVehicleTbl;
    public TableColumn colVehicleNo;
    public TableColumn colVehicleType;
    public TableColumn colParkingSlot;
    public TableColumn colParkedTime;

    public static ObservableList<ParkedVehiclesTM> parkedVehiclesTMObservableList = FXCollections.observableArrayList();

    public void initialize(){
        parkedVehicleTbl.setItems(parkedVehiclesTMObservableList);
        colVehicleNo.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colParkingSlot.setCellValueFactory(new PropertyValueFactory<>("parkingSlot"));
        colParkedTime.setCellValueFactory(new PropertyValueFactory<>("parkedTime"));
    }
}
