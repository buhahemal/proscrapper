package main;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import javax.swing.JOptionPane;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
class Getdata {
	static String urlsite;
	Document PageHtmldata;
	Connection con = null;
	public Getdata(String uri) {
		// TODO Auto-generated constructor stub
		con=Connect.connect();
		try {
			URL url = new URL(uri);
			URLConnection connection = url.openConnection();
			con = Connect.connect();
			System.out.println("Internet is connected");
			urlsite = uri;
			PageHtmldata = Jsoup.connect("https://economictimes.indiatimes.com/").get();
		} catch (IOException e) {
			System.out.println("Internet is not connected");
		}
	}

	public void Gettitle() {
		System.out.println("Page Title Is : "+PageHtmldata.title());
	}

	public void Refreshpage() throws IOException {
		try {
			PageHtmldata = Jsoup.connect("https://economictimes.indiatimes.com/").get();
			
			System.out.println("Page Reloaded Sucessfully");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void GetSectionCategory() throws IOException {
		try {
			Elements Section = PageHtmldata.select("nav#topNav");
			Elements links = Section.select("div.navElement");
			
			for (Element link : links) {
				System.out.println(link);
				System.out.println("Href: " + link.attr("href"));
				System.out.println("Category Name : " + link.text());
				/*PreparedStatement st = con.prepareStatement("select * from news_category where Category_name=? limit 1");
				st.setString(1, link.text());
			    ResultSet r1=st.executeQuery();

			     if(r1.next()) {

			           
			      }
			     else
			     {
			    	 try {
			    		 PreparedStatement stmt=con.prepareStatement("insert into news_category(Category_name,Category_url,Status) values(?,?,?)");  
				    	 stmt.setString(1, link.text());  
				    	 stmt.setString(2,link.text().toLowerCase());
				    	 stmt.setInt(3, 1);
				    	   
				    	 int i=stmt.executeUpdate();  
				    	 
			    	 }
			    	 catch (Exception e) {
			    		 	System.out.println(e.getMessage());
					}
			     }*/
			}
			
		} catch (Exception e) {

		}
	}

	public void GetTopNews() {
		try {
			Elements Div_top = PageHtmldata.select("div.tabsView");
			Elements tabscontent = Div_top.select("div.tabsContent");
			Elements links = tabscontent.select("a");
			for (Element link : links) {
				// System.out.println("Href: " + link.attr("href"));
				System.out.println(" News: " + link.text());
			}

		} catch (Exception e) {
		}
	}

	public void Coronacase() {
		try {
			Elements Section = PageHtmldata.select("section.c-t-home");
			Elements IndiaData = Section.select("div#india_data");
			Elements Worlddata = Section.select("div#world_data");
			System.out.println("Corona Cases In India = " + IndiaData.select("div.no-of-cases").first().text());
			System.out.println("Due to Corona Death In India = " + IndiaData.select("div.no-of-cases").last().text());
			System.out.println("Corona Cases In World = " + Worlddata.select("div.no-of-cases").first().text());
			System.out.println("Due to Corona Death In World = " + Worlddata.select("div.no-of-cases").last().text());
		} catch (Exception e) {

		}
	}
}

public class Scrape {

	public static void main(String[] args) throws IOException {
		Getdata Scrapping = new Getdata("https://economictimes.indiatimes.com/");
		Integer Condition_Var = 0;
		do {
			Scanner select = new Scanner(System.in);
			Integer Choose = 0;
			System.out.println("\n1. Refresh Page\n2. Title\n3. GetCategory \n4. Corona-Cases \n5. Top-News \n6. Exit");
			System.out.print("Choose Your Option = ");
			try {
				Choose = select.nextInt();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			switch (Choose) {
			case 1:
				Scrapping.Refreshpage();
				break;

			case 2:
				Scrapping.Gettitle();
				break;

			case 3:
				Scrapping.GetSectionCategory();
				break;

			case 4:
				Scrapping.Coronacase();
				break;
			case 5:
				Scrapping.GetTopNews();
				break;
			case 6:
				System.out.println("Exit");
				Condition_Var = 5;
				break;

			}
		} while (Condition_Var < 4);
		System.out.println("Thankyou For Using");
	}

}
