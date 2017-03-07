package Utils;

import model.ListNode;

public class InputFactory {
	public static ListNode getListNode(int[] array){
		ListNode head = new ListNode(-1);
		ListNode cur = head;
		for(int a : array){
			cur.next = new ListNode(a);
			cur = cur.next;
		}
		
		return head.next;
	}
}
