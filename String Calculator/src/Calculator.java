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
                    result += Integer.parseInt(number);
                }
            }
        }
        return result;
    }
}