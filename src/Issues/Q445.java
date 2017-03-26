package Issues;

import model.ListNode;

public class Q445 implements IIssueTemplate {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		       if(l1 == null && l2 == null){
		            return null;
		        }else if(l1 == null){
		            return l2;
		        }else if(l2 == null){
		            return l1;
		        } 
		        int len1 = getLength(l1);
		        int len2 = getLength(l2);
		        
		        if(len2 > len1){
		            ListNode tmp = l1;
		            l1 = l2;
		            l2 = tmp;
		        }
		        
		        
		        int diff = Math.abs(len1 -len2);
		        ListNode head  =  new ListNode(-1);
		        
		        int carrier = process(l1, l2, diff, head);
		        if(carrier != 0){
		            ListNode tmp = new ListNode(1);
		            tmp.next = head.next;
		            head.next = tmp;
		        }
		        return head.next;
		        
		    }
		    
		    int process(ListNode l1, ListNode l2, int diff, ListNode head){
		        if(diff > 0){
		            int carrier = process(l1.next, l2, diff-1, head);
		            
		            ListNode tmp = new ListNode((l1.val+carrier)%10);
		            tmp.next = head.next;
		            head.next = tmp;
		            return (l1.val+carrier)/10;
		        }else{
		            if(l1 == null && l2 == null){
		                return 0;
		            }
		            
		            int carrier = process(l1.next, l2.next, 0, head);
		            
		            ListNode tmp = new ListNode((l1.val + l2.val + carrier)%10);
		            tmp.next = head.next;
		            head.next = tmp;
		            return (l1.val + l2.val + carrier)/10;
		        }
		        
		    }
		    		    
		    int getLength(ListNode node){
		        ListNode tmp = node;
		        int res = 0;
		        
		        while(tmp != null){
		            res++;
		            tmp  = tmp.next;
		            
		        }
		        return res;
		    }
		    
	@Override
	public void go() {
		// TODO Auto-generated method stub

	}

}
