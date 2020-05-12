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
import org.jsoup.safety.Whitelist;
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

			Integer player_chkid = 0;

			PreparedStatement st = con
					.prepareStatement("select Id from c_player_profile where player_fullname=? limit 1");
			st.setString(1, profile.get(0).text());
			ResultSet Playedataset = st.executeQuery();

			if (Playedataset.next()) {
				player_chkid = Playedataset.getInt("Id");
				PreparedStatement stmt = con.prepareStatement(
						"UPDATE c_player_profile SET player_age = ?, player_image_url = ? where Id = ?");
				stmt.setString(1, profile.get(2).text());
				stmt.setString(2, player_profile.select("img").attr("src"));
				stmt.setInt(3, player_chkid);
				player_chkid = stmt.executeUpdate();
				if (player_chkid == 1) {
					 System.out.println("Update Profile Done " + profile.get(0).text());
				}
			} else {
				try {
					PreparedStatement stmt = con.prepareStatement(
							"insert into c_player_profile(c_player_Id,player_fullname,player_borndetails,player_age,player_team,player_battingstyle, player_bowlingstyle,player_image_url) values(?,?,?,?,?,?,?,?)");
					stmt.setInt(1, pid);
					stmt.setString(2, profile.get(0).text());
					stmt.setString(3, profile.get(1).text());
					stmt.setString(4, profile.get(2).text());
					stmt.setString(5, profile.get(3).text());
					stmt.setString(6, profile.get(4).text());
					stmt.setString(7, profile.get(5).text());
					stmt.setString(8, player_profile.select("img").attr("src"));
					int ids = stmt.executeUpdate();
					if (ids == 1) {
						 System.out.println("New Profile Done " + profile.get(0).text());
					}
				} catch (Exception e) {

					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 2);
					System.exit(0);
				}
			}
			// profile insert done
			
			Element bowling_stat = PageHtmldata.select("table.table").last();
			Elements bowling_rows = bowling_stat.select("tr");
			for (int j = 1; j < bowling_rows.size() - 1; j++) { // first row is the col names so skip it.
				Element row = bowling_rows.get(j);
				Elements cols = row.select("td");
				String tbname ="";
				if(j == 1) {
					tbname="c_player_test_bowling";
				}
				if(j == 2) {
					tbname="c_player_odi_bowling";
				}
				if(j == 3) {
					tbname="c_player_t20_bowling";
				}
				
				
				Integer player_insert_id = 0;
				
				PreparedStatement Inst = con
						.prepareStatement("select c_player_Id from "+tbname+" where c_player_Id=? limit 1");
				Inst.setInt(1,pid);
				ResultSet Playerdata = Inst.executeQuery();

				if (Playerdata.next()) {
					player_insert_id = Playerdata.getInt("c_player_Id");
					PreparedStatement stmt = con.prepareStatement(
							"UPDATE "+tbname+" SET  no_of_match = ?, no_of_balls = ?, no_of_run_given = ?, no_wicket_take = ?, average = ?, economony = ?, bowling_strike_rate = ?, 5wi_hole = ?, 10wi_match = ?, best_bowling_ing = ?, best_bowling_match  = ? Where c_player_Id = ?");
					stmt.setString(1, cols.get(1).text());
					stmt.setString(2, cols.get(2).text());
					stmt.setString(3, cols.get(3).text());
					stmt.setString(4, cols.get(4).text());
					stmt.setString(5, cols.get(5).text());
					stmt.setString(6, cols.get(6).text());
					stmt.setString(7, cols.get(7).text());
					stmt.setString(8, cols.get(8).text());
					stmt.setString(9, cols.get(9).text());
					stmt.setString(10, cols.get(10).text());
					stmt.setString(11, cols.get(11).text());
					stmt.setInt(12, pid);
					player_insert_id = stmt.executeUpdate();
					if (player_insert_id == 1) {
						System.out.println(""+tbname+" update Record  " + profile.get(0).text());
					}
				} else {
					try {
						
						PreparedStatement stmt = con.prepareStatement(
								"insert into "+tbname+"(c_player_Id, no_of_match, no_of_balls, no_of_run_given, no_wicket_take, average, economony, bowling_strike_rate, 5wi_hole, 10wi_match, best_bowling_ing, best_bowling_match) values(?,?,?,?,?,?,?,?,?,?,?,?)");
						stmt.setInt(1, pid);
						stmt.setString(2, cols.get(1).text());
						stmt.setString(3, cols.get(2).text());
						stmt.setString(4, cols.get(3).text());
						stmt.setString(5, cols.get(4).text());
						stmt.setString(6, cols.get(5).text());
						stmt.setString(7, cols.get(6).text());
						stmt.setString(8, cols.get(7).text());
						stmt.setString(9, cols.get(8).text());
						stmt.setString(10, cols.get(9).text());
						stmt.setString(11, cols.get(10).text());
						stmt.setString(12, cols.get(11).text());
						player_insert_id = stmt.executeUpdate();
						if (player_insert_id == 1) {
							System.out.println(""+tbname+" New Insert  " + profile.get(0).text());
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
						JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 2);
						System.exit(0);
					}
				}
				

			}

			// batting stat insert
			Element batting_stat = PageHtmldata.select("table.table").first();

			Elements batting_rows = batting_stat.select("tr");
			for (int j = 1; j < batting_rows.size() - 1; j++) { // first row is the col names so skip it.
				Element row = batting_rows.get(j);
				Elements cols = row.select("td");
				String tbname ="";
				if(j == 1) {
					tbname="c_player_test_batting";
				}
				if(j == 2) {
					tbname="c_player_odi_batting";
				}
				if(j == 3) {
					tbname="c_player_t20_batting";
				}
				
				
				Integer player_insert_id = 0;
				
				PreparedStatement Inst = con
						.prepareStatement("select c_player_Id from "+tbname+" where c_player_Id=? limit 1");
				Inst.setInt(1,pid);
				ResultSet Playerdata = Inst.executeQuery();

				if (Playerdata.next()) {
					player_insert_id = Playerdata.getInt("c_player_Id");
					PreparedStatement stmt = con.prepareStatement(
							"UPDATE "+tbname+" SET No_of_match = ?, innings = ?, Run = ?, Notout = ?,Highest_score = ?, Average = ?, Balls_faced = ?, Strike_rate = ?, no_of_century = ?, no_of_fifty = ?, no_of_four = ?, no_of_six = ?, no_of_catches = ?, no_of_stumping = ? Where c_player_Id = ?");
					stmt.setString(1, cols.get(1).text());
					stmt.setString(2, cols.get(2).text());
					stmt.setString(3, cols.get(3).text());
					stmt.setString(4, cols.get(4).text());
					stmt.setString(5, cols.get(5).text());
					stmt.setString(6, cols.get(6).text());
					stmt.setString(7, cols.get(7).text());
					stmt.setString(8, cols.get(8).text());
					stmt.setString(9, cols.get(9).text());
					stmt.setString(10, cols.get(10).text());
					stmt.setString(11, cols.get(11).text());
					stmt.setString(12, cols.get(12).text());
					stmt.setString(13, cols.get(13).text());
					stmt.setString(14, cols.get(14).text());
					stmt.setInt(15, player_insert_id);
					player_insert_id = stmt.executeUpdate();
					if (player_insert_id == 1) {
						System.out.println(""+tbname+" update Record  " + profile.get(0).text());
					}
				} else {
					try {
						
						PreparedStatement stmt = con.prepareStatement(
								"insert into "+tbname+"(c_player_Id, No_of_match, innings, Run, Notout,Highest_score, Average, Balls_faced, Strike_rate, no_of_century, no_of_fifty, no_of_four, no_of_six, no_of_catches, no_of_stumping) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
						stmt.setInt(1, pid);
						stmt.setString(2, cols.get(1).text());
						stmt.setString(3, cols.get(2).text());
						stmt.setString(4, cols.get(3).text());
						stmt.setString(5, cols.get(4).text());
						stmt.setString(6, cols.get(5).text());
						stmt.setString(7, cols.get(6).text());
						stmt.setString(8, cols.get(7).text());
						stmt.setString(9, cols.get(8).text());
						stmt.setString(10, cols.get(9).text());
						stmt.setString(11, cols.get(10).text());
						stmt.setString(12, cols.get(11).text());
						stmt.setString(13, cols.get(12).text());
						stmt.setString(14, cols.get(13).text());
						stmt.setString(15, cols.get(14).text());
						player_insert_id = stmt.executeUpdate();
						if (player_insert_id == 1) {
							System.out.println(""+tbname+" New Insert  " + profile.get(0).text());
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
						JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 2);
						System.exit(0);
					}
				}
			}

			

		} catch (Exception e) {
			if (e.getMessage() == "Read timed out") {
				JOptionPane.showMessageDialog(null, "Read Time Out Please Wait......", "Success O peration", 1);
				scrape_player_data();
			}
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, e.getStackTrace(), "Error", 2);
		}
		String htmlToClean = PageHtmldata.toString();
	    Jsoup.clean(htmlToClean, Whitelist.none());
		System.out.println("Done Player Id IS = "+pid);
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
//					 get_player_profile("https://www.cricketcountry.com/players/akshar-patel/",
//					 18);
//					 break;
					get_player_profile(rs4.getString("player_url"), rs4.getInt("Id"));
					
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			try {
				JOptionPane.showMessageDialog(null, "All Player Data Scrap Sucessfully.....", "Success O peration", 1);
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
