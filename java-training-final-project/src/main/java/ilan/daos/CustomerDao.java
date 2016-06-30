package ilan.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import ilan.models.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long>{

}
