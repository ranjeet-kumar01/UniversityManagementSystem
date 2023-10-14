package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JButton login, cancel;
    JTextField tfusername,tfpassword;
//    JPasswordField tfpassword;
    
    Login() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 20);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(160, 20, 150, 20);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 50, 100, 20);
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(160, 50, 150, 20);
        add(tfpassword);
        
        login = new JButton("Login");
        login.setBounds(50, 100, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Tahoma", Font.BOLD, 16));
        login.addActionListener(this);
        add(login);
        
        cancel = new JButton("cancel");
        cancel.setBounds(180, 100, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 16));
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        setSize(600, 300);
        setLocation(350, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            
            String username=tfusername.getText();
            String password=tfpassword.getText();  
            
            
            String query="select * from login where username='"+username+"' and password='"+password+"'";
            
            try{
                JdbcConnection jdbcConn=new JdbcConnection();
                ResultSet rs=jdbcConn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Project();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                    System.exit(0);
                }
                jdbcConn.c.close();
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
//                    setVisible(false);
            System.exit(0);
        }
        
        
    }
    
    public static void main(String[] args) {
        new Login();
    }
    
}
