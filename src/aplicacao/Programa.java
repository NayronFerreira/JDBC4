package aplicacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import db.DB;

public class Programa {

	public static void main(String[] args) {
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;
		
		try{
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"UPDATE seller "
					+"SET BaseSalary = BaseSalary + ? "
					+"WHERE "
					+"(DepartmentId = ?)"
							);
			st.setDouble(1, 2000);
			st.setInt(2, 2);
			
			st = conn.prepareStatement("UPDATE seller "
					+"SET Name = ? "
					+"WHERE "
					+"(Id = ?)"
					);
			
			st.setString(1, "Nayron Ferreira");
			
			st.setInt(2, 8);
			
			int linhas = st.executeUpdate();
			
			System.out.println("Foram alterada(s) "+linhas+" linha(s)");
		}catch(SQLException x) {
			x.printStackTrace();
	//	}catch(ParseException c) {
		//	c.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
