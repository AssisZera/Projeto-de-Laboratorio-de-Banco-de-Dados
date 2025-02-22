package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entity.fornecedor;

public class fornecedorDAO {

public void cadastrarFornecedor(fornecedor fornecedor) {
		
		String sql = "INSERT INTO FORNECEDOR (NOMEFORNECEDOR) VALUES (?)";
		
		PreparedStatement ps = null;
		
		try {
			ps = Conexao.getConexao().prepareStatement(sql);
			ps.setString(1, fornecedor.getNomeFornecedor());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
