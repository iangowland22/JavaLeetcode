/*
Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

This was challenging because of the flow of control. Certain operations needed to be performed 
outside of loops, before variables were reset, and the the comparison between the current unique
sequence and the current character of the original phrase.
 */

public class LongestSequenceNoRepeats {

    public static int longestUniqueSequence(String phrase){

        /*
        So I need to figure out how to iterate through the entire phrase while comparing each 
        successive phrase character to the letters in the unique sequence of letters without repeats.
        In the event I do encounter a repeat letter in the phrase, I need to record the length of the sequence
        to determine the longest unique sequence, clear the sequence, and then continue iterating through the original phrase.
        */

        String sequence = "";
        int highest = 0;
        sequence += phrase.charAt(0);
        int i = 1;
        while(i < phrase.length() && phrase.length()!= 0){
            int j = 0;
            while(j < sequence.length()){
                if(phrase.charAt(i) == sequence.charAt(j)){
                    if(sequence.length() > highest){
                        highest = sequence.length();
                    }
                    sequence = "";
                    break;
                }
                j++;
            }
            sequence += phrase.charAt(i);
            i++;
        }
        return highest;
    }

    public static void main(String[] args){
        String test = "abcabcbb";
        System.out.println(longestUniqueSequence(test));

        test = "bbbbb";
        System.out.println(longestUniqueSequence(test));
        
        test = "pwwkew";
        System.out.println(longestUniqueSequence(test));
    }
}
