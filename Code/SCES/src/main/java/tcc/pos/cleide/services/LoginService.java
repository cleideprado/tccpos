package tcc.pos.cleide.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import tcc.pos.cleide.dao.ClienteDAO;

@Path("login")
public class LoginService {

	@GET
	@Path("")
	public Response autenticacao(@QueryParam("email") String email, @QueryParam("senha") String senha) {
		if (ClienteDAO.autenticacao(email, senha)) {
			return Response.status(200).build();
		}
		return Response.status(401).entity("You are not authorized!").build();
	}
	
}
