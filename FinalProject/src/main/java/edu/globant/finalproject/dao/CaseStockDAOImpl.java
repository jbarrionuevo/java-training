package edu.globant.finalproject.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import edu.globant.finalproject.hibernate.CaseStock;
import edu.globant.finalproject.model.Inventory.CaseStockDTO;

@Repository
public class CaseStockDAOImpl extends GenericDAOImpl<CaseStock, Integer> implements CaseStockDAO{
	
}
