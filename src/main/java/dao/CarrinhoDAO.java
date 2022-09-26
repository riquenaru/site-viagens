package dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Passagem;
import model.Usuario;
import model.Carrinho;

public class CarrinhoDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar
	
	public void save(Carrinho carrinho) {
		String sql = "INSERT INTO carrinho (qtd_itens, total_compra,"
				+ " data_compra, passagem, id_passagem, cpf_cnpj) values(?,?,?,?,?,?)";
		
		
		try {
			// Cria uma conexao com o banco
			
			conn = ConnectionMySQL.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parametro da sql
			
			pstm.setInt(1, carrinho.getQtd_item());
			pstm.setDouble(2, carrinho.getValor_total());
			SimpleDateFormat formatter = new SimpleDateFormat("d/MM/yyyy");
            pstm.setDate(3, new Date (formatter.parse(carrinho.getData_compra()).getTime()));
            pstm.setString(4, carrinho.getPassagem());
            
            pstm.setInt(5,carrinho.getPassagens().getIdPassagem());
            pstm.setString(6,carrinho.getUsuario().getCpf_cnpj());
            
            
          
            
			// Executar a sql para inserçãoo dos dados
            
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
	
	public List<Carrinho> getcarrinho() {
		String sql = "select * from carrinho;";

		List<Carrinho> carrinho = new ArrayList<Carrinho>();

		// Classe que vai recuperar os dados do banco de dados
		
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Carrinho carrinho1 = new Carrinho();
				Passagem passagem = new Passagem();
				Usuario usuario = new Usuario();
				
				carrinho1.setIdCarrinho(rset.getInt("id_carrinho"));

				carrinho1.setQtd_item(rset.getInt("qtd_itens"));

				carrinho1.setPassagem(rset.getString("passagem"));

				SimpleDateFormat dateFormat = new SimpleDateFormat("d/MM/yyyy");
                carrinho1.setData_compra(dateFormat.format(rset.getDate("data_compra")));
                //setData_compras(dateFormat.format(rset.getDate("data_compras")));
				passagem.setIdPassagem(rset.getInt("id_passagem"));
				usuario.setCpf_cnpj(rset.getString("cpf_cnpj"));
				
				
				carrinho.add(carrinho1);

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

		return carrinho;
	}
	// Metodo pra atualizar

	public void update(Carrinho carrinho) {
		String sql = "INSERT INTO carrinho (qtd_itens, total_compra,"
				+ " data_compra, passagem, id_passagem, cpf_cnpj, id_carrinho) values(?,?,?,?,?,??)";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, carrinho.getQtd_item());

			pstm.setDouble(2, carrinho.getValor_total());

			SimpleDateFormat formatter = new SimpleDateFormat("d/MM/yyyy");
            pstm.setDate(3, new Date(formatter.parse(carrinho.getData_compra()).getTime()));
            
            pstm.setInt(4, carrinho.getPassagens().getIdPassagem());

			pstm.setString(5, carrinho.getUsuario().getCpf_cnpj());
			
			pstm.setInt(6, carrinho.getIdCarrinho());

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
		String sql = "DELETE FROM compras WHERE id_compras = ?";

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

	public Carrinho getCarrinhoById(int id) {
		String sql = "SELECT * FROM carrinho WHERE id_compras = ?;";

		Carrinho carrinho = new Carrinho();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			carrinho.setIdCarrinho(rset.getInt("id_carrinho"));

			carrinho.setQtd_item(rset.getInt("qtd_itens"));
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("d/MM/yyyy");
            carrinho.setData_compra(dateFormat.format(rset.getDate("data_compra")));

			carrinho.setValor_total(rset.getDouble("valor_total"));

			
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

		return carrinho;
	}

	

}