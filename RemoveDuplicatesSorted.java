/*

Given an integer array nums sorted in non-decreasing order, remove the duplicates 
in-place such that each unique element appears only once. The relative order of the 
elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must 
instead have the result be placed in the first part of the array nums. More formally, 
if there are k elements after removing the duplicates, then the first k elements of nums 
should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array 
in-place with O(1) extra memory.

 */

public class RemoveDuplicatesSorted {

    public static int[] checkDuplicates(int[] numbers){
        for(int i= 0; i < numbers.length; i++){
            if(i < numbers.length-1 && numbers[i] == numbers[i+1]){
                shiftElementsLeft(numbers, i);
                if(numbers[i] != -999999999){
                    i--;
                }
            }
        }
        return numbers;
    }

    public static int[] shiftElementsLeft(int[] numbers, int index){
        int i = index;
        while(i < numbers.length-1){
            numbers[i] = numbers[i+1];
            i++;
        }
        numbers[i] = -999999999;
        return numbers;
    }

    public static void printArr(int[] numbers){
        int i = 0;
        while(i < numbers.length-1 && numbers[i+1] != -999999999){
            System.out.print(numbers[i] + ", ");
            i++;
        }
        System.out.println(numbers[i]);
    }

    public static void main(String[] args){

       int[] test1 = {0,1,2,3,3,3,3,3,4,5,6,7,8,9};
       int[] test2 = {0,0,0,0,0,1,2,3,4,5,5,5,5,5,6,6,6,6,6,6,6,7,7,8};

       System.out.println("Test 1 original array: ");
       printArr(test1);
       test1 = checkDuplicates(test1);
       System.out.println("Test 1 without duplicates: ");
       printArr(test1);

       System.out.println("Test 2 original array: ");
       printArr(test2);
       test2 = checkDuplicates(test2);
       System.out.println("Test 2 without duplicates: ");
       printArr(test2);

    }
    
}
