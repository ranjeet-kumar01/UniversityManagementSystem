package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class ExaminationDetails extends JFrame implements ActionListener {

    JTextField search;
    JButton submit, cancel;
    JTable table;

    ExaminationDetails() {
        setLayout(null);
        setSize(1000, 600);
        setLocation(200, 50);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("University Result");
        heading.setBounds(50, 0, 500, 50);
        heading.setFont(new Font("Tohma", Font.BOLD, 25));
        add(heading);

        JLabel lblrollno = new JLabel("Roll No.");
        lblrollno.setBounds(50, 80, 150, 25);
        lblrollno.setFont(new Font("Tohma", Font.BOLD, 20));
        add(lblrollno);

        search = new JTextField();
        search.setBounds(250, 80, 150, 25);
        search.setFont(new Font("Tohma", Font.PLAIN, 20));
        add(search);
        setVisible(true);

        submit = new JButton("Result");
        submit.setBounds(480, 80, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Back");
        cancel.setBounds(630, 80, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        table = new JTable();
        table.setFont(new Font("Serif", Font.PLAIN, 16));
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {

                int row = table.getSelectedRow();
                table.getModel().getValueAt(row, 2);
                search.setText(table.getModel().getValueAt(row, 2).toString());
            }
        }
        );

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 130, 1000, 310);
        add(jsp);

        try {
            JdbcConnection conn = new JdbcConnection();
            ResultSet rs = conn.s.executeQuery("select *from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            setVisible(false);

            new Marks(search.getText());
        } else {
            setVisible(false);
        }
    }

    public static void main(String arg[]) {
        new ExaminationDetails();
    }
}
