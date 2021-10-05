package controller;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ViewDriverDetailsController {
    public AnchorPane driverContext;
    public TableView driverTbl;
    public TableColumn colName;
    public TableColumn colNIC;
    public TableColumn colLiceneNo;
    public TableColumn colAddress;
    public TableColumn colContact;

    public void initialize(){
        driverTbl.setItems(FXCollections.observableArrayList(DriverFormController.driverArrayList));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        colLiceneNo.setCellValueFactory(new PropertyValueFactory<>("liceneNo"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));

    }
}
