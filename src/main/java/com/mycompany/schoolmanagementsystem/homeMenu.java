/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schoolmanagementsystem;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author JM
 */
public class homeMenu extends JFrame{
    // Variables
    private JLabel title, studcnt, coursecnt, subtitle;
    private JButton manageStud, manageCourse, manageGrades, genReport;
    
    homeMenu(){
        
        //Window settings
        setTitle("School Management System");
        setSize(1080, 720);// 720p
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);//center
        setResizable(false);//No more fullscreen
        
        //Title
        title = new JLabel("School Management Sytem");
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(190, 40, 700, 60);
        add(title);
        
        //Counters
        studcnt = new JLabel("Total Students: ");
        studcnt.setFont(new Font("Arial", Font.BOLD, 18));
        studcnt.setBounds(200, 85, 320, 100);
        add(studcnt);
        
        coursecnt = new JLabel("Courses: ");
        coursecnt.setFont(new Font("Arial", Font.BOLD, 18));
        coursecnt.setBounds(560, 85, 320, 100);
        add(coursecnt);
        
        //Buttons
        subtitle = new JLabel("Quick Actions: ");
        subtitle.setFont(new Font("Arial", Font.BOLD, 18));
        subtitle.setBounds(30, 200, 320, 100);
        add(subtitle);
        
        manageStud = new JButton("Manage Students");      
        manageStud.setBounds(175, 275, 320, 100);
        manageStud.setFont(new Font("Arial", Font.BOLD, 18));
        add(manageStud);
        
        manageCourse = new JButton("Manage Courses");      
        manageCourse.setBounds(535, 275, 320, 100);
        manageCourse.setFont(new Font("Arial", Font.BOLD, 18));
        add(manageCourse);
        
        manageGrades = new JButton("Manage Grades");      
        manageGrades.setBounds(175, 395, 320, 100);
        manageGrades.setFont(new Font("Arial", Font.BOLD, 18));
        add(manageGrades);
        
        genReport = new JButton("Generate Reports");      
        genReport.setBounds(535, 395, 320, 100);
        genReport.setFont(new Font("Arial", Font.BOLD, 18));
        add(genReport);
    }
}