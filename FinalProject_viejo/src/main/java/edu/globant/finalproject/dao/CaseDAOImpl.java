package edu.globant.finalproject.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import edu.globant.finalproject.model.Case.CaseDTO;
import edu.globant.finalproject.model.Case.DesignDTO;
import edu.globant.finalproject.model.Case.DeviceDTO;



@Repository
public class CaseDAOImpl implements CaseDAO{

	public void save(CaseDTO c) {
		System.out.println("guardo en la bd el case: "+c.getPrice());
	}

	public ArrayList<CaseDTO> getAll() {
//		ArrayList<CaseDTO> cases = generarDatosPrueba();
		return new ArrayList<CaseDTO>();
	}

//	private ArrayList<CaseDTO> generarDatosPrueba() {
//		ArrayList<CaseDTO> cases = new ArrayList<CaseDTO>();
//		ArrayList<DeviceDTO> devices = new ArrayList<DeviceDTO>();
//		DeviceDTO d = new DeviceDTO("Iphone","6s");
//		DeviceDTO d2 = new DeviceDTO("Samsung","S6 Edge");
//		DesignDTO de = new DesignDTO("red", 0.21, 0.68);
//		
//		devices.add(d);
//		devices.add(d2);
//		
//		System.out.println("busco todos los cases en la bd y los devuelvo");
//		CaseDTO c = new CaseDTO("prueba1","asda221", devices, de , 500.00);
//		cases.add(c);
//		return cases;
//	}

}
