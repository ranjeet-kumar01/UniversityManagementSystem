package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class TeacherLeave extends JFrame implements ActionListener {

    Choice cempid;
    JDateChooser dcdate;
    Choice ctime;
    JButton cancel, submit;

    TeacherLeave() {
        setLayout(null);

        JLabel head = new JLabel("Teacher Leave");
        head.setBounds(150, 0, 500, 50);
        head.setFont(new Font("serif", Font.BOLD, 30));
        add(head);

        JLabel heading = new JLabel("Search by Employee Id");
        heading.setBounds(20, 50, 150, 20);
        add(heading);

        cempid = new Choice();
        cempid.setBounds(180, 50, 150, 20);
        add(cempid);

        try {
            JdbcConnection conn = new JdbcConnection();
                ResultSet rs = conn.s.executeQuery("select * from teacher");
            while (rs.next()) {
                cempid.add(rs.getString("empid"));

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        JLabel lblDate = new JLabel("Date");
        lblDate.setBounds(30, 80, 80, 30);
        add(lblDate);

        dcdate = new JDateChooser();
        dcdate.setBounds(180, 80, 150, 20);
        add(dcdate);

        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(30, 120, 150, 20);
        add(lbltime);

        ctime = new Choice();
        ctime.add("Half day");
        ctime.add("full Day");
        ctime.setBounds(180, 120, 150, 20);
        add(ctime);

        submit = new JButton("Submit");
        submit.setBounds(50, 200, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 200, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setSize(500, 600);
        setLocation(450, 50);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String empid = (String)cempid.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration = (String)ctime.getSelectedItem();

            String query = "insert into teacherleave values('" + empid + "','" + date + "','" + duration + "')";

            try {
                JdbcConnection con = new JdbcConnection();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();

            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String args[]) {
        new TeacherLeave();
    }
}
