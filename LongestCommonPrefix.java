/*
 * This is the solution provided by LeetCode.
 * 
 * The while loop condition will evaluate to zero when the String at value i 
 * matches the entire String of prefix, which is the first String (the first word)
 * in the array strs.
 * 
 * When the next word does not match the first word, which is stored in the prefix
 * variable, the prefix word takes off the last letter and then iterates through the 
 * comparison of the two words.
 * 
 * When and if there are any words left in the prefix variable, the next word in the
 * strs array is compared to the prefix variable and the process repeats. 
 */

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "There is no common prefix.";
            }        
        return prefix;
    }
    
    public static void main(String[] args){

        String[] fl = {"flying", "flan", "flack"};
        String[] random = {"next", "thus", "center"};

        System.out.println(longestCommonPrefix(fl));
        System.out.println(longestCommonPrefix(random));
    }
    
}
