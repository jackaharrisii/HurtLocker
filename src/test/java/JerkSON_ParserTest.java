import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class JerkSON_ParserTest {

    private JerkSON_Parser parser;

    @Before
    public void setUp() throws Exception {
        parser = new JerkSON_Parser();
        parser.createObjectArray();
        parser.createAndReturnGroceryList();
//        parser.countUniqueItems();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createObjectArrayTest() {
        String[] expected = new String[]{
            "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016",
            "naME:BreaD;price:1.23;type:Food;expiration:1/02/2016",
            "NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016",
            "naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016",
            "naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016",
            "naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016",
            "naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016",
            "naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016",
            "NAME:MilK;price:3.23;type:Food;expiration:1/17/2016",
            "naMe:MilK;price:1.23;type:Food!expiration:4/25/2016",
            "naMe:apPles;price:0.25;type:Food;expiration:1/23/2016",
            "naMe:apPles;price:0.23;type:Food;expiration:5/02/2016",
            "NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016",
            "naMe:;price:3.23;type:Food;expiration:1/04/2016",
            "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016",
            "naME:BreaD;price:1.23;type:Food@expiration:1/02/2016",
            "NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016",
            "naMe:MiLK;priCe:;type:Food;expiration:1/11/2016",
            "naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016",
            "naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016",
            "naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016",
            "naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016",
            "NAME:MilK;price:3.23;type:Food;expiration:1/17/2016",
            "naMe:MilK;priCe:;type:Food;expiration:4/25/2016",
            "naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016",
            "naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016",
            "NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016",
            "naMe:;price:3.23;type:Food^expiration:1/04/2016"
        };
        Assert.assertEquals(expected, parser.getObjectArray());
        Assert.assertEquals(28, parser.getObjectArray().length);
    }

    @Test
    public void testCreateAndReturnGroceryList(){
        Assert.assertEquals(24, parser.getGroceryList().size());
        Assert.assertEquals("milk", parser.getGroceryList().get(0).getName());
        Assert.assertEquals("3.23", parser.getGroceryList().get(0).getPrice());
        Assert.assertEquals("food", parser.getGroceryList().get(0).getType());
        Assert.assertEquals("1/25/2016", parser.getGroceryList().get(0).getExpiration());

        // THIS IS THE WEIRD COOKIE SPELLING WITH THE ZERO INSTEAD OF THE O
        Assert.assertEquals("cookies", parser.getGroceryList().get(17).getName());

        Assert.assertEquals("bread", parser.getGroceryList().get(parser.getGroceryList().size()-1).getName());
        Assert.assertEquals("1.23", parser.getGroceryList().get(parser.getGroceryList().size()-1).getPrice());
        Assert.assertEquals("food", parser.getGroceryList().get(parser.getGroceryList().size()-1).getType());
        Assert.assertEquals("1/25/2016", parser.getGroceryList().get(parser.getGroceryList().size()-1).getExpiration());
    }

    @Test
    public void countErrorsTest(){
        Assert.assertEquals(4, parser.countErrors());
    }

    @Test
    public void countUniqueItemsTest(){
        // REPLACE ALL INSANCES OF xxxx WITH Xxxx ONCE I GET THE REGEX WORKING
        Assert.assertEquals(6, parser.getUniqueItemsCount().get("milk"), 0.0001);
        Assert.assertEquals(6, parser.getUniqueItemsCount().get("bread"), 0.0001);
        Assert.assertEquals(8, parser.getUniqueItemsCount().get("cookies"), 0.0001);
        Assert.assertEquals(4, parser.getUniqueItemsCount().get("apples"), 0.0001);
    }

}