package modelo;

import java.sql.Connection;
import java.sql.Statement;

public class bitacora {

	private String usuario;
	private String password;
	private String token;

	public void insAcceso() {
		try {
			// al insertar toma la fecha de la inserción
			String query = "INSERT INTO bitacora(usuario, password, token) VALUES('" + usuario + "', '" + password
					+ "', '" + token + "')";
			conexion objC = new conexion();
			Connection conn = objC.getCon();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
