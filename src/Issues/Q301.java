package Issues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//BFS is faster , see Leetcode


public class Q301 implements IIssueTemplate {

	
	public List<String> removeInvalidParentheses(String s) {
        int start = 0;
        int end = s.length()-1;
        for(; start < s.length(); start++){
            if(s.charAt(start) != ')'){
                break;
            }
        }
        for(; end >= 0; end--){
            if(s.charAt(end) != '('){
                break;
            }
        }
        
        s = s.substring(start, end+1);
        
        List<String> res = new ArrayList();
        StringBuilder sb = new StringBuilder();
        process(s, 0, sb, res);
        
        return res;
        
        
    }
    
    void process(String ori, int index, StringBuilder sb, List<String> res){
        if(index == ori.length()){
            String str = sb.toString();
            if(verify(str)){
                if(res.isEmpty()){
                    res.add(str);
                }else if(res.get(0).length() == str.length() && !res.contains(str)){
                    res.add(str);
                }else if(res.get(0).length() < str.length()){
                    res.clear();
                    res.add(str);
                }
            }
            return;
        }
        if(ori.charAt(index) != '(' && ori.charAt(index) != ')'){
            sb.append(ori.charAt(index));
            process(ori, index+1, sb, res);
        }
        else{
            sb.append(ori.charAt(index));
            process(ori, index+1, sb, res);
            sb.deleteCharAt(sb.length()-1);
        
            process(ori, index+1, sb, res);
        }
        
        
        
    }
    
    boolean verify(String str){
        LinkedList<Character> stk = new LinkedList();
        
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != '(' && str.charAt(i) != ')'){
                continue;
            }
            
            if(str.charAt(i) == '('){
                stk.push('(');
            }else{
                if(stk.size() > 0){
                    stk.pop();
                }else{
                    return false;
                }
            }
            
            
        }
        
        if(stk.size() > 0){
            return false;
        }
        
        return true;
    }
	
	
	@Override
	public void go() {
		List<String> res = removeInvalidParentheses(")(f");

	}

}
