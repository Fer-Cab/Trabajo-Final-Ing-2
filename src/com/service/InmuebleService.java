package com.service;

import java.util.List;

import com.model.Inmueble;
import com.repositories.InmuebleRepository;


public class InmuebleService {


	private InmuebleRepository inmuebleRepository;

	public InmuebleService() {
	}

	public Inmueble createInmueble(Inmueble inmueble) {
		return inmuebleRepository.save(inmueble);
	}

	public String getAllInmuebles() {

		return inmuebleRepository.findAll().toString();
	}

	public void updateInmueble(Inmueble inmueble) {
		inmuebleRepository.save(inmueble);
	}

	public void deleteInmueble(Long id) {
		inmuebleRepository.delete(id);
	}

	public Inmueble getInmuebleByDireccionAndPisoAndDpto(String direccion, char piso, char dpto) {
		return inmuebleRepository.findByDireccionAndPisoAndDpto(direccion, piso, dpto);
	}

	public List<Inmueble> getInmuebleByTipoDeInmueble(String tipoDeInmueble) {
		return inmuebleRepository.findByTipoDeInmueble(tipoDeInmueble);
	}

	public List<Inmueble> getInmuebleByTipoDeOperacion(String tipoDeOperacion) {
		return inmuebleRepository.findByTipoDeOperacion(tipoDeOperacion);
	}

	public List<Inmueble> getInmuebleByTipoDeEstado(String tipoDeEstado) {
		return inmuebleRepository.findByTipoDeEstado(tipoDeEstado);
	}

	public List<Inmueble> getInmuebleByCiudad(String ciudad) {
		return inmuebleRepository.findByCiudad(ciudad);
	}

	public List<Inmueble> getInmuebleByNumHabitaciones(char numHabitaciones) {
		return inmuebleRepository.findByNumHabitaciones(numHabitaciones);
	}

	public List<Inmueble> getInmuebleByM2(int m2) {
		return inmuebleRepository.findByM2(m2);
	}

	public List<Inmueble> getInmuebleByAlquiler(double alquiler) {
		return inmuebleRepository.findByAlquiler(alquiler);
	}

	public List<Inmueble> getInmuebleByVenta(double venta) {
		return inmuebleRepository.findByVenta(venta);
	}

}
