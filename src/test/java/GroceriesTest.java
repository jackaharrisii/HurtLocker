import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GroceriesTest {

    Groceries groceries;
    Groceries groceriessssss;

    @Before
    public void setUp() throws Exception {
        groceries = new Groceries("Butter", "3.50", "Food", "1/10/1982");
        groceriessssss = new Groceries("Butter", "3.50", "Food", "1/10/1982", 5);

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

    @Test
    public void getMultiplesTest(){
        Assert.assertEquals(5, groceriessssss.getMultiples(), 0.0001);
    }

    @Test
    public void setMultiplesTest(){
        groceriessssss.setMultiples(8);
        Assert.assertEquals(8, groceriessssss.getMultiples(),0.0001);
    }
}