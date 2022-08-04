/*
Given a string s consisting of words and spaces, return the length of the last word in the string.
A word is a maximal substring consisting of non-space characters only.

Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.

Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.


Constraints:

    1 <= s.length <= 104
    s consists of only English letters and spaces ' '.
    There will be at least one word in s.
 */

public class LastWordLength {

    public static int lastWordLength(String sentence){
        sentence = sentence.trim();
        int wordLength = 0;
        for(int i = sentence.length()-1; i > 0 && sentence.charAt(i) != ' '; i--){
            wordLength++;
        }
        return wordLength;
    }

    public static void main(String[] args){
        String test = "Hello World";
        System.out.println(lastWordLength(test));

        test = " hello world ";
        System.out.println(lastWordLength(test));

        test = "   fly me   to   the moon  ";
        System.out.println(lastWordLength(test));
    }
    
}
