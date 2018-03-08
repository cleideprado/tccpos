package tcc.pos.cleide.entities;


/**Classe para objetos do tipo Cliente, onde serão contidos, valores e métodos para o mesmo.
* @author Cleide Prado
*/
public class Cliente {

	private String cpf = null;
	private String nome =  null;
	private String endereco = null;
	private String estado = null;
	private String municipio = null;
	private String telefone = null;
	private String email = null;
	private String senha = null;
	
	/**
	 * Retorna o valor do cpf do cliente
	 * @return String - CPF do Cliente
	 * */
	public String getCpf() {
		return cpf;
	}
	/**
	 * Retorna o Email do cliente
	 * @return String - Email do Cliente
	 * */
	public String getEmail() {
		return email;
	}
	/**
	 * Retorna o Endereço do cliente
	 * @return String - Endereço do Cliente
	 * */
	public String getEndereco() {
		return endereco;
	}
	/**
	 * Retorna o município do cliente
	 * @return String  - Município do Cliente
	 * */
	public String getMunicipio() {
		return municipio;
	}
	/**
	 * Retorna o estado do cliente
	 * @return String - Estado do Cliente
	 * */
	public String getEstado() {
		return estado;
	}
	/**
	 * Retorna o nome do cliente
	 * @return String - Nome do Cliente
	 * */
	public String getNome() {
		return nome;
	}
	/**
	 * Retorna a senha do cliente
	 * @return String - Senha do Cliente
	 * */
	public String getSenha() {
		return senha;
	}
	/**
	 * Retorna o telefone do cliente
	 * @return String - Telefone do Cliente
	 * */
	public String getTelefone() {
		return telefone;
	}
	/**
	 * Insere o cpf do cliente
	 * @param cpf String 
	 * */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	/**
	 * Insere o Email do cliente
	 * @param email String
	 * */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Insere o Endereço do cliente
	 * @param endereco String
	 * */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	/**
	 * Insere o Estado do cliente
	 * @param estado String
	 * */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * Insere o Telefone do cliente
	 * @param telefone String
	 * */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	/**
	 * Insere o Município do cliente
	 * @param municipio String
	 * */
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	/**
	 * Insere a Senha do cliente
	 * @param senha String
	 * */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	/**
	 * Insere o Nome do cliente
	 * @param nome String
	 * */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
