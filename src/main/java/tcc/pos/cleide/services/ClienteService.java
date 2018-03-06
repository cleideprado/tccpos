package tcc.pos.cleide.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
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
 * Root resource (exposed at "myresource" path)
 */
@Path("clientes")
public class ClienteService {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public List<Cliente> listar() {
        return ClienteDAO.listar();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{cpf}")
    public Cliente listarPorCPF(@PathParam("cpf") String cpf) {
        return ClienteDAO.getByCPF(cpf);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response criarCliente(Cliente cliente) {
    	ClienteDAO.inserir(cliente);
    	return Response.status(201).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{cpf}")
    public Response atualizarCliente(@PathParam("cpf") String cpf, Cliente cliente) {
    	if (ClienteDAO.hasCPF(cpf)) {
    		ClienteDAO.atualizar(cliente);
    		return Response.status(200).build();
    	}
    	return Response.status(404).entity("CPF not found!!!").build();
    }
    
    @DELETE
    @Path("/{cpf}")
    public Response excluirCliente(@PathParam("cpf") String cpf) {
    	if (ClienteDAO.hasCPF(cpf)) {
    		ClienteDAO.excluir(ClienteDAO.getByCPF(cpf));
    		return Response.status(200).build();
    	}
    	return Response.status(404).entity("CPF not found!!!").build();
    }
}