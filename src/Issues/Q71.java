package Issues;

import java.util.LinkedList;

public class Q71 implements IIssueTemplate {

	public String simplifyPath(String path) {
LinkedList<String> stk = new LinkedList();
        
        String[] str = path.split("/");
        for(String s : str){
            if(s.equals(".") || s.equals("")){
                continue;
            }else if(s.equals("..") ){
               if(stk.isEmpty()){
                   continue;
               }else{
                   stk.pop();
               }
            }
            else{
                stk.push(s);
            }
        }
        
        if(stk.isEmpty()){
            return "/";
        }
        
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = stk.size()-1; i >=0; i--){
            sb.append("/").append(stk.get(i));
        }
        
        return sb.toString();
	        
	        
	    }
	@Override
	public void go() {

		String res = simplifyPath("/...");

	}

}
