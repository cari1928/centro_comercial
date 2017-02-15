package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "tienda")
public class tienda {

	// Atributos clase = atributos tabla en BD
	private int id;
	private String nombre;
	private String h_apertura;
	private String h_cierre;
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
	public String getH_apertura() {
		return h_apertura;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public String getH_cierre() {
		return h_cierre;
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

	public void setH_apertura(String h_apertura) {
		this.h_apertura = h_apertura;
	}

	public void setH_cierre(String h_cierre) {
		this.h_cierre = h_cierre;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<tienda> getListadoT() {
		List<tienda> listT = null;
		tienda objT;

		try {
			listT = new ArrayList<>();

			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "SELECT * FROM tienda ORDER BY nombre";
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);

			while (res.next()) {
				objT = new tienda();
				objT.id = res.getInt(1);
				objT.nombre = res.getString(2);
				objT.h_apertura = res.getString(3);
				objT.h_cierre = res.getString(4);
				objT.telefono = res.getString(5);
				listT.add(objT);
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listT;
	}

	public tienda verTienda() {
		try {
			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "SELECT * FROM tienda WHERE id=" + this.id;
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);

			if (res.next()) {
				this.nombre = res.getString(2);
				this.h_apertura = res.getString(3);
				this.h_cierre = res.getString(4);
				this.telefono = res.getString(5);
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return this;
	}

	public void insTienda() {
		try {
			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "INSERT INTO tienda(nombre, h_apertura, h_cierre, telefono) VALUES('" + this.nombre + "', '"
					+ this.h_apertura + "', '" + this.h_cierre + "', '" + this.telefono + "')";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actTienda() {
		try {
			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "UPDATE servicio SET nombre='" + this.nombre + "', h_apertura='" + this.h_apertura
					+ "', h_cierre='" + this.h_cierre + "', telefono='" + this.telefono + "' WHERE id=" + this.id;
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delTienda() {
		try {
			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "DELETE FROM servicio WHERE id=" + this.id;
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
