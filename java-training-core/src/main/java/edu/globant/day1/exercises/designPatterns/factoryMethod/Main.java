/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.day1.exercises.designPatterns.factoryMethod;


import edu.globant.day1.exercises.designPatterns.Entity.Employee;
import java.util.Scanner;

/**
 *
 * @author fedec
 */
public class Main {

    public static void main(String... args) {

        Employee employee1;
        FactorySeller factory;
/*
        // Store seller
        factory = new FactoryStoreSeller();
        employee1 = factory.getSeller();
        employee1.setFullname("Federico Gaston Calarco");
        showEmployee(employee1);

        System.out.println("<><><><><><><><><><><><><><><>");

        // Delivey Seller
        factory = new FactoryDeliverySeller();
        employee1 = factory.getSeller();
        employee1.setFullname("Gaston Federico Calarco");
        showEmployee(employee1);
*/
        System.out.println("Create seller");
        
        
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Employee name: ");
            String fullname = scanner.nextLine();

            System.out.println("Choose type of Seller: 0 -> Store Seller || 1 -> Delivery Seller");
            factory = getSeller(scanner.nextInt());
            employee1 = factory.getSeller();
            employee1.setFullname(fullname);

            
            showEmployee(employee1);

        } catch (Exception e) {

        }

    }

    public static void showEmployee(Employee emp) {
        System.out.println(String.format("%s: %s", emp.getJobTitle(), emp.getFullname()));
    }

    public static FactorySeller getSeller(int type) {
        return type == 0 ? new FactoryStoreSeller() : new FactoryDeliverySeller();
    }
}
