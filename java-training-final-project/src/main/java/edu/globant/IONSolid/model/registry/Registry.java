package edu.globant.IONSolid.model.registry;

import java.util.Map;

import edu.globant.IONSolid.model.registry.exception.NotFoundRegisterException;

public interface Registry<T1, T> {
	
	public T getRegister(T1 id) throws NotFoundRegisterException;
	
	public void insertRegister(T object) throws NotFoundRegisterException;
	
	public void updateRegister(T object)  throws NotFoundRegisterException;
	
	public boolean isRegisterRegistered(T object)  throws NotFoundRegisterException;
	
	public boolean isRegisterRegisteredById(T1 object);
	
	public Map<T1, T> getAllRegisters();
}
