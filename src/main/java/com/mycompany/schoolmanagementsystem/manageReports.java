
package com.mycompany.schoolmanagementsystem;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class manageReports extends JFrame implements ActionListener{
    private JButton homebtn,exportbtn,printbtn,genreport;
    private JLabel title,reporttext,preview;
    private JComboBox <String> reportcmb;
    private static final String[] reporttypes = {"Attendance & Performance Report", "Detailed Student Attendance", "Course Grade Performance"};//might change later?
    private DefaultTableModel tablemodel;
    private JScrollPane sp;
    private JTable table;
    private static final String[] tablecol = {"Metric / Category", "Count / Average"};
    
    manageReports(){
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
       
        title = new JLabel("Report Management");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBounds(430, 20, 250, 50);
        add(title);
        
        reporttext = new JLabel("Report Types");
        reporttext.setFont(new Font("Arial", Font.BOLD, 13));
        reporttext.setBounds(40, 100, 90, 25);
        add(reporttext);
        
        reportcmb = new JComboBox<>(reporttypes);
        reportcmb.setBounds(135, 100, 250, 25);
        add(reportcmb);
        
        genreport = new JButton("Generate report");
        genreport.setBounds(770, 125, 150, 27);
        genreport.setFont(new Font("Arial", Font.BOLD, 12));
        add(genreport);
        
        preview = new JLabel("Report Preview Area");
        preview.setFont(new Font("Arial", Font.BOLD, 13));
        preview.setBounds(40, 150, 200, 20);
        add(preview);
        
        tablemodel = new DefaultTableModel(tablecol,0);
        table = new JTable(tablemodel);
        table.setFillsViewportHeight(true);
        sp = new JScrollPane(table);
        sp.setBounds(40, 175, 1000, 410);
        add(sp);
        
        exportbtn = new JButton("Export to CSV / Text");
        exportbtn.setBounds(680, 610, 170, 40);
        exportbtn.setFont(new Font("Arial", Font.BOLD, 12));
        add(exportbtn);
        
        printbtn = new JButton("Print Report");
        printbtn.setBounds(870, 610, 170, 40);
        printbtn.setFont(new Font("Arial", Font.BOLD, 12));
        add(printbtn);
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
