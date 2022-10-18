/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package studentAllinfoPackage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import mainPackage.DbConnection;

/**
 * FXML Controller class
 *
 * @author rakib
 */
public class StudentInfoController implements Initializable {

    @FXML
    private TableView<infoSendToTable> tableView;
    @FXML
    private TableColumn<infoSendToTable, String> col_Student_name;
    @FXML
    private TableColumn<infoSendToTable, String> col_Student_id;
    @FXML
    private TableColumn<infoSendToTable, String> col_DoB;
    @FXML
    private TableColumn<infoSendToTable, String> col_Birth_reg_no;
    @FXML
    private TableColumn<infoSendToTable, String> col_age;
    @FXML
    private TableColumn<infoSendToTable, String> col_gender;
    @FXML
    private TableColumn<infoSendToTable, String> col_religion;
    @FXML
    private TableColumn<infoSendToTable, String> col_blood_Group;
    @FXML
    private TableColumn<infoSendToTable, String> col_mobile_number;
    @FXML
    private TableColumn<infoSendToTable, String> col_father_name;
    @FXML
    private TableColumn<infoSendToTable, String> col_mother_name;
    @FXML
    private TableColumn<infoSendToTable, String> col_father_NID;
    @FXML
    private TableColumn<infoSendToTable, String> col_father_mobile_number;
    @FXML
    private TableColumn<infoSendToTable, String> col_nationality;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        col_Student_name.setCellValueFactory(new PropertyValueFactory<>("StudentName"));
        col_Student_id.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
        col_DoB.setCellValueFactory(new PropertyValueFactory<>("Dob"));
        col_Birth_reg_no.setCellValueFactory(new PropertyValueFactory<>("BirthRegNo"));
        col_age.setCellValueFactory(new PropertyValueFactory<>("Age"));
        col_gender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        col_religion.setCellValueFactory(new PropertyValueFactory<>("Religion"));
        col_blood_Group.setCellValueFactory(new PropertyValueFactory<>("BloodGroup"));
        col_mobile_number.setCellValueFactory(new PropertyValueFactory<>("MobileNumber"));
        col_father_name.setCellValueFactory(new PropertyValueFactory<>("FatherName"));
        col_mother_name.setCellValueFactory(new PropertyValueFactory<>("MotherName"));
        col_father_NID.setCellValueFactory(new PropertyValueFactory<>("FatherNID"));
        col_father_mobile_number.setCellValueFactory(new PropertyValueFactory<>("FatherMobileNumber"));
        col_nationality.setCellValueFactory(new PropertyValueFactory<>("Nationality"));
        //tableView.setItems(observableList);
        
       // ObservableList<infoSendToTable> observableList = FXCollections.observableArrayList();

        String UserAllInfo = "SELECT * FROM student_info";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dburl = "jdbc:sqlserver://DESKTOP-NJJUDI4\\SQLEXPRESS:13745;databaseName=Sudent_Management_System;integratedSecurity=true";
            Connection connection = DriverManager.getConnection(dburl);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(UserAllInfo);

            String studentName, studentId;
            while (result.next()) {

                studentName = result.getString("Student's Name");
                studentId = result.getString("Student id");
//                col_Student_name.setCellValueFactory(new PropertyValueFactory<>{"test"});
                System.out.printf("Student Name: %s\nStudent ID: %s\n", studentName, studentId);
            }
//            if (userName!=null) {
//                isUserName=true;
//                //System.out.printf("userName: %s pass: %s",userName,password);
//            }else {
//                isUserName=false;
//                //System.out.printf("Not found\n");
//            }
//            if (password!=null) {
//                isPassword=true;
//            }else {
//                isPassword=false;
//                //System.out.printf("Not found\n");
//            }

            //System.out.println("ISuserName:----"+isUserName+"\nand ISPass---- "+isPassword);
            //System.err.println("Database connection working Successfully!");
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
//            new infoSendToTable("Rakib", "202071001", "13/12/1999", "202071682628", "23", "Male", "Islam", "AB+", "0173644648", "Alal Hossain", "Lata Khatun", "2395923875", "0232334325", "Bangladesh"),
//            new infoSendToTable("Rakib", "202071001", "13/12/1999", "202071682628", "23", "Male", "Islam", "AB+", "0173644648", "Alal Hossain", "Lata Khatun", "2395923875", "0232334325", "Bangladesh"),
//            new infoSendToTable("Rakib", "202071001", "13/12/1999", "202071682628", "23", "Male", "Islam", "AB+", "0173644648", "Alal Hossain", "Lata Khatun", "2395923875", "0232334325", "Bangladesh")

}
