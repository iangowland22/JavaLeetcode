import java.util.Scanner;

/*

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

 */

public class ValidParentheses {

    public static boolean checkScopes(String scopes){

        String[] splitScopes = scopes.split("");
        int parenthesesCount = 0;
        int squareBracketCount = 0;
        int curlyBracketCount = 0;
        for(int i = 0; i < splitScopes.length; i++){

            if(checkParentheses(splitScopes[i])){
                parenthesesCount++;
            }
            else if(checkSquareBrackets(splitScopes[i])){
                squareBracketCount++;
            }
            else if(checkCurlyBrackets(splitScopes[i])){
                curlyBracketCount++;
            }   
        }
        if(parenthesesCount % 2 == 0 && squareBracketCount % 2 == 0 && curlyBracketCount % 2 == 0){
            return true;
        }
        return false;
    }

    public static boolean checkParentheses(String potential){
        
        if(potential.contains("(") || potential.contains(")")) {
            return true;
        }
        return false;
    }

    public static boolean checkSquareBrackets(String potential){
        
        if(potential.contains("[") || potential.contains("]")) {
            return true;
        }
        return false;
    }

    public static boolean checkCurlyBrackets(String potential){
        
        if(potential.contains("{") || potential.contains("}")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args){

        int test = 0 % 2;
        System.out.println(test);

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a full opening and closing symbol of a parenthetical block: ");
        String userInput = keyboard.nextLine();

        System.out.println(checkScopes(userInput));
        keyboard.close();
    }
}
