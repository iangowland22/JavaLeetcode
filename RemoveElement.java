/*
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. 
The relative order of the elements may be changed.

Since it is impossible to change the length of the array in some languages, you must instead have 
the result be placed in the first part of the array nums. More formally, if there are k elements after 
removing the duplicates, then the first k elements of nums should hold the final result. It does not 
matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

In RemoveDuplicateSorted, I assigned the rightmost elements with -999999999 so that at the end I would only print
the leftmost remaining elements of the array and stop at the first instance of -999999999. 

Instead of doing that for this program, I just assigned zero to the rightmost elements. 
 */

public class RemoveElement {

    public static int[] removeElement(int[] numbers, int toRemove){
        for(int i = 1; i < numbers.length; i++){
            if(numbers[i] == toRemove){
                numbers = shiftElementsLeft(numbers, i);
                i--;
            }
        }
        return numbers;
    }
    
    public static int[] shiftElementsLeft(int[] numbers, int indexOfRemoval){
        int i = indexOfRemoval;
        while(i < numbers.length-1){
            numbers[i] = numbers[i+1];
            i++;
        }
        numbers[i] = 0;
        return numbers;
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

        int[] test1 = {1,2,3,4,5,6,6,6,6,6,65,5,5,5,5,3,3,3,3,3,3,};
        System.out.print("Original array of test1: ");
        printArr(test1);
        test1 = removeElement(test1, 3);
        System.out.println("test1 array with all instances of 3 removed: ");
        printArr(test1);

        int[] test2 = {2,4,6,7,7,7,7,7,7,7,7,7,7,7,8,9,9,10};
        System.out.print("Original array of test2: ");
        printArr(test2);
        test2 = removeElement(test2, 7);
        System.out.println("test2 array with all instances of 7 removed: ");
        printArr(test2);
    }
}
