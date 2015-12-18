package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Account {

	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long accountId;

	@JsonIgnore
	private String password;
	private String userName;
	private String permisos;

	
	public Account(String name, String password,String permisos) {
		
		this.userName = name;
		this.password = password;
		this.permisos = permisos;
	}

	
	Account() {
	}

	
	public Account(long accountId,String name, String password,String permisos) {
		this.accountId =accountId;
		this.userName = name;
		this.password = password;
		this.permisos = permisos;
	}


	public Long getAccountId() {
		return accountId;
	}


	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}
	
	public String getPermisos(){
		return permisos;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((permisos == null) ? 0 : permisos.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (permisos == null) {
			if (other.permisos != null)
				return false;
		} else if (!permisos.equals(other.permisos))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	
	public boolean equals(String newUserName){
		boolean exist = false;
		
		if(userName.equalsIgnoreCase(newUserName)){
			exist=true;
		}
		return exist;
	}


	@Override
	public String toString() {
		return "Account [ userName=" + userName + ", password=" + password + ", permisos="
				+ permisos + "]";
	}
	
	
	
}