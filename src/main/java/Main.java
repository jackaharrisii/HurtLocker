import org.apache.commons.io.IOUtils;
import java.io.IOException;

public class Main {

    private ResultsPrinter resultsPrinter = new ResultsPrinter();
    private static JerkSON_Parser jp = new JerkSON_Parser();

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
//        String output = (new Main()).readRawDataToString();
//        System.out.println(output);
        ResultsPrinter.printHeader("Milk", 6);   // CLEARLY THE WRONG ANSWER HERE

    }
}
