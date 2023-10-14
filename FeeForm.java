package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import java.sql.*;

public class FeeForm extends JFrame implements ActionListener {

    Choice crollno;
    JComboBox cbcourse, cbbranch, cbsemester;
    JButton update, pay, back, print;
    JLabel labeltotal;

    FeeForm() {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(900, 600);
        setLocation(200, 20);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(420, 50, 400, 300);
        add(image);

        JLabel heading = new JLabel("Student Fee Form");
        heading.setBounds(50, 50, 500, 30);
        heading.setFont(new Font("Tohma", Font.BOLD, 30));
        add(heading);

        JLabel lblrollno = new JLabel("Select Roll No");
        lblrollno.setBounds(50, 100, 150, 25);
        lblrollno.setFont(new Font("Tohma", Font.BOLD, 20));
        add(lblrollno);

        crollno = new Choice();
        crollno.setBounds(200, 100, 150, 25);
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

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 25);
        lblname.setFont(new Font("Tohma", Font.BOLD, 25));
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(200, 150, 250, 25);
        labelname.setFont(new Font("Tohma", Font.BOLD, 20));
        add(labelname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(50, 200, 180, 25);
        lblfname.setFont(new Font("Tohma", Font.BOLD, 25));
        add(lblfname);

        JLabel labelfname = new JLabel();
        labelfname.setBounds(230, 200, 250, 25);
        labelfname.setFont(new Font("Tohma", Font.BOLD, 20));
        add(labelfname);

        try {
            JdbcConnection conn = new JdbcConnection();
            String query = "select * from student where rollno='" + crollno.getSelectedItem() + "'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        crollno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {

                try {
                    JdbcConnection conn = new JdbcConnection();
                    String query = "select * from student where rollno='" + crollno.getSelectedItem() + "'";
                    ResultSet rs = conn.s.executeQuery(query);
                    while (rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));

                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });

        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(50, 250, 200, 25);
        lblcourse.setFont(new Font("serif", Font.BOLD, 25));
        add(lblcourse);

        String course[] = {"BTech", "BBA", "BCA", "Bsc", "Msc", "MBA", "MCA", "Bcom", "MCom", "MA", "BA"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200, 250, 150, 25);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(50, 300, 200, 25);
        lblbranch.setFont(new Font("serif", Font.BOLD, 25));
        add(lblbranch);

        String branch[] = {"Computer Science", "Electronics", "Mechanical", "Civil", "IT"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(200, 300, 150, 25);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);

        JLabel lblsemester = new JLabel("Semester");
        lblsemester.setBounds(50, 350, 200, 25);
        lblsemester.setFont(new Font("serif", Font.BOLD, 25));
        add(lblsemester);

        String semester[] = {"semester1", "semester2", "semester3", "semester4", "semester5", "semester6", "semester7", "semester8",};
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(200, 350, 150, 25);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);

        /// total fee amount
        JLabel lbltotal = new JLabel("Toatal Payable");
        lbltotal.setBounds(50, 400, 200, 25);
        lbltotal.setFont(new Font("serif", Font.BOLD, 25));
        add(lbltotal);

        labeltotal = new JLabel();
        labeltotal.setBounds(230, 400, 200, 25);
        labeltotal.setFont(new Font("serif", Font.BOLD, 25));
        add(labeltotal);

        update = new JButton("Update");
        update.setBounds(100, 500, 120, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(update);

        pay = new JButton("Pay Fee");
        pay.setBounds(250, 500, 120, 30);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        pay.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(pay);

        back = new JButton("Back");
        back.setBounds(400, 500, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(back);

        print = new JButton("Print");
        print.setBounds(550, 500, 120, 30);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        print.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(print);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            String course = (String) cbcourse.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();

            try {
                JdbcConnection conn = new JdbcConnection();
                ResultSet rs = conn.s.executeQuery("select *from fee where course='" + course + "'");
                while (rs.next()) {
                    labeltotal.setText(rs.getString(semester));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (ae.getSource() == pay) {

            String rollno = crollno.getSelectedItem();
            String course = (String) cbcourse.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();
            String total = labeltotal.getText();

            try {
                JdbcConnection conn = new JdbcConnection();

                String query = "insert into studentfee values('" + rollno + "', '" + course + "', '" + branch + "', '" + semester + "', '" + total + "')";
                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Fee Submited Successfully");

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (ae.getSource() == print) {

            PrinterJob printerJob = PrinterJob.getPrinterJob();
            if (printerJob.printDialog()) {
                try {
                    printerJob.print(); // This will print the form
                } catch (PrinterException ex) {
                    ex.printStackTrace();

                }

                Printable printable = new Printable() {
                    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
                        if (pageIndex == 0) {
                            // Print the contents of your form here using graphics
                            // You can use methods like drawString, drawRect, etc., to draw components and data.
                            return Printable.PAGE_EXISTS;
                        } else {
                            return Printable.NO_SUCH_PAGE;
                        }
                    }
                };

                printerJob.setPrintable(printable);
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String arg[]) {
        new FeeForm();
    }
}
