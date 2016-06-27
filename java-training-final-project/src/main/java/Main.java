import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import edu.globant.finalProject.model.Case.Case;
import edu.globant.finalProject.model.Case.CellphoneCase;
import edu.globant.finalProject.model.Case.Design;
import edu.globant.finalProject.model.Case.Device;
import edu.globant.finalProject.model.Employee.Employee;
import edu.globant.finalProject.model.Employee.Logistic;
import edu.globant.finalProject.model.Employee.Seller;
import edu.globant.finalProject.model.Employee.TypeOfEmployee;
import edu.globant.finalProject.model.Inventory.Inventory;
import edu.globant.finalProject.model.Provider.CellphoneProvider;
import edu.globant.finalProject.model.Provider.Provider;
import edu.globant.finalProject.model.Provider.TabletProvider;


public class Main {
	
	public static void main(String[] args) {
		TypeOfEmployee logistic = new Logistic();
		TypeOfEmployee seller = new Seller();
		
		Employee emp1 = new Employee("dante", logistic);
		Employee emp2 = new Employee("fede", seller);
		Employee emp3 = new Employee("cris", seller);
		Employee emp4 = new Employee("gio", logistic);
		
		Provider realCase = new CellphoneProvider();
		Provider omCase = new TabletProvider();
		
		TreeSet<Provider> setProviders = new TreeSet<Provider>();
		setProviders.add(realCase);
		
		Device iphone = new Device("iphone","s6");
		ArrayList<Device> devices = new ArrayList<Device>();
		devices.add(iphone);
		Design design = new Design("black",0.54,0.65);
		
		Case kase = new CellphoneCase(0, "iphoneCase", setProviders, devices, design, 400.00, 5);
		HashMap<Case,Integer> cases = new HashMap<Case,Integer>();
		cases.put(kase,10);
		
		Inventory inventory = new Inventory();
		inventory.setCases(cases);
		
		showAllStock(inventory);
	}

	private static void showAllStock(Inventory inventory) {
		//inventory.getCases().for
		
	}
	
}
