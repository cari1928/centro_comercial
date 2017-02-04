package controlador;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import modelo.empleado;

//ubica a la clase
@Path("/empleado")
public class WSEmpleado {

	// define el método, el contexto
	@GET
	@Path("/listado")

	// listado = producir
	@Produces(MediaType.APPLICATION_JSON)
	public List<empleado> getListado() {
		empleado objeE = new empleado();
		return objeE.getListaE();
		// después lo convertirá a JSON
	}

	@GET
	@Path("/ver/{idEmp}") // {variable} No es parte de la URL
	@Produces(MediaType.APPLICATION_JSON)
	// se vacía la variable de path en una variable java
	public empleado verEmpleado(@PathParam("idEmp") int idemp) {
		empleado objE = new empleado();
		objE.setId(idemp);
		return objE.getEmpleado();
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
