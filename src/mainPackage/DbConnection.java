/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainPackage;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;


/**
 *
 * @author rakib
 */
public class DbConnection{
//            String UserAllInfo = " select * from user_info;";
       
    public void dbConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dburl="jdbc:sqlserver://DESKTOP-NJJUDI4\\SQLEXPRESS:13745;databaseName=Sudent_Management_System;integratedSecurity=true";
            DriverManager.getConnection(dburl);
//            Statement statement = connection.createStatement();
//            ResultSet result = statement.executeQuery(UserAllInfo);
//            
//            while (result.next()) {
//                super.userName = result.getString("User Name");
//                super.password = result.getString("Password");
//            }
            System.err.println("Database Connected!");
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
        
    }
              
}
