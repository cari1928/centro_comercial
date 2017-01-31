package modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "local")
public class local {
	// Atributos clase = atributos tabla en BD
	private int id;
	private boolean area;
	private boolean almacen;

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public int getId() {
		return id;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public boolean isArea() {
		return area;
	}

	// para que salga en respuesta de una solicitud get o post
	@XmlElement(required = true)
	public boolean isAlmacen() {
		return almacen;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setArea(boolean area) {
		this.area = area;
	}

	public void setAlmacen(boolean almacen) {
		this.almacen = almacen;
	}

}