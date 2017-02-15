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
import modelo.empleado;

//ubica a la clase
@Path("/empleado")
public class WSEmpleado {

	@GET
	@Path("/listado/{usr}/{pwd}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	public List<empleado> getListado(@PathParam("usr") String usrB, @PathParam("pwd") String pwdB,
			@PathParam("token") String tokenB) {

		bitacora objB = new bitacora();
		objB.setUsuario(usrB);
		objB.setPassword(pwdB);
		objB.setToken(tokenB);

		if (objB.validaToken()) {
			empleado objeE = new empleado();
			return objeE.getListaE();
		} 

		return null;

	}

	@GET

	// @Path("/ver/{idEmp}") // {variable} No es parte de la URL
	// public empleado verEmpleado(@PathParam("idEmp") int idemp) {

	@Path("/ver/{usr}/{pwd}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON) // agregado
	public empleado verEmpleado(@PathParam("usr") String usrB, @PathParam("pwd") String pwdB,
			@PathParam("token") String tokenB) {

		bitacora objB = new bitacora();
		objB.setUsuario(usrB);
		objB.setPassword(pwdB);
		objB.setToken(tokenB);

		if (objB.validaToken()) {
			empleado objE = new empleado();
			// objE.setId(idemp);
			objE.setNombre(usrB);
			return objE.getEmpleado();
		} else {
			return null;
		}
	}

	@POST
	@Path("/insertar")
	// insertará un JSON
	// si se quiere regresar un mensaje se debe usar produces
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public empleado insEmpleado(empleado objE) {
		// en este punto ya pasó por jersey, el objeto tiene todos los valores
		objE.insEmpleado();
		return objE;
		// jersey lo vuelve a parsear en JSON
	}

	@PUT
	@Path("/actualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public empleado actEmpleado(empleado objE) {
		objE.actEmpleado();
		return objE;
	}

	@DELETE
	@Path("/borrar/{idEmp}")
	public void delEmpleado(@PathParam("idEmp") int idemp) {
		empleado objE = new empleado();
		objE.setId(idemp);
		objE.delEmpleado();
	}

}
