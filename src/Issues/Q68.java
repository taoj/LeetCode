package Issues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q68 implements IIssueTemplate {

	 public List<String> fullJustify(String[] words, int maxWidth) {
	        
	        
	        List<String> res = new ArrayList();
	        StringBuilder sb = new StringBuilder();
	        
	        LinkedList<String> q = new LinkedList();
	        int index = 0;
	        while(index < words.length){
	            sb.setLength(0);
	            
	            q.offer(words[index]);
	            int count = 1;
	            int length = words[index].length();
	            index++;
	            
	            while(index < words.length && (length +words[index].length() +1 <= maxWidth)){
	                
	                length += words[index].length()+1;
	                count ++;
	                q.offer(words[index]);
	                index++;
	            }
	            
	            if(index == words.length){
	                while(!q.isEmpty()){
	                    sb.append(q.poll());
	                    if(!q.isEmpty()){
	                        sb.append(' ');
	                    }
	                }
	            }else{
	                int spaces = maxWidth-length + count-1;
	                int spacePer= count == 1 ? 0 : spaces/(count-1);
	                int remain = count == 1 ? 0 : spaces%(count-1);
	            
	                while(!q.isEmpty()){
	                    sb.append(q.poll());
	                    if(!q.isEmpty()){
	                        for(int i = 1; i <= spacePer; i++){
	                            sb.append(' ');
	                        }
	                        if(remain > 0){
	                            sb.append(' ');
	                            remain--;
	                        }
	                    }
	                    
	                }
	            }
	            
	            
	            while(sb.length() < maxWidth){
	                sb.append(' ');
	            }
	            res.add(sb.toString());
	            
	        }
	        
	        return res;
	    }
	@Override
	public void go() {
		// TODO Auto-generated method stub
		String[] words = {"What","must","be","shall","be."};
		fullJustify(words, 12);

	}

}
