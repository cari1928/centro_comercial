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
import modelo.proveedor;

@Path("/proveedor")
public class WSProveedor {

	@GET
	@Path("/listado/{usr}/{pass}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<proveedor> getListado(@PathParam("usr") String usr, @PathParam("pass") String pass,
			@PathParam("token") String token) {

		bitacora objB = new bitacora();
		objB.setUsuario(usr);
		objB.setPassword(pass);
		objB.setToken(token);

		if (objB.validaToken()) {
			proveedor objL = new proveedor();
			return objL.getListaP();
		}
		return null;
	}

	@GET
	@Path("/ver/{idPro}/{usr}/{pass}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public proveedor getProveedor(@PathParam("idPro") int idpro, @PathParam("usr") String usr,
			@PathParam("pass") String pass, @PathParam("token") String token) {

		bitacora objB = new bitacora();
		objB.setUsuario(usr);
		objB.setPassword(pass);
		objB.setToken(token);

		if (objB.validaToken()) {
			proveedor objP = new proveedor();
			objP.setId(idpro);
			return objP.getProveedor();
		}
		return null;
	}

	@POST
	@Path("/insertar/{usr}/{pass}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public proveedor insProveedor(proveedor objP, @PathParam("usr") String usr, @PathParam("pass") String pass,
			@PathParam("token") String token) {

		bitacora objB = new bitacora();
		objB.setUsuario(usr);
		objB.setPassword(pass);
		objB.setToken(token);

		if (objB.validaToken()) {
			objP.insProveedor();
			return objP;
		}
		return null;
	}

	@PUT
	@Path("/actualizar/{usr}/{pass}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public proveedor actProveedor(proveedor objP, @PathParam("usr") String usr, @PathParam("pass") String pass,
			@PathParam("token") String token) {

		bitacora objB = new bitacora();
		objB.setUsuario(usr);
		objB.setPassword(pass);
		objB.setToken(token);

		if (objB.validaToken()) {
			objP.actProveedor();
			return objP;
		}
		return null;
	}

	@DELETE
	@Path("/borrar/{idPro}/{usr}/{pass}/{token}")
	public void delProveedor(@PathParam("idPro") int idpro, @PathParam("usr") String usr,
			@PathParam("pass") String pass, @PathParam("token") String token) {

		bitacora objB = new bitacora();
		objB.setUsuario(usr);
		objB.setPassword(pass);
		objB.setToken(token);

		if (objB.validaToken()) {
			proveedor objP = new proveedor();
			objP.setId(idpro);
			objP.delProveedor();
		}
	}

}
