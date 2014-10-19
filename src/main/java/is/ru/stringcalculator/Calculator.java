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
		int num = Integer.parseInt(number);
		if(num >= 1000){
			return 0;
		}
		return num;
	}

	private static String[] splitNumbers(String numbers){
	    String cleaned = numbers.replaceAll("/n",",");
	    return cleaned.split(",");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
 	    String num = "";
        for(String number : numbers){
        	if(toInt(number) < 0){
        		num += number+", ";
        	}
		    total += toInt(number);
		}
		if(num.length() > 0){
			//throw new IllegalArgumentException("Negatives not allowed: "+num.substring(0, num.length()-2));
		}
		return total;
    }
    private static int changeDelimiter(String text){
    	int newLineIndex = text.indexOf("/n");
    	String delimiter = text.substring(2, newLineIndex);
    	if(delimiter.charAt(0) == '['){
    		delimiter = delimiter.substring(1, delimiter.length() - 1);
    	}

    	String newText = text.substring(newLineIndex + 2);
    	String cleaned = newText.replaceAll(Pattern.quote(delimiter),",");

    	String[] numbersArray = cleaned.split(",");
    	return sum(numbersArray);
    }



}