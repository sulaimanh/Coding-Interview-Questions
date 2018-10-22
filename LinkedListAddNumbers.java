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


public class LinkedListAddNumbers{

	class Node{
		int data;
		Node next;
		public Node(int data){
			this.data = data;
			next = null;
		}
	}

	public static void main(String [] args){
		LinkedListAddNumbers linkNumbers = new LinkedListAddNumbers();
		Node x = null;
		Node y = null;
		
		x = linkNumbers.addToLinkedList(x);
		y = linkNumbers.addToLinkedList(y);

		linkNumbers.addTwoNumbers(x,y);
	}

	public Node addTwoNumbers(Node l1, Node l2){
        int x = getNumber(l1);
        int y = getNumber(l2);
        System.out.println("The two numbers are: \nx = "+x+"\ny = "+y);
        int fin = x + y;
        System.out.println("The result of adding these two numbers are: "+fin);
        
        int rem;
        Node head = null;
        Node temp = head;
        while(fin != 0){
            rem = fin % 10;
            fin = fin/10;
            if(head == null){
                head = new Node(rem);
                temp = head;
            }else{
                temp.next = new Node(rem);
                temp = temp.next;
            }
        }
        


        return head;
    }
    
    public int getNumber(Node node){
        if(node.next == null)
            return node.data;
        return Integer.parseInt("" + getNumber(node.next) + node.data);
    }

	public Node addToLinkedList(Node a){
		Node newNode = new Node((int)(Math.random()*9)+1);
		if(a == null)
			a = new Node((int)(Math.random()*9)+1);

		Node last = a;
		for(int i = 0; i < 3; i++){
			last.next = new Node((int)((Math.random()*9)+1));
			last = last.next;
		}
		return a;
	}

}