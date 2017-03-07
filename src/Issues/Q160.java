package Issues;

import Utils.InputFactory;
import model.ListNode;

public class Q160 implements IIssueTemplate {

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
