package ilan.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import ilan.models.Inventory;

public interface InventoryDao extends JpaRepository<Inventory,Long>{

}
