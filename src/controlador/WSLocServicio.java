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
import modelo.local_servicio;

@Path("/local_servicio")
public class WSLocServicio {

	@GET
	@Path("/listado/{usr}/{pass}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<local_servicio> getListadoL(@PathParam("usr") String usrB, @PathParam("pass") String passB,
			@PathParam("token") String tokenB) {

		bitacora objB = new bitacora();
		objB.setUsuario(usrB);
		objB.setPassword(passB);
		objB.setToken(tokenB);

		if (objB.validaToken()) {
			local_servicio objL = new local_servicio();
			return objL.getListadoL();
		}
		return null;
	}

	@GET
	@Path("/ver/{idLoc}/{idSer}/{usr}/{pass}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public local_servicio verLocServicio(@PathParam("idLoc") int idloc, @PathParam("idSer") int idser,
			@PathParam("usr") String usrB, @PathParam("pass") String passB, @PathParam("token") String tokenB) {

		bitacora objB = new bitacora();
		objB.setUsuario(usrB);
		objB.setPassword(passB);
		objB.setToken(tokenB);

		if (objB.validaToken()) {
			local_servicio objL = new local_servicio();
			objL.setId_local(idloc);
			objL.setId_servicio(idser);
			return objL.verLocServicio();
		}
		return null;
	}

	@POST
	@Path("/insertar/{usr}/{pass}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public local_servicio insLocServicio(local_servicio objL, @PathParam("usr") String usrB,
			@PathParam("pass") String passB, @PathParam("token") String tokenB) {

		bitacora objB = new bitacora();
		objB.setUsuario(usrB);
		objB.setPassword(passB);
		objB.setToken(tokenB);

		if (objB.validaToken()) {
			objL.insLocServicio();
			return objL;
		}
		return null;
	}

	@PUT
	@Path("/actualizar/{idLoc}/{idSer}/{usr}/{pass}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public local_servicio actLocServicio(local_servicio objL, @PathParam("idLoc") int idloc,
			@PathParam("idSer") int idser, @PathParam("usr") String usrB, @PathParam("pass") String passB,
			@PathParam("token") String tokenB) {

		bitacora objB = new bitacora();
		objB.setUsuario(usrB);
		objB.setPassword(passB);
		objB.setToken(tokenB);

		if (objB.validaToken()) {
			local_servicio tempL = new local_servicio();
			tempL.setId_local(idloc);
			tempL.setId_servicio(idser);

			objL.actLocServicio(tempL);
			return objL;
		}
		return null;
	}

	@DELETE
	@Path("/borrar/{usr}/{pass}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delLocServicio(local_servicio objL, @PathParam("usr") String usrB, @PathParam("pass") String passB,
			@PathParam("token") String tokenB) {

		bitacora objB = new bitacora();
		objB.setUsuario(usrB);
		objB.setPassword(passB);
		objB.setToken(tokenB);

		if (objB.validaToken()) {
			objL.delLocServicio();
		}
	}
}
