package main;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class Scrapdata {
	static String urlsite;
	static Document PageHtmldata;
	Connection con = null;

	public Scrapdata() {
		con = Connect.connect();
		try {
			URL url = new URL("https://economictimes.indiatimes.com/");
			URLConnection connection = url.openConnection();
			con = Connect.connect();
			PageHtmldata = Jsoup.connect("https://economictimes.indiatimes.com/").get();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,e.getStackTrace()+"Note :\n"+e.getMessage(),"Error",2);
		}
	}

	protected static void Gettitle() {
		System.out.println("Page Title Is : "+PageHtmldata.title());
	}
	
	protected static void Refreshpage() throws IOException {
		try {
			PageHtmldata = Jsoup.connect("https://economictimes.indiatimes.com/").get();
			System.out.println("Page Reloaded Sucessfully");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	protected static void GetSectionCategory() {
		try {
			Elements Section = PageHtmldata.select("nav#topNav");
			Elements links = Section.select("div.navElement");
			for (Element link : links) {
				System.out.println("Href: " + link.attr("href"));
				System.out.println("Category Name : " + link.text());
			}
		} catch (Exception e) {

		}
	}
	protected static void GetTopNews() {
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

	protected static void Coronacase() {
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
