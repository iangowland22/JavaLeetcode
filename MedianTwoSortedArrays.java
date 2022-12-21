/*

Given two sorted arrays nums1 and nums2 of size m and n respectively, 
return the median of the two sorted arrays.

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

NOTE: This exercise specified a time complexity of O(log(m+n)), which mine is not, 
so I omitted this from this prompt. I also left in some notes to explain my thought
process as if a student was reading it.

I might have another way to do this which I'm going to try tomorrow.

 */

 /**
  * @author Ian Gowland
  */

import java.util.Scanner;

public class MedianTwoSortedArrays {

    public static int[] fillArray(int length){
        int[] arr = new int[length];
        for(int i = 0; i < length; i++){
            arr[i] = i+1;
        }
        return arr;
    }

    public static void printArray(int[] arr){
        int i = 0;
        while(i < arr.length-1){
            System.out.print(arr[i] + ", ");
            i++;
        }
        System.out.println(arr[i]);

    }

    public static double findMedian(int[] arrOne, int[] arrTwo){

        int[] merged = new int[arrOne.length + arrTwo.length];
        int arrOneCount = 0;
        int arrTwoCount = 0;
    
        /*
         Keep track of each element from the two sorted arrays that have been added to 
         the merged array (i cannot be used because it will represent the total length 
         of the merged array). 
         
         If all the elements of the first array have been added to the
         merged array, then we add the remaining elements of the second array. (vice versa)
         */

        int i = 0;

        while(i < merged.length && arrOneCount < arrOne.length && arrTwoCount < arrTwo.length){

            if(arrOneCount < arrOne.length && arrOne[arrOneCount] < arrTwo[arrTwoCount]){
                merged[i] = arrOne[arrOneCount];
                arrOneCount++;
            } else {
                merged[i] = arrTwo[arrTwoCount];
                arrTwoCount++;
            }
            i++;
        }

        if(i != merged.length){

            if(arrOneCount < arrOne.length){
                while(arrOneCount < arrOne.length){
                    merged[i] = arrOne[arrOneCount];
                    arrOneCount++;
                    i++;
                }
            } else if (arrTwoCount < arrTwo.length){
                while(arrTwoCount < arrTwo.length){
                    merged[i] = arrTwo[arrTwoCount];
                    arrTwoCount++;
                    i++;
                }
            }
        }

        // If the merged array is an odd number of elements, the median is simply the middle element

        if(merged.length % 2 != 0){
            return merged[(merged.length/2)];
        } 

        /*
        If the merged array is an even number of elements the two middle adjacent
        elements must be added and divided by two in order to determine the median.
        2.0 is used for division so that the decimal remainder is not disregarded.

        Example: 1,2,3,4,5,6,7,8,9,10

        The median is between the two most middle elements: 5 and 6 
        The median in this example is: 5.5 (5 + 6 / 2.0)

        */

        return (merged[merged.length/2] + merged[(merged.length/2)-1])/2.0;

    }


    public static void main(String[] args){

        Scanner keyboard = new Scanner(System.in);

        // Two arrays for testing 

        int[] one = {1,2,7,8,9,13,27,545,652,897,1235};
        int[] two = {26,28,31,45,67,9999};
        System.out.print("First array: ");
        printArray(one);
        System.out.print("Second array: ");
        printArray(two);

        double start = System.currentTimeMillis();
        System.out.println(findMedian(one, two));
        System.out.println("Time elapsed: " + (System.currentTimeMillis() - start) + "ms");

        one = fillArray(10);
        two = fillArray(20);
        System.out.print("First array: ");
        printArray(one);
        System.out.print("Second array: ");
        printArray(two);

        start = System.currentTimeMillis();
        System.out.println(findMedian(one, two));
        System.out.println("Time elapsed: " + (System.currentTimeMillis() - start) + "ms");

        int[] large = fillArray(1000);
        int[] larger = fillArray(5000);

        start = System.currentTimeMillis();
        System.out.println(findMedian(large, larger));
        System.out.println("Time elapsed: " + (System.currentTimeMillis() - start) + "ms");

    }


}



