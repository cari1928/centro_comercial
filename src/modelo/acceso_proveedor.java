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
public class acceso_proveedor {

	private int id_proveedor;
	private int id_tienda;

	@XmlElement(required = true)
	public int getId_proveedor() {
		return id_proveedor;
	}

	@XmlElement(required = true)
	public int getId_tienda() {
		return id_tienda;
	}

	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public void setId_tienda(int id_tienda) {
		this.id_tienda = id_tienda;
	}

	public List<acceso_proveedor> getListA() {
		List<acceso_proveedor> listA = null;
		acceso_proveedor objA;

		try {
			listA = new ArrayList<>();

			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "SELECT * FROM acceso_proveedor ORDER BY id_proveedor";
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);

			while (res.next()) {
				objA = new acceso_proveedor();
				objA.id_proveedor = res.getInt(1);
				objA.id_tienda = res.getInt(2);
				listA.add(objA);
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listA;
	}

	public acceso_proveedor verAccProovedor() {
		try {
			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "SELECT * FROM acceso_proveedor WHERE id_proveedor=" + this.id_proveedor + " AND id_tienda="
					+ this.id_tienda;
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

	public void insAccProveedor() {
		try {
			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "INSERT INTO acceso_proveedor VALUES(" + this.id_proveedor + ", " + this.id_tienda + ")";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actAccProveedor(acceso_proveedor objA) {
		try {
			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "UPDATE acceso_proveedor SET id_proveedor=" + this.id_proveedor + ", id_tienda="
					+ this.id_tienda + " WHERE id_proveedor=" + objA.getId_proveedor() + " AND id_tienda="
					+ objA.getId_tienda();
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delAccProveedor() {
		try {
			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "DELETE FROM acceso_proveedor WHERE id_proveedor=" + this.id_proveedor + " AND id_tienda="
					+ this.id_tienda;
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
