/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package homePackage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author rakib
 */
public class HomeController implements Initializable {

    @FXML
    private Pane pane_root_home_tab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
            AnchorPane registrationPage = FXMLLoader.load(getClass().getResource("/studentAllinfoPackage/studentInfo.fxml"));
            pane_root_home_tab.getChildren().setAll(registrationPage);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void registrationHandle(ActionEvent event) {
        try {
            AnchorPane registrationPage = FXMLLoader.load(getClass().getResource("/registrationPackage/registration.fxml"));
            pane_root_home_tab.getChildren().setAll(registrationPage);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void showAllStudentInfoHandle(ActionEvent event) {
         try {
            AnchorPane registrationPage = FXMLLoader.load(getClass().getResource("/studentAllinfoPackage/studentInfo.fxml"));
            pane_root_home_tab.getChildren().setAll(registrationPage);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void updateInfoHandle(ActionEvent event) {
         try {
            AnchorPane registrationPage = FXMLLoader.load(getClass().getResource("/updateInfoPackage/updateInfo.fxml"));
            pane_root_home_tab.getChildren().setAll(registrationPage);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void deleteinfoHandle(ActionEvent event) {
        try {
            AnchorPane registrationPage = FXMLLoader.load(getClass().getResource("/deleteInfoPackage/deleteInfo.fxml"));
            pane_root_home_tab.getChildren().setAll(registrationPage);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void createUserHandle(ActionEvent event) {
        try {
            AnchorPane registrationPage = FXMLLoader.load(getClass().getResource("/createUserPackage/createUser.fxml"));
            pane_root_home_tab.getChildren().setAll(registrationPage);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
