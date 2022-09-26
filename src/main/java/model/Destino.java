package model;

import java.util.Date;

public class Destino {
	
	// Atributos
	private int idDestino;
	private String destino;
	private Date data_viagem;
	
	// Construtores
		public Destino() {

		}

		public Destino(int idDestino, String destino, Date data_viagem) {
			this.idDestino = idDestino;
			this.destino = destino;
			this.data_viagem = data_viagem;
		}

	
	//Getters and Setters
	public int getIdDestino() {
		return idDestino;
	}
	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Date getData_viagem() {
		return data_viagem;
	}
	public void setData_viagem(Date data_viagem) {
		this.data_viagem = data_viagem;
	}
	
	
}
