package Issues;

public class Q43 implements IIssueTemplate {

	 public String multiply(String num1, String num2) {
	        int l1 = num1.length();
	        int l2 = num2.length();
	        
	        if(l1 < l2){
	            String tmp = num1;
	            num1 = num2;
	            num2 = tmp;
	        }
	        
	        int[] array = new int[l1+l2];
	        
	        int startIndex = l1+l2-1;
	        int lastIndex = 0;
	        
	        for(int i = num2.length()-1; i >=0; i--){
	            lastIndex = process(num1, num2.charAt(i), startIndex, array);
	            startIndex--;
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        
	        
	        for(; lastIndex <= l1+l2-1; lastIndex++){
	            if(array[lastIndex] != 0)break;
	          
	        }
	       
	        for(int i = lastIndex ; i <= l1+l2-1; i++){
	            sb.append((char)(array[i]+48));
	        }
	        
	        
	        return sb.length() == 0 ? "0": sb.toString();
	        
	    }
	    
	    
	    
	    int process(String num1, char chr, int startIndex, int[] array){
	        
	        int carrier = 0;
	        
	        for(int i = num1.length()-1; i >=0; i--){
	            int a = num1.charAt(i)-48;
	            int b = chr-48;
	            
	            int result = a*b+array[startIndex]+carrier;
	            array[startIndex] = result%10;
	            carrier = result/10;
	            startIndex--;
	            
	        }
	        if(carrier != 0){
	            array[startIndex] = carrier;
	        
	             return startIndex;
	        }
	        
	        return startIndex+1;
	        
	    }
	@Override
	public void go() {
		
		String s1 = "1";
		String s2 = "1";
		String result = multiply(s1,s2);
		

	}

}
