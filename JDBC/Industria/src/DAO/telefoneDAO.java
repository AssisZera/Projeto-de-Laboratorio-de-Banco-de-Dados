package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entity.telefone;

public class telefoneDAO {

	public void cadastrarTelefone(telefone telefone) {
        String sql = "INSERT INTO TELEFONE (NUMTELEFONE, CODDDD, NUMFORNECEDOR, NUMFUNC) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, telefone.getNumTelefone());
            ps.setInt(2, telefone.getCodDDD());

            if (telefone.getNumFornecedor() != null) {
                ps.setInt(3, telefone.getNumFornecedor());
            } else {
                ps.setNull(3, java.sql.Types.INTEGER);
            }

            if (telefone.getNumFunc() != null) {
                ps.setInt(4, telefone.getNumFunc());
            } else {
                ps.setNull(4, java.sql.Types.INTEGER);
            }

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
}
