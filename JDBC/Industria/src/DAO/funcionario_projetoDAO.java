package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entity.funcionario_projeto;

public class funcionario_projetoDAO {

public void cadastrarFuncionario_projeto(funcionario_projeto funcionario_projeto) {
		
		String sql = "INSERT INTO FUNCIONARIO_PROJETO (NUMFUNC, NUMPROJETO, DATAINICIOPROJETO, HORASTRABALHADAS) VALUES (?, ?, ?, ?)";
		
		PreparedStatement ps = null;
		
		try {
			
			ps = Conexao.getConexao().prepareStatement(sql);
			ps.setInt(1, funcionario_projeto.getNumFunc());
			ps.setInt(2, funcionario_projeto.getNumProjeto());
			ps.setString(3, funcionario_projeto.getDataInicioProjeto());
			ps.setDouble(4, funcionario_projeto.getHorasTrabalhadas());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
