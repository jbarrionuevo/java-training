package ilan.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import ilan.models.Provider;


public interface ProviderDao extends JpaRepository<Provider,Long>{

}
