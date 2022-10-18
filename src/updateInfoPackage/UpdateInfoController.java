/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package updateInfoPackage;

import com.jfoenix.controls.JFXButton;
import deleteInfoPackage.Delete;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import mainPackage.DbConnection;

/**
 * FXML Controller class
 *
 * @author rakib
 */
public class UpdateInfoController extends Delete implements Initializable {

    @FXML
    private AnchorPane anchorpane_root;
    @FXML
    private Pane pane_info_root;
    @FXML
    private Label lbl_Student_Name;
    @FXML
    private Label lbl_Student_ID;
    @FXML
    private Label lbl_DOB;
    @FXML
    private Label lbl_Birth_Reg_No;
    @FXML
    private Label lbl_Age;
    @FXML
    private Label lbl_Gender;
    @FXML
    private Label lbl_Religion;
    @FXML
    private Label lbl_Blood_Group;
    @FXML
    private Label lbl_Mobile_Number;
    @FXML
    private Label lbl_Father_Name;
    @FXML
    private Label lbl_Mother_Name;
    @FXML
    private Label lbl_Father_NID_NO;
    @FXML
    private Label lbl_Father_Mobile_No;
    @FXML
    private Label lbl_Nationality;
    @FXML
    private Label lbl_Search_status;
    @FXML
    private TextField tf_Search_Box;
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
    private TextField tf_father_NID;
    @FXML
    private TextField tf_father_Mobile_number;
    @FXML
    private TextField tf_nationality;
    @FXML
    private Pane pane_Update_Info_root;
    @FXML
    private JFXButton btn_formToggle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pane_info_root.setVisible(false);
        pane_Update_Info_root.setVisible(false);
        lbl_Search_status.setVisible(false);
        btn_formToggle.setVisible(true);
    }

    @FXML
    private void searchHandle(ActionEvent event) {
        pane_Update_Info_root.setVisible(false);
        btn_formToggle.setVisible(true);
        String ID = tf_Search_Box.getText();
        searchinfo(ID);
        if (isIsData() == true) {
            lbl_Search_status.setVisible(false);
            pane_info_root.setVisible(true);
        } else {
            pane_info_root.setVisible(false);
            lbl_Search_status.setVisible(true);
            lbl_Search_status.setText("Student ID is Not Found!");
        }
        if (isIsData() == false) {
            pane_info_root.setVisible(false);
            lbl_Search_status.setVisible(true);
            lbl_Search_status.setText("Student ID is Not Found!");
        }
        lbl_Student_Name.setText(getStudentName());
        lbl_Student_ID.setText(getStudentId());
        lbl_DOB.setText(getDob());
        lbl_Birth_Reg_No.setText(getBirthRegNo());
        lbl_Age.setText(getAge());
        lbl_Gender.setText(getGender());
        lbl_Religion.setText(getReligion());
        lbl_Blood_Group.setText(getBloodGroup());
        lbl_Mobile_Number.setText(getMobileNumber());
        lbl_Father_Name.setText(getFatherName());
        lbl_Mother_Name.setText(getMotherName());
        lbl_Father_NID_NO.setText(getFatherNID());
        lbl_Father_Mobile_No.setText(getFatherMobileNumber());
        lbl_Nationality.setText(getNationality());

        //-------remove section  set name and id
//        if (isIsData() == true) {
//            lbl_Search_status.setVisible(false);
//            pane_Remove_Info_root.setVisible(true);
//        } else {
//            pane_Remove_Info_root.setVisible(false);
//        }
//        lbl_show_student_name.setText(getStudentName());
//        lbl_show_student_ID.setText(getStudentId());
    }

    @FXML
    private void updateHandle(ActionEvent event) {
        String studentName, studentId, dob, birthRegNo, age, gender, religion, bloodGroup, mobileNumber, fatherName, motherName, fatherNID, fatherMobileNumber, nationality;
        studentName=tf_Student_Name.getText();
        studentId=tf_Student_Id.getText();
        dob=tf_DOB.getText();
        birthRegNo=tf_Birth_reg_No.getText();
        age=tf_age.getText();
        gender=tf_Gender.getText();
        religion=tf_Religion.getText();
        bloodGroup=tf_blood_Group.getText();
        mobileNumber=tf_Mobile_number.getText();
        fatherName=tf_Father_name.getText();
        motherName=tf_mother_name.getText();
        fatherNID=tf_father_NID.getText();
        fatherMobileNumber=tf_father_Mobile_number.getText();
        nationality= tf_nationality.getText();
        
        System.out.println(studentName);
        System.out.println(studentId);
        System.out.println(age);
        
        String updateQuery="UPDATE student_info SET [Student's Name] = '"+studentName+"',[Student id] = "+studentId+",[Date of Birth] = '"+dob+"',[Birth Reg. No] = '"+birthRegNo+"',Age = '"+age+"',Gender = '"+gender+"',Religion = '"+religion+"',[Blood Group] = '"+bloodGroup+"',[Student's Mobile No] = '"+mobileNumber+"',[Father's Name] = '"+fatherName+"',[Mother's Name] = '"+motherName+"',[Father's NID No] = '"+fatherNID+"',[Father mobile No] = '"+fatherMobileNumber+"',Nationality = '"+nationality+"' WHERE [Student id] ="+getStudentId()+";";
        try {
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String dburl = "jdbc:sqlserver://DESKTOP-NJJUDI4\\SQLEXPRESS:13745;databaseName=Sudent_Management_System;integratedSecurity=true";
                Connection connection = DriverManager.getConnection(dburl);
                PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                preparedStatement.executeUpdate();
                System.out.println("Updated...");
        } catch (ClassNotFoundException ex) {
            //lbl_status.setText("Please insert Valid Information");
            System.err.println(ex.getMessage());
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            //lbl_status.setText("Please insert Valid Information");
            System.err.println(e.getMessage());
        }
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Student Managment System");
            alert.setHeaderText("Info Updated!");
            alert.setContentText(studentName+" Is update Successfully!");
            alert.showAndWait();
        
    }

    @FXML
    private void FormShowHandle(ActionEvent event) {
        pane_Update_Info_root.setVisible(true);
        btn_formToggle.setVisible(false);
        tf_Student_Name.setText(getStudentName());
        tf_Student_Id.setText(getStudentId());
        tf_DOB.setText(getDob());
        tf_Birth_reg_No.setText(getBirthRegNo());
        tf_age.setText(getAge());
        tf_Gender.setText(getGender());
        tf_Religion.setText(getReligion());
        tf_blood_Group.setText(getBloodGroup());
        tf_Mobile_number.setText(getMobileNumber());
        tf_Father_name.setText(getFatherName());
        tf_mother_name.setText(getMotherName());
        tf_father_NID.setText(getFatherNID());
        tf_father_Mobile_number.setText(getFatherMobileNumber());
        tf_nationality.setText(getNationality());   
    }

}
