package com.controllers;

import com.model.Propietario;
import com.service.PropietarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/propietario")
public class PropietarioController {

	@Autowired
	private PropietarioService propietarioService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void createPropietario(@RequestBody Propietario propietario) {
		propietarioService.createPropietario(propietario);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void updatePropietario(@RequestBody Propietario propietario) {
		propietarioService.updatePropietario(propietario);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void deletePropietario(@RequestBody Propietario propietario) {
		propietarioService.deletePropietario(propietario.getPropietarioId());
	}

	@RequestMapping(value = "/TipoDocAndNumDoc/{tipoDoc}&{numDoc}", method = RequestMethod.GET)
	public Propietario getPropietarioByTipoDocAndNumDoc(@PathVariable("tipoDoc") String tipoDoc, @PathVariable("numDoc") int numDoc) {
		return propietarioService.findByTipoDocAndNumDoc(tipoDoc, numDoc);

	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getAllPropietarios() {
		return propietarioService.getAllPropietarios();
	}

	
}