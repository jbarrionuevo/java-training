package edu.globant.testing.integration;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EmployeeServiceIT.class, EmployeeServiceSpringInjectionIT.class })
public class AllTestsIT {

}
