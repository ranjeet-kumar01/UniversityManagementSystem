package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Marks extends JFrame implements ActionListener {

    String rollno;
    JButton cancel;

    Marks(String rollno) {
        this.rollno = rollno;

        setLayout(null);
        setSize(600, 650);
        setLocation(300, 0);

        JLabel heading = new JLabel("IFTM University");
        heading.setBounds(200, 0, 200, 30);
        heading.setFont(new Font("Tohma", Font.BOLD, 25));
        add(heading);

        JLabel subheading = new JLabel("Examination Result 2023");
        subheading.setBounds(190, 40, 220, 25);
        subheading.setFont(new Font("Tohma", Font.BOLD, 18));
        add(subheading);

        JLabel lblrollno = new JLabel("Roll Number " + rollno);
        lblrollno.setBounds(60, 100, 250, 25);
        lblrollno.setFont(new Font("Serif", Font.PLAIN, 18));
        add(lblrollno);

        JLabel lblsemester = new JLabel("Semester");
        lblsemester.setBounds(60, 130, 250, 25);
        lblsemester.setFont(new Font("Serif", Font.PLAIN, 18));
        add(lblsemester);

        JLabel lblsub1 = new JLabel();
        lblsub1.setBounds(100, 200, 200, 25);
        lblsub1.setFont(new Font("Serif", Font.PLAIN, 18));
        add(lblsub1);

        JLabel lblsub2 = new JLabel();
        lblsub2.setBounds(100, 230, 200, 25);
        lblsub2.setFont(new Font("Serif", Font.PLAIN, 18));
        add(lblsub2);

        JLabel lblsub3 = new JLabel();
        lblsub3.setBounds(100, 260, 200, 25);
        lblsub3.setFont(new Font("Serif", Font.PLAIN, 18));
        add(lblsub3);

        JLabel lblsub4 = new JLabel();
        lblsub4.setBounds(100, 290, 200, 25);
        lblsub4.setFont(new Font("Serif", Font.PLAIN, 18));
        add(lblsub4);

        JLabel lblsub5 = new JLabel();
        lblsub5.setBounds(100, 320, 200, 25);
        lblsub5.setFont(new Font("Serif", Font.PLAIN, 18));
        add(lblsub5);

        JLabel lblmarks1 = new JLabel();
        lblmarks1.setBounds(300, 200, 100, 25);
        lblmarks1.setFont(new Font("Serif", Font.BOLD, 18));
        add(lblmarks1);

        JLabel lblmarks2 = new JLabel();
        lblmarks2.setBounds(300, 230, 100, 25);
        lblmarks2.setFont(new Font("Serif", Font.BOLD, 18));
        add(lblmarks2);

        JLabel lblmarks3 = new JLabel();
        lblmarks3.setBounds(300, 260, 100, 25);
        lblmarks3.setFont(new Font("Serif", Font.BOLD, 18));
        add(lblmarks3);

        JLabel lblmarks4 = new JLabel();
        lblmarks4.setBounds(300, 290, 100, 25);
        lblmarks4.setFont(new Font("Serif", Font.BOLD, 18));
        add(lblmarks4);

        JLabel lblmarks5 = new JLabel();
        lblmarks5.setBounds(300, 320, 100, 25);
        lblmarks5.setFont(new Font("Serif", Font.BOLD, 18));
        add(lblmarks5);

        try {
            JdbcConnection conn = new JdbcConnection();
            ResultSet rss = conn.s.executeQuery("select * from subject where rollno= '" + rollno + "'");
            while (rss.next()) {
                lblsub1.setText(rss.getString("subject1") + "           ---------    ");
                lblsub2.setText(rss.getString("subject2") + "               ---------    ");
                lblsub3.setText(rss.getString("subject3") + "            ---------    ");
                lblsub4.setText(rss.getString("subject4") + "         ---------    ");
                lblsub5.setText(rss.getString("subject5") + "             ---------    ");
            }

            ResultSet rsm = conn.s.executeQuery("select * from marks where rollno= '" + rollno + "'");
            while (rsm.next()) {

                lblmarks1.setText(rsm.getString("marks1"));
                lblmarks2.setText(rsm.getString("marks2"));
                lblmarks3.setText(rsm.getString("marks3"));
                lblmarks4.setText(rsm.getString("marks4"));
                lblmarks5.setText(rsm.getString("marks5"));
                lblsemester.setText("Semester  " + rsm.getString("semester"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        cancel = new JButton("Back");
        cancel.setBounds(400, 450, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String arg[]) {
        new Marks("");
    }
}
