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
import modelo.tienda;

@Path("/tienda")
public class WSTienda {

	@GET
	@Path("/listado/{usr}/{pass}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<tienda> getListaT(@PathParam("usr") String usr, @PathParam("pass") String pass,
			@PathParam("token") String token) {

		bitacora objB = new bitacora();
		objB.setUsuario(usr);
		objB.setPassword(pass);
		objB.setToken(token);

		if (objB.validaToken()) {
			tienda objT = new tienda();
			return objT.getListadoT();
		}

		return null;
	}

	@GET
	@Path("/ver/{idTie}")
	@Produces(MediaType.APPLICATION_JSON)
	public tienda verTienda(@PathParam("idTie") int idtie) {
		tienda objT = new tienda();
		objT.setId(idtie);
		return objT.verTienda();
	}

	@POST
	@Path("/insertar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public tienda insTienda(tienda objT) {
		objT.insTienda();
		return objT;
	}

	@PUT
	@Path("/actualizar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public tienda actTienda(tienda objT) {
		objT.actTienda();
		return objT;
	}

	@DELETE
	@Path("/borrar/{idTie}")
	public void insTienda(@PathParam("idTie") int idtie) {
		tienda objT = new tienda();
		objT.setId(idtie);
		objT.delTienda();
	}
}
