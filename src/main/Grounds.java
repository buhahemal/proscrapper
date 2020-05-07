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

class get_ground {
	static Document PageHtmldata;
	static Connection con = null;
	public get_ground() {
		try {
			URL url = new URL("https://en.wikipedia.org/wiki/List_of_cricket_grounds_by_capacity");
			URLConnection connection = url.openConnection();
			con = Connect.connect();
			PageHtmldata = Jsoup.connect("https://en.wikipedia.org/wiki/List_of_cricket_grounds_by_capacity").get();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",2);
		}
	}
	
	public static void get_geounds(){
	       try{
	    	   ArrayList<String> Ground_list = new ArrayList<>();	    	   
	    	   Element Div_top = PageHtmldata.select("table.wikitable").first();
	    	   //System.out.println(Div_top);
	    	   Elements rows = Div_top.select("tr");
	    	   for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
	    		    Element row = rows.get(i);
	    		    Elements cols = row.select("td");
	    		    System.out.println(row);
	    		    Ground_list.add(cols.get(2).text());
	    		}
	    	   System.out.println(Ground_list);
	    	   
	    	   Elements pcontent = Div_top.select("strong");
	    	   System.out.println(pcontent);
	    	   
				for (Element link : pcontent) {
					Integer length=link.text().length();
					System.out.println(length);
					System.out.println("last char = " + link.text().charAt(link.text().length() - 2));
					PreparedStatement st = con.prepareStatement("select * from c_team where team_name=? limit 1");
					st.setString(1, link.text());
				    ResultSet r1=st.executeQuery();

				     if(r1.next()) {   
				      }
				     else
				     {
				    	 try {
//				    		 PreparedStatement stmt=con.prepareStatement("insert into c_team(team_name,team_url) values(?,?)");  
//					    	 stmt.setString(1, link.text());  
//					    	 stmt.setString(2,link.attr("href"));
//					    	 int i=stmt.executeUpdate();  
//					    	 
				    	 }
				    	 catch (Exception e) {

				    		    JOptionPane.showMessageDialog(null, e.getMessage(),"Error",2);
				    		    System.exit(0);
						}
				     }
				}
	       }catch(Exception e){
		   System.out.println(e.getMessage());
	    JOptionPane.showMessageDialog(null, e.getStackTrace(),"Error",2);
	   }
	}    
}
public class Grounds {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		get_ground gt= new get_ground();
			gt.get_geounds();
	}

}
