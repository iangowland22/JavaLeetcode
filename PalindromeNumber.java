import java.util.Scanner;

/**
 * 5/23/24
 * Update this to short circuit when the left-most index does not match the right-most index 
 */

/*
Given an integer x, return true if x is a palindrome integer.
An integer is a palindrome when it reads the same backward as forward.

    For example, 121 is a palindrome while 123 is not.

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */

public class PalindromeNumber {

    public static boolean checkPalindrome(Integer checkInt){

        String numberString = checkInt.toString();
        int lastIndex = numberString.length();
        int i = 0;
        String reversed = "";

       while(i < lastIndex) {
            String current = (String) numberString.subSequence(lastIndex-1-i, lastIndex-i);
            reversed = reversed + current;
            i++;
       }
       String comparison = "\nOriginal number: " + checkInt + "\nPalindrome: " + reversed;
       if(numberString.equals(reversed)){
           System.out.println("Yes, this number is a palindrome. " + comparison);
           return true;
       }
       System.out.println("No, this number is not a palindrome. " + comparison);
       return false;
    }

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter your number to check if it is a palindrome: ");

        while(!keyboard.hasNextInt()){
            System.out.println("Please enter a valid number: ");
        }
        int inputNumber = keyboard.nextInt();
        checkPalindrome(inputNumber);
        keyboard.close();

        // test
    }
    
}
