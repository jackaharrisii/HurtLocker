import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GroceriesTest {

    Groceries groceries;

    @Before
    public void setUp() throws Exception {
        groceries = new Groceries("Butter", "3.50", "Food", "1/10/1982");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getName() {
        Assert.assertEquals("Butter", groceries.getName());
    }

    @Test
    public void getPrice() {
        Assert.assertEquals("3.50", groceries.getPrice());
    }

    @Test
    public void getType() {
        Assert.assertEquals("Food", groceries.getType());
    }

    @Test
    public void getExpiration() {
        Assert.assertEquals("1/10/1982", groceries.getExpiration());
    }
}