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
import modelo.acceso_proveedor;
import modelo.bitacora;

@Path("/acceso_proveedor")
public class WSAccProveedor {

	@GET
	@Path("/listado/{usr}/{pass}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<acceso_proveedor> getListadoC(@PathParam("usr") String usrB, @PathParam("pass") String passB,
			@PathParam("token") String tokenB) {

		bitacora objB = new bitacora();
		objB.setUsuario(usrB);
		objB.setPassword(passB);
		objB.setToken(tokenB);

		if (objB.validaToken()) {
			acceso_proveedor objA = new acceso_proveedor();
			return objA.getListA();
		}
		return null;
	}

	@GET
	@Path("/ver/{idPro}/{idTie}/{usr}/{pass}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public acceso_proveedor getAccProveedor(@PathParam("idPro") int idpro, @PathParam("idTie") int idtie,
			@PathParam("usr") String usrB, @PathParam("pass") String passB, @PathParam("token") String tokenB) {

		bitacora objB = new bitacora();
		objB.setUsuario(usrB);
		objB.setPassword(passB);
		objB.setToken(tokenB);

		if (objB.validaToken()) {
			acceso_proveedor objA = new acceso_proveedor();
			objA.setId_proveedor(idpro);
			objA.setId_tienda(idtie);
			return objA.verAccProovedor();
		}
		return null;
	}

	@POST
	@Path("/insertar/{usr}/{pass}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public acceso_proveedor insAccProveedor(acceso_proveedor objA, @PathParam("usr") String usrB,
			@PathParam("pass") String passB, @PathParam("token") String tokenB) {

		bitacora objB = new bitacora();
		objB.setUsuario(usrB);
		objB.setPassword(passB);
		objB.setToken(tokenB);

		if (objB.validaToken()) {
			objA.insAccProveedor();
			return objA;
		}
		return null;
	}

	// actualiza la tienda de un proveedor
	@PUT
	@Path("/actualizar/{idPro}/{idTie}/{usr}/{pass}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public acceso_proveedor actAccTienda(acceso_proveedor objA, @PathParam("idPro") int idpro,
			@PathParam("idTie") int idtie, @PathParam("usr") String usrB, @PathParam("pass") String passB,
			@PathParam("token") String tokenB) {

		bitacora objB = new bitacora();
		objB.setUsuario(usrB);
		objB.setPassword(passB);
		objB.setToken(tokenB);

		if (objB.validaToken()) {
			acceso_proveedor tempA = new acceso_proveedor();
			tempA.setId_proveedor(idpro);
			tempA.setId_tienda(idtie);

			objA.actAccProveedor(tempA);
			return objA;
		}
		return null;
	}

	@DELETE
	@Path("/borrar/{usr}/{pass}/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	public acceso_proveedor delAccProveedor(acceso_proveedor objA, @PathParam("usr") String usrB,
			@PathParam("pass") String passB, @PathParam("token") String tokenB) {

		bitacora objB = new bitacora();
		objB.setUsuario(usrB);
		objB.setPassword(passB);
		objB.setToken(tokenB);

		if (objB.validaToken()) {
			objA.delAccProveedor();
		}
		return null;
	}

}
