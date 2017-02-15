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
@XmlRootElement(name = "servicio")
public class servicio {

	// Atributos clase = atributos tabla en BD
	private int id;
	private String servicio;
	private float precio;

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public int getId() {
		return id;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public String getServicio() {
		return servicio;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public float getPrecio() {
		return precio;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public List<servicio> getListaS() {
		List<servicio> listS = null;
		servicio objS = null;

		try {
			listS = new ArrayList<>();

			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "SELECT * FROM servicio ORDER BY servicio";
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);

			while (res.next()) {
				objS = new servicio();
				objS.id = res.getInt(1);
				objS.servicio = res.getString(2);
				objS.precio = res.getFloat(3);
				listS.add(objS);
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listS;
	}

	public servicio verServicio() {
		try {
			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "SELECT * FROM servicio WHERE id=" + this.id;
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);

			if (res.next()) {
				this.servicio = res.getString(2);
				this.precio = res.getFloat(3);
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public void insServicio() {
		try {
			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "INSERT INTO servicio(servicio, precio) VALUES('" + this.servicio + "', " + this.precio
					+ ")";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actServicio() {
		try {
			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "UPDATE servicio SET servicio='" + this.servicio + "', precio=" + this.precio + " WHERE id="
					+ this.id;
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delServicio() {
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
