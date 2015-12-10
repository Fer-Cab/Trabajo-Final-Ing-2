package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Inmueble {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long inmuebleId;

	@JsonIgnore
	@ManyToMany
	private List<InmuebleList> inmuebleLists;

	private String descripcion;
	private String tipoDeInmueble;
	private String tipoDeOperacion;
	private String tipoDeEstado;
	private String estado;
	private String direccion;
	private char piso;
	private char dpto;
	private String ciudad;
	private String provincia;
	private ArrayList<String> imagen;
	private char numHabitaciones;
	private char banios;
	private int m2;
	private double alquiler;
	private double venta;
	private String tipoSuelo;
	private boolean garage;
	private boolean ascensor;
	private boolean amueblado;
	private double comision;

	public Inmueble() {
	}

	public Inmueble(String descripcion, String tipoDeInmueble, String tipoDeOperacion, String tipoDeEstado,
			String estado, String direccion, char piso, char dpto, String ciudad, String provincia,
			char numHabitaciones, char banios, int m2, double alquiler, double venta, String tipoSuelo, boolean garage,
			boolean ascensor, boolean amueblado, double comision) {
		super();
		this.descripcion = descripcion;
		this.tipoDeInmueble = tipoDeInmueble;
		this.tipoDeOperacion = tipoDeOperacion;
		this.tipoDeEstado = tipoDeEstado;
		this.estado = estado;
		this.direccion = direccion;
		this.piso = piso;
		this.dpto = dpto;
		this.ciudad = ciudad;
		this.provincia = provincia;
		imagen = new ArrayList<>();
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
	}

	public long getInmuebleId() {
		return inmuebleId;
	}

	public List<InmuebleList> getInmuebleLists() {
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

	public String getTipoDeEstado() {
		return tipoDeEstado;
	}

	public String getEstado() {
		return estado;
	}

	public String getDireccion() {
		return direccion;
	}

	public char getPiso() {
		return piso;
	}

	public char getDpto() {
		return dpto;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getProvincia() {
		return provincia;
	}

	public ArrayList<String> getImagen() {
		return imagen;
	}

	public char getNumHabitaciones() {
		return numHabitaciones;
	}

	public char getBanios() {
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

	public void addImagen(String img) {
		imagen.add(img);
	}

	@Override
	public String toString() {
		return "Inmueble [inmuebleId=" + inmuebleId + ", inmuebleLists=" + inmuebleLists + ", descripcion="
				+ descripcion + ", tipoDeInmueble=" + tipoDeInmueble + ", tipoDeOperacion=" + tipoDeOperacion
				+ ", tipoDeEstado=" + tipoDeEstado + ", estado=" + estado + ", direccion=" + direccion + ", piso="
				+ piso + ", dpto=" + dpto + ", ciudad=" + ciudad + ", provincia=" + provincia + ", imagen=" + imagen
				+ ", numHabitaciones=" + numHabitaciones + ", banios=" + banios + ", m2=" + m2 + ", alquiler=" + alquiler
				+ ", venta=" + venta + ", tipoSuelo=" + tipoSuelo + ", garage=" + garage + ", ascensor=" + ascensor
				+ ", amueblado=" + amueblado + ", comision=" + comision + "]";
	}

}
