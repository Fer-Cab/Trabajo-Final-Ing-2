package com.controllers;

import com.model.Empleado;
import com.service.EmpleadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/empleado")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void createEmpleado(@RequestBody Empleado empleado) {
		empleadoService.createEmpleado(empleado);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void updateEmpleado(@RequestBody Empleado empleado) {
		empleadoService.updateEmpleado(empleado);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void deleteEmpleado(@RequestBody Empleado empleado) {
		empleadoService.deleteEmpleado(empleado.getEmpleadoId());
	}

	@RequestMapping(value = "/TipoDocAndNumDoc/{tipoDoc}&{numDoc}", method = RequestMethod.GET)
	public Empleado getEmpleadoByTipoDocAndNumDoc(@PathVariable("tipoDoc") String tipoDoc, @PathVariable("numDoc") int numDoc) {
		return empleadoService.findByTipoDocAndNumDoc(tipoDoc, numDoc);

	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getAllEmpleados() {
		return empleadoService.getAllEmpleados();
	}

}