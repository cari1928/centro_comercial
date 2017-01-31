package modelo;

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

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

}
