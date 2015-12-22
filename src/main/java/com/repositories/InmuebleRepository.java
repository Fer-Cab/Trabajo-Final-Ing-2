package com.repositories;

import java.util.List;



import com.model.Inmueble;

public interface InmuebleRepository  {

	Inmueble findByDireccionAndPisoAndDpto(String direccion, char piso, char dpto);

	List<Inmueble> findByTipoDeInmueble(String tipoDeInmueble);

	List<Inmueble> findByTipoDeOperacion(String tipoDeOperacion);

	List<Inmueble> findByTipoDeEstado(String tipoDeEstado);

	List<Inmueble> findByCiudad(String ciudad);

	List<Inmueble> findByNumHabitaciones(char numHabitaciones);

	List<Inmueble> findByM2(int m2);

	List<Inmueble> findByAlquiler(double alquiler);

	List<Inmueble> findByVenta(double venta);

	Inmueble save(Inmueble inmueble);

	Object findAll();

	void delete(Long id);

}
