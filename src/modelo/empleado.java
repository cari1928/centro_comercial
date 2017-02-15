package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement; //no causa error

//las dos instrucciones especifican la raiz de json
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "empleado")
public class empleado {
	// Atributos clase = atributos tabla en BD
	private int id;
	private String nombre;
	private String apellido_p;
	private String apellido_m;
	private String rfc;
	private String direccion;
	private String correo;
	private String tel_casa;
	private String tel_cel;
	private String genero;

	private String status;

	// atributo factible a salir de un resultado web service
	public String getStatus() {
		return status;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public int getId() {
		return id;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public String getNombre() {
		return nombre;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public String getApellido_p() {
		return apellido_p;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public String getApellido_m() {
		return apellido_m;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public String getRfc() {
		return rfc;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public String getDireccion() {
		return direccion;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public String getCorreo() {
		return correo;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public String getTel_casa() {
		return tel_casa;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public String getTel_cel() {
		return tel_cel;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public String getGenero() {
		return genero;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido_p(String apellido_p) {
		this.apellido_p = apellido_p;
	}

	public void setApellido_m(String apellido_m) {
		this.apellido_m = apellido_m;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setTel_casa(String tel_casa) {
		this.tel_casa = tel_casa;
	}

	public void setTel_cel(String tel_cel) {
		this.tel_cel = tel_cel;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<empleado> getListaE() {
		// jersey va a tomar cada objeto y retornará un json
		List<empleado> arrE = null;
		empleado objE;
		String query = "";

		try {
			arrE = new ArrayList<>();

			conexion objC = new conexion();
			Connection con = objC.getCon();

			// si va a tener valores
			query = "SELECT * FROM empleado ORDER BY nombre";
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);

			while (res.next()) {
				objE = new empleado();
				objE.id = res.getInt(1);
				objE.nombre = res.getString(2);
				objE.apellido_p = res.getString(3);
				objE.apellido_m = res.getString(4);
				objE.rfc = res.getString(5);
				objE.direccion = res.getString(6);
				objE.correo = res.getString(7);
				objE.tel_casa = res.getString(8);
				objE.tel_cel = res.getString(9);
				objE.genero = res.getString(10);
				arrE.add(objE);
			}

			con.close();

		} catch (Exception e) {
			System.out.println(query);
			e.printStackTrace();
		}
		return arrE;
	}

	public empleado getEmpleado() {
		String query = "no hay query";

		try {
			// query = "SELECT * FROM empleado WHERE id=" + id;
			query = "SELECT * FROM empleado WHERE nombre='" + this.nombre + "'";

			conexion objC = new conexion();
			Connection con = objC.getCon();
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);

			if (res.next()) {
				this.id = res.getInt(1);
				this.apellido_p = res.getString(3);
				this.apellido_m = res.getString(4);
				this.rfc = res.getString(5);
				this.direccion = res.getString(6);
				this.correo = res.getString(7);
				this.tel_casa = res.getString(8);
				this.tel_cel = res.getString(9);
				this.genero = res.getString(10);
				// this.status = "";
			}

		} catch (Exception e) {
			System.out.println(query);
			e.printStackTrace();
		}
		// regresa este mismo contexto de empleado
		return this;
	}

	public void insEmpleado() {
		try {
			String query = "INSERT INTO empleado(nombre, apellido_p, apellido_m, rfc, "
					+ "direccion, correo, tel_casa, tel_cel, genero)" + " values('" + nombre + "', '" + apellido_p
					+ "', '" + apellido_m + "', '" + rfc + "', '" + direccion + "', '" + correo + "', '" + tel_casa
					+ "', '" + tel_cel + "', '" + genero + "')";
			conexion objC = new conexion();
			Connection con = objC.getCon();
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);

		} catch (Exception e) {
			System.out.println(e.toString()); // para mostrar errores en consola
		}
	}

	// falta checar que funcionen actualizar y eliminar

	public void actEmpleado() {
		try {
			String query = "UPDATE empleado SET nombre='" + nombre + "', apellido_p='" + apellido_p + "', "
					+ "apellido_m='" + apellido_m + "', rfc='" + rfc + "', direccion='" + direccion + "', correo='"
					+ correo + "', tel_casa='" + tel_casa + "', tel_cel='" + tel_cel + "', genero='" + genero
					+ "' WHERE id=" + id;
			 
			conexion objC = new conexion();
			Connection con = objC.getCon();
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);

		} catch (Exception e) {
			System.out.println(e.toString()); // para mostrar errores en consola
		}
	}

	public void delEmpleado() {
		try {
			String query = "DELETE FROM empleado where id=" + this.id;
			conexion objC = new conexion();
			Connection con = objC.getCon();
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
		} catch (Exception e) {
			System.out.println(e.toString()); // para mostrar errores en consola
		}
	}

}