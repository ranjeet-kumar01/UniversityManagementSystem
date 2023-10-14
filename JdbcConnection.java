
package university.management.system;

import java.sql.*;

public class JdbcConnection {
    
    Connection c;
    Statement s;
    
    JdbcConnection(){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem", "root","umsystem");
            s=c.createStatement();
        }
        catch(Exception ex){
            ex.printStackTrace();
            
        }
        
    }
    
  
}
