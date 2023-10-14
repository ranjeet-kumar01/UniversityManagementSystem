package university.management.system;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    About() {
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setSize(700, 600);
        setLocation(300, 50);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(320, 0, 400, 250);
        add(image);

        JLabel heading = new JLabel("<html>University<br>Management System");
        heading.setBounds(70, 50, 250, 130);
        heading.setFont(new Font("Tohma", Font.BOLD, 30));
        add(heading);

        JLabel lblname = new JLabel("Developed By:  Ranjeet Kumar");
        lblname.setBounds(80, 230, 450, 40);
        lblname.setFont(new Font("Tohma", Font.BOLD, 30));
        add(lblname);

        JLabel lblrollno = new JLabel("Roll Number: 20113026");
        lblrollno.setBounds(80, 290, 450, 30);
        lblrollno.setFont(new Font("Tohma", Font.PLAIN, 25));
        add(lblrollno);

        JLabel lblcourse = new JLabel("Course: Diploma(CS&E)");
        lblcourse.setBounds(80, 350, 450, 30);
        lblcourse.setFont(new Font("Tohma", Font.PLAIN, 25));
        add(lblcourse);

        JLabel lblphone = new JLabel("Contact: 6397703953");
        lblphone.setBounds(80, 410, 550, 30);
        lblphone.setFont(new Font("Tohma", Font.PLAIN, 25));
        add(lblphone);
        
        JLabel lblemail = new JLabel("Email: ranjeetdiwakarcs@gmail.com");
        lblemail.setBounds(80, 470, 550, 25);
        lblemail.setFont(new Font("Tohma", Font.PLAIN, 20));
        add(lblemail);
        
        JLabel lbladdress = new JLabel("<html>Add: Milak Arif, Rampur,</br>Uttar Pradesh-244927</html>");
        lbladdress.setBounds(80, 530, 450, 30);
        lbladdress.setFont(new Font("Tohma", Font.PLAIN, 20));
        add(lbladdress);
        
        
       ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/rkabout.jpg"));
        Image img2 = img1.getImage().getScaledInstance(200, 220, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel img = new JLabel(img3);
        img.setBounds(390, 260, 250, 250);
        add(img);

        setVisible(true);
    }

    public static void main(String arg[]) {
        new About();
    }
}
