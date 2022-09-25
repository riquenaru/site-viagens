package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
//import java.text.DateFormat;

import connection.ConnectionMySQL;

import model.Destino;

public class DestinoDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo para salvar
	public void save(Destino destino) {
		String sql = "INSERT INTO destino (destino) values(?);";

		try {
			// Criar conexão com o banco
			conn = ConnectionMySQL.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro paramentro
			pstm.setString(1, destino.getDestino());
			pstm.setDate(2, (Date) destino.getData_viagem());

			// Executa a sql para inserção dos dados
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
	public List<Destino> getDestino() {
		String sql = "select * from destino;";

		List<Destino> lista = new ArrayList<Destino>();
		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Destino destino = new Destino();

				destino.setDestino(rset.getString("destino"));
				destino.setIdDestino(rset.getInt("id_destino"));
				destino.setData_viagem(rset.getDate("data_viagem"));
				lista.add(destino);
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

	// Metodo para Atualizar
	public void update(Destino destino) {
		String sql = "UPDATE destino set destino = ?, id_destino = ?, data_viagem = ? where id_destino = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, destino.getDestino());
			pstm.setDate(2, (Date) destino.getData_viagem());
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

	public void deleteById(int id) {
		String sql = "DELETE FROM destino WHERE id_destino = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

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

	public Destino getDestinoById(int id) {
		String sql = "SELECT * FROM destino WHERE id_destino = ?;";

		Destino destino = new Destino();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);

			rset = pstm.executeQuery();
			rset.next();

			destino.setDestino(rset.getString("destino"));
			destino.setIdDestino(rset.getInt("id_destino"));
			destino.setData_viagem(rset.getDate("data_viagem"));

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

		return destino;

	}

}
