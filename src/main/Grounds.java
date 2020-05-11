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
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;


class get_ground {
	static String PageSHtmldata;
	static Document PageHtmldata;
	static Connection con = null;
	public get_ground() {
		try {
			URL url = new URL("https://www.cricket-stats.net/genp/grounds.shtml");
			URLConnection connection = url.openConnection();
			con = Connect.connect();
			PageSHtmldata = String.valueOf(Jsoup.connect("https://www.cricket-stats.net/genp/grounds.shtml").get());
			PageHtmldata = Jsoup.parse(PageSHtmldata);
			 
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",2);
		}
	}
	
	public static void get_geounds(){
	       try{
	    	   
	    	   ArrayList<String> Country_list=new ArrayList<String>();
	    	   Elements Country_array_part = PageHtmldata.select("span:not(.LinkMed)");
	    	   Elements Country_array = Country_array_part.select("span:not(.Comments)");
	    	   ArrayList<String> list=new ArrayList<String>();
	    	   for(Element country : Country_array)
	    	   {
	    		   Country_list.add(country.text());
	    	   }
	    	   
	    	   Elements recordtable = PageHtmldata.select("div.RecordTable");
	    	   //Element table = Div_top.get(2);
	    	   //System.out.println(Div_top.size());
	    	  // System.out.println(table);
	    	   for (int i=0; i<Country_list.size(); i++) 
	    	   {
	    		   //System.out.println(i);
	    		   //System.out.println(Country_list.get(i));
	    	     
	    		 Element table = recordtable.get(i);
	    		 Elements rows = table.select("tr");
	    		 System.out.println(table);
	    		 for (int j = 1; j < rows.size(); j++) { //first row is the col names so skip it.
	    		        Element row = rows.get(j);
	    		        Elements cols = row.select("td");
	    		        System.out.println(cols.get(0).text());
	    		        System.out.println(cols.get(1).text());
	    		        System.out.println(cols.get(2).text());
	    		        System.out.println(cols.get(3).text());
	    		        System.out.println(cols.get(4).text());
	    		        break;
	    		 }
	    		 break;
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
