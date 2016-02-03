package com.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Contrato {

	private Cliente cliente;

	private Inmueble inmueble;

	@Id
	private String fecha;

	@GeneratedValue(strategy = GenerationType.AUTO)
	private int contratoId;

	private String estado;
	private double monto;

	public Contrato() {
	}

	public Contrato(Cliente cliente, Inmueble inmueble, String fecha, int contratoId, String estado, double monto) {
		super();
		this.cliente = cliente;
		this.inmueble = inmueble;
		this.fecha = fecha;
		this.contratoId = contratoId;
		this.estado = estado;
		this.monto = monto;
	}

	public Contrato(Cliente cliente, Inmueble inmueble, String fecha, int contratoId, double monto) {
		super();
		this.cliente = cliente;
		this.inmueble = inmueble;
		this.fecha = fecha;
		this.contratoId = contratoId;
		this.monto = monto;
	}
	
	

	public Cliente getCliente() {
		return cliente;
	}

	public Inmueble getInmueble() {
		return inmueble;
	}

	public String getFecha() {
		return fecha;
	}

	public int getContratoId() {
		return contratoId;
	}

	public String getEstado() {
		return estado;
	}

	public double getMonto() {
		return monto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + contratoId;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((inmueble == null) ? 0 : inmueble.hashCode());
		long temp;
		temp = Double.doubleToLongBits(monto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Contrato other = (Contrato) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (contratoId != other.contratoId)
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (inmueble == null) {
			if (other.inmueble != null)
				return false;
		} else if (!inmueble.equals(other.inmueble))
			return false;
		if (Double.doubleToLongBits(monto) != Double.doubleToLongBits(other.monto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		if (estado == null)
			return "Contrato [cliente=" + cliente + ", inmueble=" + inmueble + ", fecha=" + fecha + ", contratoId="
					+ contratoId + ", monto=" + monto + "]";

		return "Contrato [cliente=" + cliente + ", inmueble=" + inmueble + ", fecha=" + fecha + ", contratoId="
				+ contratoId + ", estado=" + estado + ", monto=" + monto + "]";
	}

}
