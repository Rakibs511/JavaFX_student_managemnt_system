/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainPackage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rakib
 */
public class LoginController implements Initializable {

    @FXML
    private TextField tf_user_name;
    @FXML
    private PasswordField tf_password;
    @FXML
    private Label lbl_Login_Status;
    @FXML
    private AnchorPane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void loginHandle(ActionEvent event) {
        String userName = tf_user_name.getText();
        String userPassword = tf_password.getText();

        LoginAuth userInfo = new LoginAuth();
        userInfo.loginSystem(userName, userPassword);

        if (userInfo.isUserName == true && userInfo.isPassword == true) {
            lbl_Login_Status.setText("Login Success!");
            System.out.println("Login Success!");
            try {
                AnchorPane homePage = FXMLLoader.load(getClass().getResource("/homePackage/home.fxml"));
                root.getChildren().setAll(homePage);
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            tf_user_name.setText("");
            tf_password.setText("");
            lbl_Login_Status.setText("Login Failed Please Provide Correct Info.");
            System.out.println("Login Failed!");
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Student Managment System");
            alert.setHeaderText("Login Failed!");
            alert.setContentText("Please Enter Valid Info");
            alert.showAndWait();

        }

    }

}
