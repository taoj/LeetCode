package Utils;

import java.util.LinkedList;

import model.ListNode;
import model.TreeNode;

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
	
	public static TreeNode getTreeFromString(String input){
		String[] array = input.split(",");
		if(array.length == 0){
			return null;
		}
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode root = new TreeNode(Integer.valueOf(array[0]));
		queue.offer(root);
		
		int i = 1;
		while(i < array.length){
			TreeNode node = queue.poll();
			if(!array[i].equals("null")){
				TreeNode left = new TreeNode(Integer.valueOf(array[i]));
				node.left = left;
				queue.offer(left);
			}
			i++;
			if(i >= array.length){
				break;
			}
			
			if(!array[i].equals("null")){
				TreeNode right = new TreeNode(Integer.valueOf(array[i]));
				node.right = right;
				queue.offer(right);
			}
			i++;
			
			
		}
		
		return root;
		
		
		
	}
	
}
