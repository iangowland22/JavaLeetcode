/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

 */

public class RotateArray {

    public static int[] rotateArray(int[] arr, int rotations) {
        if(rotations > arr.length) {
            rotations = rotations % arr.length;
        }
        int[] rotated = new int[arr.length];
        int startIndex = (arr.length)-rotations;
        for(int i = 0; i < arr.length; i++) {
            rotated[i] = arr[startIndex];
            if(startIndex == arr.length-1) {
                startIndex = 0;
            } else {
                startIndex++;
            }
        }
        return rotated;
    }

    public static void main(String[] args) {
        // example 1
        int[] example1 = {1,2,3,4,5,6,7};
        int[] rotated = rotateArray(example1, 3);
        PrintArray.print(rotated);
        // example 2
        int[] example2 = {-1, 100, 3, 99};
        rotated = rotateArray(example2, 2);
        PrintArray.print(rotated);
        // test rotations beyond length of array
        rotated = rotateArray(example1, 10);
        PrintArray.print(rotated);
    }    
}
