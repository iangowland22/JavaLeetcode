/*
Return x with its digits reversed. If reversing x causes 
the value to go outside the range then return 0.

Example 1:
Input: x = 123
Output: 321

Example 2:
Input: x = -123
Output: -321

Example 3:
Input: x = 120
Output: 21
*/

public class ReverseInteger {

    public static int reverseInteger(Integer toReverse){

        String str = toReverse.toString();
        int index = str.length()-1;
        String reversed = "";
        while(index >= 0){
            if(index == 0){
                if(str.charAt(index) == '-'){
                    reversed = "-" + reversed;
                    break;
                }
                else if(str.charAt(index) == 0){
                    index--;
                    break;
                } 
            } 
            reversed += str.charAt(index);
            index--;
        }

        int converted = 0;
        try {
            converted = Integer.parseInt(reversed);
        } catch (Exception e) {
            System.err.println("Reversed number out of bounds. " + e.getMessage());
            return 0;
        }
        return converted;
    }

    public static void main(String[] args){

        int test = 3234698;
        System.out.println("Original number: " + test);
        System.out.println("Reversed: " + reverseInteger(test) + "\n");

        test = Integer.MAX_VALUE;
        System.out.println("Original number: " + test);
        System.out.println("Reversed: " + reverseInteger(test) + "\n");

        test = -34567;
        System.out.println("Original number: " + test);
        System.out.println("Reversed: " + reverseInteger(test) + "\n");

        test = 120;
        System.out.println("Original number: " + test);
        System.out.println("Reversed: " + reverseInteger(test) + "\n");
    }
    
}
