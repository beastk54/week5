/**
 * 
 */
package week5;
import java.util.*;

/**
 * @author beast
 *
 */
public class Ex11_3  {

    public static final int PREFIX_VISA = 4;
    public static final int PREFIX_MASTERCARD = 5;
    public static final int PREFIX_AMEX = 37;
    public static final int PREFIX_DISCOVER = 6;
    static int[] prefixes = new int[] {
            PREFIX_VISA, PREFIX_MASTERCARD, PREFIX_AMEX, PREFIX_DISCOVER };
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a credit card number: ");
        long creditCardNum = scan.nextLong();

        if (isValid(creditCardNum)) {
            System.out.println(creditCardNum + " is valid.");
        } else {
            System.out.println(creditCardNum + " is invalid.");
        }
    }
    public static boolean isValid(long number) {

        if (getSize(number) > 16 || getSize(number) < 13) return false;

        for (int i = 0; i < prefixes.length; i++) {

            if (getPrefix(number, prefixes[i]) == prefixes[i]) break; 
            if (i < prefixes.length - 1) return false; 
        }
        int sum = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);

        return sum % 10 == 0;
    }
    public static boolean prefixMatched(long number, int d) {

        if (d > number) return false;
        long difference = (getSize(number) - getSize(d));
        return d == (int)(number / Math.pow(10, difference));
    }
    public static long getPrefix(long number, int k) {
        if (prefixMatched(number, k)) return k;
        return number;
    }
    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        while (number > 0) {
            number /= 10;
            int digit = getDigit((int) (number % 10) * 2);
            sum += digit;
            number /= 10;
        }
        return sum;
    }

    public static int sumOfOddPlace(long num) {
        int sum = 0;
        while (num > 0) {
            int digit = (int) (num % 10);
            digit = getDigit(digit);
            sum += digit;
            num /= 100;
        }
        return sum;
    }
    public static int getDigit(int num) {
        return (num > 9) ? num - 9 : num;
    }
    public static int getSize(long d) {
        int size = 0;
        while (d > 0) {
            size++;
            d /= 10;
        }
        return size;
    }
}