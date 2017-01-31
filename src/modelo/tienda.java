package modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "tienda")
public class tienda {

	// Atributos clase = atributos tabla en BD
	private int id;
	private String nombre;
	private String h_apertura;
	private String h_cierre;
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
	public String getH_apertura() {
		return h_apertura;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public String getH_cierre() {
		return h_cierre;
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

	public void setH_apertura(String h_apertura) {
		this.h_apertura = h_apertura;
	}

	public void setH_cierre(String h_cierre) {
		this.h_cierre = h_cierre;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
