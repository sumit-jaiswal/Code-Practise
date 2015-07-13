package com.meetup;


public class Problem1 {
	
	public ListNode addNumbers(ListNode l1,ListNode l2){
		ListNode sum = new ListNode();
		ListNode root = sum;
		int rem=0;
		while(l1 != null || l2 != null){
			if(l1 !=null && l2 != null){
				sum.value = (l1.value + l2.value + rem)%10;
				rem = (l1.value + l2.value + rem)/10;
			}
			else if(l1 == null && l2 != null){
				sum.value = (l2.value +rem)%10;
				rem = (l2.value + rem)/10;
			}
			else if(l1 != null && l2 == null){
				sum.value = (l1.value +rem)%10;
				rem = (l1.value + rem)/10;
			}
			sum.next = new ListNode();
			sum = sum.next;
		}
		if(rem != 0){
			sum.value = rem;
		}
		else{
			sum = null;
		}
		return root;
	}
	
	
	
	public static void main(String[] args) {
		Problem1 p1 = new Problem1();
		ListNode l1 = new ListNode(1);
		l1.next=new ListNode(2);
		l1.next=new ListNode(3);
		
		ListNode l2 = new ListNode(4);
		l2.next = new ListNode(5);
		l2.next = new ListNode(6);
		
		ListNode sum = p1.addNumbers(l1, l2);
		while(sum != null){
			System.out.print(sum.value);
			sum=sum.next;
		}
	}
}
class ListNode{
	int value;
	ListNode next;
	
	public ListNode(){
	}
	
	public ListNode(int value){
		this.value = value;
	}
}
