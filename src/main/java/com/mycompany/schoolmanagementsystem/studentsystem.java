package com.mycompany.schoolmanagementsystem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class studentsystem extends JFrame implements ActionListener {

 
    private JButton btnSearch, btnAdd, btnEdit, btnDelete, btnBack;
    private JLabel lblTitle, lblSearch;
    private JTextField txtSearch;
    private JTable tblStudents;
    private JScrollPane scrollPane;

    
    studentsystem(){
        
        setTitle("School Management System");
        setSize(1080, 720);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Back Button
        btnBack = new JButton("<- Back To Home");
        btnBack.setBounds(10, 20, 150, 50);
        add(btnBack);

        // Title
        lblTitle = new JLabel("Student Management");
        lblTitle.setFont(new java.awt.Font("Arial", 1, 18));
        lblTitle.setBounds(450, 40, 400, 40);
        add(lblTitle);

        // Search Label
        lblSearch = new JLabel("Search:");
        lblSearch.setFont(new java.awt.Font("Arial", 1, 18));
        lblSearch.setBounds(300, 100, 75, 30);
        add(lblSearch);

        // Search TextField
        txtSearch = new JTextField();
        txtSearch.setBounds(375, 100, 325, 30);
        add(txtSearch);
        
        // Search Button
        btnSearch = new JButton("Search");
        btnSearch.setBounds(725, 100, 75, 30);
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
        scrollPane.setBounds(100, 150, 880, 300);
        add(scrollPane);
        
        // Bottom Buttons
        btnAdd = new JButton("Add Student");
        btnAdd.setBounds(300, 500, 130, 50);
        add(btnAdd);

        btnEdit = new JButton("Edit Student");
        btnEdit.setBounds(460, 500, 130, 50);
        add(btnEdit);

        btnDelete = new JButton("Delete Student");
        btnDelete.setBounds(620, 500, 130, 50);
        add(btnDelete);
        
        btnBack.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnBack){
            homeMenu sMS = new homeMenu();
            sMS.setVisible(true);
            this.dispose();
        }
    }
 
}

