public class ResultsPrinter {

    public ResultsPrinter() {
    }

    public static void printHeader(String name, int occurrences){
        System.out.println(String.format(
                "RESULTS!!!!!!!!!\n\n" +
                "Name: %7s      Seen: %d times\n" +
                "=============      =============\n",
                name, occurrences
        ));
    }

    public static void printPriceCount(String price, int occurrences){
        System.out.println(String.format(
                "Price:   %6s      Seen: %d times\n" +
                "-------------      -------------\n",
                price, occurrences
        ));
        // IF ANOTHER PRICE, PRINT THAT TOO
    }

    public static void printErrors(int errors){
        System.out.println(String.format(
                "Errors             seen: %d times",
                errors
        ));
    }

}
