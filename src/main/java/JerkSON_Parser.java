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
    private ArrayList<Groceries> groceryListWithMultiples = new ArrayList<>();
    private String[] objectArray;
    private Integer errorCount;
    private HashMap<String, Integer> uniqueItemsCount = new HashMap<>();
    private HashMap<String, Integer> milkCount = new HashMap<>();
    private HashMap<String, Integer> breadCount = new HashMap<>();
    private HashMap<String, Integer> cookieCount = new HashMap<>();
    private HashMap<String, Integer> appleCount = new HashMap<>();


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
                // ALSO THE .replaceAll WITH SOMETHING ELSE
                // OR MAYBE THESE ARE NOT STRING UTILITIES, BECAUSE THEY'RE ACTING ON PATTERNS INSTEAD OF STRINGS.....?
                groceryList.add(new Groceries(m.group(1).replaceAll("0", "o").replaceAll("@", "a").replaceAll("1", "i").toLowerCase(),
                        m.group(2).toLowerCase(), m.group(3).toLowerCase(), m.group(4).toLowerCase()));
            }
        }
        return groceryList;
    }

    public int countErrors(){
        errorCount = objectArray.length - groceryList.size();
        return errorCount;
    }

//    public HashMap<String, Integer> countUniqueItems(){
//        // COME BACK TO THIS TO DIFFERENTIATE BETWEEN VARYING PRICES - Groceries OBJECT IS ALREADY BUILT, JUST NEED TO IMPLEMENT
//        for (Groceries item : groceryList){
//            if (!uniqueItemsCount.keySet().contains(item.getName())) uniqueItemsCount.put(item.getName(), 1);
//            else uniqueItemsCount.replace(item.getName(),uniqueItemsCount.get(item.getName()) +1);
//        }
//        return uniqueItemsCount;
//    }

    public void countAllTheThings(){
        countMilk();
        countBread();
        countCookies();
        countApples();
    }

    public void countMilk(){
        for (Groceries item : groceryList){
            if (item.getName().equals("milk")){
                if (!milkCount.keySet().contains(item.getPrice()))milkCount.put(item.getPrice(), 1);
                else {
                    milkCount.replace(item.getPrice(), (milkCount.get(item.getPrice()) + 1));
                }
            }
        }
    }

    public void countBread(){
        for (Groceries item : groceryList){
            if (item.getName().equals("bread")){
                if (!breadCount.keySet().contains(item.getPrice()))breadCount.put(item.getPrice(), 1);
                else {
                    breadCount.replace(item.getPrice(), (breadCount.get(item.getPrice()) + 1));
                }
            }
        }
    }

    public void countCookies(){
        for (Groceries item : groceryList){
            if (item.getName().equals("cookies")){
                if (!cookieCount.keySet().contains(item.getPrice()))cookieCount.put(item.getPrice(), 1);
                else {
                    cookieCount.replace(item.getPrice(), (cookieCount.get(item.getPrice()) + 1));
                }
            }
        }
    }

    public void countApples(){
        for (Groceries item : groceryList){
            if (item.getName().equals("apples")){
                if (!appleCount.keySet().contains(item.getPrice()))appleCount.put(item.getPrice(), 1);
                else {
                    appleCount.replace(item.getPrice(), (appleCount.get(item.getPrice()) + 1));
                }
            }
        }
    }

//    public ArrayList<Groceries> generateGroceryListWithMultiples(){
//        for (Groceries item : groceryList) {
//            int count = 0;
//            for (Groceries searchItem : groceryList){
//                if (item.getName().equals(searchItem.getName()) && item.getPrice().equals(searchItem.getPrice())){
//                    count++;
//                }
//            }
//
//            }
//        return groceryListWithMultiples;
//    }

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

    public  HashMap<String, Integer> getUniqueItemsCount() {
        return uniqueItemsCount;
    }

    public ArrayList<Groceries> getGroceryListWithMultiples() {
        return groceryListWithMultiples;
    }

    public HashMap<String, Integer> getMilkCount() {
        return milkCount;
    }

    public HashMap<String, Integer> getBreadCount() {
        return breadCount;
    }

    public HashMap<String, Integer> getCookieCount() {
        return cookieCount;
    }

    public HashMap<String, Integer> getAppleCount() {
        return appleCount;
    }
}
