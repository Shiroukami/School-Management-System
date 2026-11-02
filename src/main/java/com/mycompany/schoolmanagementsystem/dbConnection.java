package com.mycompany.schoolmanagementsystem;
import com.mysql.cj.util.DnsSrv;
import java.sql.*;
public class dbConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "school_management_system";
    private static final String user = "root";
    private static final String Pass = "";
    
    public static void createDatabase(){
        String sql = "CREATE DATABASE IF NOT EXISTS " + DB_NAME;
        
        try(Connection kon = DriverManager.getConnection(URL, user, Pass);
                Statement stmt = kon.createStatement()){
            stmt.executeUpdate(sql);
            System.out.println("Database " + DB_NAME +" is Ready");
        }catch(SQLException e){
            System.out.println("Failed To Create Database");
            e.printStackTrace();
        }
    }
    
    public static Connection getConnections(){
        try{
            createDatabase();
            Connection kon = DriverManager.getConnection(URL + DB_NAME + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", user, Pass);
            System.out.println("Successfully Connected to The Database!");
            return kon;
        }catch(SQLException e){
            System.out.println("DB connection Failed");
            e.printStackTrace();
            return null;
        }
    }
    
    public static void initializeTables() {
        String[] tables = {
            
            "CREATE TABLE IF NOT EXISTS sections ("
            + "section_id VARCHAR(20) PRIMARY KEY, "
            + "section_name VARCHAR(100), "
            + "schedule_days VARCHAR(50));",

            "CREATE TABLE IF NOT EXISTS students ("
            + "student_id VARCHAR(20) PRIMARY KEY, "
            + "first_name VARCHAR(50), "
            + "last_name VARCHAR(50), "
            + "section_id VARCHAR(20), "
            + "FOREIGN KEY (section_id) REFERENCES sections(section_id));",

            "CREATE TABLE IF NOT EXISTS courses ("
            + "course_id VARCHAR(20) PRIMARY KEY, "
            + "course_name VARCHAR(100));",

            "CREATE TABLE IF NOT EXISTS attendance ("
            + "attendance_id INT AUTO_INCREMENT PRIMARY KEY, "
            + "student_id VARCHAR(20), "
            + "date DATE, " + "status VARCHAR(20), "
            + "FOREIGN KEY (student_id) REFERENCES students(student_id));"
        };
        
        try(Connection kon = getConnections();
                Statement stmt = kon.createStatement()){
            for (String sql:tables){
                stmt.executeUpdate(sql);
            }
            System.out.println("All Tables Have Been Verified/Created");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}