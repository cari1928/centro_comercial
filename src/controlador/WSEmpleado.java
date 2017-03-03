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
	@Path("/ver/{idEmp}/{usr}/{pwd}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public empleado verEmpleado(@PathParam("idEmp") int idemp, @PathParam("usr") String usrB,
			@PathParam("pwd") String pwdB, @PathParam("token") String tokenB) {

		bitacora objB = new bitacora();
		objB.setUsuario(usrB);
		objB.setPassword(pwdB);
		objB.setToken(tokenB);

		if (objB.validaToken()) {
			empleado objE = new empleado();
			objE.setId(idemp);
			return objE.getEmpleado();
		}
		return null;
	}

	@POST
	@Path("/insertar/{usr}/{pwd}/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public empleado insEmpleado(empleado objE, @PathParam("idEmp") int idemp, @PathParam("usr") String usrB,
			@PathParam("pwd") String pwdB, @PathParam("token") String tokenB) {

		bitacora objB = new bitacora();
		objB.setUsuario(usrB);
		objB.setPassword(pwdB);
		objB.setToken(tokenB);

		if (objB.validaToken()) {
			objE.insEmpleado();
			return objE;
		}
		return null;
	}

	@PUT
	@Path("/actualizar/{usr}/{pwd}/{token}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public empleado actEmpleado(empleado objE, @PathParam("idEmp") int idemp, @PathParam("usr") String usrB,
			@PathParam("pwd") String pwdB, @PathParam("token") String tokenB) {

		bitacora objB = new bitacora();
		objB.setUsuario(usrB);
		objB.setPassword(pwdB);
		objB.setToken(tokenB);

		if (objB.validaToken()) {
			objE.actEmpleado();
			return objE;
		}
		return null;
	}

	@DELETE
	@Path("/borrar/{idEmp}/{usr}/{pwd}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public empleado delEmpleado(@PathParam("idEmp") int idemp, @PathParam("usr") String usrB, @PathParam("pwd") String pwdB,
			@PathParam("token") String tokenB) {

		bitacora objB = new bitacora();
		objB.setUsuario(usrB);
		objB.setPassword(pwdB);
		objB.setToken(tokenB);

		if (objB.validaToken()) {
			empleado objE = new empleado();
			objE.setId(idemp);
			objE.delEmpleado();
			return objE;
		}
		
		return null;
	}

}
