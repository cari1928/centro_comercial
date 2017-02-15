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

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "local")
public class local {

	// Atributos clase = atributos tabla en BD
	private int id;
	private int area;
	private boolean almacen;
	private float renta_base;

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public int getId() {
		return id;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public int getArea() {
		return area;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public boolean isAlmacen() {
		return almacen;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public float getRenta_base() {
		return renta_base;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public void setAlmacen(boolean almacen) {
		this.almacen = almacen;
	}

	public void setRenta_base(float renta_base) {
		this.renta_base = renta_base;
	}

	public List<local> getListaL() {
		List<local> listL = null;
		local objL;

		try {
			listL = new ArrayList<>();

			// conexión
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "SELECT * FROM local ORDER BY id";
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);

			while (res.next()) {
				objL = new local();
				objL.id = res.getInt(1);
				objL.area = res.getInt(2);
				objL.almacen = res.getBoolean(3);
				objL.renta_base = res.getFloat(4);
				listL.add(objL);
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listL;
	}

	public local getLocal() {

		try {
			String query = "SELECT * FROM local WHERE id=" + this.id;

			// conexión
			conexion objC = new conexion();
			Connection con = objC.getCon();
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);

			if (res.next()) {
				this.area = res.getInt(2);
				this.almacen = res.getBoolean(3);
				this.renta_base = res.getFloat(4);
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return this;
	}

	public void insLocal() {
		try {

			String query = "INSERT INTO local(area, almacen, renta_base) " + "values(" + this.area + ", " + this.almacen
					+ ", " + this.renta_base + ")";
			conexion objC = new conexion();
			Connection con = objC.getCon();
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			con.close(); // verificar si daña el funcionamiento

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actLocal() {
		try {
			String query = "UPDATE local SET area=" + this.area + ", almacen=" + this.almacen + ", renta_base="
					+ this.renta_base + "  WHERE id=" + this.id;

			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			con.close(); // verificar si daña el funcionamiento

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delLocal() {
		try {
			String query = "DELETE FROM local WHERE id=" + this.id;

			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}