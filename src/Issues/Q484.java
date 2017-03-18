package Issues;

import java.util.LinkedList;

public class Q484 implements IIssueTemplate {

	int[] result;
	boolean terminate = false;

	public int[] findPermutation(String s) {
		int n = s.length()+1;
		if(n == 1){
			return new int[]{1};
		}

		boolean[] flags = new boolean[n+1];

		LinkedList<Integer> res = new LinkedList();

		for(int i = 1; i <= n; i++){
			res.offer(i);
			flags[i] = true;
			process(res, s, 0, s.length(), flags);
			res.poll();
			flags[i] = false;
		}

		return result;


	}

	void process(LinkedList<Integer> res, String s, int level, int end, boolean[] flags){
		if(terminate){
			return;
		}

		if(level == end){
			// terminate
			terminate = true;
			result = new int[res.size()];
			for(int i = 0 ; i < res.size(); i++){
				result[i] = res.get(i);
			}
			return;
		}

		if(s.charAt(level) == 'I'){
			int top = res.peek();
			for(int i = 1; i < flags.length; i++){
				if(!flags[i] && i >top){
					flags[i] = true;
					res.offer(i);
					process(res, s, level+1, end, flags);
					res.poll();
					flags[i] = false;
				}
			}
		}else{
			int top = res.peek();
			for(int i = 1; i < flags.length; i++){
				if(!flags[i] && i <top){
					flags[i] = true;
					res.offer(i);
					process(res, s, level+1, end, flags);
					res.poll();
					flags[i] = false;
				}
			}
		}
	}
	
	
	@Override
	public void go() {
		// TODO Auto-generated method stub
		
		int[] res = findPermutation("DI");
		System.out.println(res);

	}

}
