package Issues;

public class Q117 implements IIssueTemplate {

	class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
		}
	
    public void connect(TreeLinkNode root) {
        if(root == null){
            return ;
        }
        
        TreeLinkNode start = root;
        
        while(start != null){
            TreeLinkNode node = start;
        
            while(node != null){
                if(node.left == null && node.right == null){
                    node = node.next;
                    continue;
                }
                TreeLinkNode ptr = null;
                if(node.left != null && node.right != null){
                    node.left.next = node.right;
                    ptr = node.right;
                }else if(node.left != null){
                    ptr = node.left;
                }else{
                    ptr = node.right;
                }
                TreeLinkNode tmp = node.next;
                while(tmp != null && tmp.left == null && tmp.right == null){
                    tmp = tmp.next;
                }
                if(tmp != null){
                    if(tmp.left != null){
                        ptr.next = tmp.left;
                    }else{
                        ptr.next = tmp.right;
                    }
                    
                }
                node = tmp;
            }
            
            while(start != null){
                if(start.left != null){
                    start = start.left;
                    break;
                }else if(start.right != null){
                    start = start.right;
                    break;
                }else{
                    start = start.next;
                }
            }
        }
        
        
        
        
    }
	
	
	
	
	
	@Override
	public void go() {
		TreeLinkNode t1 = new TreeLinkNode(1);
		TreeLinkNode t2 = new TreeLinkNode(2);
		TreeLinkNode t3 = new TreeLinkNode(3);
		TreeLinkNode t4 = new TreeLinkNode(4);
		TreeLinkNode t5 = new TreeLinkNode(5);
		
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		
		connect(t1);
		
		
		System.out.println("hi");
		
		
		
		// TODO Auto-generated method stub

	}

}
