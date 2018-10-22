import java.util.*;

/*
    You are given two non-empty linked lists representing two non-negative integers. 
    The digits are stored in reverse order and each of their nodes contain a single digit. 
    Add the two numbers and return it as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Example:

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.

*/


public class LinkedListNumbers{

    class ListNode{
        int val;
        ListNode next;
        public ListNode(int data){
            this.val = data;
            next = null;
        }
    }

    public static void main(String [] args){
        LinkedListAddNumbers linkNumbers = new LinkedListAddNumbers();
        ListNode x = null;
        ListNode y = null;
        
        x = linkNumbers.addToLinkedList(x);
        y = linkNumbers.addToLinkedList(y);

        linkNumbers.addTwoNumbers(x,y);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        return getNode(l1,l2);
    }

    public ListNode getNode(ListNode l1, ListNode l2){
        ListNode head = null;
        ListNode temp = null;
        int addition;
        
        // - Here, we will traverse through both listnodes and performing the addition
        while(l1 != null || l2 != null){
            // - If l1 is null, then we will set the next node equal to l2 and return 
            if(l1 == null){
                temp.next = l2;
                return head;
            // - If l2 is null, then we will set the next node equal to l1 and return    
            }else if(l2 == null){
                temp.next = l1;
                return head;
            }
            
            // - Here, we will perform the addition
            addition = l1.val + l2.val;
            // - If the addition is greater than 10, then we will perform the carry on operation
            if(addition >= 10){
                // - If the next 2 nodes are null, then we have to create a new node with val = 1
                if(l1.next == null && l2.next == null)
                    l1.next = new ListNode(1);
                // - If the next node in l1 is null, then we will create a new node in l1 in order to continue the addition
                else if(l1.next == null)
                    l1.next = new ListNode(1);
                // - If the next node in l2 is null, then we will create a new node in l2 in order to continue the addition
                else if(l2.next == null)
                    l2.next = new ListNode(1);
                // - If neither of them are null and we just have to carry, then that is what we will do
                else
                    l1.next.val = l1.next.val + 1;
            }
            
            // - Here, we will get the ones digit from addition
            addition = addition%10;
            // - If head is null, then we will create the new head
            if(head == null){
                head = new ListNode(addition);
                l1 = l1.next;
                l2 = l2.next;
                temp = head;
            // - Otherwise, we will create the linked list.
            }else{
                temp.next = new ListNode(addition);
                temp = temp.next;
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        
        return head;
    }
   
    public ListNode addToLinkedList(ListNode a){
        ListNode newNode = new ListNode((int)(Math.random()*9)+1);
        if(a == null)
            a = new ListNode((int)(Math.random()*9)+1);

        ListNode last = a;
        for(int i = 0; i < 3; i++){
            last.next = new ListNode((int)((Math.random()*9)+1));
            last = last.next;
        }
        return a;
    }

}