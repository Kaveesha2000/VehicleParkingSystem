package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ManagementLogInController {
    public AnchorPane ManagementLogInContext;
    public JFXTextField managementName;
    public JFXPasswordField managementPassword;
    public Label managementLabel;
    public ImageView image;
    public FontAwesomeIconView managementLog;
    public JFXButton cancelBtn;

    public void goToPassword(ActionEvent actionEvent) {
        managementPassword.requestFocus();
    }

    public void goToTasks(ActionEvent actionEvent) throws IOException {
        if(managementPassword.getText().equals("1234") & managementName.getText().equalsIgnoreCase("Management")){
            URL resource = getClass().getResource("../view/AdminTasks.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage window = (Stage) ManagementLogInContext.getScene().getWindow();
            window.setScene(new Scene(load));
        }
        else{
            managementLabel.setText("Enter correct username or password");
        }
    }

    public void goToHomePage(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage)cancelBtn.getScene().getWindow();
        stage.close();
    }

    /*public void viewImage(MouseEvent mouseEvent) {
        if(managementName.getText().equals("Management")){
            managementLog.setVisible(false);
            image.setVisible(true);
        }
    }*/
}
