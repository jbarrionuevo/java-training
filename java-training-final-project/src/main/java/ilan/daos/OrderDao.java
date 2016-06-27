package ilan.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import ilan.models.Order;


public interface OrderDao extends JpaRepository<Order,Long>{

}
