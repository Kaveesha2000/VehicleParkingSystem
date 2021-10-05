package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.OnDeliveryVehiclesTM;

public class OnDeliveryVehiclesController {

    public TableView onDeliveryTbl;
    public TableColumn colVehicleNo;
    public TableColumn colVehicleType;
    public TableColumn colDriverName;
    public TableColumn colLeftTime;

    public static ObservableList<OnDeliveryVehiclesTM> onDeliveryVehiclesTMObservableList = FXCollections.observableArrayList();

    public void initialize(){
        onDeliveryTbl.setItems(onDeliveryVehiclesTMObservableList);
        colVehicleNo.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colDriverName.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        colLeftTime.setCellValueFactory(new PropertyValueFactory<>("leftTime"));
    }

}
