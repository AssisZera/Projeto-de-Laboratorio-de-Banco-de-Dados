package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entity.fornecedor_projeto;

public class fornecedor_projetoDAO {

public void cadastrarFornecedor_projeto(fornecedor_projeto fornecedor_projeto) {
		
		String sql = "INSERT INTO FORNECEDOR_PROJETO (NUMFORNECEDOR, NUMPROJETO, NOMEMATERIAL, QTDMATERIAL) VALUES (?, ?, ?, ?)";
		
		PreparedStatement ps = null;
		
		try {
			ps = Conexao.getConexao().prepareStatement(sql);
			ps.setInt(1, fornecedor_projeto.getNumFornecedor());
			ps.setInt(2, fornecedor_projeto.getNumProjeto());
			ps.setString(3, fornecedor_projeto.getNomeMaterial());
			ps.setInt(4, fornecedor_projeto.getQtdMaterial());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
