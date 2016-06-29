package edu.globant.day6.exercises.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.globant.day6.exercises.DAO.DeviceDAO;
import edu.globant.day6.exercises.model.Device;

@Service
public class DeviceService {
	@Autowired
	DeviceDAO deviceDAO;

	public DeviceDAO getDeviceDAO() {
		return deviceDAO;
	}

	public void setDeviceDAO(DeviceDAO deviceDAO) {
		this.deviceDAO = deviceDAO;
	}

	public void saveDevice(Device aDevice) {
		deviceDAO.save(aDevice);
	}
}
