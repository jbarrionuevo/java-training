package ilan.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import ilan.models.Case;

public interface CaseDao extends JpaRepository<Case,Long>{

}
