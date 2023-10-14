package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class TeacherDetails extends JFrame implements ActionListener {

    JTable table;
    JButton search, print, update, add, cancel;
    Choice cempid;

    TeacherDetails() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        
        JLabel head = new JLabel("Teacher Details");
        head.setBounds(350, 0, 500, 50);
        head.setFont(new Font("serif", Font.BOLD, 30));
        add(head);
        
        
        JLabel heading = new JLabel("Search by Emp Id");
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

        table = new JTable();

        try {
            JdbcConnection conn = new JdbcConnection();
            ResultSet rs = conn.s.executeQuery("select * from teacher");

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

        update = new JButton("Update");
        update.setBounds(220, 100, 80, 20);
        update.addActionListener(this);
        add(update);

        add = new JButton("Add");
        add.setBounds(320, 100, 80, 20);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setBounds(420, 100, 80, 20);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900, 600);
        setLocation(200, 50);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == search) {
            String query = "select *from teacher where empid='" + cempid.getSelectedItem() + "'";
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
        } else if (ae.getSource() == update) {
            setVisible(false);
//            new AddTeacher();
        } else if (ae.getSource() == add) {
            setVisible(false);
            new AddTeacher();
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }

    }

    public static void main(String arg[]) {
        new TeacherDetails();
    }

}
