import java.util.Map;

public class ResultsGenerator {

    // CREATE INSTANCES OF CLASSES
    JerkSON_Parser parser = new JerkSON_Parser();
    ResultsPrinter printer = new ResultsPrinter();

    // BINS TO PASS TO PRINTER


    public ResultsGenerator(){
    }

    // PROOF OF CONCEPT THAT I CAN SEPERATE THE VARIABLES, THE COUNTS, ETC
//    public void run(){
//        parser.createObjectArray();
//        System.out.println(parser.createAndReturnGroceryList().toString());
////        parser.generateGroceryListWithMultiples();
////        System.out.println(parser.getGroceryListWithMultiples().toString());  // THIS ONE IS RETURNING A BLANK ARRAYLIST
//        parser.countAllTheThings();
//        System.out.println(parser.getMilkCount());
//        System.out.println(parser.getBreadCount());
//        System.out.println(parser.getCookieCount());
//        System.out.println(parser.getAppleCount());
//        System.out.println("Errors: " + parser.countErrors());
//    }

    public void setup(){
        parser.createObjectArray();
        parser.createAndReturnGroceryList();
//        parser.generateGroceryListWithMultiples();
//        System.out.println(parser.getGroceryListWithMultiples().toString());  // THIS ONE IS RETURNING A BLANK ARRAYLIST
        parser.countAllTheThings();
    }

    public void run(){
        setup();
        // MILK
        int milk = 0;
        for (Map.Entry<String, Integer> entry : parser.getMilkCount().entrySet())milk += entry.getValue();
        printer.printHeader("Milk", milk);
        for (Map.Entry<String, Integer> entry : parser.getMilkCount().entrySet()) {
            printer.printPriceCount(entry.getKey(), entry.getValue());
        }
        // BREAD
        int bread = 0;
        for (Map.Entry<String, Integer> entry : parser.getBreadCount().entrySet())bread += entry.getValue();
        printer.printHeader("Bread", bread);
        for (Map.Entry<String, Integer> entry : parser.getBreadCount().entrySet()) {
            printer.printPriceCount(entry.getKey(), entry.getValue());
        }
        // COOKIES
        int cookies = 0;
        for (Map.Entry<String, Integer> entry : parser.getCookieCount().entrySet())cookies += entry.getValue();
        printer.printHeader("Cookies", cookies);
        for (Map.Entry<String, Integer> entry : parser.getCookieCount().entrySet()) {
            printer.printPriceCount(entry.getKey(), entry.getValue());
        }
        // APPLES
        int apples = 0;
        for (Map.Entry<String, Integer> entry : parser.getAppleCount().entrySet())apples += entry.getValue();
        printer.printHeader("Apples", apples);
        for (Map.Entry<String, Integer> entry : parser.getAppleCount().entrySet()) {
            printer.printPriceCount(entry.getKey(), entry.getValue());
        }
        printer.printErrors(parser.countErrors());
    }

}
