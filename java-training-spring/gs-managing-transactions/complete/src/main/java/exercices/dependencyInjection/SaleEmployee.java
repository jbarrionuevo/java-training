package exercices.dependencyInjection;

public class SaleEmployee {

	private String name;
	
	public SaleEmployee(String name) {
		this.name = name;
	}
	
	String getName() {
		return this.name;
	}
}
