package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class StudentLeaveDetails extends JFrame implements ActionListener {

    JTable table;
    JButton search, print, cancel;
    Choice crollno;

    StudentLeaveDetails() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel head = new JLabel("Student Leave Details");
        head.setBounds(350, 0, 500, 50);
        head.setFont(new Font("serif", Font.BOLD, 30));
        add(head);

        JLabel heading = new JLabel("Search by Roll No");
        heading.setBounds(20, 50, 150, 20);
        add(heading);

        crollno = new Choice();
        crollno.setBounds(180, 50, 150, 20);
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

        table = new JTable();

        try {
            JdbcConnection conn = new JdbcConnection();
            ResultSet rs = conn.s.executeQuery("select * from studentleave");

            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 150, 900, 500);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(20, 100, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120, 100, 80, 20);
        print.addActionListener(this);
        add(print);

        cancel = new JButton("Cancel");
        cancel.setBounds(220, 100, 80, 20);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900, 600);
        setLocation(200, 50);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == search) {
            String query = "select *from studentleave where rollno='" + crollno.getSelectedItem() + "'";
            try {
                JdbcConnection Conn = new JdbcConnection();
                ResultSet rs = Conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }

    }

    public static void main(String arg[]) {
        new StudentLeaveDetails();
    }

}
