package main;

import java.awt.Color;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.Histogram;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.PieStyler.AnnotationType;
import org.knowm.xchart.style.Styler.ChartTheme;
import org.knowm.xchart.style.Styler.LegendPosition;
import org.knowm.xchart.style.Theme;

public class Xchart_demo {
	static Connection con = null;
	public Xchart_demo() {
		// TODO Auto-generated constructor stub
		con = Connect.connect();
		
		
	}
	@SuppressWarnings("rawtypes")
	public static void get_team_piechart() throws SQLException{
		
		java.sql.Statement stmt = null;
		 // Create Chart
		PieChart chart = new PieChartBuilder().width(1000).height(600).title("Top 10 - Counrty Grounds List").build();
		 
	   
	    
		    stmt = con.createStatement();
			String sql = "SELECt * from c_team_grounds order by noofground desc limit 10";
			ResultSet rs = stmt.executeQuery(sql);

			   while(rs.next()){
			         
				   chart.addSeries(rs.getString("team_name")+" - "+rs.getInt("noofground"),rs.getInt("noofground"));
			   }

	    
			
	    // Show it
	    new SwingWrapper(chart).displayChart();
	}
	private static List<Double> getGaussianData(int count) {
		 
	    List<Double> data = new ArrayList<Double>(count);
	    Random r = new Random();
	    for (int i = 0; i < count; i++) {
	      data.add(r.nextGaussian() * 10);
	    }
	    return data;
	  }
	@SuppressWarnings("rawtypes")
	public static void get_team_chart(Integer C_Id) throws SQLException{
	
		 // Create Chart
	    CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title("Score Histogram").xAxisTitle("Mean").yAxisTitle("Count").build();
	 
	    // Customize Chart
	    chart.getStyler().setLegendPosition(LegendPosition.InsideNW);
	    chart.getStyler().setAvailableSpaceFill(.96);
	    chart.getStyler().setOverlapped(true);
	 
	    // Series
	    Histogram histogram1 = new Histogram(getGaussianData(10000), 20, -20, 20);
	    Histogram histogram2 = new Histogram(getGaussianData(15000), 20, -20, 20);
	    chart.addSeries("histogram 1", histogram1.getxAxisData(), histogram1.getyAxisData());
	    chart.addSeries("histogram 2", histogram2.getxAxisData(), histogram2.getyAxisData());
	    
	    new SwingWrapper(chart).displayChart();
	}
	

	public static void main(String[] args) throws IOException, SQLException{
		//get_team_piechart();
		get_team_chart(5);
	}
	
}
