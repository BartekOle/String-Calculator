import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter text");
        String text = scan.nextLine();
        System.out.println("Result: " + Add(text));
    }
    public static int Add(String numbers)
    {
        ArrayList negativeNumbers = new ArrayList<Integer>();
        int result = 0;
        String delimeter = ",|\\\\n";
        if(!numbers.isEmpty()) {
            if(numbers.startsWith("//"))
            {
                delimeter = "";
                String helpString = numbers;
                int numberOfDelimiters = helpString.length() - helpString.replace("[", "").length();
                int index = 3;
                for(int i = 0; i < numberOfDelimiters; i++)
                {
                    delimeter += numbers.substring(index, numbers.indexOf("]", index));
                    index = numbers.indexOf("]", index) + 2;
                }
                delimeter = "[" + delimeter + "]";
                numbers = numbers.substring(index+1);
            }
            String[] arrayNumbers = numbers.split(delimeter);
            for(String number : arrayNumbers) {
                if (!number.isEmpty()) {
                    int integerNumber = Integer.parseInt(number);
                    if (integerNumber < 0) {
                        negativeNumbers.add(integerNumber);
                    } else {
                        if (integerNumber <= 1000) {
                            result += integerNumber;
                        }
                    }
                }
            }
        }
        if(negativeNumbers.size() > 0)
        {
            throw new RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
        }
        return result;
    }
}