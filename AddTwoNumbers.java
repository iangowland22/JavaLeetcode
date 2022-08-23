/*
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order, and each of their nodes contains a single digit. 
Add the two numbers and return the sum. You may assume the two numbers 
do not contain any leading zero, except the number 0 itself.

Example 1:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: 807
Explanation: 342 + 465 = 807.

Example 2:

Input: l1 = [0], l2 = [0]
Output: 0

Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: 10009998

****************************************************************************************

I probably could have made a method in the ListNode class provided by the prompt to add
additional nodes to the ListNode list. I might come back and do that because the main method
has all of the ListNode building hardcoded. I definitely need more practice with LinkedLists
and data structures in general.

I also changed the prompt to return the sum of the values stored in each node instead of
returning the revesed sum as a ListNode object with each digit stored in reverse, like the two 
ListNode objects that are added to each other.

 */

public class AddTwoNumbers {

     private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val){ 
            this.val = val;
            next = null;
        }
        ListNode(int val, ListNode next){
            this.val = val; 
            this.next = next; 
        }
    }

    public static int addTwo(ListNode first, ListNode second){
        int total = 0; 
        ListNode currentNode = first;
        total += extractNumbersFromList(currentNode);
        currentNode = second;
        total += extractNumbersFromList(second);
        return total;
    }

    private static int extractNumbersFromList(ListNode first){
        int total = 0;
        String str = "";
        ListNode currentNode = first;
        str += currentNode.val;

        if(currentNode.next != null){
            currentNode = currentNode.next;
            while(currentNode.next != null){
                str = currentNode.val + str;
                currentNode = currentNode.next;
            }
        }
        str = currentNode.val + str;
        total += Integer.parseInt(str);

        return total;
    }


    public static void main(String[] args){

        ListNode firstList3 = new ListNode(3);
        ListNode firstList2 = new ListNode(4, firstList3);
        ListNode firstList1 = new ListNode(2, firstList2);

        ListNode secondList3 = new ListNode(4);
        ListNode secondList2 = new ListNode(6, secondList3);
        ListNode secondList1 = new ListNode(5, secondList2);
        
        System.out.println(addTwo(firstList1, secondList1));

        firstList1 = new ListNode(0);
        secondList1 = new ListNode(0);

        System.out.println(addTwo(firstList1, secondList1));

        ListNode firstList7 = new ListNode(9);
        ListNode firstList6 = new ListNode(9, firstList7);
        ListNode firstList5 = new ListNode(9, firstList6);
        ListNode firstList4 = new ListNode(9, firstList5);
        firstList3 = new ListNode(9, firstList4);
        firstList2 = new ListNode(9, firstList3);
        firstList1 = new ListNode(9, firstList2);

        ListNode secondList4 = new ListNode(9);
        secondList3 = new ListNode(9, secondList4);
        secondList2 = new ListNode(9, secondList3);
        secondList1 = new ListNode(9, secondList2);

        System.out.println(addTwo(firstList1, secondList1));

        

    }
}
