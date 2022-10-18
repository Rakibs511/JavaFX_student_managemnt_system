/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package registrationPackage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mainPackage.DbConnection;

/**
 * FXML Controller class
 *
 * @author rakib
 */
public class RegistrationController implements Initializable {

    @FXML
    private TextField tf_Student_Name;
    @FXML
    private TextField tf_Student_Id;
    @FXML
    private TextField tf_DOB;
    @FXML
    private TextField tf_Birth_reg_No;
    @FXML
    private TextField tf_age;
    @FXML
    private TextField tf_Gender;
    @FXML
    private TextField tf_Religion;
    @FXML
    private TextField tf_blood_Group;
    @FXML
    private TextField tf_Mobile_number;
    @FXML
    private TextField tf_Father_name;
    @FXML
    private TextField tf_mother_name;
    @FXML
    private TextField tf_father_Mobile_number;
    @FXML
    private TextField tf_nationality;
    @FXML
    private TextField tf_father_NID;
    @FXML
    private Label lbl_status;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void RegisterHandle(ActionEvent event) {
        String studentName, studentId, dob, birthRegNo, age, gender, religion, bloodGroup, mobileNumber, fatherName, motherName, fatherNID, fatherMobileNumber, nationality;
        studentName = tf_Student_Name.getText();
        studentId = tf_Student_Id.getText();
        dob = tf_DOB.getText();
        birthRegNo = tf_Birth_reg_No.getText();
        age = tf_age.getText();
        gender = tf_Gender.getText();
        religion = tf_Religion.getText();
        bloodGroup = tf_blood_Group.getText();
        mobileNumber = tf_Mobile_number.getText();
        fatherName = tf_Father_name.getText();
        motherName = tf_mother_name.getText();
        fatherNID = tf_father_NID.getText();
        fatherMobileNumber = tf_father_Mobile_number.getText();
        nationality = tf_nationality.getText();

        String registerInsertQuery = "INSERT INTO [dbo].[student_info]([Student's Name],[Student id],[Date of Birth],[Birth Reg. No],[Age],[Gender],[Religion],[Blood Group],[Student's Mobile No],[Father's Name],[Mother's Name],[Father's NID No],[Father mobile No],[Nationality]) VALUES ('" + studentName + "','" + studentId + "','" + dob + "','" + birthRegNo + "','" + age + "','" + gender + "','" + religion + "','" + bloodGroup + "','" + mobileNumber + "','" + fatherName + "','" + motherName + "','" + fatherNID + "','" + fatherMobileNumber + "','" + nationality + "')";

        try {
            if (studentName == "" && studentId == "") {
                lbl_status.setText("Text Field Can't be empty!");
            } else {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String dburl = "jdbc:sqlserver://DESKTOP-NJJUDI4\\SQLEXPRESS:13745;databaseName=Sudent_Management_System;integratedSecurity=true";
                Connection connection = DriverManager.getConnection(dburl);
                PreparedStatement preparedStatement = connection.prepareStatement(registerInsertQuery);
                preparedStatement.executeUpdate();

                lbl_status.setText("Registration Successful!");
                //clear form text
                tf_Student_Name.clear();
                tf_Student_Id.clear();
                tf_DOB.clear();
                tf_Birth_reg_No.clear();
                tf_age.clear();
                tf_Gender.clear();
                tf_Religion.clear();
                tf_blood_Group.clear();
                tf_Mobile_number.clear();
                tf_Father_name.clear();
                tf_mother_name.clear();
                tf_father_NID.clear();
                tf_father_Mobile_number.clear();
                tf_nationality.clear();

                System.err.println("Data Insert Successful!");
            }
        } catch (ClassNotFoundException ex) {
            lbl_status.setText("Please insert Valid Information");
            System.err.println(ex.getMessage());
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            lbl_status.setText("Please insert Valid Information");
            System.err.println(e.getMessage());
        }

//        System.out.println("student name: "+studentName+"\nStudent id: "+studentId+
//                "\nDob: "+dob+"\nBirth Reg No: "+birthRegNo+"\nage: "+age+"\nGender: "+gender+"\nReligion: "+religion+"\nBlood: "+bloodGroup+
//                "\nMobile: "+mobileNumber+"\n Father Name: "+fatherName+"\nMother Name: "+motherName+"\nfather NID: "+fatherNID+"\nfather Mobile Number: "+
//                fatherMobileNumber+"\n Nationality: "+nationality);
    }

}
