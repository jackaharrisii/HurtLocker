public class ResultsPrinter {

    public ResultsPrinter() {
    }

    public void printHeader(String name, int occurrences){
        System.out.println(String.format(
                "RESULTS!!!!!!!!!\n\n" +
                "name: %s      seen: %d times\n" +
                "=============      =============\n",
                name, occurrences
        ));
    }

    public void printPriceCount(String price, int occurrences){
        System.out.println(String.format(
                "Price:   %s      seen: %d times\n" +
                "-------------      -------------\n",
                price, occurrences
        ));
        // IF ANOTHER PRICE, PRINT THAT TOO
    }

    public void printErrors(int errors){
        System.out.println(String.format(
                "Errors             seen: %d times",
                errors
        ));
    }

}
