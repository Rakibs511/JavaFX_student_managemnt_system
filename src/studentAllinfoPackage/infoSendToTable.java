/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentAllinfoPackage;

import javafx.beans.property.SimpleStringProperty;


/**
 *
 * @author rakib
 */
public class infoSendToTable {

    private SimpleStringProperty studentName, studentId, dob, birthRegNo, age, gender, religion, bloodGroup, mobileNumber, fatherName, motherName, fatherNID, fatherMobileNumber, nationality;

    public infoSendToTable(String studentName, String studentId, String dob, String birthRegNo, String age, String gender, String religion, String bloodGroup, String mobileNumber, String fatherName, String motherName, String fatherNID, String fatherMobileNumber, String nationality) {
        this.studentName = new SimpleStringProperty( studentName);
        this.studentId = new SimpleStringProperty(studentId);
        this.dob = new SimpleStringProperty(dob);
        this.birthRegNo = new SimpleStringProperty(birthRegNo);
        this.age = new SimpleStringProperty(age);
        this.gender = new SimpleStringProperty(gender);
        this.religion = new SimpleStringProperty(religion);
        this.bloodGroup = new SimpleStringProperty(bloodGroup);
        this.mobileNumber = new SimpleStringProperty(mobileNumber);
        this.fatherName = new SimpleStringProperty(fatherName);
        this.motherName = new SimpleStringProperty(motherName);
        this.fatherNID = new SimpleStringProperty(fatherNID);
        this.fatherMobileNumber = new SimpleStringProperty(fatherMobileNumber);
        this.nationality = new SimpleStringProperty(nationality);
    }

    public String getStudentName() {
        return studentName.get();
    }

    public void setStudentName(String studentName) {
        this.studentName = new SimpleStringProperty(studentName);
    }

    public String getStudentId() {
        return studentId.get();
    }

    public void setStudentId(String studentId) {
        this.studentId = new SimpleStringProperty(studentId);
    }

    public String getDob() {
        return dob.get();
    }

    public void setDob(String dob) {
        this.dob = new SimpleStringProperty(dob);
    }

    public String getBirthRegNo() {
        return birthRegNo.get();
    }

    public void setBirthRegNo(String birthRegNo) {
        this.birthRegNo = new SimpleStringProperty(birthRegNo);
    }

    public String getAge() {
        return age.get();
    }

    public void setAge(String age) {
        this.age = new SimpleStringProperty(age);
    }

    public String getGender() {
        return gender.get();
    }

    public void setGender(String gender) {
        this.gender = new SimpleStringProperty(gender);
    }

    public String getReligion() {
        return religion.get();
    }

    public void setReligion(String religion) {
        this.religion = new SimpleStringProperty(religion);
    }

    public String getBloodGroup() {
        return bloodGroup.get();
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = new SimpleStringProperty(bloodGroup);
    }

    public String getMobileNumber() {
        return mobileNumber.get();
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = new SimpleStringProperty(mobileNumber);
    }

    public String getFatherName() {
        return fatherName.get();
    }

    public void setFatherName(String fatherName) {
        this.fatherName = new SimpleStringProperty(fatherName);
    }

    public String getMotherName() {
        return motherName.get();
    }

    public void setMotherName(String motherName) {
        this.motherName = new SimpleStringProperty(motherName);
    }

    public String getFatherNID() {
        return fatherNID.get();
    }

    public void setFatherNID(String fatherNID) {
        this.fatherNID = new SimpleStringProperty(fatherNID);
    }

    public String getFatherMobileNumber() {
        return fatherMobileNumber.get();
    }

    public void setFatherMobileNumber(String fatherMobileNumber) {
        this.fatherMobileNumber = new SimpleStringProperty(fatherMobileNumber);
    }

    public String getNationality() {
        return nationality.get();
    }

    public void setNationality(String nationality) {
        this.nationality = new SimpleStringProperty(nationality);
    }
    
}
