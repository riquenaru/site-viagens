package dao;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Usuario;

public class UsuarioDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar
	public void save(Usuario usuario) {
		String sql = "INSERT INTO usuario (senha, nome, cpf_cnpj) values(?,?,?)";

		try {
			// Cria uma conexao com o banco
			conn = ConnectionMySQL.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parametro da sql
			pstm.setString(1, usuario.getSenha());
			pstm.setString(2, usuario.getEmail());
			pstm.setString(3, usuario.getCpf_cnpj());
			pstm.setInt(4, usuario.getIdUsuario());

			// Executar a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// Metodo para Ler
	public List<Usuario> getUsuario() {
		String sql = "select * from usuario;";

		List<Usuario> lista = new ArrayList<Usuario>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Usuario usuario = new Usuario();

				usuario.setSenha(rset.getString("senha"));
				usuario.setEmail(rset.getString("email"));
				usuario.setCpf_cnpj(rset.getString("Cpf_cnpj"));
				lista.add(usuario);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return lista;
	}
	// Metodo pra Atualizar

	public void update(Usuario usuario) {
		String sql = "UPDATE usuario set senha = ?, email = ?, cpf_cnpj = ?, id_login = ? where id_usuario = ?;";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, usuario.getSenha());
			pstm.setString(2, usuario.getEmail());
			pstm.setString(3, usuario.getCpf_cnpj());
			pstm.setInt(4, usuario.getLogin().getId());
			pstm.setInt(5, usuario.getIdUsuario());
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Metodo para deletar
	public void deleteByCpf(String id) {
		String sql = "DELETE FROM usuario WHERE cpf_cnpj = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Usuario getUsuarioByCpf(String id) {
		String sql = "SELECT * FROM usuario WHERE cpf_cnpj = ?;";

		Usuario usuario = new Usuario();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);

			rset = pstm.executeQuery();
			rset.next();

			usuario.setCpf_cnpj(rset.getString("cpf_cnpj"));
			usuario.setSenha(rset.getString("senha"));
			usuario.setEmail(rset.getString("email"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return usuario;
	}

}
