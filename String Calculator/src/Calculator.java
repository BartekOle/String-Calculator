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
                delimeter = String.valueOf(numbers.charAt(2));
                numbers = numbers.substring(5);
            }
            String[] arrayNumbers = numbers.split(delimeter);
            for(String number : arrayNumbers)
            {
                if(!number.isEmpty()) {
                    if(Integer.parseInt(number) < 0)
                    {
                        negativeNumbers.add(Integer.parseInt(number));
                    }
                    else
                    {
                        result += Integer.parseInt(number);
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