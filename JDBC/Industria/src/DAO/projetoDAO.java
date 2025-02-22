package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entity.projeto;

public class projetoDAO {

public void cadastrarProjeto(projeto projeto) {
		
		String sql = "INSERT INTO PROJETO (ORCAPROJETO) VALUES (?)";
		
		PreparedStatement ps = null;
		
		try {
			ps = Conexao.getConexao().prepareStatement(sql);
			ps.setDouble(1, projeto.getOrcaProjeto());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
