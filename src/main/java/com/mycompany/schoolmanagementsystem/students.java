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
    
    public String getstudentname(){
        return studentname;     
    }
    
    public String getSectionID(){
        return sectionID;     
    }
    
}
