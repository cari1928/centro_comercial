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
	@Path("/listado/completo/{usr}/{pass}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<acceso_proveedor> getListadoC(@PathParam("usr") String usrB, @PathParam("pass") String passB,
			@PathParam("token") String tokenB) {

		bitacora objB = new bitacora();
		objB.setUsuario(usrB);
		objB.setPassword(passB);
		objB.setToken(tokenB);

		if (objB.validaToken()) {
			acceso_proveedor objA = new acceso_proveedor();
			return objA.getListCompleta();
		}
		return null;
	}

	@GET
	@Path("/listado/tiendas/{idPro}/{usr}/{pass}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<acceso_proveedor> getListadoT(@PathParam("idPro") int idpro, @PathParam("usr") String usrB,
			@PathParam("pass") String passB, @PathParam("token") String tokenB) {

		bitacora objB = new bitacora();
		objB.setUsuario(usrB);
		objB.setPassword(passB);
		objB.setToken(tokenB);

		if (objB.validaToken()) {
			acceso_proveedor objA = new acceso_proveedor();
			objA.setId_proveedor(idpro);
			return objA.getListTP();
		}
		return null;
	}

	@GET
	@Path("/listado/proveedores/{idTie}/{usr}/{pass}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<acceso_proveedor> getListadoP(@PathParam("idTie") int idtie, @PathParam("usr") String usrB,
			@PathParam("pass") String passB, @PathParam("token") String tokenB) {

		bitacora objB = new bitacora();
		objB.setUsuario(usrB);
		objB.setPassword(passB);
		objB.setToken(tokenB);

		if (objB.validaToken()) {
			acceso_proveedor objA = new acceso_proveedor();
			objA.setId_tienda(idtie);
			return objA.getListPT();
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
	@Path("/actualizar/tienda/{usr}/{pass}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public acceso_proveedor actAccTienda(acceso_proveedor objA, @PathParam("usr") String usrB,
			@PathParam("pass") String passB, @PathParam("token") String tokenB) {

		bitacora objB = new bitacora();
		objB.setUsuario(usrB);
		objB.setPassword(passB);
		objB.setToken(tokenB);

		if (objB.validaToken()) {
			objA.actTP();
			return objA;
		}
		return null;
	}

	// actualiza el proveedor de una tienda
	@PUT
	@Path("/actualizar/proveedor/{usr}/{pass}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public acceso_proveedor actAccProveedor(acceso_proveedor objA, @PathParam("usr") String usrB,
			@PathParam("pass") String passB, @PathParam("token") String tokenB) {

		bitacora objB = new bitacora();
		objB.setUsuario(usrB);
		objB.setPassword(passB);
		objB.setToken(tokenB);

		if (objB.validaToken()) {
			objA.actPT();
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
