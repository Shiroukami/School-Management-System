import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class GradesManagements extends JFrame {

    private JTable studentTable, gradesTable;

    private DefaultTableModel studentModel, gradesModel;

    private JTextField searchField, gradeField;

    private JComboBox<String> programCombo;

    public GradesManagements() {

        setTitle("School Management System");
        setSize(1330, 880);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        Color background = new Color(240, 240, 240);

        getContentPane().setBackground(background);

        JButton backButton = new JButton("<- Back To Home");
        backButton.setBounds(15, 58, 187, 63);
        add(backButton);

        backButton.addActionListener(e -> {
            dispose();
        });

        JLabel title = new JLabel("Grades Management");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(500, 65, 350, 40);
        add(title);

        JLabel searchLabel = new JLabel("Search Student ID:");
        searchLabel.setFont(new Font("Arial", Font.BOLD, 14));
        searchLabel.setBounds(15, 158, 140, 30);
        add(searchLabel);

        searchField = new JTextField();
        searchField.setBounds(153, 158, 311, 30);
        add(searchField);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(471, 158, 94, 32);
        add(searchButton);

        JLabel studentLabel = new JLabel("Student List");
        studentLabel.setFont(new Font("Arial", Font.BOLD, 18));
        studentLabel.setBounds(15, 218, 200, 30);
        add(studentLabel);

        JLabel programLabel = new JLabel("Programs:");
        programLabel.setFont(new Font("Arial", Font.BOLD, 14));
        programLabel.setBounds(490, 230, 80, 25);
        add(programLabel);

        String[] programs = {
            "DIT 1-1",
            "DIT 1-2",
            "DIT 2-1",
            "DIT 2-2",
            "DIT 3-1",
        };

        programCombo = new JComboBox<>(programs);
        programCombo.setBounds(565, 232, 125, 32);
        add(programCombo);

        studentModel = new DefaultTableModel(
            new String[]{"Student ID", "Name"}, 0
        );

        studentTable = new JTable(studentModel);

        JScrollPane studentScroll = new JScrollPane(studentTable);
        studentScroll.setBounds(15, 265, 675, 561);
        add(studentScroll);

        JLabel gradesLabel = new JLabel("Student Grades");
        gradesLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gradesLabel.setBounds(752, 300, 250, 30);
        add(gradesLabel);
        
        gradesModel = new DefaultTableModel(
            new String[]{"Course ID", "Grades"}, 0
        );

        gradesTable = new JTable(gradesModel);

        JScrollPane gradesScroll = new JScrollPane(gradesTable);
        gradesScroll.setBounds(752, 345, 562, 375);
        add(gradesScroll);

        JLabel enterGradeLabel = new JLabel("Enter Grade:");
        enterGradeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        enterGradeLabel.setBounds(752, 770, 100, 30);
        add(enterGradeLabel);

        gradeField = new JTextField();
        gradeField.setBounds(847, 771, 154, 30);
        add(gradeField);

        JButton addButton = new JButton("Add");
        addButton.setBounds(1015, 758, 94, 63);
        add(addButton);

        addButton.addActionListener(e -> {

            if (studentTable.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please select a student first!"
                );
                return;
            }

            String courseID = JOptionPane.showInputDialog(
                this,
                "Enter Course ID:"
            );

            if (courseID == null || courseID.trim().isEmpty()) {
                return;
            }

            String grade = gradeField.getText().trim();

            if (grade.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please enter a grade!"
                );
                return;
            }

            try {
                double value = Double.parseDouble(grade);

                if (value < 0 || value > 100) {
                    JOptionPane.showMessageDialog(
                        this,
                        "Grade must be between 0 and 100!"
                    );
                    return;
                }

                gradesModel.addRow(new Object[]{
                    courseID,
                    grade
                });

                gradeField.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid numeric grade!"
                );
            }
        });

        JButton editButton = new JButton("Edit");
        editButton.setBounds(1118, 758, 94, 63);
        add(editButton);

        editButton.addActionListener(e -> {

            int selectedRow = gradesTable.getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please select a grade to edit!"
                );
                return;
            }

            String newGrade = gradeField.getText().trim();

            if (newGrade.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please enter the new grade!"
                );
                return;
            }

            try {
                double value = Double.parseDouble(newGrade);

                if (value < 0 || value > 100) {
                    JOptionPane.showMessageDialog(
                        this,
                        "Grade must be between 0 and 100!"
                    );
                    return;
                }

                gradesModel.setValueAt(
                    newGrade,
                    selectedRow,
                    1
                );

                gradeField.setText("");

                JOptionPane.showMessageDialog(
                    this,
                    "Grade updated successfully!"
                );

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid numeric grade!"
                );
            }
        });

        JButton printButton = new JButton("Print");
        printButton.setBounds(1221, 758, 94, 63);
        add(printButton);

        printButton.addActionListener(e -> {

            try {
                gradesTable.print();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                    this,
                    "Unable to print grades!"
                );
            }
        });

        searchButton.addActionListener(e -> {

            String studentID = searchField.getText().trim();

            if (studentID.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please enter a Student ID!"
                );
                return;
            }

            boolean found = false;

            for (int i = 0; i < studentModel.getRowCount(); i++) {

                String id = studentModel.getValueAt(i, 0).toString();

                if (id.equalsIgnoreCase(studentID)) {

                    studentTable.setRowSelectionInterval(i, i);
                    found = true;
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(
                    this,
                    "Student not found!"
                );
            }
        });

        studentTable.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                int selectedRow = studentTable.getSelectedRow();

                if (selectedRow != -1) {
                    gradesModel.setRowCount(0);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new GradesManagements();
        });
    }
}