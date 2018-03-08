package tcc.pos.cleide.services;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tcc.pos.cleide.dao.ClienteDAO;
import tcc.pos.cleide.entities.Cliente;

/**
 * Classe de serviços para autenticação. Contem Metodo GET que verifica a existencia de um Cliente no DB.
 * @author Cleide Prado
 */
@Path("login")
public class LoginService {
	
	/**
	 * Verifica se um Cliente existe baseado no email e senha enviados por parametro.
	 * Retorna todas as informações do cliente em caso positivo e caso contrario retorna HTTP 401 code.
	 * @param email String
	 * @param senha String
	 * @return HTTP status code
	 */
	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public Response autenticacao(@QueryParam("email") String email, @QueryParam("senha") String senha) {
		Cliente c = ClienteDAO.autenticacao(email, senha);
		if (c != null) {
			return Response.status(200).entity(c).header("Access-Control-Allow-Origin", "*").build();  	
		}
		return Response.status(401).entity("").header("Access-Control-Allow-Origin", "*").build();
	}
	
}
