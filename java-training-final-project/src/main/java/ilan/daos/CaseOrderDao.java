package ilan.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import ilan.models.CaseOrder;


public interface CaseOrderDao extends JpaRepository<CaseOrder,Long>{

}
