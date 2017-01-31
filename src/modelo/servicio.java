package modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "servicio")
public class servicio {

	// Atributos clase = atributos tabla en BD
	private int id;
	private String servicio;
	private float precio;

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public int getId() {
		return id;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public String getServicio() {
		return servicio;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public float getPrecio() {
		return precio;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

}
