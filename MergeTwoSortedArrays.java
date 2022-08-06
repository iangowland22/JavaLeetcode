/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, 
representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function, but instead be stored inside the array nums1. 
To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should 
be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].

Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.

I want to return to this class and rewrite try to write it as a recursive method.
 */

public class MergeTwoSortedArrays {

    public static int[] mergeArrays(int[] nums1, int[] nums2){
        int current2 = 0;
        for(int i = 0; i < nums1.length && current2 < nums2.length; i++){
            if(nums2[current2] <= nums1[i]){
                for(int j = nums1.length-1; j > i; j--){
                    nums1[j] = nums1[j-1];
                }
                nums1[i] = nums2[current2];
                current2++;
            } 
        }
        return nums1;
    }

    public static void printArr(int[] numbers){
        int i = 0;
        while(i < numbers.length-1){
            System.out.print(numbers[i] + ", ");
            i++;
        }
        System.out.println(numbers[i] + "\n");
    }
    

    public static void main(String[] args){

        int[] nums2 = {1,4,7,17,26,27,62};
        int n = nums2.length;
        int[] nums1 = {1,2,5,8,16,18,32,45,63,72,0,0,0,0,0,0,0};
        int m = nums1.length;
        System.out.println("nums1: ");
        printArr(nums1);
        System.out.println("nums2: ");
        printArr(nums2);
        nums1 = mergeArrays(nums1, nums2);
        System.out.println("Merged: ");
        printArr(nums1);
    }
}
