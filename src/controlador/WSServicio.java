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
import modelo.servicio;

@Path("/servicio")
public class WSServicio {

	@GET
	@Path("/listado/{usr}/{pass}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<servicio> getListado(@PathParam("usr") String usr, @PathParam("pass") String pass,
			@PathParam("token") String token) {

		bitacora objB = new bitacora();
		objB.setUsuario(usr);
		objB.setPassword(pass);
		objB.setToken(token);

		if (objB.validaToken()) {
			servicio objS = new servicio();
			return objS.getListaS();
		}
		return null;
	}

	@GET
	@Path("/ver/{idSer}/{usr}/{pass}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public servicio verServicio(@PathParam("idSer") int idser, @PathParam("usr") String usr,
			@PathParam("pass") String pass, @PathParam("token") String token) {

		bitacora objB = new bitacora();
		objB.setUsuario(usr);
		objB.setPassword(pass);
		objB.setToken(token);

		if (objB.validaToken()) {
			servicio objS = new servicio();
			objS.setId(idser);
			return objS.verServicio();
		}
		return null;
	}

	@POST
	@Path("/insertar/{usr}/{pass}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public servicio insServicio(servicio objS, @PathParam("usr") String usr, @PathParam("pass") String pass,
			@PathParam("token") String token) {

		bitacora objB = new bitacora();
		objB.setUsuario(usr);
		objB.setPassword(pass);
		objB.setToken(token);

		if (objB.validaToken()) {
			objS.insServicio();
			return objS;
		}
		return null;
	}

	@PUT
	@Path("/actualizar/{usr}/{pass}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public servicio actServicio(servicio objS, @PathParam("usr") String usr, @PathParam("pass") String pass,
			@PathParam("token") String token) {

		bitacora objB = new bitacora();
		objB.setUsuario(usr);
		objB.setPassword(pass);
		objB.setToken(token);

		if (objB.validaToken()) {
			objS.actServicio();
			return objS;
		}
		return null;
	}

	@DELETE
	@Path("/borrar/{idServ}/{usr}/{pass}/{token}")
	public void delServicio(@PathParam("idServ") int idserv, @PathParam("usr") String usr,
			@PathParam("pass") String pass, @PathParam("token") String token) {

		bitacora objB = new bitacora();
		objB.setUsuario(usr);
		objB.setPassword(pass);
		objB.setToken(token);

		if (objB.validaToken()) {
			servicio objS = new servicio();
			objS.setId(idserv);
			objS.delServicio();
		}
	}
}
