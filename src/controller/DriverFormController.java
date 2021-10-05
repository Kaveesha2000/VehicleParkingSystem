package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.Drivers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DriverFormController {
    public AnchorPane driverContext;
    public JFXTextField txtDName;
    public JFXTextField txtDNIC;
    public JFXTextField txtDliceneNo;
    public JFXTextField txtDAddress;
    public JFXTextField txtDContact;

    static ArrayList<Drivers> driverArrayList =new ArrayList();
    public Label dlabel1;
    public Label dlabel2;
    public Label dlabel3;
    public Label dlabel4;
    public Label dlabel5;

    public void addDriver(ActionEvent actionEvent) {
        Drivers driver = new Drivers(txtDName.getText(),txtDNIC.getText(),txtDliceneNo.getText(),txtDAddress.getText(),Integer.parseInt(txtDContact.getText()));
        txtDName.clear();
        txtDNIC.clear();
        txtDliceneNo.clear();
        txtDAddress.clear();
        txtDContact.clear();
        if (driverArrayList.add(driver)){
            new Alert(Alert.AlertType.CONFIRMATION,"Saved successfully...", ButtonType.CLOSE).show();
        }else{
            new Alert(Alert.AlertType.WARNING,"Try Again...", ButtonType.CLOSE).show();
        }
    }

    public void moveToNIC(ActionEvent actionEvent) {
        txtDNIC.requestFocus();
    }

    public void moveToLiceneNo(ActionEvent actionEvent) {
        txtDliceneNo.requestFocus();
    }

    public void moveToAddress(ActionEvent actionEvent) {
        txtDAddress.requestFocus();
    }

    public void moveToContact(ActionEvent actionEvent) {
        txtDContact.requestFocus();
    }

    public void viewDetails(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ViewDriverDetails.fxml");
        Parent load = FXMLLoader.load(resource);
        driverContext.getChildren().clear();
        driverContext.getChildren().add(load);
    }

    public void checkingDName(KeyEvent keyEvent) {
        String value ="^([A-Za-z]{1,30})$";
        Pattern pattern=Pattern.compile(value);
        Matcher match=pattern.matcher(txtDName.getText());
        if(!match.matches()){
            dlabel1.setText("Invalid Name!");
        }else{
            dlabel1.setText("");
        }
    }

    public void checkingDNIC(KeyEvent keyEvent) {
        String value ="^([0-9]{11}.([A-Z]{1}))$";
        Pattern pattern=Pattern.compile(value);
        Matcher match=pattern.matcher(txtDNIC.getText());
        if(!match.matches()){
            dlabel2.setText("Invalid NIC!");
        }else{
            dlabel2.setText("");
        }
    }

    public void checkingDLiceneNo(KeyEvent keyEvent) {
        String value ="^([A-Z]{1}.([0-9]{7}))$";
        Pattern pattern=Pattern.compile(value);
        Matcher match=pattern.matcher(txtDliceneNo.getText());
        if(!match.matches()){
            dlabel3.setText("Invalid Licene Number!");
        }else{
            dlabel3.setText("");
        }
    }

    public void checkingDAddress(KeyEvent keyEvent) {
        String value ="^([A-Za-z]{3,40})$";
        Pattern pattern=Pattern.compile(value);
        Matcher match=pattern.matcher(txtDAddress.getText());
        if(!match.matches()){
            dlabel4.setText("Invalid Address!");
        }else{
            dlabel4.setText("");
        }
    }

    public void checkingDContactNo(KeyEvent keyEvent) {
        String value ="^([0-9]{10})$";
        Pattern pattern=Pattern.compile(value);
        Matcher match=pattern.matcher(txtDContact.getText());
        if(!match.matches()){
            dlabel5.setText("Invalid Contact Number!");
        }else{
            dlabel5.setText("");
        }
    }
}
