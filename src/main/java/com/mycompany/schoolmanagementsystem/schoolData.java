
package com.mycompany.schoolmanagementsystem;

import java.sql.*;
import java.util.*;

public class schoolData {
    public static ArrayList<students> students =  new ArrayList<>();
    public static ArrayList<courses> courses = new ArrayList<>();
    public static ArrayList<sections> sections = new ArrayList<>();
    
    
    
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
    
    public static void loadCourses(){
        courses.clear();
        String sql = "SELECT * FROM courses";
        try (Connection kon = dbConnection.getConnections();
                Statement stmt = kon.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                courses.add(new courses(rs.getString("course_id"), rs.getString("course_name")));
            }
            
        }catch(SQLException e){
                e.printStackTrace();
                } 
    }
    
    public static void loadSections(){
        sections.clear();
        String sql = "SELECT * FROM sections";
        try (Connection kon = dbConnection.getConnections();
                Statement stmt = kon.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
            while(rs.next()){
                sections.add(new sections(rs.getString("section_id"), rs.getString("section_name"),
                        rs.getString("schedule_days")));
            }
        }catch(SQLException e){
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
            e.printStackTrace();
        }
                
    }
    
    public static void addCourseToDatabase(String courseID, String coursename){
        String sql = "INSERT INTO courses (course_id, course_name) VALUES (?,?)";
        try(Connection kon = dbConnection.getConnections();
                PreparedStatement pstmt = kon.prepareStatement(sql)){
            pstmt.setString(1,courseID);
            pstmt.setString(2,coursename);
            pstmt.executeUpdate();
            System.out.println("Course added Successfully");
            loadCourses();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void addSectionToDatabase(String sectionID, String sectionName, String scheduleDays){
        String sql = "INSERT INTO sections (section_id, section_name, schedule_days) VALUES (?,?,?)";
        try(Connection kon = dbConnection.getConnections();
                PreparedStatement pstmt = kon.prepareStatement(sql)){
            pstmt.setString(1, sectionID);
            pstmt.setString(2, sectionName);
            pstmt.setString(3, scheduleDays);
            pstmt.executeUpdate();
            System.out.println("Section added Successfully");
            loadSections();
        }catch(SQLException e){
            e.printStackTrace();
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
    
    public static void updateCourse(String courseID, String newCourseID, String newCourseName){
        String sql = "UPDATE courses SET course_id = ?, course_name = ? WHERE course_id = ?";
        
        try(Connection kon = dbConnection.getConnections();
             PreparedStatement pstmt = kon.prepareStatement(sql)){
            
            pstmt.setString(1, newCourseID);
            pstmt.setString(2, newCourseName);
            pstmt.setString(3, courseID);
            pstmt.executeUpdate();
            System.out.println("Course Successfully updated in the database!");
            loadCourses();
        }catch(SQLException e){
            System.out.println("Failed to update course.");
            e.printStackTrace();
        }
    }
    
    public static void updateSection(String sectionID, String newSectionID, String newSectionName, String newScheduleDays){
        String sql = "UPDATE sections SET section_id = ?, section_name = ?, schedule_days = ? WHERE section_id = ?";
        try(Connection kon = dbConnection.getConnections();
             PreparedStatement pstmt = kon.prepareStatement(sql)){
            
            pstmt.setString(1, newSectionID);
            pstmt.setString(2, newSectionName);
            pstmt.setString(3, newScheduleDays);
            pstmt.setString(4, sectionID);
            pstmt.executeUpdate();
            System.out.println("Section Successfull updated in the database!");
            loadSections();
        }catch(SQLException e){
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
    
    public static void deleteCourse(String courseID){
        String sql = "DELETE FROM courses WHERE course_id = ?";
        try(Connection kon = dbConnection.getConnections();
                PreparedStatement pstmt = kon.prepareStatement(sql)){
            
            pstmt.setString(1, courseID);
            pstmt.executeUpdate();
            System.out.println("Course Deleted Successfully from the Database");
        }catch(SQLException e){
            System.out.println("Failed to delete course from the database");
            e.printStackTrace();
        }
    }
    
    public static void deleteSection(String sectionID){
        String sql = "DELETE FROM sections WHERE section_id = ?";
        try(Connection kon = dbConnection.getConnections();
                PreparedStatement pstmt = kon.prepareStatement(sql)){
            
            pstmt.setString(1, sectionID);
            pstmt.executeUpdate();
            System.out.println("Section Deleted Successfully from the Database");
        }catch(SQLException e){
            System.out.println("Failed to delete section from the database");
            e.printStackTrace();
        }
    }
}
