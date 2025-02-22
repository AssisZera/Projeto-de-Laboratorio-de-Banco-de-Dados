package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entity.DDD;

public class DDDDAO {

	public void cadastrarDDD(DDD DDD) {
		
		String sql = "INSERT INTO DDD (NUMDDD, REGIAODDD) VALUES (?, ?)";
		
		PreparedStatement ps = null;
		
		try {
			ps = Conexao.getConexao().prepareStatement(sql);
			ps.setInt(1, DDD.getNumDDD());
			ps.setString(2, DDD.getRegiaoDDD());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
