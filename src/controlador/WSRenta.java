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
import modelo.renta;

@Path("/renta")
public class WSRenta {

	@GET
	@Path("/listado/{usr}/{pass}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<renta> getListadoR(@PathParam("usr") String usrB, @PathParam("pass") String passB,
			@PathParam("token") String tokenB) {

		bitacora objB = new bitacora();
		objB.setUsuario(usrB);
		objB.setPassword(passB);
		objB.setToken(tokenB);

		if (objB.validaToken()) {
			renta objR = new renta();
			return objR.getListadoR();
		}
		return null;
	}

	@GET
	@Path("/ver/{idLoc}/{idTie}/{usr}/{pass}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public renta verRenta(@PathParam("idLoc") int idloc, @PathParam("idTie") int idtie, @PathParam("usr") String usrB,
			@PathParam("pass") String passB, @PathParam("token") String tokenB) {

		bitacora objB = new bitacora();
		objB.setUsuario(usrB);
		objB.setPassword(passB);
		objB.setToken(tokenB);

		if (objB.validaToken()) {
			renta objA = new renta();
			objA.setId_local(idloc);
			objA.setId_tienda(idtie);
			return objA.verRenta();
		}
		return null;
	}

	@POST
	@Path("/insertar/{usr}/{pass}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public renta insRenta(renta objR, @PathParam("usr") String usrB, @PathParam("pass") String passB,
			@PathParam("token") String tokenB) {

		bitacora objB = new bitacora();
		objB.setUsuario(usrB);
		objB.setPassword(passB);
		objB.setToken(tokenB);

		if (objB.validaToken()) {
			objR.insRenta();
			return objR;
		}
		return null;
	}

	@PUT
	@Path("/actualizar/{idLoc}/{idTie}/{usr}/{pass}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public renta actRenta(renta objR, @PathParam("idLoc") int idloc, @PathParam("idTie") int idtie,
			@PathParam("usr") String usrB, @PathParam("pass") String passB, @PathParam("token") String tokenB) {

		bitacora objB = new bitacora();
		objB.setUsuario(usrB);
		objB.setPassword(passB);
		objB.setToken(tokenB);

		if (objB.validaToken()) {
			renta tempR = new renta();
			tempR.setId_local(idloc);
			tempR.setId_tienda(idtie);

			objR.actRenta(tempR);
			return objR;
		}
		return null;
	}

	@DELETE
	@Path("/borrar/{usr}/{pass}/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void delRenta(renta objR, @PathParam("usr") String usrB, @PathParam("pass") String passB,
			@PathParam("token") String tokenB) {

		bitacora objB = new bitacora();
		objB.setUsuario(usrB);
		objB.setPassword(passB);
		objB.setToken(tokenB);

		if (objB.validaToken()) {
			objR.delRenta();
		}
	}
}
