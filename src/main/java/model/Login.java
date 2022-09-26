package model;


public class Login {
	
	// Atributos
	private int id;
	private String tipo;
	
	// Contrutores
	public Login() {
	
	}
	public Login(int id, String tipo) {

		this.id = id;
		this.tipo = tipo;
	}
	
	// Getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
