package com.service;

import com.model.Propietario;
import com.repositories.PropietarioRepository;




public class PropietarioService {


	private PropietarioRepository propietarioRepository;

	public PropietarioService() {
	}

	public Propietario createPropietario(Propietario propietario) {
		return propietarioRepository.save(propietario);
	}

	public Propietario findByTipoDocAndNumDoc(String tipoDoc,int numDoc) {
		return propietarioRepository.findByTipoDocAndNumDoc(tipoDoc, numDoc);
	}

	public void updatePropietario(Propietario propietario) {
		propietarioRepository.save(propietario);
	}

	public void deletePropietario(Long id) {
		propietarioRepository.delete(id);
	}
	
	public String getAllPropietarios() {

		return propietarioRepository.findAll().toString();
	}
}