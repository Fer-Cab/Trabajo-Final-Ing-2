package com.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Empleado  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empleadoId;


	public String tipoDoc;
	public int numDoc;
	public String nombre;
	public String apellido;
	public int telFijo;
	public int telCel;
	public String direccion;
	public String ciudad;
	public String provincia;
	public String nacionalidad;
	public String e_mail;
	public String foto;
	public String sector;
	public String categoria;
	public String fechaIngreso;

	public Empleado(String nombre, String apellido, String tipoDoc, int numDoc, int telFijo, int telCel,
			String direccion, String ciudad, String provincia, String nacionalidad, String e_mail, String foto,
			String sector, String categoria, String fechaIngreso) {
		super();

		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDoc = tipoDoc;
		this.numDoc = numDoc;
		this.telFijo = telFijo;
		this.telCel = telCel;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.nacionalidad = nacionalidad;
		this.e_mail = e_mail;
		this.foto = foto;
		this.sector = sector;
		this.categoria = categoria;
		this.fechaIngreso = fechaIngreso;
	}

	Empleado() {
	}

	public Long getEmpleadoId() {
		return empleadoId;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public int getNumDoc() {
		return numDoc;
	}

	public int getTelFijo() {
		return telFijo;
	}

	public int getTelCel() {
		return telCel;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getProvincia() {
		return provincia;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public String getE_mail() {
		return e_mail;
	}

	public String getFoto() {
		return foto;
	}

	public String getSector() {
		return sector;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((provincia == null) ? 0 : provincia.hashCode());
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((e_mail == null) ? 0 : e_mail.hashCode());
		result = prime * result + ((empleadoId == null) ? 0 : empleadoId.hashCode());
		result = prime * result + ((fechaIngreso == null) ? 0 : fechaIngreso.hashCode());
		result = prime * result + ((foto == null) ? 0 : foto.hashCode());
		result = prime * result + ((nacionalidad == null) ? 0 : nacionalidad.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + numDoc;
		result = prime * result + ((sector == null) ? 0 : sector.hashCode());
		result = prime * result + telCel;
		result = prime * result + telFijo;
		result = prime * result + ((tipoDoc == null) ? 0 : tipoDoc.hashCode());
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
		Empleado other = (Empleado) obj;
		if (provincia == null) {
			if (other.provincia != null)
				return false;
		} else if (!provincia.equals(other.provincia))
			return false;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (ciudad == null) {
			if (other.ciudad != null)
				return false;
		} else if (!ciudad.equals(other.ciudad))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (e_mail == null) {
			if (other.e_mail != null)
				return false;
		} else if (!e_mail.equals(other.e_mail))
			return false;
		if (empleadoId == null) {
			if (other.empleadoId != null)
				return false;
		} else if (!empleadoId.equals(other.empleadoId))
			return false;
		if (fechaIngreso == null) {
			if (other.fechaIngreso != null)
				return false;
		} else if (!fechaIngreso.equals(other.fechaIngreso))
			return false;
		if (foto == null) {
			if (other.foto != null)
				return false;
		} else if (!foto.equals(other.foto))
			return false;
		if (nacionalidad == null) {
			if (other.nacionalidad != null)
				return false;
		} else if (!nacionalidad.equals(other.nacionalidad))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numDoc != other.numDoc)
			return false;
		if (sector == null) {
			if (other.sector != null)
				return false;
		} else if (!sector.equals(other.sector))
			return false;
		if (telCel != other.telCel)
			return false;
		if (telFijo != other.telFijo)
			return false;
		if (tipoDoc == null) {
			if (other.tipoDoc != null)
				return false;
		} else if (!tipoDoc.equals(other.tipoDoc))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Empleado [empleadoId=" + empleadoId + ", nombre=" + nombre + ", apellido=" + apellido + ", tipoDoc="
				+ tipoDoc + ", numDoc=" + numDoc + ", telFijo=" + telFijo + ", telCel=" + telCel + ", direccion="
				+ direccion + ", ciudad=" + ciudad + ", provincia=" + provincia + ", nacionalidad=" + nacionalidad
				+ ", e_mail=" + e_mail + ", foto=" + foto + ", sector=" + sector + ", categoria=" + categoria
				+ ", fechaIngreso=" + fechaIngreso + "]";
	}

}