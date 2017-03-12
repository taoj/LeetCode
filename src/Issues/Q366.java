package Issues;

import java.util.ArrayList;
import java.util.List;

import Utils.InputFactory;
import model.TreeNode;

public class Q366 implements IIssueTemplate {

	public List<List<Integer>> findLeaves(TreeNode root) {
		
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null){
			return result;
		}
		
		process(root, result);
		return result;
		
	}
	
	int process(TreeNode node, ArrayList<List<Integer>> result){
		
		if(node.left == null && node.right == null){
			if(result.isEmpty()){
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				tmp.add(node.val);
				result.add(tmp);
				
			}else{
				result.get(0).add(node.val);
			}
			
			return 0;
		}
		int left = node.left == null ? -1 : process(node.left, result)+1;
		int right = node.right == null ? -1 : process(node.right, result)+1;
		
		int depth = Math.max(left, right);
		if(result.size() -1 < depth){
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			tmp.add(node.val);
			result.add(tmp);
		}else{
			result.get(depth).add(node.val);
		}
		
		return depth;
		
		
		
	}
	
	@Override
	public void go() {
		// TODO Auto-generated method stub
		
		String input = "1,2,3,4,null,7,10,5,6,8,9";
		TreeNode root = InputFactory.getTreeFromString(input);
		
		List<List<Integer>> result = findLeaves(root);

	}

}
