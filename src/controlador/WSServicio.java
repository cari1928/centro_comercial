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
	@Path("/ver/{idSer}")
	@Produces(MediaType.APPLICATION_JSON)
	public servicio verServicio(@PathParam("idSer") int idser) {
		servicio objS = new servicio();
		objS.setId(idser);
		return objS.verServicio();
	}
	
	@POST
	@Path("/insertar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public servicio insServicio(servicio objS) {
		objS.insServicio();
		return objS;
	}
	
	@PUT
	@Path("/actualizar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public servicio actServicio(servicio objS) {
		objS.actServicio();
		return objS;
	}
	
	@DELETE
	@Path("/borrar/{idServ}")
	public void delServicio(@PathParam("idServ") int idserv) {
		servicio objS = new servicio();
		objS.setId(idserv);
		objS.delServicio();
	}
}
