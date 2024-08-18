public class PrintArray {

    public static void print(int[] numbers){
        int i = 0;
        while(i < numbers.length-1){
            System.out.print(numbers[i] + ", ");
            i++;
        }
        System.out.println(numbers[i] + "\n");
    }
    
}
