package ilan.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import ilan.models.CaseDesign;

public interface CaseDesignDao extends  JpaRepository<CaseDesign,Long>{

}
