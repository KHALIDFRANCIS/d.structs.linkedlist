package linkedlistv2;

import java.util.*;
import java.io.*;
import java.lang.*;	

public class Linkylist {
	
	node head;
	int halfnode;
	private char[] jump;
	
	public void append(int data) {		//add to the end
		if(head==null) {				//without a head, theres nothing. This will check if there is a head node.
			head = new node(data);		//this will make the head the new node
			return;
		}
		node trav = head; 				// this node has a pointer that will point to the first node (head node) of the linked list
		while (trav.next != null) {		//if there is a node after this node
			trav = trav.next;		 	//go to the next node 
		}	
			trav.next = new node(data);
	}
	
	public void prepend(int data) {		//add to the beginning
		node newhead = new node(data);	//create a new head value
		newhead.next= head;				//this will point to the existing head thus taking over as the new head
		head = newhead;					//this designates the "newhead" as the head node 
	}
	
	public void delete(int data) {
		if (head == null) return;		//if there is no head, do nothing
		if (head.data == data) {		//in the case that you want to delete the head node
			head = head.next;			//the node after the current head becomes the new head
			return;
		}
		node trav = head;						//again we start by creating a reference that starts at the head
		while (trav.next != null ) {			//explanation is a little further up in the append method
			if(trav.next.data == data) {		//if the next node is the one you want to delete
				trav.next = trav.next.next;		//the mode that was 2 places over becomes the next node
			}
//			trav = trav.next;
		}	
	}
	
	public void insertAfter(int insert, int data) {
		if (head.next == null) {			//if there is nothing after the head node
			head.next = new node(data);		//insert this new node after the head node
		}
		node trav = head;
		while (trav.next != null) {			
			if (trav.data == insert) {			//if the current node is the node that data will be inserted after
				node newness = new node(data);	//create a new node
				newness.next = trav.next;		//the new node will point to the node that is after the current node
				trav.next = newness;			//the current node will point to the new node
			}
			trav = trav.next;
		}
	}
	
	public void deleteAtEnd(int data) {
		node trav = head;					
		while (trav.next != null) {		//same stuff different line
			if (trav.next == null) {	//if there is nothing after the current node that were in, then logically we are at the end
				trav = null;			//because we are at the end, we will delete the current node
			}
			trav = trav.next;
		}
	}
	
	public int numbofnodes() {
		node trav = head;
		int nodecount = 0;
		while (trav.next != null) {
			trav = trav.next;
			nodecount ++;
		}
		return nodecount;
	}
	
//	to find the middle node in a linked list
//	this option will increment a counter as it goes through then divide the counter by 2 and that middle number ( index
	public int middlenode(int halfnode) {		
		node trav = head;
		int nodect = 0;
		while (trav != null) {
			if (nodect == halfnode)
				return trav.data;
			nodect ++;
			trav = trav.next;
		}
			return halfnode;
		}
	
//	this option will feature two noced jumping at a two to one ration
//	top one jumps two for every one that the bottom jumps. When the top is finished, the bottom node will print.
	public int jump() {
		node top = head;
		node bottom = head;
		while (top != null && top.next != null) {
			top = top.next.next;
			bottom  = bottom.next;
		}
		if (top.next.next == null && top.next != null) {
			return bottom.next.data;		
		} else {
			return bottom.data;
		}
		
//		System.out.println("the middle node is " + bottom.data);
	}
	
	public ListNode reverselist(ListNode head) {
		node prev = null;		//this is the pointer / reference to the previous node
		node curr = head;		//this is the current node 
		node next = null;		//this is the pointer / reference to the next node 
		while(curr != null) {			//while the current node is not equal to null......if there's something after,
			next = curr.next; 			//....with respect to the current node, the next node (next) = the current node pointing to the next node (curr.next)
			curr.next = prev;			//this is the part where the pointer to the next node "(->)" gets reversed to point the the previous node "(<-)"
//			after the pointer gets flipped, everything takes their new places
			prev = curr;		//what was the previous node is now the current node 
			curr = next;		//what was the current node becomes the next node
		}
		return  prev;
	}
	
	
	
	public static void main(String[] args) {
		Linkylist linky = new Linkylist();
//		LinkedList <Integer> linky = new LinkedList<Integer>();
		
		
		linky.prepend(6);
		linky.prepend(1);
		linky.prepend(9);
		linky.prepend(4);
		linky.prepend(0);
		linky.prepend(8);
		linky.prepend(7);
		linky.prepend(5);
		linky.prepend(2);
		linky.prepend(3);
		linky.prepend(45);
		linky.prepend(19);
		
		System.out.println(linky.jump());
		

	}

}
//APPEND means to add to the end, PREPEND means to add to the beginning
