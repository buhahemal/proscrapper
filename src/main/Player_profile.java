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

class get_playerprofile {
	static Document PageHtmldata;
	static Connection con = null;

	public get_playerprofile() {
		con = Connect.connect();
	}

	public static void get_player_profile(String url) {
		try {
			
			PageHtmldata = Jsoup.connect(url).get();
			Elements player_profile = PageHtmldata.select("section.ply-info-outer");
			Element batting_stat = PageHtmldata.select("table.table").first();
			Element bowling_stat = PageHtmldata.select("table.table").last();
			System.out.println(player_profile.select("aside.ply-info-dis").first().text());
			System.out.println(player_profile.select("span.itemprop"));
			System.out.println(player_profile);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, e.getStackTrace(), "Error", 2);
		}
	}
	
}

public class Player_profile {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		get_playerprofile gp = new get_playerprofile();
		gp.get_player_profile("https://www.cricketcountry.com/players/aashish-kapoor/");
	}

}
