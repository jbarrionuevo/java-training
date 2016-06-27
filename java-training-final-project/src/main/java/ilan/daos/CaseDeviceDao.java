package ilan.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import ilan.models.CaseDevice;

public interface CaseDeviceDao extends JpaRepository<CaseDevice,Long>{
	public CaseDevice findByName(String name);
}
