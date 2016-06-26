package dependencyInjection.excercices;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	
	public static void main(String[] args) {

	    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	    ApplicationManager manager = (ApplicationManager) context.getBean("applicationManager");
	    SaleEmployee emp = new SaleEmployee("Pablo");
	    Sale newSale = new Sale("Axc0124", emp);
	    newSale = manager.registerASale(newSale);
	    System.out.println("Employee Name " + newSale.getEmployee().getName());
	    manager.checkInventory();
	}
}
