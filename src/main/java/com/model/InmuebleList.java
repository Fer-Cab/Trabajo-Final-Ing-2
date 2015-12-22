package com.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class InmuebleList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long inmuebleListId;

	
	@JsonIgnore
	@ManyToOne
	private Cliente cliente;
	

	@JsonIgnore
	@ManyToOne
	private Propietario propietario;

	@ManyToMany
	public List<Inmueble> inmuebles;
	
	
	public InmuebleList() {
		inmuebles = new ArrayList<Inmueble>();
		
	}

	public InmuebleList(Cliente cliente) {
	
		this.cliente = cliente;

	}
	public InmuebleList(Propietario propietario) {
		
		this.propietario = propietario;

	}

	@Override
	public String toString() {
		if (cliente != null)
		return "InmuebleList [cliente=" + cliente + ", inmuebles=" + inmuebles + "]";
		
		else if (propietario != null)
			return "InmuebleList [propietario=" + propietario + ", inmuebles=" + inmuebles + "]";
		
		else return null;
	}
	

}