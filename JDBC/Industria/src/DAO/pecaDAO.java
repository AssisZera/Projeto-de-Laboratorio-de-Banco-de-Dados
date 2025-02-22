package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entity.peca;

public class pecaDAO {

public void cadastrarPeca(peca peca) {
		
		String sql = "INSERT INTO PECA (PESOPECA, CORPECA, NUMDEPOSITO) VALUES (?, ?, ?)";
		
		PreparedStatement ps = null;
		
		try {
			ps = Conexao.getConexao().prepareStatement(sql);
			ps.setDouble(1, peca.getPesoPeca());
			ps.setString(2, peca.getCorPeca());
			ps.setInt(3, peca.getNumDeposito());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
