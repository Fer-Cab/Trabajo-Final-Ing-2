package com.service;

import java.util.Collection;


import com.model.Cliente;
import com.model.Inmueble;
import com.model.InmuebleList;
import com.model.Propietario;
import com.repositories.InmuebleListRepository;



public class InmuebleListService {


	private InmuebleListRepository inmuebleListRepository;

	public InmuebleListService() {
	}

	public InmuebleList createInmuebleList(InmuebleList inmuebleList) {
		return inmuebleListRepository.save(inmuebleList);
	}

	public void updateInmuebleList(InmuebleList inmuebleList) {
		inmuebleListRepository.save(inmuebleList);
	}

	public void deleteInmuebleList(Long id) {
		inmuebleListRepository.delete(id);
	}

/*	public InmuebleList getInmuebleListByCliente(Cliente clt, long inmuebleListId) {

		// System.out.println(inmuebleListRepository.findByClienteTipoDocAndNumDocAndInmuebleListId(clt.getTipoDoc(),
		// clt.getNumDoc(), inmuebleListId));

		return inmuebleListRepository.findByClienteTipoDocAndNumDocAndInmuebleListId(clt.getTipoDoc(), clt.getNumDoc(),
				inmuebleListId);

	}

	public InmuebleList getInmuebleListByPropietario(Propietario prop, long inmuebleListId) {

		// System.out.println(inmuebleListRepository.findByPropietarioTipoDocAndNumDocAndInmuebleListId(prop.getTipoDoc(),
		// prop.getNumDoc(), inmuebleListId));

		return inmuebleListRepository.findByPropietarioTipoDocAndNumDocAndInmuebleListId(prop.getTipoDoc(),
				prop.getNumDoc(), inmuebleListId);

	}*/

/*	public Collection<InmuebleList> findByClienteTipoDocAndNumDoc(String tipoDoc, int numDoc) {

		return inmuebleListRepository.findByClienteTipoDocAndNumDoc(tipoDoc, numDoc);
	}

	public Collection<InmuebleList> findByPropietarioTipoDocAndNumDoc(String tipoDoc, int numDoc) {

		return inmuebleListRepository.findByPropietarioTipoDocAndNumDoc(tipoDoc, numDoc);
	}*/

	public void addInmueble(Object obj, long inmuebleListId, Inmueble inmueble) {
/*
		if (obj.getClass() == Cliente.class) {
			Cliente other = (Cliente) obj;
			InmuebleList inmuebleList = inmuebleListRepository.findByClienteTipoDocAndNumDocAndInmuebleListId(
					other.getTipoDoc(), other.getNumDoc(), inmuebleListId);

			System.out.println(inmuebleList);

			inmuebleList.inmuebles.add(inmueble);

			System.out.println(inmuebleList);

			inmuebleListRepository.save(inmuebleList);

			System.out.println(inmuebleList);
		}

		else

		if (obj.getClass() == Propietario.class) {
			Propietario other = (Propietario) obj;
			InmuebleList inmuebleList = inmuebleListRepository.findByPropietarioTipoDocAndNumDocAndInmuebleListId(
					other.getTipoDoc(), other.getNumDoc(), inmuebleListId);

			System.out.println(inmuebleList);

			inmuebleList.inmuebles.add(inmueble);

			System.out.println(inmuebleList);

			inmuebleListRepository.save(inmuebleList);

			System.out.println(inmuebleList);
		}*/

	}

}
