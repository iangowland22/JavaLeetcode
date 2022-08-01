/*
Implement strStr().

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, 
or -1 if needle is not part of haystack.

Clarification:
What should we return when needle is an empty string? This is a great question to ask during an interview.
For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to 
C's strstr() and Java's indexOf().

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1

 */

public class IndexOf{

    public static int indexOf(String word, String sequence){

        int index = -1;
        int i = 0;
        int j = 0;
        if(word.length() == 0){
            return 0;
        } else {
            while(i < word.length()-1 && j < sequence.length()-1){
                if(word.charAt(i) == sequence.charAt(j) && j != 0){
                    j++;
                }
                if(word.charAt(i) == sequence.charAt(j) && j == 0){
                    index = i;
                    j++;
                } 
                i++;
            }
        }
        if(j == sequence.length()-1 && word.charAt(i) == sequence.charAt(j)){
            return index;
        } else {
            return -1;
        }
    }

    public static void main(String[] args){

        String haystack = "philosophy";
        String needle = "phi";
        System.out.println(indexOf(haystack, needle));

        needle = "not";
        System.out.println(indexOf(haystack, needle));

        needle = "sophy";
        System.out.println(indexOf(haystack, needle));

        needle = "sophi";
        System.out.println(indexOf(haystack, needle));

    
    }
}
