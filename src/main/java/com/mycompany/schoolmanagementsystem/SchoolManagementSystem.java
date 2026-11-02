package com.mycompany.schoolmanagementsystem;
import java.sql.*;

public class SchoolManagementSystem {
    public static void main(String[] args) {
        Connection c = dbConnection.getConnections();
        dbConnection.initializeTables();
        System.out.println("Success: Java Is Connected to Mysql");
        
        homeMenu sMS = new homeMenu();
        sMS.setVisible(true);
        
       
    }
}
