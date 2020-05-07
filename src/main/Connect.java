
package main;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Connect {
 
  public static Connection connect(){
       try{
    Class.forName("com.mysql.cj.jdbc.Driver"); 
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proscrapper?useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
    if(con!=null) {
    	return con ;
    }
   }catch(Exception e){
	   System.out.println(e.getMessage());
    JOptionPane.showMessageDialog(null, e.getStackTrace(),"Error",2);
    System.exit(0);
   }
   return null ;
}    
  }
   