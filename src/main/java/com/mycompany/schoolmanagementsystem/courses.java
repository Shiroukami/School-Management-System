
package com.mycompany.schoolmanagementsystem;

public class courses {
    private String courseID, coursename;
    
    public courses(String courseID,String coursename){
        this.courseID = courseID;
        this.coursename = coursename;   
    }
    
    //Getters & Setters
    public String getCourseID(){
        return courseID;
    }
    public String getCourseName(){
        return coursename;
    }
    
    public void setCourseID(String courseID){
        this.courseID = courseID;
    }
    public void setCourseName(String coursename){
        this.coursename = coursename;
    }
}
