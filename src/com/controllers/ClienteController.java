package com.controllers;

import com.model.Cliente;
import com.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void createCliente(@RequestBody Cliente cliente) {
		clienteService.createCliente(cliente);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void updateCliente(@RequestBody Cliente cliente) {
		clienteService.updateCliente(cliente);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void deleteCliente(@RequestBody Cliente cliente) {
		clienteService.deleteCliente(cliente.getClienteId());
	}

	@RequestMapping(value = "/TipoDocAndNumDoc/{tipoDoc}&{numDoc}", method = RequestMethod.GET)
	public Cliente getClienteByTipoDocAndNumDoc(@PathVariable("tipoDoc") String tipoDoc, @PathVariable("numDoc") int numDoc) {
		return clienteService.findByTipoDocAndNumDoc(tipoDoc, numDoc);

	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public String getAllClientes() {
		return clienteService.getAllClientes();
	}

}