
package com.mycompany.schoolmanagementsystem;
public class sections {
    private String sectionID,sectionName,scheduleDays;
    
    public sections(String sectionID, String sectionName, String scheduleDays){
        this.sectionID = sectionID;
        this.sectionName = sectionName;
        this.scheduleDays = scheduleDays;
    }
    public String getSectionID(){
        return sectionID;
    }
    public String getSectionName(){
        return sectionName;
    }
    public String getScheduleDays(){
        return scheduleDays;
    }
    public void setSectionID(String sectionID){
        this.sectionID = sectionID; 
    }
    public void setSectionName(String sectionName){
        this.sectionName = sectionName; 
    }
    public void setScheduleDays(String scheduleDays){
        this.scheduleDays = scheduleDays; 
    }
}
