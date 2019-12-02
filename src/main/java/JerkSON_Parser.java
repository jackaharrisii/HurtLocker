import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JerkSON_Parser {

    private ResultsPrinter resultsPrinter = new ResultsPrinter();
    private TextReader textReader = new TextReader();
    private StringBuilder outputString = new StringBuilder();
    private String inputString;
    private ArrayList<Groceries> groceryList = new ArrayList<Groceries>();
    private String[] objectArray;
    private Integer errorCount;
    private HashMap<String, Integer> uniqueItemsCount = new HashMap<>();


    public JerkSON_Parser(){
        inputString = textReader.getTextAsString();
    }

    public void createObjectArray(){
        objectArray = Pattern.compile("##").split(inputString);
    }

    public ArrayList<Groceries> createAndReturnGroceryList(){
        createObjectArray();
        for (String objectString : objectArray){
            //create a grocery object
            String patternString = "(?i)name:([a-zA-Z0-9]+);(?i)price:([0-9]+\\.[0-9]+).(?i)type.([a-zA-Z]+).(?i)expiration.([0-9]+/[0-9]+/[0-9]+)";
            Pattern p = Pattern.compile(patternString);
            Matcher m = p.matcher(objectString);
            // store it in the groceryList
            while (m.find()) {
                // REPLACE THE .toLowerCase WITH REGEX FUNCTIONS TO RETURN IN THE PROPER CASE IN THE FIRST PLACE
                groceryList.add(new Groceries(m.group(1).toLowerCase(), m.group(2).toLowerCase(), m.group(3).toLowerCase(), m.group(4).toLowerCase()));
            }
        }
        return groceryList;
    }

    public int countErrors(){
        errorCount = objectArray.length - groceryList.size();
        return errorCount;
    }

    public HashMap<String, Integer> countUniqueItems(){
        for (Groceries item : groceryList){
            if (!uniqueItemsCount.keySet().contains(item.getName())) uniqueItemsCount.put(item.getName(), 1);
            else uniqueItemsCount.replace(item.getName(),uniqueItemsCount.get(item.getName()) +1);
        }
        return uniqueItemsCount;
    }

    public StringBuilder getOutputString() {
        return outputString;
    }

    public String getInputString() {
        return inputString;
    }

    public ArrayList<Groceries> getGroceryList() {
        return groceryList;
    }

    public String[] getObjectArray(){
        return objectArray;
    }

    public HashMap<String, Integer> getUniqueItemsCount() {
        return uniqueItemsCount;
    }
}
