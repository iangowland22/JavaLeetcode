import java.util.Scanner;

/*

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II.
The number 27 is written as XXVII, which is XX + V + II. Roman numerals are usually written largest to smallest from left 
to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before 
the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six 
instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9. 
    X can be placed before L (50) and C (100) to make 40 and 90. 
    C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer.

Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.

Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

 */

public class RomanToInteger {

    public static int romanToInt(String romanNumerals) {

        romanNumerals = romanNumerals.toLowerCase();
        String[] splitSequence = romanNumerals.split("");
        int converted = 0;
        
        for(int i = 0; i < splitSequence.length; i++){

            if(splitSequence[i].equals("i")){

                if(i == splitSequence.length-1){
                    converted += 1;
                } else if(splitSequence[i+1].equals("v")){
                    converted += 4;
                    i += 1;
                } else if(splitSequence[i+1].equals("x")){
                    converted += 9;
                    i += 1;
                } else {
                    converted += 1;
                }
            } else if(splitSequence[i].equals("v")){
                converted += 5;
            } else if(splitSequence[i].equals("x")){
                
                if(i == splitSequence.length-1){
                    converted += 10;
                } else if(splitSequence[i+1].equals("l")){
                    converted += 40;
                    i += 1;
                } else if(splitSequence[i+1].equals("c")){
                    converted += 90;
                    i += 1;
                } else {
                    converted += 10;
                }
            } else if(splitSequence[i].equals("l")){
                converted += 50;
            } else if(splitSequence[i].equals("c")){
                
                if(i == splitSequence.length-1){
                    converted += 100;
                } else if(splitSequence[i+1].equals("d")){
                    converted += 400;
                    i += 1;
                } else if(splitSequence[i+1].equals("m")){
                    converted += 900;
                    i += 1;
                } else {
                    converted += 100;
                }
            } else if(splitSequence[i].equals("d")){
                converted += 500;
            } else if(splitSequence[i].equals("m")){
                converted += 1000;
            } 
        }
        System.out.println("Original Roman numerals: " + romanNumerals.toUpperCase() + "\nConverted number: " + converted);
        return converted;
    } 


    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter your sequence of Roman numerals to convert it into Arabic numerals: ");
        String sequence = keyboard.next();
        romanToInt(sequence);
        keyboard.close();
    }
}