package model;



public class Usuario {
	

	// Atributos
	private int idUsuario;
	private String email;
	private String senha;
	private String cpf_cnpj;

	private Login login;

	// Construtores
	public Usuario() {

	}

	public Usuario(int idUsuario, String email, String senha, String cpf_cnpj, Login login) {
		this.idUsuario = idUsuario;
		this.email = email;
		this.senha = senha;
		this.cpf_cnpj = cpf_cnpj;
		this.login = login;
	}

	// Getters and setters
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	

}
