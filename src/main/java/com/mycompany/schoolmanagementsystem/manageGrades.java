package com.mycompany.schoolmanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class manageGrades extends JFrame implements ActionListener {
    private JButton homebtn,searchbtn,addbtn,editbtn,printbtn;
    private DefaultTableModel gradestblmodel,studentstblmdl;
    private JScrollPane gradesp, studentsp;
    private JTable gradestbl, studenttbl;
    private static final String[] gradestblcol = {"Course ID", "Grades"};
    private static final String[] studenttblcol = {"Student ID", "Name"};
    private JTextField gradetxtfield,searchtxtfield;
    private JLabel title, sectionfiltertxt, gradeentry, coursename, studtitle, gradestitle,searchtitle;
    private JComboBox <String> sectionsfilter;
    private static final String[] sections = {"DIT 2-1", "DIT 1-1"};// might change later
    
    manageGrades(){
        setTitle("School Management System");
        setSize(1080, 720);// 720p
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);//center
        setResizable(false);//No more fullscreen
        
        homebtn = new JButton("<- Back To Home");
        homebtn.setFont(new Font("Arial", Font.BOLD, 12));
        homebtn.setBounds(10, 20, 150, 50);
        add(homebtn);
       
        title = new JLabel("Grades Management");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBounds(430, 20, 250, 50);
        add(title);
                
        searchtitle = new JLabel("Search Student ID:");
        searchtitle.setFont(new Font("Arial", Font.BOLD, 12));
        searchtitle.setBounds(10, 100, 125, 25);
        add(searchtitle);
        
        searchtxtfield = new JTextField();
        searchtxtfield.setBounds(120, 100, 250, 25);
        add(searchtxtfield);
        
        searchbtn = new JButton("Search");
        searchbtn.setBounds(375, 100, 75, 25);
        add(searchbtn);
        
        sectionfiltertxt = new JLabel("Sections:");
        sectionfiltertxt.setFont(new Font("Arial", Font.BOLD, 12));
        sectionfiltertxt.setBounds(390, 160, 75, 25);
        add(sectionfiltertxt);
        
        sectionsfilter = new JComboBox<>(sections);
        sectionsfilter.setBounds(450, 160, 100, 25);
        add(sectionsfilter);
        
        studtitle = new JLabel("Student List");
        studtitle.setFont(new Font("Arial", Font.BOLD, 15));
        studtitle.setBounds(10, 135, 100, 50);
        add(studtitle);
        
        studentstblmdl = new DefaultTableModel(studenttblcol,0);
        studenttbl = new JTable(studentstblmdl);
        studenttbl.setFillsViewportHeight(true);
        studentsp = new JScrollPane(studenttbl);
        studentsp.setBounds(10, 185, 540, 450);
        add(studentsp);
        
        gradestitle = new JLabel("Student Grades");
        gradestitle.setFont(new Font("Arial", Font.BOLD, 15));
        gradestitle.setBounds(600, 200, 125, 50);
        add(gradestitle);
        
        gradestblmodel= new DefaultTableModel(gradestblcol,0);
        gradestbl = new JTable(gradestblmodel);
        gradestbl.setFillsViewportHeight(true);
        gradesp = new JScrollPane(gradestbl);
        gradesp.setBounds(600, 250, 450, 300);
        add(gradesp);
        
        gradeentry = new JLabel("Enter Grade:");
        gradeentry.setFont(new Font("Arial", Font.BOLD, 12));
        gradeentry.setBounds(600, 590, 75, 25);
        add(gradeentry);
        
        gradetxtfield = new JTextField();
        gradetxtfield.setBounds(675, 590, 125, 25);
        add(gradetxtfield);
        
        addbtn = new JButton("Add");
        addbtn.setBounds(810, 580, 75, 50);
        add(addbtn);
        
        editbtn = new JButton("Edit");
        editbtn.setBounds(893, 580, 75, 50);
        add(editbtn);
        
        printbtn = new JButton("Print");
        printbtn.setBounds(975, 580, 75, 50);
        add(printbtn);
        
        homebtn.addActionListener(this);
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == homebtn){
            homeMenu sMS = new homeMenu();
            sMS.setVisible(true);
            this.dispose();
        }
    }
}
