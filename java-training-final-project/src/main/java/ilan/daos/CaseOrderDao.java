package ilan.daos;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import ilan.models.CaseOrder;
import ilan.models.ThirdPartyParticipant;


public interface CaseOrderDao extends JpaRepository<CaseOrder,Long>{
	Collection<CaseOrder> findByThirdPartyParticipant(ThirdPartyParticipant thirdPartyParticipant);
}
