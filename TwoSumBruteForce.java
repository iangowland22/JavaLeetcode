import java.util.ArrayList;

/**
 * Given solution from LeetCode for the TwoSum challenge.
 * I added the conversion to ArrayList for printing the entire formatted array.
 */

public class TwoSumBruteForce {

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        // In case there is no solution, we'll just return null
        return null;
    }

    public static ArrayList<Integer> toArrayList(int[] arr) {
        ArrayList<Integer> converted = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            converted.add(arr[i]);
        }
        return converted;
    }

    public static void main(String[] args){

        int[] arr1 = {2, 7, 11, 15};
        int target1 = 9;
        
        int[] test1 = twoSum(arr1, target1);

        ArrayList<Integer> converted1 = toArrayList(test1);

        System.out.println(converted1);

        int[] arr2 = {3, 2, 4};
        int target2 = 6;
        
        int[] test2 = twoSum(arr2, target2);

        ArrayList<Integer> converted2 = toArrayList(test2);

        System.out.println(converted2);
        
    }
    
}
