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
	// @Consumes(MediaType.APPLICATION_JSON)
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
	@Path("/ver/{idLoc}/{usr}/{pass}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public local getLocal(@PathParam("idLoc") int idloc, @PathParam("usr") String usr, @PathParam("pass") String pass,
			@PathParam("token") String token) {

		bitacora objB = new bitacora();
		objB.setUsuario(usr);
		objB.setPassword(pass);
		objB.setToken(token);

		if (objB.validaToken()) {
			local objL = new local();
			objL.setId(idloc);
			return objL.getLocal();
		}
		return null;
	}

	@POST
	@Path("/insertar/{usr}/{pass}/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public local insLocal(local objL, @PathParam("usr") String usr, @PathParam("pass") String pass,
			@PathParam("token") String token) {

		bitacora objB = new bitacora();
		objB.setUsuario(usr);
		objB.setPassword(pass);
		objB.setToken(token);

		if (objB.validaToken()) {
			objL.insLocal();
			return objL;
		}
		return null;
	}

	@PUT
	@Path("/actualizar/{usr}/{pass}/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public local actLocal(local objL, @PathParam("usr") String usr, @PathParam("pass") String pass,
			@PathParam("token") String token) {

		bitacora objB = new bitacora();
		objB.setUsuario(usr);
		objB.setPassword(pass);
		objB.setToken(token);

		if (objB.validaToken()) {
			objL.actLocal();
			return objL;
		}
		return null;
	}

	@DELETE
	@Path("/borrar/{idLoc}/{usr}/{pass}/{token}")
	public void delLocal(@PathParam("idLoc") int idloc, @PathParam("usr") String usr, @PathParam("pass") String pass,
			@PathParam("token") String token) {

		bitacora objB = new bitacora();
		objB.setUsuario(usr);
		objB.setPassword(pass);
		objB.setToken(token);

		if (objB.validaToken()) {
			local objL = new local();
			objL.setId(idloc);
			objL.delLocal();
		}
	}

}
