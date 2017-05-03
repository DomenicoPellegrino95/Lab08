package it.polito.tdp.borders.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.borders.model.Border;
import it.polito.tdp.borders.model.Country;

public class BordersDAO {

	public List<Country> loadAllCountries() {

		String sql = "SELECT CCode,StateAbb,StateNme " + "FROM country " + "ORDER BY StateAbb ";

		try {
			Connection conn = DBConnect.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			List<Country> country = new ArrayList<Country>();

			while (rs.next()) {
				country.add(new Country(rs.getString("StateAbb"), rs.getInt("CCode"), rs.getString("StateNme")));
			}

			conn.close();
			return country;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database Error -- loadAllCountries");
			throw new RuntimeException("Database Error");
		}
	}

	public List<Border> getCountryPairs(int anno) {
		String sql = "SELECT state1no, state2no " + "FROM contiguity " + "WHERE year<=? AND conttype=1  ";

		try {
			Connection conn = DBConnect.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1,  anno);

			ResultSet rs = st.executeQuery();
			
			List<Border> border = new ArrayList<Border>();

			while (rs.next())
				border.add(new Border(rs.getInt("state1no"), rs.getInt("state2no")));

			conn.close();
			return border;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database Error -- loadAllCountries");
			throw new RuntimeException("Database Error");
		}
	}
}
