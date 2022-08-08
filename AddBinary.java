/*
Given two binary strings a and b, return their sum as a binary string.

Example 1:
Input: a = "11", b = "1"
Output: "100"

Example 2:
Input: a = "1010", b = "1011"
Output: "10101"

Constraints:
1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.

I think there is a much more efficient way of accomplishing this function and I definitely
need more practice with recursive methods. Maybe a switch statement would be beneficial too.
 */

public class AddBinary {

    public static String addBinary(String first, String second){
        String added = "";
        if(first.length() < second.length()){
            String temp = first;
            first = second;
            second = temp;
        }

        int firstIndex = first.length()-1;
        int secondIndex = second.length()-1;
        boolean carry = false;

        while(firstIndex >= 0 && secondIndex >= 0){
            if(first.charAt(firstIndex) == '1'){
                if(carry){
                    if(second.charAt(secondIndex) == '1'){
                        added = "1" + added; 
                    } else {
                        added = "0" + added;
                    }
                } else {
                    if(second.charAt(secondIndex) == '1'){
                        added = "0" + added;
                        carry = true;
                    } else {
                        added = "1" + added;
                    }
                }
            } else {
                if(carry){
                    if(second.charAt(secondIndex) == '1'){
                        added = "0" + added;
                    } else {
                        added = "1" + added;
                        carry = false;
                    }
                } else {
                    if(second.charAt(secondIndex) == '1'){
                        added = "1" + added;
                    } else {
                        added = "0" + added;
                    }
                }
            }
            firstIndex--;
            secondIndex--;
        }

        while(firstIndex >= 0){
            if(carry){
                if(first.charAt(firstIndex) == '1'){
                    added = "0" + added;
                } else {
                    added = "1" + added;
                    carry = false;
                }
            } else {
                if(first.charAt(firstIndex) == '1'){
                    added = "1" + added;
                } else {
                    added = "0" + added;
                }
            }
            firstIndex--;
        }

        if(carry){
            added = "1" + added;
        }
        return added;
    }


    public static void main(String[] args){

        String added = addBinary("11","1");
        System.out.println(added);

        added = addBinary("1010", "1011");
        System.out.println(added);

    }
    
}
