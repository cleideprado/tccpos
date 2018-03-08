package tcc.pos.cleide.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tcc.pos.cleide.dao.ClienteDAO;
import tcc.pos.cleide.entities.Cliente;

/**
 * Classe de serviços para Cliente. Contem Metodos POST, GET, PUT, DELETE e OPTIONS
 * @author Cleide Prado
 */
@Path("clientes")
public class ClienteService {

    /**
     * Metodo GET que retorna todos os Cliente do banco de dados
     *
     * @return Lista de Cliente no formato JSON.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<Cliente> listar() {
        return ClienteDAO.listar();
    }
    /**
     * Metodo GET que retorna o Cliente que possue o CPF informado no parametro
     *@param cpf String
     * @return Cliente no formato JSON.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{cpf}")
    public Cliente listarPorCPF(@PathParam("cpf") String cpf) {
        return ClienteDAO.getByCPF(cpf);
    }
    /**
     * Metodo POST que cria um Cliente no banco de dados
     *@param cliente Objeto cliente no formato JSON
     * @return HTTP Status Code 201 caso operação seja concluida com sucesso .
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response criarCliente(Cliente cliente) {
    	ClienteDAO.inserir(cliente);
    	return Response.status(201).header("Access-Control-Allow-Origin", "*").header("Access-Control-Request-Methods", "POST").allow("OPTIONS").build();
    }
    /**
     * Metodo OPTIONS com os Headers apropriados para liberar acesso atraves de domínios (CORS)
     *
     * @return HTTP Status Code 200 caso operação seja concluida com sucesso.
     */
    @OPTIONS
    @Path("/")
    public Response allowCORS() {
    	return Response.status(200).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Headers", "Access-Control-Allow-Origin,Content-Type").allow("HEAD,POST,GET,OPTIONS,PUT").build();
    }
    
    /**
     * Metodo OPTIONS com os Headers apropriados para liberar acesso atraves de domínios (CORS)
     * quando um CPF é informado
     * @return HTTP Status Code 200 caso operação seja concluida com sucesso.
     */
    @OPTIONS
    @Path("/{cpf}")
    public Response allowCORSDelete() {
    	return Response.status(200).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "DELETE,PUT").header("Access-Control-Allow-Headers", "Access-Control-Allow-Origin,Content-Type,Access-Control-Allow-Methods").allow("HEAD,POST,GET,OPTIONS,PUT").build();
    }
    /**
     * Metodo PUT para atualizar as informações de um Cliente. Recebe um Cliente no formato JSON
     * @param cpf String
     * @param cliente String
     * @return HTTP Status Code 200 caso operação seja concluida com sucesso.
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{cpf}")
    public Response atualizarCliente(@PathParam("cpf") String cpf, Cliente cliente) {
    	if (ClienteDAO.hasCPF(cpf)) {
    		ClienteDAO.atualizar(cliente);
    		return Response.status(200).header("Access-Control-Allow-Origin", "*").build();
    	}
    	return Response.status(404).entity("CPF not found!!!").header("Access-Control-Allow-Origin", "*").build();
    }
    /**
     * Metodo DELETE para excluir um Cliente do Banco de Dados
     *@param cpf String
     * @return HTTP Status Code 200 caso operação seja concluida com sucesso.
     */
    @DELETE
    @Path("/{cpf}")
    public Response excluirCliente(@PathParam("cpf") String cpf) {
    	if (ClienteDAO.hasCPF(cpf)) {
    		ClienteDAO.excluir(ClienteDAO.getByCPF(cpf));
    		return Response.status(200).header("Access-Control-Allow-Origin", "*").header("Access-Control-Request-Methods", "DELETE").allow("OPTIONS").build();
    	}
    	return Response.status(404).entity("CPF not found!!!").header("Access-Control-Allow-Origin", "*").header("Access-Control-Request-Methods", "DELETE").allow("OPTIONS").build();
    }
}
