import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JerkSON_Parser {

    private TextReader textReader = new TextReader();
    private StringBuilder outputString = new StringBuilder();
    private String inputString;
    private ArrayList<Groceries> objectList;
    private String[] objectArray;

    public JerkSON_Parser(){
        inputString = textReader.getTextAsString();
    }

    public void createObjectArray(){
//        Pattern object = Pattern.compile("([Nn][Aa][Mm][Ee]:[a-zA-Z]*[:^%*!@])");
//        Matcher matcher = object.matcher(inputString);
//        while (matcher.find()){
//            objectList.add(matcher.group(1));
//        }
        objectArray = inputString.split("##");   // FIGURE OUT HOW TO DO THIS WITH JUST REGEX
    }

    public String tryGroupingOnObject(){
        createObjectArray();
        String output = "";
        String patternString = "[Nn][Aa][Mm][Ee]:([a-zA-Z]*);[Pp][Rr][Ii][Cc][Ee]:([0-9]+\\.[0-9]+)";
        Pattern p = Pattern.compile(patternString);
        Matcher m = p.matcher(objectArray[0]);
        while(m.find()){
            output += "Name is " + m.group(1);
            output += "\nPrice is " + m.group(2);
        }
        return output;
    }

    public void createObjectList(){
//        for(String )


    }



    public StringBuilder getOutputString() {
        return outputString;
    }

    public String getInputString() {
        return inputString;
    }

    public ArrayList<Groceries> getObjectList() {
        return objectList;
    }

    public String[] getObjectArray(){
        return objectArray;
    }
}
