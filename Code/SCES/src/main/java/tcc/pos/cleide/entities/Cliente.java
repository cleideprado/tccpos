package tcc.pos.cleide.entities;

public class Cliente {

	private String cpf = null;
	private String nome =  null;
	private String endereco = null;
	private String estado = null;
	private String municipio = null;
	private String telefone = null;
	private String email = null;
	private String senha = null;
	
	public String getCpf() {
		return cpf;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public String getMunicipio() {
		return municipio;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
