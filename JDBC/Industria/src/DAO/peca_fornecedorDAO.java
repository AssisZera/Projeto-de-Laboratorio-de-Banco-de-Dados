package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entity.peca_fornecedor;

public class peca_fornecedorDAO {

public void cadastrarPeca_fornecedor(peca_fornecedor peca_fornecedor) {
		
		String sql = "INSERT INTO PECA_FORNECEDOR (NUMFORNECEDOR, NUMPECA) VALUES (?, ?)";
		
		PreparedStatement ps = null;
		
		try {
			ps = Conexao.getConexao().prepareStatement(sql);
			ps.setInt(1, peca_fornecedor.getNumFornecedor());
			ps.setInt(2, peca_fornecedor.getNumPeca());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
