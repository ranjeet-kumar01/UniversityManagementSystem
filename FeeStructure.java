
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FeeStructure extends JFrame {
 
    
    FeeStructure(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        setSize(1000,600);
        setLocation(150,50);
        
        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(50,0,250,25);
        heading.setFont(new Font("Tohma",Font.BOLD,25));
        add(heading);
        
        JTable table = new JTable();
        
        try{
            
            JdbcConnection conn = new JdbcConnection();
            ResultSet rs = conn.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,60,1000,700);
        add(jsp);
        
        setVisible(true);
    }
    
    public static void main(String arg[]){
        new FeeStructure();
    }
}
