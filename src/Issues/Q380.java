package Issues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Q380 implements IIssueTemplate {

	public class RandomizedSet {


	    List<Integer> list;
	    Random rand;
	    Map<Integer, Integer> map;
	    /** Initialize your data structure here. */
	    public RandomizedSet() {
	        list = new ArrayList();
	        rand = new Random();
	        map = new HashMap();
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	        if(map.containsKey(val)){
	            return false;
	        }
	        
	        list.add(val);
	        map.put(val, list.size()-1);
	        return true;
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	        if(map.containsKey(val)){
	            
	            int index = map.get(val);
	            
	            int tmp = list.get(list.size()-1);
	            map.put(tmp, index);
	            map.remove(val);
	            list.set(index, tmp);
	            list.remove(list.size()-1);
	            
	            return true;
	        }
	        
	        return false;
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	        int r = rand.nextInt(list.size());
	        
	        return list.get(r);
	    }
	}
	@Override
	public void go() {
		// TODO Auto-generated method stub

	}

}
