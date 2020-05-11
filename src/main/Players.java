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

class get_player {
	static Document PageHtmldata;
	static Connection con = null;

	public get_player() {
		try {
			URL url = new URL("https://www.cricketcountry.com/players/");
			URLConnection connection = url.openConnection();
			con = Connect.connect();
			PageHtmldata = Jsoup.connect("https://www.cricketcountry.com/players/").get();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 2);
		}
	}

	public static void get_player() {
		try {

			Elements Div_top = PageHtmldata.select("nav.tabnav");
			System.out.println(Div_top);
			Elements links = Div_top.select("a");
			for (Element link : links) {
				System.out.println(link.text() + " " + link.id().substring(3));
				Integer country_ID = 0;

				PreparedStatement st = con.prepareStatement("select * from c_team where team_name=? limit 1");
				st.setString(1, link.text());
				ResultSet Countrydataset = st.executeQuery();

				if (Countrydataset.next()) {
					System.out.println(Countrydataset.getString("Id"));
					country_ID = Countrydataset.getInt("Id");
				} else {

				}

				Elements Divtab = PageHtmldata.select("div#tabcontent" + link.id().substring(3) + "");
				Elements Playerinfo = Divtab.select("a[href^=https:]");

				for (Element Onebyoneplayerinfo : Playerinfo) {
					if (Onebyoneplayerinfo.text() == "" || Onebyoneplayerinfo.attr("href") == "") {

					} else {
						try {
							PreparedStatement stmt = con.prepareStatement(
									"insert into c_player(player_name,player_url,country_Id,status) values(?,?,?,?)");
							stmt.setString(1, Onebyoneplayerinfo.text());
							stmt.setString(2, Onebyoneplayerinfo.attr("href"));
							stmt.setInt(3, country_ID);
							stmt.setInt(4, 1);
							int i = stmt.executeUpdate();

						} catch (Exception e) {

							JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 2);
							System.exit(0);
						}
					}
				}

			}
			JOptionPane.showMessageDialog(null,"Players has been Scrapped Successfully","Success O peration",1);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, e.getStackTrace(), "Error", 2);
		}
	}
}

public class Players {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		get_player gp = new get_player();
		gp.get_player();
	}

}
