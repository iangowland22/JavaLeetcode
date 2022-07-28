import java.util.Scanner;
import java.util.ArrayList;

/*
Given an array of integers and an integer target, return indices 
of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, 
and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

public class TwoSum {

    public static boolean checkInt(Scanner scan){

        while(!scan.hasNextInt()) {
            System.out.println("Please enter only a non-negative integer, or -1 to stop: ");
        }
        return true;
    }

    public static ArrayList<Integer> findSum(ArrayList<Integer> listOfInts, int sum) {

        ArrayList<Integer> sums = new ArrayList<>();
        int counter = 0;
        int currentSum = 0;

        while(counter < listOfInts.size() && currentSum < sum) {
            currentSum += listOfInts.get(counter);
            sums.add(counter);
            counter++;

            if(currentSum > sum && counter != listOfInts.size()) {
                sums.remove(sums.size()-1);
                currentSum -= listOfInts.get(counter-1);
            }
            else if(currentSum > sum && !listOfInts.isEmpty()){
                sums.clear();
                listOfInts.remove(0);
                counter = 0;
                currentSum = 0;
            }

        }

        if(currentSum != sum){
            sums.clear();
        }

        return sums;
    }

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        String welcome = "\nGiven an array of integers nums and an integer target, " +
        "return indices of the two numbers such that they add up to target.\n" +
        "\nYou may assume that each input would have exactly one solution, " +
        "and you may not use the same element twice.\n" +
        "\nYou can return the answer in any order.\n";

        String initialMessage = "\nPlease enter a non-negative integer, or -1 to end list: ";
        System.out.print(welcome + initialMessage);

        /* 
        while(!keyboard.hasNextInt()) {
            System.out.println(errorMessage);
        }
        */

        checkInt(keyboard);
        ArrayList<Integer> listOfNumbers = new ArrayList<>();
        int currentNumber = keyboard.nextInt();

        while(currentNumber > 0) {
            listOfNumbers.add(currentNumber);
            System.out.print(initialMessage);
            checkInt(keyboard);
            currentNumber = keyboard.nextInt();
        }

        System.out.print("\nPlease enter your desired sum (again, a non-negative integer): ");
        while(!keyboard.hasNextInt()) {
            System.out.print("Please enter a non-negative integer: ");
        }
        int sum = keyboard.nextInt();

        System.out.println("\nInitial array of integers: " + listOfNumbers +"\n");

        ArrayList<Integer> foundSum = findSum(listOfNumbers, sum);

        System.out.println("Indices of integers that added to desired sum " + foundSum +"\n");

        keyboard.close();
        
    }
    
}
