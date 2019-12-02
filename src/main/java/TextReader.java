import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextReader {

    private String textAsString;

    public TextReader(){
        this.textAsString = loadFile();
    }

    public String loadFile(){
        File file = new File("/Users/jack/Dev/Labs/Week8/HurtLocker/src/main/resources/RawData.txt");
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line);
            }
            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
            // put something here to count the number of exceptions thrown
        }
        return result.toString();
    }

    public String getTextAsString() {
        return textAsString;
    }
}
