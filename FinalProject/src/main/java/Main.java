import java.util.ArrayList;

import edu.globant.finalproject.dao.CaseDAO;
import edu.globant.finalproject.dao.CaseDAOImpl;
import edu.globant.finalproject.dao.CaseStockDAO;
import edu.globant.finalproject.dao.CaseStockDAOImpl;
import edu.globant.finalproject.hibernate.CaseCoverage;
import edu.globant.finalproject.hibernate.CaseStock;
import edu.globant.finalproject.hibernate.Design;
import edu.globant.finalproject.hibernate.Device;
import edu.globant.finalproject.model.Case.DesignDTO;

public class Main {
	public static void main(String[] args) {
		CaseStockDAO cda = new CaseStockDAOImpl();
		CaseStock cw = new CaseStock();
		
		Design d = new Design("red",1.21,0.25);
		ArrayList<Device> devices = new ArrayList<Device>();
		Device dev = new Device("asda","asdas");
		devices.add(dev);
		
		CaseCoverage casee = new CaseCoverage("prueba", "1231231", devices, d, 545);
		CaseCoverage casee2 = new CaseCoverage("prueba2", "1231", devices, d, 55);
		
		cw.setActualStock(10);
		cw.setKase(casee);
	
		cda.add(cw);
	}
}
