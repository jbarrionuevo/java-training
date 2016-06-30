package edu.globant.IONSolid.model.registry;

import java.util.HashMap;
import java.util.Map;

import edu.globant.IONSolid.model.registry.exception.AlreadyExistRegisterException;
import edu.globant.IONSolid.model.registry.exception.NotFoundRegisterException;

public class Registry<T1, T> {

	private Map<T1, T> registry;

	public Registry() {
		this.registry = new HashMap<T1, T>();
	}

	public T getRegister(T1 id) throws NotFoundRegisterException {
		if (isRegisterRegistered(id)) {
			return this.registry.get(id);
		} else {
			throw new NotFoundRegisterException("The register with : " + id + " was not found");
		}
	}

	public void insertRegister(T1 id, T object) throws AlreadyExistRegisterException {
		if (!isRegisterRegistered(id)) {
			// Inserts new Sale
			this.registry.put(id, object);
		} else {
			throw new AlreadyExistRegisterException("The register: " + id + " already exists");
		}
	}

	public void updateRegister(T1 id, T object) throws NotFoundRegisterException {
		if (isRegisterRegistered(id)) {
			// Overrides old sale
			this.registry.put(id, object);
		} else {
			throw new NotFoundRegisterException("The register with : " + id + " was not found");
		}
	}

	public boolean isRegisterRegistered(T1 id) {
		return this.registry.containsKey(id);

	}

	public Map<T1, T> getAllRegisters() {
		return this.registry;
	}
}
