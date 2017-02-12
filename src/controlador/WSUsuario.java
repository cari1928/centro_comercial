package controlador;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.usuario;

@Path("/usuario")
public class WSUsuario {
	
	//lo más correcto sería crear un procedimiento almacenado
	@GET
	@Path("/validar/{usuario}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public usuario validar(@PathParam("usuario") String usuario, @PathParam("password") String password) {
		usuario objU = new usuario();
		objU.setUsuario(usuario);
		objU.setPassword(password);
		objU.validaUsuario();
		return objU;
	}
}
