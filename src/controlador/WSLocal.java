package controlador;

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

import modelo.bitacora;
import modelo.local;

@Path("/local")
public class WSLocal {

	@GET
	@Path("/listado/{usr}/{pass}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<local> getListado(@PathParam("usr") String usr, @PathParam("pass") String pass,
			@PathParam("token") String token) {

		bitacora objB = new bitacora();
		objB.setUsuario(usr);
		objB.setPassword(pass);
		objB.setToken(token);

		if (objB.validaToken()) {
			local objL = new local();
			return objL.getListaL();
		}

		return null;
	}

	@GET
	@Path("/ver/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public local getLocal(@PathParam("id") int id) {
		local objL = new local();
		objL.setId(id);
		return objL.getLocal();
	}

	@POST
	@Path("/insertar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public local insLocal(local objL) {
		objL.insLocal();
		return objL;
	}

	@PUT
	@Path("/actualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public local actLocal(local objL) {
		objL.actLocal();
		return objL;
	}

	@DELETE
	@Path("/borrar/{id}")
	public void delLocal(@PathParam("id") int id) {
		local objL = new local();
		objL.setId(id);
		objL.delLocal();
	}

}
