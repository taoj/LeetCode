package Issues;

public class Q189 implements IIssueTemplate {

	public void rotate(int[] nums, int k) {
		
		int len = nums.length;
		if(len == 0 || k%len == 0){
			return;
		}
		
		reverse(nums, 0, len-1);
		reverse(nums, 0, k-1);
		reverse(nums, k, len-1);
		
	}
	
	private void reverse(int[] nums, int start, int end){
		
		while(start < end){
			int tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			start++;
			end--;
		}
		
	}
	
	@Override
	public void go() {
		// TODO Auto-generated method stub

	}

}
