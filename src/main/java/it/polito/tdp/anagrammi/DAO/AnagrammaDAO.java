package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {
	
	public boolean isCorrect(String parola) {
		String sql = "SELECT COUNT(*) AS n " + "FROM parola " + "WHERE nome = ?";
		boolean risultato = false;
		Connection conn = ConnectDB.getConnection();
		
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, parola);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int esiste = rs.getInt("n");
				if (esiste > 0) {
					risultato = true;
				}
			}
			rs.close();
			st.close();
			conn.close();
			return risultato;
		} catch (SQLException e) {
			System.err.println("Errore di connessione al database");
			e.printStackTrace();
			return risultato;
			
		}
	}

}
