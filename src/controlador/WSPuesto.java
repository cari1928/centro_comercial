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
import modelo.puesto;

@Path("/puesto")
public class WSPuesto {

	@GET
	@Path("/listado/{usr}/{pwd}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<puesto> getListado(@PathParam("usr") String usr, @PathParam("pwd") String pass,
			@PathParam("token") String token) {

		bitacora objB = new bitacora();
		objB.setUsuario(usr);
		objB.setPassword(pass);
		objB.setToken(token);

		if (objB.validaToken()) {
			puesto objP = new puesto();
			return objP.getListaP();
		}
		return null;
	}

	@GET
	@Path("/ver/{idPue}/{usr}/{pwd}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public puesto verPuesto(@PathParam("idPue") int idpue, @PathParam("usr") String usr, @PathParam("pwd") String pass,
			@PathParam("token") String token) {

		bitacora objB = new bitacora();
		objB.setUsuario(usr);
		objB.setPassword(pass);
		objB.setToken(token);

		if (objB.validaToken()) {
			puesto objP = new puesto();
			objP.setId(idpue);
			return objP.verPuesto();
		}
		return null;
	}

	@POST
	@Path("/insertar/{usr}/{pwd}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public puesto insPuesto(puesto objP, @PathParam("usr") String usr, @PathParam("pwd") String pass,
			@PathParam("token") String token) {

		bitacora objB = new bitacora();
		objB.setUsuario(usr);
		objB.setPassword(pass);
		objB.setToken(token);

		if (objB.validaToken()) {
			objP.insPuesto();
			return objP;
		}
		return null;
	}

	@PUT
	@Path("/actualizar/{usr}/{pwd}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public puesto actPuesto(puesto objP, @PathParam("usr") String usr, @PathParam("pwd") String pass,
			@PathParam("token") String token) {

		bitacora objB = new bitacora();
		objB.setUsuario(usr);
		objB.setPassword(pass);
		objB.setToken(token);

		if (objB.validaToken()) {
			objP.actPuesto();
			return objP;
		}
		return null;
	}

	@DELETE
	@Path("/borrar/{idPue}/{usr}/{pwd}/{token}")
	public void delPuesto(@PathParam("idPue") int idpue, @PathParam("usr") String usr, @PathParam("pwd") String pass,
			@PathParam("token") String token) {

		bitacora objB = new bitacora();
		objB.setUsuario(usr);
		objB.setPassword(pass);
		objB.setToken(token);

		if (objB.validaToken()) {
			puesto objP = new puesto();
			objP.setId(idpue);
			objP.delPuesto();
		}
	}
}
