package main;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import javax.swing.JOptionPane;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class get_Teams {
	static Document PageHtmldata;
	static Connection con = null;
	public get_Teams() {
		try {
			URL url = new URL("https://www.espncricinfo.com/story/_/id/18791072/all-cricket-teams-index");
			URLConnection connection = url.openConnection();
			con = Connect.connect();
			PageHtmldata = Jsoup.connect("https://www.espncricinfo.com/story/_/id/18791072/all-cricket-teams-index").get();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",2);
		}
	}
	
	public static void get_Teams(){
	       try{
	    	   
	    	   Element Div_top = PageHtmldata.select("div.teams-section").first();
	    	   Elements links = Div_top.select("a");
				for (Element link : links) {
					System.out.println("Href: " + link.attr("href"));
					System.out.println(" News: " + link.text());
					PreparedStatement st = con.prepareStatement("select * from c_team where team_name=? limit 1");
					st.setString(1, link.text());
				    ResultSet r1=st.executeQuery();

				     if(r1.next()) {   
				      }
				     else
				     {
							try {
								PreparedStatement stmt = con
										.prepareStatement("insert into c_team(team_name,team_url) values(?,?)");
								stmt.setString(1, link.text());
								stmt.setString(2, link.attr("href"));
								int i = stmt.executeUpdate();

							} catch (Exception e) {

								JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 2);
								System.exit(0);
							}
					     }
				}
			JOptionPane.showMessageDialog(null,"Teams has been Scrapped Successfully","Success O peration",1);
			new team_gui_data().setVisible(true);
				
	       }catch(Exception e){
		   System.out.println(e.getMessage());
	    JOptionPane.showMessageDialog(null, e.getStackTrace(),"Error",2);
	   }
	}    
}
public class Teams {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			get_Teams gt= new get_Teams();
			gt.get_Teams();
	}

}
