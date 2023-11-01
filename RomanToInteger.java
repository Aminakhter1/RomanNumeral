import java.util.Scanner;
public class RomanToInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Roman numeral: ");
        String roman = scanner.nextLine();
        scanner.close();
        int result = romanToInteger(roman);
        System.out.println("Roman numeral " + roman + " is equivalent to integer " + result);
    }

    public static int romanToInteger(String s) {
        int result = 0;
        int prevValue = 0; // Keep track of the previous character's value
       // Create a mapping of Roman numerals to their integer values
        int[] values = new int[26];
        values['I' - 'A'] = 1;
        values['V' - 'A'] = 5;
        values['X' - 'A'] = 10;
        values['L' - 'A'] = 50;
        values['C' - 'A'] = 100;
        values['D' - 'A'] = 500;
        values['M' - 'A'] = 1000;
        // Iterate through the Roman numeral string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            int value = values[s.charAt(i) - 'A'];
             if (value < prevValue) {
                result -= value; // Subtraction rule (e.g., IV or IX)
            } else {
                result += value; // Addition rule (e.g., I, V, X)
            }
            prevValue = value;
        }
        return result;
    }
}
