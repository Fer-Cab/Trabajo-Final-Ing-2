package com.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Imagen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long imagenId;

	private String nombre;
	private String path;

	public Imagen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Imagen(long imagenId,String nombre, String path) {
		super();
		this.imagenId = imagenId;
		this.nombre = nombre;
		this.path = path;
	}

	public Imagen(String nombre,String path) {
		super();
		this.nombre = nombre;
		this.path = path;
	}
	
	public long getImagenId() {
		return imagenId;
	}

	public String getPath() {
		return path;
	}
	
	public String getNombre() {
		return nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imagen other = (Imagen) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Imagen [imagenId=" + imagenId + ", nombre=" + nombre + ", path=" + path + "]";
	}

	

}
