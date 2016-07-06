package ilan.daos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import ilan.models.OrderAlert;

public interface OrderAlertDao extends JpaRepository<OrderAlert,Long>{

	OrderAlert findByProductId(Long id);
	Collection<OrderAlert> findByMade(Boolean made);

}
