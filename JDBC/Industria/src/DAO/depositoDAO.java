package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entity.deposito;

public class depositoDAO {

public void cadastrarDeposito(deposito deposito) {
		
		String sql = "INSERT INTO DEPOSITO (NOMEDEPOSITO) VALUES (?)";
		
		PreparedStatement ps = null;
		
		try {
			ps = Conexao.getConexao().prepareStatement(sql);
			ps.setString(1, deposito.getNomeDeposito());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
