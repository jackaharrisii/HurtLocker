public class ResultsGenerator {

    // CREATE INSTANCES OF CLASSES
    JerkSON_Parser parser = new JerkSON_Parser();
    ResultsPrinter printer = new ResultsPrinter();

    // BINS TO PASS TO PRINTER


    public ResultsGenerator(){
    }

    public void run(){
        parser.createObjectArray();
        System.out.println(parser.createAndReturnGroceryList().toString());
        parser.generateGroceryListWithMultiples();
        System.out.println(parser.getGroceryListWithMultiples().toString());  // THIS ONE IS RETURNING A BLANK ARRAYLIST
        System.out.println("Errors: " + parser.countErrors());
    }

}
