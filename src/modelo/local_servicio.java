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
@XmlRootElement(name = "acceso_proveedor")
public class local_servicio {

	private int id_local;
	private int id_servicio;

	@XmlElement(required = true)
	public int getId_local() {
		return id_local;
	}

	@XmlElement(required = true)
	public int getId_servicio() {
		return id_servicio;
	}

	public void setId_local(int id_local) {
		this.id_local = id_local;
	}

	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}

	public List<local_servicio> getListadoL() {
		List<local_servicio> listL = null;
		local_servicio objL;

		try {
			listL = new ArrayList<>();

			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "SELECT * FROM local_servicio ORDER BY id_local";
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);

			while (res.next()) {
				objL = new local_servicio();
				objL.id_local = res.getInt(1);
				objL.id_servicio = res.getInt(2);
				listL.add(objL);
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listL;
	}

	public local_servicio verLocServicio() {
		try {
			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "SELECT * FROM local_servicio WHERE id_local=" + this.id_local + " AND id_servicio="
					+ this.id_servicio;
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);

			if (res.next()) {
				return this;
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void insLocServicio() {
		try {
			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "INSERT INTO local_servicio VALUES(" + this.id_local + ", " + this.id_servicio + ")";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actLocServicio(local_servicio objL) {
		try {
			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "UPDATE local_servicio SET id_local=" + this.id_local + ", id_servicio=" + this.id_servicio
					+ " WHERE id_local=" + objL.getId_local() + " AND id_servicio=" + objL.getId_servicio();
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delLocServicio() {
		try {
			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "DELETE FROM local_servicio WHERE id_local=" + this.id_local + " AND id_servicio="
					+ this.id_servicio;
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
