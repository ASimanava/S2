package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestLogin.class,
        TestDashboard.class,
        TestSimpleOrder.class,
        TestAddCoreProduct.class,
        TestDeleteCoreProduct.class,
} )

public class TestRunner {

}