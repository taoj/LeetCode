package Issues;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.AbstractMap;
import java.util.ArrayList;

public class Q347 implements IIssueTemplate {

	 public List<Integer> topKFrequent(int[] nums, int k) {
	        
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        
	        
	        
	        TreeMap<Integer, List<Integer>> sortedMap = new TreeMap<Integer, List<Integer>>(new Comparator<Integer>(){
	        	@Override
	        	public int compare(Integer a, Integer b){
	        		return b-a;
	        	}

				
	        });
	        
	        sortedMap.put(1, new ArrayList<Integer>());
	        
	        for(int num : nums){
	            if(map.keySet().contains(num)){
	                int count = map.get(num);
	                map.put(num, count+1);
	                
	                int index = sortedMap.get(count).indexOf(num);
	                sortedMap.get(count).remove(index);
	                
	                if(sortedMap.keySet().contains(count+1)){
	                    sortedMap.get(count+1).add(num);
	                }else{
	                    List<Integer> list = new ArrayList();
	                    list.add(num);
	                    sortedMap.put(count+1, list);
	                }
	                
	            }else{
	                map.put(num, 1);
	                sortedMap.get(1).add(num);
	            }
	        }
	        
	        
	        List<Integer> result = new ArrayList<Integer>();
	        for(Map.Entry<Integer, List<Integer>> entry : sortedMap.entrySet() ){
	            if(k == 0){
	                break;
	            }
	            for(int val : entry.getValue()){
	                result.add(val);
	            }
	            k--;
	        }
	        
	        return result;
	    }
	@Override
	public void go() {
		// TODO Auto-generated method stub

	}

}
