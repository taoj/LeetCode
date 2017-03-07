package Issues;

import Utils.InputFactory;
import model.ListNode;

public class Q160 implements IIssueTemplate {
	
	//3ms
	public ListNode getIntersectionNode_II(ListNode headA, ListNode headB) {
		
		int l1 = getLength(headA);
		int l2 = getLength(headB);
		
		while(l1 > l2){
			headA = headA.next;
			l1--;
		}
		while(l1 < l2){
			headB = headB.next;
			l2--;
		}
		
		while(headA !=  headB){
			headA = headA.next;
			headB = headB.next;
		}
		
		return headA;
	}
	
	private int getLength(ListNode node){
		if(node  == null){
			return 0;
		}
		
		return getLength(node.next)+1;
	}
// 2ms
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA== null || headB==null){
            return null;
        }
        
        ListNode last = headA;
        
        while(last.next != null){
            last = last.next;
        }
        
        last.next = headA;
        
        ListNode fast = headB;
        ListNode slow = headB;
        while(fast.next != null && fast.next.next != null){
            
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow){
                break;
            }
        }
        
        if(fast.next == null || fast.next.next == null){
            last.next = null;
            return null;
        }
        fast = headB;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        
        last.next = null;
        return fast;
    }
	
	@Override
	public void go() {
		ListNode a = InputFactory.getListNode(new int[]{1});
		ListNode b = InputFactory.getListNode(new int[]{2,4,6,8,10,12,14,16,18,20,22});
		
		getIntersectionNode(a,b);
		
	}

}
