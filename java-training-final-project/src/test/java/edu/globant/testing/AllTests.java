package edu.globant.testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EmployeeServiceIT.class, EmployeeServiceSpringInjectionIT.class,
	EmployeeTest.class, SellTest.class, SellServiceIT.class })
public class AllTests {

}
 