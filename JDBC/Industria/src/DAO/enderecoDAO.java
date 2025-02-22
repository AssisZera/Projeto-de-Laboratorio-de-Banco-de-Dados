package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entity.endereco;

public class enderecoDAO {

public void cadastrarEndereco(endereco endereco) {
		
		String sql = "INSERT INTO ENDERECO (LOGRAENDERECO, NUMENDERECO, CIDADEENDERECO, ESTADOENDERECO, NUMFORNECEDOR, NUMDEPOSITO) VALUES (?, ?, ?, ?, ?, ?)";
		
		try (Connection conn = Conexao.getConexao();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setString(1, endereco.getLograEndereco());
			ps.setInt(2, endereco.getNumEndereco());
			ps.setString(3, endereco.getCidadeEndereco());
			ps.setString(4, endereco.getEstadoEndereco());
			
			if (endereco.getNumFornecedor() != null) {
                ps.setInt(5, endereco.getNumFornecedor());
            } else {
                ps.setNull(5, java.sql.Types.INTEGER);
            }

            if (endereco.getNumDeposito() != null) {
                ps.setInt(6, endereco.getNumDeposito());
            } else {
                ps.setNull(6, java.sql.Types.INTEGER);
            }

            ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
