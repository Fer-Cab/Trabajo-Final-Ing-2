package com.service;

import com.model.Empleado;
import com.repositories.EmpleadoRepository;




public class EmpleadoService {

	private EmpleadoRepository empleadoRepository;

	public EmpleadoService() {
	}

	public Empleado createEmpleado(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}

	public Empleado findByTipoDocAndNumDoc(String tipoDoc,int numDoc){
		return empleadoRepository.findByTipoDocAndNumDoc(tipoDoc, numDoc);
	}

	public void updateEmpleado(Empleado empleado) {
		empleadoRepository.save(empleado);
	}

	public void deleteEmpleado(Long id) {
		empleadoRepository.delete(id);
	}
	
	public String getAllEmpleados() {

		return empleadoRepository.findAll().toString();
	}

}