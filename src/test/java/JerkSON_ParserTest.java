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
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createObjectArrayTest() {
//        ArrayList<String> expected = new ArrayList<>();
//        expected.add("Milk");
//        expected.add("BreaD");
//        expected.add("BrEAD");
//        expected.add("MiLK");
//        expected.add("Cookies");
//        expected.add("CoOkieS");
//        expected.add("COokIes");
//        expected.add("COOkieS");
//        expected.add("MilK");
//        expected.add("MilK");
//        expected.add("apPles");
//        expected.add("apPles");
//        expected.add("BrEAD");
//        expected.add("Milk");
//        expected.add("BreaD");
//        expected.add("BrEAD");
//        expected.add("MiLK");
//        expected.add("Cookies");
//        expected.add("CoOkieS");
//        expected.add("COokIes");
//        expected.add("COOkieS");
//        expected.add("MilK");
//        expected.add("MilK");
//        expected.add("apPles");
//        expected.add("apPles");
//        expected.add("BrEAD");
//        parser.createObjectList();
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
        parser.createObjectArray();
        Assert.assertEquals(expected, parser.getObjectArray());
    }

    @Test
    public void testGroupingOnObjectTest(){
        String expected = "Name is Milk\nPrice is 3.23";
        Assert.assertEquals(expected,parser.tryGroupingOnObject());
    }

    @Test
    public void countAnObject() {
    }

    @Test
    public void countAllObjects() {
    }
}