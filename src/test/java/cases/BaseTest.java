package cases;

import com.sun.istack.internal.Interned;
import framework.drivers.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public abstract class BaseTest {

    @BeforeTest
    public void setUp() {
    }

    @Interned
    @Test
    public abstract void test();

    @AfterTest
    public void tearDown() {

    }
}
