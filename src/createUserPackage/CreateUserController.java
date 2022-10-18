/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package createUserPackage;

import com.sun.javafx.tk.quantum.PerformanceLogger;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import mainPackage.DbConnection;

/**
 * FXML Controller class
 *
 * @author rakib
 */
public class CreateUserController implements Initializable {

    @FXML
    private TextField tf_User_Name;
    @FXML
    private TextField tf_User_Id;
    @FXML
    private PasswordField tf_Password;
    @FXML
    private TextField tf_Full_Name;
    @FXML
    private TextField tf_Phone_Number;
    @FXML
    private TextField tf_Address;
    @FXML
    private TextField tf_Email;
    @FXML
    private TextField tf_Job_Title;
    @FXML
    private Label lbl_Error_Stutas;
    @FXML
    private Label lbl_Success_status;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void createHandle(ActionEvent event) {
        String userName, userId, password, fullName, phoneNumber, address, email, jobTitle;
        userName = tf_User_Name.getText();
        userId = tf_User_Id.getText();
        password = tf_Password.getText();
        fullName = tf_Full_Name.getText();
        phoneNumber = tf_Phone_Number.getText();
        address = tf_Address.getText();
        email = tf_Email.getText();
        jobTitle = tf_Job_Title.getText();

        String user_intsert_Query = "INSERT INTO [dbo].[user_info] ([User Name],[User id],[Password],[Full Name],[Mobile Number],[Address],[E-Mail],[Job Title]) VALUES ('" + userName + "','" + userId + "','" + password + "','" + fullName + "','" + phoneNumber + "','" + address + "','" + email + "','" + jobTitle + "')";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dburl = "jdbc:sqlserver://DESKTOP-NJJUDI4\\SQLEXPRESS:13745;databaseName=Sudent_Management_System;integratedSecurity=true";
            Connection connection = DriverManager.getConnection(dburl);
            PreparedStatement pt = connection.prepareStatement(user_intsert_Query);
            pt.executeUpdate();
            lbl_Success_status.setText("Congratulations! The user is created.");

//            Statement statement = connection.createStatement();
//            ResultSet result = statement.executeQuery(UserAllInfo);
//            
//            while (result.next()) {
//                String T_userName = result.getString("User Name");
//                String T_password = result.getString("Password");
//            }
            //System.out.println("ISuserName:----"+isUserName+"\nand ISPass---- "+isPassword);
            System.err.println("Data insert Successfull!");
        } catch (ClassNotFoundException ex) {
            lbl_Error_Stutas.setText("Sorry, the user could not be created.");
            System.err.println(ex.getMessage());
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            lbl_Error_Stutas.setText("Sorry, the user could not be created.");
            System.err.println(e.getMessage());
        }
    }
}
