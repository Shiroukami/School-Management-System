package com.mycompany.schoolmanagementsystem;
public class students {
    private int studentID;
    private String studentname;
    private String sectionID;
    
    public students(int studentID, String studentname, String sectionID){
        this.studentID = studentID;
        this.studentname = studentname;
        this.sectionID = sectionID;
    }
    
    //Getters
    public int getStudentID(){
        return studentID;     
    }
    public String getstudentName(){
        return studentname;     
    }
    public String getSectionID(){
        return sectionID;     
    }
    
    public void setStudentID(int studentID){
        this.studentID = studentID;
    }
    public void setStudentName(String studentName){
        this.studentname = studentName;
    }
}
