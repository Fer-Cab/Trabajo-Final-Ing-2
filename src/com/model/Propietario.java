package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Propietario {

	@OneToMany(mappedBy = "propietario")
	private Set<InmuebleList> inmuebles = new HashSet<>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long propietarioId;

	public String tipoDoc;
	public int numDoc;
	public String nombre;
	public String apellido;
	public int telFijo;
	public int telCel;
	public String direccion;
	public String ciudad;
	public String Provincia;
	public String nacionalidad;
	public String e_mail;
	public String numCuenta;

	public Propietario(String nombre, String apellido, String tipoDoc, int numDoc, int telFijo, int telCel,
			String direccion, String ciudad, String provincia, String nacionalidad, String e_mail, String numCuenta) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDoc = tipoDoc;
		this.numDoc = numDoc;
		this.telFijo = telFijo;
		this.telCel = telCel;
		this.direccion = direccion;
		this.ciudad = ciudad;
		Provincia = provincia;
		this.nacionalidad = nacionalidad;
		this.e_mail = e_mail;
		this.numCuenta = numCuenta;
	}

	Propietario() {
	}

	public Set<InmuebleList> getInmuebles() {
		return inmuebles;
	}

	public Long getPropietarioId() {
		return propietarioId;
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
		return Provincia;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public String getE_mail() {
		return e_mail;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Provincia == null) ? 0 : Provincia.hashCode());
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((e_mail == null) ? 0 : e_mail.hashCode());
		result = prime * result + ((nacionalidad == null) ? 0 : nacionalidad.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numCuenta == null) ? 0 : numCuenta.hashCode());
		result = prime * result + numDoc;
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
		Propietario other = (Propietario) obj;
		if (Provincia == null) {
			if (other.Provincia != null)
				return false;
		} else if (!Provincia.equals(other.Provincia))
			return false;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
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
		if (numCuenta == null) {
			if (other.numCuenta != null)
				return false;
		} else if (!numCuenta.equals(other.numCuenta))
			return false;
		if (numDoc != other.numDoc)
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

}