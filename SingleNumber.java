/*

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

Example 3:
Input: nums = [1]
Output: 1

This is definitely not linear time complexity due to the selection sort, but it works. I'll have to come back to this
and figure out how I could accomplish this without sorting the array first. 
 */

public class SingleNumber {

    public static int[] sort(int[] numbers){
        int minIndex;
        for(int i = 0; i < numbers.length; i++){
            minIndex = i;
            for(int j = i+1; j < numbers.length; j++){
                if(numbers[j] < numbers[minIndex]){
                    minIndex = j;
                    int temp = numbers[minIndex];
                    numbers[minIndex] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }

        return numbers;
    }

    public static void findSingleElement(int[] numbers){
        
        int i = 0;
        while(i < numbers.length-1 && numbers[i] == numbers[i+1]){
            i += 2;
        }
        if(i <= numbers.length-1){
            System.out.println(numbers[i]);
        } else {
            System.out.println("No single element found.");
        }

    }

    public static void main(String[] args) {
        
        int[] test1 = {-1,-1,-2,-2,8,8,17,17,20};
        sort(test1);
        findSingleElement(test1);
    }
    
}
