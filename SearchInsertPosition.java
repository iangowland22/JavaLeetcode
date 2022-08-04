/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.
 
Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4

I'm not sure if this is O(log n) runtime complexity, but I reduced the initial starting index of the array search
by taking the array's numbers of elements and dividing it in half. If the value at index[halved number of elements] is less
than the target value, then the second half of the array is searched and the first half is disregarded. 
 */

public class SearchInsertPosition {

    public static int insertionIndex(int[] numbers, int target){

        int index = 0;
        int halvedArrayLength = (numbers.length-1)/2;
        if(numbers[halvedArrayLength] < target){
            index = halvedArrayLength;
        }

        while(index < numbers.length){
            if(numbers[index] == target){
                return index;
            } else if(numbers[index] > target){
                return index-1;
            } else {
                index++;
            }
        }
        return index;
    }

    public static void printArr(int[] numbers){
        int i = 0;
        while(i < numbers.length-1){
            System.out.print(numbers[i] + ", ");
            i++;
        }
        System.out.print(numbers[i] + "\n");
    }


    public static void main(String[] args){

        int[] test1 = {0,1,2,3,4,4,5,6};
        int target = 5;
        System.out.print("Array: " );
        printArr(test1);
        System.out.println("Target: " + target);
        int result = insertionIndex(test1, target);
        System.out.println("Index of target insertion: " + result);

        int[] test2 = {0,1,2,2,3,3,4,4,5,6,7,8,9,10,11,12,13,14,16,17,18,19,20};
        target = 16;
        System.out.print("Array: " );
        printArr(test2);
        System.out.println("Target: " + target);
        result = insertionIndex(test2, target);
        System.out.println("Index of target insertion: " + result);

        target = 2;
        System.out.print("Array: " );
        printArr(test2);
        System.out.println("Target: " + target);
        result = insertionIndex(test2, target);
        System.out.println("Index of target insertion: " + result);

        int[] test3 = {0,1,2,2,3,3,4,4,5,6,7,8,9,10,11,12,13,14,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35};
        target = 16;
        System.out.print("Array: " );
        printArr(test3);
        System.out.println("Target: " + target);
        result = insertionIndex(test3, target);
        System.out.println("Index of target insertion: " + result);
    }
    
}
