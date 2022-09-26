package model;

import java.sql.Date;

import model.Carrinho;


public class Carrinho {
	
	// Atributos
	
		private int idCarrinho;
		private int qtd_item;
		private Date data_compra;
		private double valor_total;
		private String passagem;
		
		private Passagem passagens;
		private Usuario usuario;
		
		// Construtores
		public Carrinho() {

		}


		public Carrinho(int idCarrinho, int qtd_item, Date data_compra, double valor_total, String passagem,
				Passagem passagens, Usuario usuario) {
			super();
			this.idCarrinho = idCarrinho;
			this.qtd_item = qtd_item;
			this.data_compra = data_compra;
			this.valor_total = valor_total;
			this.passagem = passagem;
			this.passagens = passagens;
			this.usuario = usuario;
		}

		// Getters and setters
		public int getIdCarrinho() {
			return idCarrinho;
		}


		public void setIdCarrinho(int idCarrinho) {
			this.idCarrinho = idCarrinho;
		}


		public int getQtd_item() {
			return qtd_item;
		}


		public void setQtd_item(int qtd_item) {
			this.qtd_item = qtd_item;
		}


		public Date getData_compra() {
			return data_compra;
		}


		public void setData_compra(Date date) {
			this.data_compra = date;
		}


		public double getValor_total() {
			return valor_total;
		}


		public void setValor_total(double valor_total) {
			this.valor_total = valor_total;
		}


		public String getPassagem() {
			return passagem;
		}


		public void setPassagem(String passagem) {
			this.passagem = passagem;
		}


		public Passagem getPassagens() {
			return passagens;
		}


		public void setPassagens(Passagem passagens) {
			this.passagens = passagens;
		}


		public Usuario getUsuario() {
			return usuario;
		}


		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		
		

}
