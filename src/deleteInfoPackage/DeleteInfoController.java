/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package deleteInfoPackage;

import homePackage.HomeController;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author rakib
 */
public class DeleteInfoController extends Delete implements Initializable {

    @FXML
    private TextField tf_Search_Box;
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
    private Pane pane_Remove_Info_root;
    @FXML
    private Label lbl_show_student_name;
    @FXML
    private Label lbl_show_student_ID;
    @FXML
    private AnchorPane anchorpane_root;
    @FXML
    private Label lbl_Search_status;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pane_info_root.setVisible(false);
        pane_Remove_Info_root.setVisible(false);
        lbl_Search_status.setVisible(false);
    }

    @FXML
    private void searchHandle(ActionEvent event) {
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
        if (isIsData() == true) {
            lbl_Search_status.setVisible(false);
            pane_Remove_Info_root.setVisible(true);
        } else {
            pane_Remove_Info_root.setVisible(false);
        }
        lbl_show_student_name.setText(getStudentName());
        lbl_show_student_ID.setText(getStudentId());

    }

    @FXML
    private void deleteHandle(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Student Management System");
        alert.setContentText("Deleted successfully");
        alert.showAndWait();
        String ID = tf_Search_Box.getText();
        deleteInfo(ID);
        try {
            AnchorPane registrationPage = FXMLLoader.load(getClass().getResource("/deleteInfoPackage/deleteInfo.fxml"));
            anchorpane_root.getChildren().setAll(registrationPage);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
