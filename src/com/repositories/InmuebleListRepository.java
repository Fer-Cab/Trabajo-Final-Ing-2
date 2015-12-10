package com.repositories;

import java.util.List;
import com.model.InmuebleList;

public interface InmuebleListRepository{

	InmuebleList save(InmuebleList inmuebleList);

	void delete(Long id);

	//List<InmuebleList> findByClienteTipoDocAndNumDoc(String tipoDoc, int numDoc);

	//List<InmuebleList> findByPropietarioTipoDocAndNumDoc(String tipoDoc, int numDoc);

	//InmuebleList findByClienteTipoDocAndNumDocAndInmuebleListId(String tipoDoc, int numDoc, long inmuebleListId);

//	InmuebleList findByPropietarioTipoDocAndNumDocAndInmuebleListId(String tipoDoc, int numDoc, long inmuebleListId);
}
