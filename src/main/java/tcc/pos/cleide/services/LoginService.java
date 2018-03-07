package tcc.pos.cleide.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import tcc.pos.cleide.dao.ClienteDAO;
import tcc.pos.cleide.entities.Cliente;

@Path("login")
public class LoginService {

	@GET
	@Path("")
	public Response autenticacao(@QueryParam("email") String email, @QueryParam("senha") String senha) {
		Cliente c = ClienteDAO.autenticacao(email, senha);
		if (c != null) {
			return Response.status(200).entity(c).header("Access-Control-Allow-Origin", "*").build();  	
		}
		return Response.status(401).entity("").header("Access-Control-Allow-Origin", "*").build();
	}
	
}
