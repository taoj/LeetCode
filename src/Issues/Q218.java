package Issues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Q218 implements IIssueTemplate{

	public List<int[]> getSkyline(int[][] buildings) {
	    List<int[]> result = new ArrayList<>();
	    List<int[]> height = new ArrayList<>();
	    for(int[] b:buildings) {
	        height.add(new int[]{b[0], -b[2]});
	        height.add(new int[]{b[1], b[2]});
	    }
	    Collections.sort(height, (a, b) -> {
	            if(a[0] != b[0]) 
	                return a[0] - b[0];
	            return a[1] - b[1];
	    });
	    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
	    pq.offer(0);
	    int prev = 0;
	    for(int[] h:height) {
	        if(h[1] < 0) {
	            pq.offer(-h[1]);
	        } else {
	            pq.remove(h[1]);
	        }
	        int cur = pq.peek();
	        if(prev != cur) {
	            result.add(new int[]{h[0], cur});
	            prev = cur;
	        }
	    }
	    return result;
	}
	@Override
	public void go() {
		int[][] input = new int[][]{{5,6,6},{5,7,5},{5,8,4}};
		
		List<int[]>res = getSkyline(input);
		System.out.println(res);
		
	}

}
