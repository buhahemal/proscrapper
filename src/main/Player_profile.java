package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

	public static void get_player_profile(String url, Integer pid) {
		try {

			PageHtmldata = Jsoup.connect(url).get();
			Elements player_profile = PageHtmldata.select("section.ply-info-outer");
			Elements profile = player_profile.select("aside.ply-info-dis");

			//System.out.println(profile);
			Integer player_chkid = 0;

			PreparedStatement st = con
					.prepareStatement("select * from c_player_profile where player_fullname=? limit 1");
			st.setString(1, profile.get(0).text());
			ResultSet Playedataset = st.executeQuery();

			if (Playedataset.next()) {
				player_chkid = Playedataset.getInt("Id");
			} else {
				try {
					PreparedStatement stmt = con.prepareStatement(
							"insert into c_player_profile(c_player_Id,player_fullname,player_borndetails,player_age,player_team,player_battingstyle, player_bowlingstyle) values(?,?,?,?,?,?,?)");
					stmt.setInt(1, pid);
					stmt.setString(2, profile.get(0).text());
					stmt.setString(3, profile.get(1).text());
					stmt.setString(4, profile.get(2).text());
					stmt.setString(5, profile.get(3).text());
					stmt.setString(6, profile.get(4).text());
					stmt.setString(7, profile.get(5).text());
					int ids = stmt.executeUpdate();
					if (ids == 1) {
						System.out.println("Done" + profile.get(0).text());
					}
				} catch (Exception e) {

					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 2);
					System.exit(0);
				}				
			}
			
			Element batting_stat = PageHtmldata.select("table.table").first();
			Element bowling_stat = PageHtmldata.select("table.table").last();
			Elements batting_rows = batting_stat.select("tr");
			for (int j = 1; j < batting_rows.size() - 1; j++) { // first row is the col names so skip it.
				Element row = batting_rows.get(j);
				Elements cols = row.select("td");
				System.out.println(cols.get(3));
			}

			Elements bowling_rows = bowling_stat.select("tr");
			for (int j = 1; j < bowling_rows.size() - 1; j++) { // first row is the col names so skip it.
				Element row = bowling_rows.get(j);
				Elements cols = row.select("td");
				System.out.println(cols.get(0));
			}

		} catch (Exception e) {
			if(e.getMessage() == "Read timed out") {
				scrape_player_data();
			}
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, e.getStackTrace(), "Error", 2);
		}
	}

	public static void scrape_player_data() {
		String query = "select Id,player_url from c_player";
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {
			ResultSet rs4 = null;
			try {
				rs4 = stmt.executeQuery(query);
			} catch (SQLException e) {

				e.printStackTrace();
			}

			try {
				while (rs4.next()) {
					//get_player_profile("https://www.cricketcountry.com/players/ajinkya-rahane/", 10);
					get_player_profile(rs4.getString("player_url"), rs4.getInt("Id"));
					break;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}

public class Player_profile {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		get_playerprofile gp = new get_playerprofile();
		gp.scrape_player_data();
	}

}
