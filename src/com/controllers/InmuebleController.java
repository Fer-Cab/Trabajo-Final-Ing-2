package com.controllers;

import java.util.List;

import com.model.Inmueble;
import com.service.InmuebleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/inmueble")
public class InmuebleController {

	@Autowired
	private InmuebleService inmuebleService;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void createInmueble(@RequestBody Inmueble inmueble) {
		inmuebleService.createInmueble(inmueble);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getAllInmueble() {
		return inmuebleService.getAllInmuebles();
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void updateInmueble(@RequestBody Inmueble inmueble) {
		inmuebleService.updateInmueble(inmueble);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void deleteInmueble(@RequestBody Inmueble inmueble) {
		inmuebleService.deleteInmueble(inmueble.getInmuebleId());
	}

	@RequestMapping(value = "/findByName/{direccion}&{piso}&{dpto}", method = RequestMethod.GET)
	public Inmueble getInmuebleByDireccionAndPisoAndDpto(@PathVariable("direccion") String direccion,@PathVariable("piso") char piso,
	@PathVariable("dpto") char dpto) {
		return inmuebleService.getInmuebleByDireccionAndPisoAndDpto(direccion, piso, dpto);
	}

	@RequestMapping(value = "/findByCiudad/{ciudad}", method = RequestMethod.GET)
	public List<Inmueble> getInmuebleByCiudad(@PathVariable("ciudad") String ciudad) {
		return inmuebleService.getInmuebleByCiudad(ciudad);
	}
	
/*
	public List<Inmueble> getInmuebleByTipoDeInmueble(String tipoDeInmueble) {
		return inmuebleRepository.findByTipoDeInmueble(tipoDeInmueble);
	}
	public List<Inmueble> getInmuebleByTipoDeOperacion(String tipoDeOperacion) {
		return inmuebleRepository.findByTipoDeOperacion(tipoDeOperacion);
	}
	public List<Inmueble> getInmuebleByTipoDeEstado(String tipoDeEstado) {
		return inmuebleRepository.findByTipoDeEstado(tipoDeEstado);
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
 */
}
