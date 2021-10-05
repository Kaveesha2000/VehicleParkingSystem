package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.Bus;
import model.CargoLorry;
import model.Van;
import model.Vehicle;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddVehiclesController {
    public JFXComboBox vehicleCmb;
    public JFXTextField vehicleNo;
    public JFXTextField noOfPassengers;
    public JFXTextField maxWeight;
    public AnchorPane vehicleContext;

    static ArrayList<Vehicle> vehicleList = new ArrayList();
    public Label vlabel1;
    public Label vlabel2;
    public Label vlabel3;

    public void initialize(){
            vehicleCmb.getItems().addAll("Van","Bus","Cargo Lorry");
    }

    public void addVehicle(ActionEvent actionEvent) {
            if (vehicleList.size()==14){
                new Alert(Alert.AlertType.WARNING,"You Cannot Add Vehicles!...", ButtonType.CLOSE).show();
            }else{
                try {
                    if(vehicleCmb.getSelectionModel().getSelectedItem().toString().equals("Van")){
                        Van van = new Van(vehicleNo.getText(),vehicleCmb.getValue().toString(),Integer.parseInt(noOfPassengers.getText()),Integer.parseInt(maxWeight.getText()));
                        vehicleNo.clear();
                        vehicleCmb.getSelectionModel().clearSelection();
                        noOfPassengers.clear();
                        maxWeight.clear();
                        //vehicleCmb.setValue(" ");
                        if (vehicleList.add(van)){
                            new Alert(Alert.AlertType.CONFIRMATION,"Saved successfully...", ButtonType.CLOSE).show();
                        }else{
                            new Alert(Alert.AlertType.WARNING,"Try Again...", ButtonType.CLOSE).show();
                        }
                    }

                    if(vehicleCmb.getSelectionModel().getSelectedItem().toString().equals("Bus")){

                    //-------------------------------------------------------
                        Bus bus = new Bus(vehicleNo.getText(),vehicleCmb.getValue().toString(),Integer.parseInt(noOfPassengers.getText()),Integer.parseInt(maxWeight.getText()));
                        vehicleNo.clear();
                        vehicleCmb.getSelectionModel().clearSelection();
                        noOfPassengers.clear();
                        maxWeight.clear();

                        if (vehicleList.add(bus)){
                            new Alert(Alert.AlertType.CONFIRMATION,"Saved successfully...", ButtonType.CLOSE).show();
                        }else{
                            new Alert(Alert.AlertType.WARNING,"Try Again...", ButtonType.CLOSE).show();
                        }
                    //-------------------------------------------------------
                    }

                    if(vehicleCmb.getSelectionModel().getSelectedItem().toString().equals("Cargo Lorry")){
                        CargoLorry cargoLorry = new CargoLorry(vehicleNo.getText(),vehicleCmb.getValue().toString(),Integer.parseInt(noOfPassengers.getText()),Integer.parseInt(maxWeight.getText()));
                        vehicleNo.clear();
                        vehicleCmb.getSelectionModel().clearSelection();
                        noOfPassengers.clear();
                        maxWeight.clear();

                        if (vehicleList.add(cargoLorry)){
                            new Alert(Alert.AlertType.CONFIRMATION,"Saved successfully...", ButtonType.CLOSE).show();
                        }else{
                            new Alert(Alert.AlertType.WARNING,"Try Again...", ButtonType.CLOSE).show();
                        }
                    }

                }catch (NullPointerException n){

                }
            }

    }

    public void moveToVehicleType(ActionEvent actionEvent) { vehicleCmb.requestFocus(); }

    public void moveToMaxWeight(ActionEvent actionEvent) {
        maxWeight.requestFocus();
    }

    public void moveToNoOfPassengers(ActionEvent actionEvent) {
        noOfPassengers.requestFocus();
    }

    public void viewVehicleDetails(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ViewVehicleDetails.fxml");
        Parent load = FXMLLoader.load(resource);
        vehicleContext.getChildren().clear();
        vehicleContext.getChildren().add(load);
    }

    public void checkingVehicleNo(KeyEvent keyEvent) {
        String value ="^([A-Z0-9 ]{1,3}.([0-9]{4}))$";
        Pattern pattern= Pattern.compile(value);
        Matcher match=pattern.matcher(vehicleNo.getText());
        if(!match.matches()){
            vlabel1.setText("Invalid Vehicle Number!");
        }else{
            vlabel1.setText("");
        }
    }

    public void checkingVehicleMaxWeight(KeyEvent keyEvent) {
        String value ="^([0-9]{1,4})$";
        Pattern pattern=Pattern.compile(value);
        Matcher match=pattern.matcher(maxWeight.getText());
        if(!match.matches()){
            vlabel2.setText("Invalid Maximum Weight!");
        }else{
            vlabel2.setText("");
        }

    }

    public void checkingNoOfPassengers(KeyEvent keyEvent) {
        String value ="^(([0-9]{1,2}))$";
        Pattern pattern= Pattern.compile(value);
        Matcher match=pattern.matcher(noOfPassengers.getText());
        if(!match.matches()){
            vlabel3.setText("Invalid Number Of Passengers!");
        }else{
            vlabel3.setText("");
        }
    }
}
