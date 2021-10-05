package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Drivers;
import model.Vehicle;
import view.tm.OnDeliveryVehiclesTM;
import view.tm.ParkedVehiclesTM;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import static controller.AddVehiclesController.vehicleList;
import static controller.DriverFormController.driverArrayList;
import static controller.ParkedVehiclesController.parkedVehiclesTMObservableList;
import static controller.OnDeliveryVehiclesController.onDeliveryVehiclesTMObservableList;

public class HomePageController{
    public AnchorPane HomePageContext;
    public JFXComboBox<String> vehicleTypeCmb;
    public JFXComboBox<String> driverCmb;
    public JFXTextField txtVehicleType;
    public TextField Date;
    public TextField Time;
    public TextField slotNo;
    public JFXButton parkBtn;
    public JFXButton deliveryBtn;
    public ImageView image2;
    public ImageView image1;
    public Label title;

    private int minute;
    private int hour;
    public int second;

    public void initialize(){

       for (Vehicle temp:vehicleList) {
            vehicleTypeCmb.getItems().add(temp.getVehicleNo());
       }

        vehicleTypeCmb.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            slotNo.clear();
            vehicleTypeCmb.setAccessibleText(newValue);
            for (Vehicle temp:vehicleList) {
                if(newValue.equals(temp.getVehicleNo())){
                    txtVehicleType.setText(temp.getVehicleType());
                    disableAndEnable(vehicleTypeCmb.getValue().toString());
                    if(!parkBtn.isDisable()){
                        try {
                            slotNo.setText(temp.park(temp.getVehicleNo(),temp.getVehicleType())+"");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        for (Drivers d:driverArrayList) {
            driverCmb.getItems().add(d.getName());
        }

        //---------------------------------------------------------------

        Thread clock = new Thread() {
            public void run() {
                for (; ; ) {
                    DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
                    Calendar cal = Calendar.getInstance();

                    int second = cal.get(Calendar.SECOND);
                    int minute = cal.get(Calendar.MINUTE);
                    int hour = cal.get(Calendar.HOUR_OF_DAY);
                    //System.out.println(hour + ":" + (minute) + ":" + second);
                    try {
                        String state = null;
                        if (hour >= 12) {
                            state = "PM";
                        } else {
                            state = "AM";
                        }
                        Time.setText("" + String.format("%02d", hour) + ":" + String.format("%02d", minute) + ":" + String.format("%02d", second) + " " + state);
                        try {
                            sleep(1000);
                        } catch (InterruptedException ex) {
                            System.out.println(ex);
                        }
                    }catch (NullPointerException e){
                        System.out.println(e);
                    }
                }
            }
        };
        clock.start();

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        // System.out.println(dateFormat.format(date));
        Date.setText(dateFormat.format(date));

        //-----------------------------------------------------------
        /*ScaleTransition scaleTransition=new ScaleTransition();
        scaleTransition.setNode(image1);
        scaleTransition.setDuration(Duration.millis(500));
        scaleTransition.setCycleCount(TranslateTransition.INDEFINITE);
        scaleTransition.setInterpolator(Interpolator.LINEAR);
        scaleTransition.setByX(2.0);
        scaleTransition.setByY(2.0);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();*/

        imageAction(image1);
        imageAction(image2);
        titleAction(title);
       // setDateTime();
    }

/*
    public void setDateTime() {
        Thread clock = new Thread() {
            public void run() {
                for (; ; ) {
                    SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                    Calendar cal = Calendar.getInstance();

                    int second = cal.get(Calendar.SECOND);
                    int minute = cal.get(Calendar.MINUTE);
                    int hour = cal.get(Calendar.HOUR_OF_DAY);

                    Time.setText(hour + ":" + (minute) + ":" + second);
                    Date date = new Date();
                    Date.setText(dateFormat.format(date));

                    String state = null;
                    if (hour >= 12) {
                        state = "PM";
                    } else {
                        state = "AM";
                    }

                    //System.out.println("    " + String.format("%02d", hour) + ":" + String.format("%02d", minute) + ":" + String.format("%02d", second) + " " + state);

                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        //System.out.println(ex);
                        ex.printStackTrace();
                    }
                }
            }
        };
        clock.start();
    }
*/
    public void imageAction(ImageView imageView){
        FadeTransition fadeTransition=new FadeTransition();
        fadeTransition.setNode(imageView);
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setCycleCount(TranslateTransition.INDEFINITE);
        fadeTransition.setInterpolator(Interpolator.LINEAR);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        //fadeTransition.setFromValue(1);
        //fadeTransition.setToValue(0);
        fadeTransition.play();
    }

    public void titleAction(Label label){
        FadeTransition fadeTransition=new FadeTransition();
        fadeTransition.setNode(label);
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setCycleCount(TranslateTransition.INDEFINITE);
        fadeTransition.setInterpolator(Interpolator.LINEAR);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        //fadeTransition.setFromValue(1);
        //fadeTransition.setToValue(0);
        fadeTransition.play();
    }

   //--------------------------------------------------------------------
    public void disableAndEnable(String vehicleNo){
        parkBtn.setDisable(false);
        deliveryBtn.setDisable(false);
        for (ParkedVehiclesTM temp:parkedVehiclesTMObservableList) {
            if(temp.getVehicleNo().equals(vehicleNo)){
                parkBtn.setDisable(true);
            }
        }
        if(!parkBtn.isDisable()){
            deliveryBtn.setDisable(true);
        }
    }
    //-------------------------------------------------------------------

    public void goToManagementLogIn(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ManagementLogIn.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene=new Scene(load);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void parkingVehicles(ActionEvent actionEvent) {
        try{
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm a");
            ParkedVehiclesTM parkedVehiclesTM = new ParkedVehiclesTM(vehicleTypeCmb.getValue().toString()
                    ,txtVehicleType.getText(),Integer.parseInt(slotNo.getText())
                    ,java.time.LocalDateTime.now().format(dateTimeFormatter)
            );
            parkedVehiclesTMObservableList.add(parkedVehiclesTM);
            slotNo.clear();
        }catch (Exception e){

        }
    }

    public void onDeliveryShift(ActionEvent actionEvent) {
        try{
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm a");
            parkedVehiclesTMObservableList.removeIf(temp -> temp.getVehicleNo().equals(vehicleTypeCmb.getValue().toString()));
            OnDeliveryVehiclesTM onDeliveryVehiclesTM = new OnDeliveryVehiclesTM(vehicleTypeCmb.getValue().toString(),
                    txtVehicleType.getText(),driverCmb.getValue().toString(),
                    java.time.LocalDateTime.now().format(dateTimeFormatter));
            onDeliveryVehiclesTMObservableList.add(onDeliveryVehiclesTM);
        }catch (Exception e){

        }
    }

    public void refresh(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/HomePage.fxml");
        Parent load = FXMLLoader.load(resource);
        HomePageContext.getChildren().clear();
        HomePageContext.getChildren().add(load);

    }
}
