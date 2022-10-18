/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deleteInfoPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainPackage.DbConnection;

/**
 *
 * @author rakib
 */
public class Delete {

    private String studentId, dob, birthRegNo, age, gender, religion, bloodGroup, mobileNumber, fatherName, motherName, fatherNID, fatherMobileNumber, nationality;
    private String studentName=null;
    private boolean isData = false;

    public boolean isIsData() {
        return isData;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getBirthRegNo() {
        return birthRegNo;
    }

    public void setBirthRegNo(String birthRegNo) {
        this.birthRegNo = birthRegNo;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherNID() {
        return fatherNID;
    }

    public void setFatherNID(String fatherNID) {
        this.fatherNID = fatherNID;
    }

    public String getFatherMobileNumber() {
        return fatherMobileNumber;
    }

    public void setFatherMobileNumber(String fatherMobileNumber) {
        this.fatherMobileNumber = fatherMobileNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void searchinfo(String id) {
        studentName=null;
        String OneUserInfoQuery = "SELECT * FROM student_info WHERE [Student id]='" + id + "'";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dburl = "jdbc:sqlserver://DESKTOP-NJJUDI4\\SQLEXPRESS:13745;databaseName=Sudent_Management_System;integratedSecurity=true";
            Connection connection = DriverManager.getConnection(dburl);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(OneUserInfoQuery);

            while (result.next()) {
                setStudentName(result.getString("Student's Name"));
                setStudentId(result.getString("Student id"));
                setDob(result.getString("Date of Birth"));
                setBirthRegNo(result.getString("Birth Reg. No"));
                setAge(result.getString("Age"));
                setGender(result.getString("Gender"));
                setReligion(result.getString("Religion"));
                setBloodGroup(result.getString("Blood Group"));
                setMobileNumber(result.getString("Student's Mobile No"));
                setFatherName(result.getString("Father's Name"));
                setMotherName(result.getString("Mother's Name"));
                setFatherNID(result.getString("Father's NID No"));
                setFatherMobileNumber(result.getString("Father mobile No"));
                setNationality(result.getString("Nationality"));
            }
            if (studentName != null) {
                isData = true;
            } else {
                isData = false;
            }

            System.err.println("Database connection working Successfully!");
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void deleteInfo(String id) {

        String deleteUserInfoQuery = "DELETE FROM student_info WHERE [Student id]='" + id + "'";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dburl = "jdbc:sqlserver://DESKTOP-NJJUDI4\\SQLEXPRESS:13745;databaseName=Sudent_Management_System;integratedSecurity=true";
            Connection connection = DriverManager.getConnection(dburl);
            PreparedStatement pt = connection.prepareStatement(deleteUserInfoQuery);
            pt.executeUpdate();

            System.err.println("Student Info Deleted Successfully!");
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}
