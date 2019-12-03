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
        System.out.println("Errors: " + parser.countErrors());
    }

}
