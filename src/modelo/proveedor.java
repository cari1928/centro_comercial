package modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "proveedor")
public class proveedor {
	// Atributos clase = atributos tabla en BD
	private int id;
	private String nombre;
	private String rfc;
	private String correo;
	private String telefono;

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public int getId() {
		return id;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public String getNombre() {
		return nombre;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public String getRfc() {
		return rfc;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public String getCorreo() {
		return correo;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public String getTelefono() {
		return telefono;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
