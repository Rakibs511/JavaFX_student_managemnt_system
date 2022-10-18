/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rakib
 */
public class LoginAuth {

    private String userName;
    private String password;

    public boolean isUserName = false;
    public boolean isPassword = false;

    public void loginSystem(String userNam, String Pass) {
        String UserAllInfo = "SELECT * FROM user_info WHERE [User Name]='" + userNam + "' AND [Password]='" + Pass + "';";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dburl = "jdbc:sqlserver://DESKTOP-NJJUDI4\\SQLEXPRESS:13745;databaseName=Sudent_Management_System;integratedSecurity=true";
            Connection connection = DriverManager.getConnection(dburl);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(UserAllInfo);

            while (result.next()) {
                this.userName = result.getString("User Name");
                this.password = result.getString("Password");
            }

            if (userName != null) {
                isUserName = true;
                //System.out.printf("userName: %s pass: %s",userName,password);
            } else {
                isUserName = false;
                //System.out.printf("Not found\n");
            }
            if (password != null) {
                isPassword = true;
            } else {
                isPassword = false;
                //System.out.printf("Not found\n");
            }

            //System.out.println("ISuserName:----"+isUserName+"\nand ISPass---- "+isPassword);
            System.err.println("Database connection working Successfully!");
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
