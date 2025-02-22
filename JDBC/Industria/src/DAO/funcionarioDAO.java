package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entity.funcionario;

public class funcionarioDAO {

public void cadastrarFuncionario(funcionario funcionario) {
		
		String sql = "INSERT INTO FUNCIONARIO (NOMEFUNC, SALARIFUNC, NUMDEPART, DATAINICIOFUNC) VALUES (?, ?, ?, ?)";
		
		PreparedStatement ps = null;
		
		try {
			ps = Conexao.getConexao().prepareStatement(sql);
			ps.setString(1, funcionario.getNomeFunc());
			ps.setDouble(2, funcionario.getSalariFunc());
			ps.setInt(3, funcionario.getNumDepart());
			ps.setString(4, funcionario.getDataInicioFunc());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
