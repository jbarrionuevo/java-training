package edu.globant.IONSolid.services;

public interface Registry<T> {
	
	public T getRegister(String id);
	
	public void insertRegister(T object);
	
	public void updateRegister(T object);
	
	public boolean isRegisterRegistered(T object);
}
