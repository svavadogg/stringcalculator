package is.ru.stringcalculator;
import java.util.regex.Pattern;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.startsWith("//")){
			return changeDelimiter(text);
		}
		else if(text.contains(",") || text.contains("/n") ){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    String cleaned = numbers.replaceAll("/n",",");
	    return cleaned.split(",");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }
    private static int changeDelimiter(String text){
    	int newLineIndex = text.indexOf("/n");
    	String delimiter = text.substring(2, newLineIndex);
    	String newText = text.substring(newLineIndex + 2);
    	String cleaned = newText.replaceAll(Pattern.quote(delimiter),",");

    	String[] numbersArray = cleaned.split(",");
    	return sum(numbersArray);
    }





}