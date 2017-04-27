package Issues;

import java.util.HashMap;
import java.util.Map;

public class Q494 implements IIssueTemplate {

	
	public int findTargetSumWays(int[] nums, int S) {
		
		Map<Integer, Integer> map = new HashMap();
        map.put(nums[0],1);
        map.put(-nums[0], 1);
        for(int i = 1; i< nums.length; i++){
        	int tmp  = nums[i];
            Map<Integer, Integer> tmpM = new HashMap();
            for( int key : map.keySet()){
                tmpM.put(key+tmp, map.get(key)+tmpM.getOrDefault(key+tmp,0));
                tmpM.put(key-tmp, map.get(key)+tmpM.getOrDefault(key-tmp,0));
            }
            map = tmpM;
        }
        
        return map.get(S) == null ?  0 : map.get(S);

    }
	@Override
	public void go() {
		// TODO Auto-generated method stub
		int[] input = {1,1,1,1,1};
		int res = findTargetSumWays(input, 3);
	}

}
