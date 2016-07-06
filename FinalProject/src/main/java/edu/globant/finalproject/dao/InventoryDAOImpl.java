package edu.globant.finalproject.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.globant.finalproject.hibernate.CaseCoverage;
import edu.globant.finalproject.hibernate.CaseStock;
import edu.globant.finalproject.model.Inventory.InventoryDTO;


@Repository
public class InventoryDAOImpl extends GenericDAOImpl<InventoryDTO, Integer> implements InventoryDAO {

}
