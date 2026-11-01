/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schoolmanagementsystem;

/**
 *
 * @author Monica Caluya
 */
import javax.swing.*;




/**
 *
 * @author Monica Caluya
 */
public class studentsystem extends JFrame {

 
    private JButton btnSearch, btnAdd, btnEdit, btnDelete;
    private JLabel lblTitle, lblSearch;
    private JTextField txtSearch;
    private JTable tblStudents;
    private JScrollPane scrollPane;

    
    studentsystem(){
        initComponents(); 
    }

    private void initComponents() {
        
        setTitle("School Management System");
        setSize(1350, 900);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Back Button
        JButton btnBack = new JButton("<- Back To Home");
        btnBack.setBounds(20, 60, 150, 40);
        add(btnBack);

        // Title
        lblTitle = new JLabel("School Management System");
        lblTitle.setFont(new java.awt.Font("Arial", 1, 28));
        lblTitle.setBounds(500, 40, 400, 40);
        add(lblTitle);

        // Search Label
        lblSearch = new JLabel("Search:");
        lblSearch.setFont(new java.awt.Font("Arial", 1, 24));
        lblSearch.setBounds(380, 150, 120, 40);
        add(lblSearch);

        // Search TextField
        txtSearch = new JTextField();
        txtSearch.setBounds(500, 150, 380, 40);
        add(txtSearch);
        
        // Search Button
        btnSearch = new JButton("Search");
        btnSearch.setBounds(910, 150, 120, 40);
        add(btnSearch);

        // Table
        tblStudents = new JTable(
            new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Student ID", "Name", "Course"
                }
            )
        );

        scrollPane = new JScrollPane(tblStudents);
        scrollPane.setBounds(120, 230, 1100, 380);
        add(scrollPane);
        
        // Bottom Buttons
        btnAdd = new JButton("Add Student");
        btnAdd.setBounds(370, 670, 160, 50);
        add(btnAdd);

        btnEdit = new JButton("Edit Student");
        btnEdit.setBounds(580, 670, 160, 50);
        add(btnEdit);

        btnDelete = new JButton("Delete Student");
        btnDelete.setBounds(790, 670, 160, 50);
        add(btnDelete);
    }

    
    
    
}

