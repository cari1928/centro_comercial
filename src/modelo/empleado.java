package modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement; //no causa error
//import com.sun.xml.internal.txw2.annotation.XmlElement; //causa error

//las dos instrucciones especifican la raiz de json
@XmlAccessorType(XmlAccessType.NONE) 
@XmlRootElement(name="empleado") 
public class empleado {
	// Atributos clase = atributos tabla en BD
	private int id;
	private String nombre;
	private String apellido_p;
	private String apellido_m;
	private String rfc;
	private String direccion;
	private String correo;
	private String tel_casa;
	private String tel_cel;
	private char genero;

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public int getId() {
		return id;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required=true)
	public String getNombre() {
		return nombre;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public String getApellido_p() {
		return apellido_p;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public String getApellido_m() {
		return apellido_m;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public String getRfc() {
		return rfc;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public String getDireccion() {
		return direccion;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public String getCorreo() {
		return correo;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public String getTel_casa() {
		return tel_casa;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public String getTel_cel() {
		return tel_cel;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public char getGenero() {
		return genero;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido_p(String apellido_p) {
		this.apellido_p = apellido_p;
	}

	public void setApellido_m(String apellido_m) {
		this.apellido_m = apellido_m;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setTel_casa(String tel_casa) {
		this.tel_casa = tel_casa;
	}

	public void setTel_cel(String tel_cel) {
		this.tel_cel = tel_cel;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

}
