package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entity.departamento;

public class departamentoDAO {

public void cadastrarDepartamento(departamento departamento) {
		
		String sql = "INSERT INTO DEPARTAMENTO (SETORDEPART) VALUES (?)";
		
		PreparedStatement ps = null;
		
		try {
			ps = Conexao.getConexao().prepareStatement(sql);
			ps.setString(1, departamento.getSetorDepart());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
