/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.globant.ioncases.controller;

import edu.globant.ioncases.entity.Cart;
import edu.globant.ioncases.entity.Case;
import edu.globant.ioncases.entity.Customer;
import edu.globant.ioncases.entity.Device;
import edu.globant.ioncases.entity.DeviceType;
import edu.globant.ioncases.entity.StoreSeller;
import edu.globant.ioncases.service.CustomerService;
import edu.globant.ioncases.service.CustomerServiceImpl;
import edu.globant.ioncases.service.EmployeeService;
import edu.globant.ioncases.service.EmployeeServiceImpl;
import edu.globant.ioncases.service.InventoryService;
import edu.globant.ioncases.service.InventoryServiceImpl;
import edu.globant.ioncases.service.SellerService;
import edu.globant.ioncases.service.SellerServiceImpl;
import java.util.Map;

/**
 *
 * @author fedec
 */
public class MainTest {

    public static void main(String[] args) {

        // Make a customer
        System.out.println("--------------------------CUSTOMER--------------------------------------------");
        CustomerService customerService = new CustomerServiceImpl();

        customerService.newCustomer(new Customer(0, "Federico Gaston Calarco", 22, 'M', "La Plata"));
        customerService.newCustomer(new Customer(1, "Homer Jay Simpson ", 38, 'M', "Springfield"));

        Customer customer1 = customerService.getCustomerById(1);

        // Devices
        Device iphone6 = new Device(DeviceType.CELLPHONE, "Iphone 6");
        Device motoG = new Device(DeviceType.CELLPHONE, "Motorola Moto G (3rd Generation)");

        Device iPadAir = new Device(DeviceType.TABLET, "Apple iPad Air MD785LL/B");

        // Cases
        Case caseBatmanEdition = new Case("Batman edition", 20);
        caseBatmanEdition.addCompatibleDevice(iphone6);
        caseBatmanEdition.addCompatibleDevice(motoG);

        Case casePink = new Case("Case pink", 5);
        casePink.addCompatibleDevice(iPadAir);

        // Inventory
        System.out.println("------------------------------INVENTORY----------------------------------------");
        
        InventoryService inventory = new InventoryServiceImpl();

        inventory.addStock(casePink, 200);
        inventory.addStock(caseBatmanEdition, 6);


        showAllStock(inventory.getAllStock());
        
        // Shopping cart
        Cart shoppingCart = new Cart();

        //   shoppingCart.addElementsToCart(caseBatmanEdition, 3);
        // Make a seller 
        SellerService sellerService = new SellerServiceImpl();

   //     sellerService.newSale(customer1, shoppingCart);
    
        
// StoreSeller
        EmployeeService employeeService = new EmployeeServiceImpl();

        employeeService.addEmployee(new StoreSeller("Federico"));

        System.out.println("-> " + employeeService.getEmployee(0).getJobTitle());

    // 
    }

    public static void showAllStock(Map<Case,Integer> inventory) {
         
        System.out.println("--------------------------------Show all stock-----------------------");
        
        inventory.forEach((caseCover, stock) -> {
            System.out.println("Case: " + caseCover.getDesign() + "Stock: " + stock);
        });
        
        System.out.println("----------------------------------------------------------------------");
    }

}
