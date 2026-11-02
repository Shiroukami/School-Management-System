package com.mycompany.schoolmanagementsystem;
import com.mysql.cj.util.DnsSrv;
import java.sql.*;
public class dbConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/school_management_db";
    private static final 
    private static final String user = "root";
    private static final String Pass = "";
    
    
    
    public static Connection getConnections(){
        try{
            Connection Kon = DriverManager.getConnection(URL , user , Pass);
            System.out.println("Db  connection Success");
            return Kon;
        }catch(SQLException e){
            System.out.println("DB connection Failed");
            e.printStackTrace();
            return null;
        }
    }
    
}
