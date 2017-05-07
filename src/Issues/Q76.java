package Issues;

import java.util.HashMap;
import java.util.Map;

public class Q76 implements IIssueTemplate {

	public String minWindow(String s, String t) {
        int[] map = new int[128];
        
        for(int i = 0 ; i < t.length(); i++){
            map[t.charAt(i)]++;
        }
        
        int start = 0; 
        int end = 0;
        
        int head = 0;
        int tail = 0;
        
        int len = s.length()+1;
        
        int count = t.length();
        
        while(end < s.length()){
            
            int val = s.charAt(end);
            
            if(map[val] >  0){
                count--;
            }
            
            end++;
            map[val] -- ;
            
            while(count == 0){
                if(len > (end-start)){
                    len = end-start;
                    head = start;
                    tail = end;
                }
                int pre = s.charAt(start);
                start++;
                map[pre]++;
                if(map[pre] >0){
                    count++;
                }
            }
        }
        
        if(len == s.length()+1){
            return "";
        }
        
        return s.substring(head, tail);
        
    }
	
	
	@Override
	public void go() {
		// TODO Auto-generated method stub

		String s = "bdab";
		String t = "ab";
		
		String res = minWindow(s, t);
		
	}

}
