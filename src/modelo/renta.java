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
@XmlRootElement(name = "renta")
public class renta {

	private int id_local;
	private int id_tienda;

	@XmlElement(required = true)
	public int getId_local() {
		return id_local;
	}

	@XmlElement(required = true)
	public int getId_tienda() {
		return id_tienda;
	}

	public void setId_local(int id_local) {
		this.id_local = id_local;
	}

	public void setId_tienda(int id_tienda) {
		this.id_tienda = id_tienda;
	}

	public List<renta> getListadoR() {
		List<renta> listR = null;
		renta objR;

		try {
			listR = new ArrayList<>();

			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "SELECT * FROM renta ORDER BY id_local";
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);

			while (res.next()) {
				objR = new renta();
				objR.id_local = res.getInt(1);
				objR.id_tienda = res.getInt(2);
				listR.add(objR);
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listR;
	}

	public renta verRenta() {
		try {
			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "SELECT * FROM renta WHERE id_local=" + this.id_local + " AND id_tienda=" + this.id_tienda;
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

	public void insRenta() {
		try {
			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "INSERT INTO renta VALUES(" + this.id_local + ", " + this.id_tienda + ")";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actRenta(renta objR) {
		try {
			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "UPDATE renta SET id_local=" + this.id_local + ", id_tienda=" + this.id_tienda
					+ " WHERE id_local=" + objR.getId_local() + " AND id_tienda=" + objR.getId_tienda();
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delRenta() {
		try {
			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "DELETE FROM renta WHERE id_local=" + this.id_local + " AND id_tienda=" + this.id_tienda;
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
