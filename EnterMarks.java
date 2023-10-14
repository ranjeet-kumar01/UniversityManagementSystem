package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class EnterMarks extends JFrame implements ActionListener {

    Choice crollno;
    JComboBox cbsemester;
    JTextField tfsub1, tfsub2, tfsub3, tfsub4, tfsub5, tfmarks1, tfmarks2, tfmarks3, tfmarks4, tfmarks5;
    JButton submit, cancel;

    EnterMarks() {
        setLayout(null);

        setSize(1000, 600);
        setLocation(200, 50);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(540, 40, 400, 300);
        add(image);

        JLabel heading = new JLabel("Enter Marks of Students");
        heading.setBounds(50, 0, 500, 50);
        heading.setFont(new Font("Tohma", Font.BOLD, 25));
        add(heading);

        JLabel lblrollno = new JLabel("Select Roll No");
        lblrollno.setBounds(50, 70, 150, 25);
        lblrollno.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblrollno);

        crollno = new Choice();
        crollno.setBounds(250, 70, 200, 25);
        add(crollno);

        try {
            JdbcConnection conn = new JdbcConnection();
            ResultSet rs = conn.s.executeQuery("select * from student");
            while (rs.next()) {
                crollno.add(rs.getString("rollno"));

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        JLabel lblsemester = new JLabel("Select Semester");
        lblsemester.setBounds(50, 100, 150, 25);
        lblsemester.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblsemester);

        String semester[] = {"1st Semester", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester", "6th Semester", "7th Semester", "8th Semester"};

        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(250, 100, 150, 25);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);

        JLabel lblentersub = new JLabel("Enter Subject");
        lblentersub.setBounds(90, 150, 150, 25);
        lblentersub.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblentersub);

        JLabel lblentermarks = new JLabel("Enter Marks");
        lblentermarks.setBounds(300, 150, 150, 25);
        lblentermarks.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblentermarks);

        tfsub1 = new JTextField();
        tfsub1.setBounds(50, 200, 200, 25);
        add(tfsub1);

        tfsub2 = new JTextField();
        tfsub2.setBounds(50, 230, 200, 25);
        add(tfsub2);

        tfsub3 = new JTextField();
        tfsub3.setBounds(50, 260, 200, 25);
        add(tfsub3);

        tfsub4 = new JTextField();
        tfsub4.setBounds(50, 290, 200, 25);
        add(tfsub4);

        tfsub5 = new JTextField();
        tfsub5.setBounds(50, 320, 200, 25);
        add(tfsub5);

        tfmarks1 = new JTextField();
        tfmarks1.setBounds(250, 200, 200, 25);
        add(tfmarks1);

        tfmarks2 = new JTextField();
        tfmarks2.setBounds(250, 230, 200, 25);
        add(tfmarks2);

        tfmarks3 = new JTextField();
        tfmarks3.setBounds(250, 260, 200, 25);
        add(tfmarks3);

        tfmarks4 = new JTextField();
        tfmarks4.setBounds(250, 290, 200, 25);
        add(tfmarks4);

        tfmarks5 = new JTextField();
        tfmarks5.setBounds(250, 320, 200, 25);
        add(tfmarks5);

        submit = new JButton("Submit");
        submit.setBounds(80, 380, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(300, 380, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            try {
                JdbcConnection conn = new JdbcConnection();
                String querysub = "insert into subject values('" + crollno.getSelectedItem() + "', "
                        + "'" + cbsemester.getSelectedItem() + "', '" + tfsub1.getText() + "', "
                        + "'" + tfsub2.getText() + "', '" + tfsub3.getText() + "', '" + tfsub4.getText() + "',"
                        + " '" + tfsub5.getText() + "')";
                
                String querymarks = "insert into marks values('" + crollno.getSelectedItem() + "', "
                        + "'" + cbsemester.getSelectedItem() + "', '" + tfmarks1.getText() + "', "
                        + "'" + tfmarks2.getText() + "', '" + tfmarks3.getText() + "', '" + tfmarks4.getText() + "',"
                        + " '" + tfmarks5.getText() + "')";
                  
                        conn.s.executeUpdate(querysub);
                        conn.s.executeUpdate(querymarks);
                        JOptionPane.showMessageDialog(null, "Marks Inserted Successfully");
                  
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String arg[]) {

        new EnterMarks();
    }
}
