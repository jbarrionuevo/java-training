package edu.globant.day6.exercises.DAO;

import org.springframework.data.repository.CrudRepository;

import edu.globant.day6.exercises.model.Device;

public interface DeviceDAO extends CrudRepository<Device, Long> {

}
