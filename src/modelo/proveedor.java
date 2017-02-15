package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "proveedor")
public class proveedor {
	// Atributos clase = atributos tabla en BD
	private int id;
	private String nombre;
	private String rfc;
	private String correo;
	private String telefono;

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
	public String getRfc() {
		return rfc;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public String getCorreo() {
		return correo;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public String getTelefono() {
		return telefono;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<proveedor> getListaP() {
		List<proveedor> listP = null;
		proveedor objP;

		try {

			listP = new ArrayList<>();

			// conexion
			String query = "SELECT * FROM proveedor ORDER BY nombre";
			conexion objC = new conexion();
			Connection con = objC.getCon();
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);

			while (res.next()) {
				objP = new proveedor();
				objP.id = res.getInt(1);
				objP.nombre = res.getString(2);
				objP.rfc = res.getString(3);
				objP.correo = res.getString(4);
				objP.telefono = res.getString(5);
				listP.add(objP);
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listP;
	}

	public proveedor getProveedor() {
		try {
			String query = "SELECT * FROM proveedor WHERE id=" + this.id;

			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);

			if (res.next()) {
				this.nombre = res.getString(2);
				this.rfc = res.getString(3);
				this.correo = res.getString(4);
				this.telefono = res.getString(5);
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return this;
	}

	public void insProveedor() {
		String query = "no";
		try {
			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			query = "INSERT INTO proveedor(nombre, rfc, correo, telefono)" + "VALUES('" + this.nombre + "', '"
					+ this.rfc + "', '" + this.correo + "', '" + this.telefono + "')";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);

			con.close();

		} catch (Exception e) {
			System.out.print(query);
			e.printStackTrace();
		}
	}

	public void actProveedor() {
		try {
			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "UPDATE proveedor SET nombre='" + this.nombre + "', rfc='" + this.rfc + "', correo='"
					+ this.correo + "', telefono='" + this.telefono + "' WHERE id=" + this.id;
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delProveedor() {
		try {
			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "DELETE FROM proveedor WHERE id=" + this.id;
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
