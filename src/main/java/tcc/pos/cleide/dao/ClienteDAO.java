package tcc.pos.cleide.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tcc.pos.cleide.entities.Cliente;

/**Classe de acesso ao Banco de dados para o Objeto CLiente. Contem métodos para manipular CRUD de Cliente no DB.
* @author Cleide Prado
*/
public class ClienteDAO {

	/**
	 * Insere um objeto Cliente no Banco de dados
	 * @param cliente Objeto Cliente
	 * */
	public static void inserir(Cliente cliente) {
		 Connection conn = ConnectionDb.getConnection();

	        PreparedStatement stmt = null;
	        try {    
	            stmt = conn.prepareStatement("INSERT INTO clientes (cpf, nome, endereco, estado, municipio, telefone, email, senha) values (?,?,?,?,?,?,?,?)");
	            stmt.setString(1, cliente.getCpf());
	            stmt.setString(2, cliente.getNome());
	            stmt.setString(3, cliente.getEndereco());
	            stmt.setString(4, cliente.getEstado());
	            stmt.setString(5, cliente.getMunicipio());
	            stmt.setString(6, cliente.getTelefone());
	            stmt.setString(7, cliente.getEmail());
	            stmt.setString(8, cliente.getSenha());
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }finally{
	            ConnectionDb.closeConnection(conn,stmt);
	        }
		
	}
	/**
	 * Remove um objeto Cliente no Banco de dados
	 * @param cliente Objeto Cliente
	 * */
	public static void excluir (Cliente cliente) {
		Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("DELETE FROM clientes WHERE cpf=?");
            stmt.setString(1, cliente.getCpf());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
	}
	/**
	 * Atualiza atributos um objeto Cliente no Banco de dados
	 * @param cliente Objeto Cliente
	 * */
	public static void atualizar(Cliente cliente){
        Connection conn = ConnectionDb.getConnection();

        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("UPDATE clientes SET nome=?, endereco=?, estado=?, municipio=?, telefone=?, email=?, senha=? WHERE cpf=?");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getEstado());
            stmt.setString(4, cliente.getMunicipio());
            stmt.setString(5, cliente.getTelefone());
            stmt.setString(6, cliente.getEmail());
            stmt.setString(7, cliente.getSenha());
            stmt.setString(8, cliente.getCpf());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
    }
	/**
	 * Recupera um objeto Cliente no Banco de dados atraves do atributo cpf
	 * @param cpf String
	 * @return Cliente 
	 * */
	public static Cliente getByCPF(String cpf){
        Connection conn = ConnectionDb.getConnection();
        ResultSet rs =null;
        Cliente cliente = null;
        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("SELECT * FROM clientes WHERE cpf=?");
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();
            if (rs.next()){
                cliente = new Cliente();
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setMunicipio(rs.getString("municipio"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
        return cliente;
    }	
	/**
	 * Verifica se existe algum Cliente com o atributo cpf informado.
	 * @param cpf String
	 * @return boolean 
	 * */
	public static boolean hasCPF(String cpf){
        Connection conn = ConnectionDb.getConnection();
        ResultSet rs =null;    
        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("SELECT * FROM clientes WHERE cpf=?");
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();
            if (rs.next()){
            	ConnectionDb.closeConnection(conn,stmt,rs);
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt);
        }
        return false;
    }
	/**
	 * Recupera uma Lista de objetos Cliente no Banco de dados
	 * @return List 
	 * */
	public static List<Cliente> listar(){
        Connection conn = ConnectionDb.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cliente> teamList = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM clientes");
            rs = stmt.executeQuery();
            
            while(rs.next()){
            	Cliente cliente = new Cliente();
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setMunicipio(rs.getString("municipio"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));
                
                teamList.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn, stmt,rs);
        }
        
        return teamList;
    }
	
	/**
	 * Recupera um objeto Cliente no Banco de dados caso usuario e senha sejam válidos
	 * @param email String
	 * @param senha String
	 * @return Cliente 
	 * */
    public static Cliente autenticacao(String email, String senha){
        Connection conn = ConnectionDb.getConnection();
        ResultSet rs =null;
        Cliente cliente = null;
        PreparedStatement stmt = null;
        try {         
            stmt = conn.prepareStatement("SELECT * FROM clientes WHERE email=? and senha=?");
            stmt.setString(1, email);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            if (rs.next()){
            	cliente = new Cliente();
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setMunicipio(rs.getString("municipio"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));
             }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            ConnectionDb.closeConnection(conn,stmt,rs);
        }
        return cliente;
    }
	
}
