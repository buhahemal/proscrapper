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
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 2);
		}
	}

	public static void get_grounds() {
		try {

			ArrayList<String> Country_list = new ArrayList<String>();
			Elements Country_array_part = PageHtmldata.select("span:not(.LinkMed)");
			Elements Country_array = Country_array_part.select("span:not(.Comments)");
			ArrayList<String> list = new ArrayList<String>();
			for (Element country : Country_array) {
				Country_list.add(country.text());
			}

			Elements recordtable = PageHtmldata.select("div.RecordTable");

			for (int i = 0; i < Country_list.size(); i++) {
				Integer country_ID = 0;

				PreparedStatement st = con.prepareStatement("select * from c_team where team_name=? limit 1");
				st.setString(1, Country_list.get(i));
				ResultSet Countrydataset = st.executeQuery();

				if (Countrydataset.next()) {
					country_ID = Countrydataset.getInt("Id");
				} else {
					try {
						PreparedStatement stmt = con
								.prepareStatement("insert into c_team(team_name,team_url) values(?,?)");
						stmt.setString(1, Country_list.get(i));
						stmt.setString(2, "");
						int ids = stmt.executeUpdate();
						if (ids == 1) {
							PreparedStatement ast = con
									.prepareStatement("select * from c_team where team_name=? limit 1");
							st.setString(1, Country_list.get(i));
							ResultSet aCountrydataset = st.executeQuery();

							if (aCountrydataset.next()) {
								country_ID = aCountrydataset.getInt("Id");
							}

						}
					} catch (Exception e) {

						JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 2);
						System.exit(0);
					}

				}
				Element table = recordtable.get(i);
				Elements rows = table.select("tr");
				//System.out.println(table);
				for (int j = 1; j < rows.size(); j++) { // first row is the col names so skip it.
					Element row = rows.get(j);
					Elements cols = row.select("td");

					PreparedStatement stmt = con.prepareStatement(
							"insert into c_grounds(team_id,ground_city,ground_name,no_of_test,no_of_odi,no_of_t20) values(?,?,?,?,?,?)");
					stmt.setInt(1, country_ID);
					stmt.setString(2, cols.get(0).text());
					stmt.setString(3, cols.get(1).text());
					stmt.setString(4, cols.get(2).text());
					stmt.setString(5, cols.get(3).text());
					stmt.setString(6, cols.get(4).text());
					int chk = stmt.executeUpdate();
				}

			}
			JOptionPane.showMessageDialog(null,"Venues has been Scrapped Successfully","Success O peration",1);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, e.getStackTrace(), "Error", 2);
		}
	}
}

public class Venues {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		get_ground gt = new get_ground();
		gt.get_grounds();
	}

}
