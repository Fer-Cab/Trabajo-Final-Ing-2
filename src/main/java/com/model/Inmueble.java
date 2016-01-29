package com.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Inmueble {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long inmuebleId;

	@JsonIgnore
	@ManyToMany
	private List<Inmueble> inmuebleLists;

	private String descripcion;
	private String tipoDeInmueble;
	private String tipoDeOperacion;
	private String estado;
	private String direccion;
	private String piso;
	private String dpto;
	private String ciudad;
	private String provincia;
	private int numHabitaciones;
	private int banios;
	private int m2;
	private double alquiler;
	private double venta;
	private String tipoSuelo;
	private boolean garage;
	private boolean ascensor;
	private boolean amueblado;
	private double comision;

	@OneToOne
	private String tipoDoc;
	@OneToOne
	private int numDoc;
	
	public Inmueble() {
	}

	public Inmueble(String descripcion, String tipoDeInmueble, String tipoDeOperacion,
			String estado, String direccion, String piso, String dpto, String ciudad, String provincia,
			int numHabitaciones, int banios, int m2, double alquiler, double venta, String tipoSuelo, boolean garage,
			boolean ascensor, boolean amueblado, double comision,String tipoDoc, int numDoc) {
		super();
		this.descripcion = descripcion;
		this.tipoDeInmueble = tipoDeInmueble;
		this.tipoDeOperacion = tipoDeOperacion;
		this.estado = estado;
		this.direccion = direccion;
		this.piso = piso;
		this.dpto = dpto;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.numHabitaciones = numHabitaciones;
		this.banios = banios;
		this.m2 = m2;
		this.alquiler = alquiler;
		this.venta = venta;
		this.tipoSuelo = tipoSuelo;
		this.garage = garage;
		this.ascensor = ascensor;
		this.amueblado = amueblado;
		this.comision = comision;
		this.tipoDoc= tipoDoc;
		this.numDoc = numDoc;
	}

	
	public Inmueble(long inmuebleId, String descripcion, String tipoDeInmueble,
			String tipoDeOperacion, String estado, String direccion, String piso, String dpto,
			String ciudad, String provincia,  int numHabitaciones, int banios, int m2, double alquiler,
			double venta, String tipoSuelo, boolean garage, boolean ascensor, boolean amueblado, double comision,String tipoDoc, int numDoc) {
		super();
		this.inmuebleId = inmuebleId;
		this.descripcion = descripcion;
		this.tipoDeInmueble = tipoDeInmueble;
		this.tipoDeOperacion = tipoDeOperacion;
		this.estado = estado;
		this.direccion = direccion;
		this.piso = piso;
		this.dpto = dpto;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.numHabitaciones = numHabitaciones;
		this.banios = banios;
		this.m2 = m2;
		this.alquiler = alquiler;
		this.venta = venta;
		this.tipoSuelo = tipoSuelo;
		this.garage = garage;
		this.ascensor = ascensor;
		this.amueblado = amueblado;
		this.comision = comision;
		this.tipoDoc= tipoDoc;
		 this.numDoc = numDoc;
	}

	public long getInmuebleId() {
		return inmuebleId;
	}

	public List<Inmueble> getInmuebleLists() {
		return inmuebleLists;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getTipoDeInmueble() {
		return tipoDeInmueble;
	}

	public String getTipoDeOperacion() {
		return tipoDeOperacion;
	}

	public String getEstado() {
		return estado;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getPiso() {
		return piso;
	}

	public String getDpto() {
		return dpto;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getProvincia() {
		return provincia;
	}



	public String getTipoDoc() {
		return tipoDoc;
	}

	public int getNumDoc() {
		return numDoc;
	}

	public int getNumHabitaciones() {
		return numHabitaciones;
	}

	public int getBanios() {
		return banios;
	}

	public int getM2() {
		return m2;
	}

	public double getAlquiler() {
		return alquiler;
	}

	public double getVenta() {
		return venta;
	}

	public String getTipoSuelo() {
		return tipoSuelo;
	}

	public boolean isGarage() {
		return garage;
	}

	public boolean isAscensor() {
		return ascensor;
	}

	public boolean isAmueblado() {
		return amueblado;
	}

	public double getComision() {
		return comision;
	}

	@Override
	public String toString() {
		return "Inmueble [inmuebleId=" + inmuebleId + ", inmuebleLists=" + inmuebleLists + ", descripcion="
				+ descripcion + ", tipoDeInmueble=" + tipoDeInmueble + ", tipoDeOperacion=" + tipoDeOperacion
				+ ", estado=" + estado + ", direccion=" + direccion + ", piso=" + piso + ", dpto=" + dpto + ", ciudad="
				+ ciudad + ", provincia=" + provincia + ", numHabitaciones=" + numHabitaciones + ", banios=" + banios
				+ ", m2=" + m2 + ", alquiler=" + alquiler + ", venta=" + venta + ", tipoSuelo=" + tipoSuelo
				+ ", garage=" + garage + ", ascensor=" + ascensor + ", amueblado=" + amueblado + ", comision="
				+ comision + ", tipoDoc=" + tipoDoc + ", numDoc=" + numDoc + "]";
	}

	

}
