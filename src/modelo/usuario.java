package modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "usuario")
public class usuario {

	private String usuario;
	private String password;
	private String token;
	private String status; //esto o que si hay error el token env�a un valor que se puede interpretar como err�neo

	@XmlElement(required = true)
	public String getToken() {
		return token;
	}

	@XmlElement(required = true)
	public String getUsuario() {
		return usuario;
	}

	@XmlElement(required = true)
	public String getPassword() {
		return password;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void validaUsuario() {
		String query = "query null";
	
		try {
			query = "SELECT * FROM usuario " + "WHERE nombre='" + usuario + "' and password='" + password + "'";
			conexion objC = new conexion();
			Connection conn = objC.getCon();
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(query);

			if (res.next()) {
				// se actualiza el valor de token
				generarToken("MD5", usuario, password);
				bitacora objB = new bitacora();
				objB.setUsuario(usuario);
				objB.setPassword(password);
				objB.setToken(token);
				objB.insAcceso();
				
			} else {
				this.token = "no_valido";
			}

		} catch (Exception e) {
			System.out.println(query);
			e.printStackTrace();
		}
	}

	// generar token con md5
	public void generarToken(String alg, String usuario, String password) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date fecha = new Date();
			String cadena = dateFormat.format(fecha) + usuario + password;

			byte[] digest = null;
			byte[] buffer = cadena.getBytes();

			MessageDigest messageDigest = MessageDigest.getInstance(alg);
			messageDigest.reset();
			messageDigest.update(buffer);
			digest = messageDigest.digest();

			token = toHexadecimal(digest);
		} catch (NoSuchAlgorithmException ex) {
			// token = ex.toString();
			// System.out.println("Error creando Digest");
		}
	}

	private static String toHexadecimal(byte[] digest) {
		String hash = "";
		for (byte aux : digest) {
			int b = aux & 0xff;
			if (Integer.toHexString(b).length() == 1)
				hash += "0";
			hash += Integer.toHexString(b);
		}
		return hash;
	}

}
