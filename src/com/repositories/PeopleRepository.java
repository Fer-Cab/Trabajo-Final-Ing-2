package com.repositories;

import java.util.List;

import com.model.Account;

public interface PeopleRepository {
		
	Object findByTipoDocAndNumDoc(String tipoDoc,int numDoc);

	Object save(Object object);

	void delete(Long id);

	List<Object> findAll();
	
	Account findByUserName(String userName);

}
