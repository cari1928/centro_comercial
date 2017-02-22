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
@XmlRootElement(name = "puesto")
public class puesto {

	// Atributos clase = atributos tabla en BD
	private int id;
	private String puesto;

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public int getId() {
		return id;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public String getPuesto() {
		return puesto;
	}

	public void setId(int id) {
		this.id = id;
	}

	// para el cambio de modelo, éste método no se ocupa
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public List<puesto> getListaP() {
		List<puesto> listP = null;
		puesto objP;

		try {
			listP = new ArrayList<>();

			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "SELECT * FROM puesto ORDER BY puesto";
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);

			while (res.next()) {
				objP = new puesto();
				objP.id = res.getInt(1);
				objP.puesto = res.getString(2);
				listP.add(objP);
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listP;
	}

	// utilizado para el cambio de modelo
	public void verPuesto() {
		try {
			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "SELECT * FROM puesto WHERE id=" + this.id;
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);

			if (res.next()) {
				this.puesto = res.getString(2);
			}

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void insPuesto() {
		try {
			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "INSERT INTO puesto(puesto) " + "VALUES('" + this.puesto + "')";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actPuesto() {
		try {
			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "UPDATE puesto SET puesto='" + this.puesto + "' WHERE id=" + this.id;
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delPuesto() {
		try {
			// conexion
			conexion objC = new conexion();
			Connection con = objC.getCon();

			// valores
			String query = "DELETE FROM puesto WHERE id=" + this.id;
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
