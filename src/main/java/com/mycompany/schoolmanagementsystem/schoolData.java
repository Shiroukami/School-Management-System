
package com.mycompany.schoolmanagementsystem;

import java.sql.*;
import java.util.*;

public class schoolData {
    public static ArrayList<students> students =  new ArrayList<>();
    
    
    
    //Load Database
    public static void loadStudents(){
        students.clear();
        String sql = "SELECT * FROM students";
        try (Connection kon = dbConnection.getConnections();
                Statement stmt = kon.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                students.add(new students(rs.getInt("student_id"), rs.getString("name"), rs.getString("section_id")));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    
    //Insert to Database
    public static void addStudentToDatabase(String name, String sectionID){
        String sql = "INSERT INTO students (name,section_id) VALUES (?,?)";
        
        try (Connection kon = dbConnection.getConnections();
                PreparedStatement pstmt = kon.prepareStatement(sql)){
            pstmt.setString(1, name);
            pstmt.setString(2, sectionID);
            pstmt.executeUpdate();
            System.out.println("Student added Successfully!");
            loadStudents();
        }catch (SQLException e){
            System.out.println("FAILED TO INSERT STUDENT!");
            System.out.println("SQL Error Message: " + e.getMessage());
            System.out.println("Error Code: " + e.getErrorCode());
        }
                
    }
    
    
    //Edit Database
    public static void updateStudent(int studentId, String newName, String newSectionId) {
        String sql = "UPDATE students SET name = ?, section_id = ? WHERE student_id = ?";

        try (Connection kon = dbConnection.getConnections();
             PreparedStatement pstmt = kon.prepareStatement(sql)) {

            pstmt.setString(1, newName);
            pstmt.setString(2, newSectionId);
            pstmt.setInt(3, studentId);
            pstmt.executeUpdate();
            System.out.println("Student successfully updated in the database!");
            loadStudents();
        }catch(SQLException e){
            System.out.println("Failed to update student.");
            e.printStackTrace();
        }
    }
    
    //Delete From DataBase
    public static void deleteStudent(int studentId){
        String sql = "DELETE FROM students WHERE student_id = ?";
        try (Connection kon = dbConnection.getConnections();
                PreparedStatement pstmt = kon.prepareStatement(sql)){
            
            pstmt.setInt(1, studentId);
            pstmt.executeUpdate();
            System.out.println("Student deleted Successfully from the Database");
            loadStudents();
        }catch(SQLException e){
            System.out.println("Failed to delete student from the database");
            e.printStackTrace();
        }
    }
}
