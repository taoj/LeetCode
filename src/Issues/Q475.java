package Issues;

import java.util.Arrays;

public class Q475 implements IIssueTemplate {
	
	
	/*
	 * binary search solution
	 * 
	 */
/*
	 public int findRadius(int[] houses, int[] heaters) {
	        
	        int record = -1; // can not be negative
	        int end = heaters.length-1;
	        Arrays.sort(heaters);
	        for(int house : houses){
	            record = Math.max(record, getNearest(house, heaters, 0, end));
	        }
	        
	        return record;
	        
	    }
	    
    int getNearest(int target, int[] heaters, int start, int end){
        
        if(end < start){
            return Integer.MAX_VALUE;
        }
        
        int mid = start+ (end-start)/2;
        
        if(heaters[mid] == target){
            return 0;
        }
        else if(heaters[mid] > target){
            return Math.min(heaters[mid]-target, getNearest(target, heaters, start, mid-1));
        }else{
            return Math.min(target- heaters[mid], getNearest(target, heaters, mid+1, end));
        }
    }
    */
	
	/**
	 *   two pointer solution , beat 95% , 18 ms
	 */
	public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int record = 0;
        int start = 0;
        int len = heaters.length;
        
        for(int house : houses){
            for(; start < len; start++){
                if(heaters[start] >= house){
                    break;
                }
            }
            if(start == 0){
                record = Math.max(record, heaters[0]-house);
            }else if(start == len){
                record = Math.max(record, house - heaters[start-1]);
            }else{
                record = Math.max(record, Math.min(house-heaters[start-1], heaters[start]-house));
            }
        }
        
        
        return record;
    }
	@Override
	public void go() {
		// TODO Auto-generated method stub

		int result = findRadius(new int[]{282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923},
				new int[]{823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612});
		System.out.println(result);
	}

}
