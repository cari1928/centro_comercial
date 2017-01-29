package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {
	private String driver = "org.postgresql.Driver";
	private String usuario = "postgres";
	private String password = "1234";
	private String cadconexion = "jdbc:postgresql://localhost:5432/centro_comercial";
	private Connection con;
	
	public conexion () {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(cadconexion, usuario, password);
		} catch(Exception e) {
			e.printStackTrace();
			//System.out.println(e.toString());
		}
	}

	public Connection getCon() {
		return con;
	}
	
}
