
package com.mycompany.schoolmanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class manageCourse extends JFrame implements ActionListener{
    private JButton homebtn,searchbtn,addbtn,editbtn,delbtn,enrollbtn,removebtn,multenrollbtn,multremovebtn;
    private DefaultTableModel coursetblmdl,sectiontblmdl,studenttblmdl;
    private JScrollPane coursesp,sectionsp,studentsp;
    private JTable coursetbl,sectiontbl,studenttbl;
    private static final String[] coursetblcol = {"Course ID", "Course Name", "No. Enrolled Students"};
    private static final String[] studenttblcol = {"Student ID", "Name","Status"};
    private static final String[] sectiontblcol = {"Section ID", "Description","No. Enrolled Students"};
    private JTextField idtxtfield, nametxtfield;
    private JLabel title, addcourse, courseid, coursename, studtitle, coursetitle;
    private JComboBox <String> studstatus;
    private static final String[] status = {"Enrolled", "Unenrolled"};
    
    
    manageCourse(){
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
       
        title = new JLabel("Course Management");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBounds(430, 20, 250, 50);
        add(title);
        
        coursetitle = new JLabel("Course List");
        coursetitle.setFont(new Font("Arial", Font.BOLD, 15));
        coursetitle.setBounds(10, 100, 100, 25);
        add(coursetitle);
        
        coursetblmdl = new DefaultTableModel(coursetblcol,0);
        coursetbl = new JTable(coursetblmdl);
        coursetbl.setFillsViewportHeight(true);
        coursesp = new JScrollPane(coursetbl);
        coursesp.setBounds(10, 125, 640, 220);
        add(coursesp);
        
        addcourse = new JLabel("Add New Course");
        addcourse.setFont(new Font("Arial", Font.BOLD, 12));
        addcourse.setBounds(680, 125, 140, 25);
        add(addcourse);
        
        courseid = new JLabel("Course ID:");
        courseid.setFont(new Font("Arial", Font.BOLD, 12));
        courseid.setBounds(680, 150, 140, 25);
        add(courseid);
        
        coursename = new JLabel("Course Name:");
        coursename.setFont(new Font("Arial", Font.BOLD, 12));
        coursename.setBounds(680, 175, 140, 25);
        add(coursename);
        
        idtxtfield = new JTextField();
        idtxtfield.setBounds(750, 150, 264, 25);
        add(idtxtfield);
        
        nametxtfield = new JTextField();
        nametxtfield.setBounds(764, 175, 250, 25);
        add(nametxtfield);
        
        addbtn = new JButton("Save");
        addbtn.setBounds(680, 225, 106, 50);
        add(addbtn);
        
        editbtn = new JButton("Edit");
        editbtn.setBounds(796, 225, 106, 50);
        add(editbtn);
        
        delbtn = new JButton("Delete");
        delbtn.setBounds(912, 225, 106, 50);
        add(delbtn);
        
        studtitle = new JLabel("Course Enrollment");
        studtitle.setFont(new Font("Arial", Font.BOLD, 15));
        studtitle.setBounds(10, 375, 250, 25);
        add(studtitle);
        
        sectiontblmdl = new DefaultTableModel(sectiontblcol, 0 );
        sectiontbl = new JTable(sectiontblmdl);
        sectiontbl.setFillsViewportHeight(true);
        sectionsp = new JScrollPane(sectiontbl);
        sectionsp.setBounds(10, 410, 320,220);
        add(sectionsp);
        
        studenttblmdl = new DefaultTableModel(studenttblcol,0);
        studenttbl = new JTable(studenttblmdl);
        studenttbl.setFillsViewportHeight(true);
        studentsp = new JScrollPane(studenttbl);
        studentsp.setBounds(340, 410, 320,220);
        add(studentsp);
        
        enrollbtn = new JButton("Enroll Student");
        enrollbtn.setBounds(680, 440, 140, 50);
        add(enrollbtn);
        
        removebtn = new JButton("Remove Student");
        removebtn.setBounds(850, 440, 140, 50);
        add(removebtn);
        
        multenrollbtn = new JButton("Enroll Program");
        multenrollbtn.setBounds(680, 520, 140, 50);
        add(multenrollbtn);
        
        multremovebtn = new JButton("Remove Program");
        multremovebtn .setBounds(850, 520, 140, 50);
        add(multremovebtn);
        
        
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