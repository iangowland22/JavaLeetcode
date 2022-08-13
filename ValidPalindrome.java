/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters 
and removing all non-alphanumeric characters, it reads the same forward and backward. 
Alphanumeric characters include letters and numbers. Given a string s, return true 
if it is a palindrome, or false otherwise.

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 */

public class ValidPalindrome {

    public static String removeNonAlphabetical(String str){
        str = str.toLowerCase();
        str = str.replaceAll("[^a-z]", "");
        return str;
    }

    
    public static boolean determinePalindrome(String str){

        str = removeNonAlphabetical(str);
        int front = 0;
        int back = str.length()-1;
        int middle = str.length()/2;

        while(front < middle && back > middle){
            if(str.charAt(front) == str.charAt(back)){
                front++;
                back--;
            } else {
                return false;
            }
        }

        if(front < middle){
            if(str.charAt(front) == str.charAt(middle)){
                return true;
            } else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String test = "A man, a plan, a canal: Panama";
        System.out.println(determinePalindrome(test));

        test = "race a car";
        System.out.println(determinePalindrome(test));

        test = "arace a cara";
        System.out.println(determinePalindrome(test));

        test = "araca a cara";
        System.out.println(determinePalindrome(test));

        test = "abracadabra";
        System.out.println(determinePalindrome(test));

        test = "abracadabrarbadacarba";
        System.out.println(determinePalindrome(test));

        test = "";
        System.out.println(determinePalindrome(test));
    }
    
}
