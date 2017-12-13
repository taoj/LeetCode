package Issues;

import java.util.Arrays;

public class Q681 implements IIssueTemplate {

	@Override
	public void go() {
		// TODO Auto-generated method stub

		nextClosestTime("19:34");
	}

    public String nextClosestTime(String time) {
        int[] array = new int[4];
        array[0] = time.charAt(0)-'0';
        array[1] = time.charAt(1)-'0';
        array[2] = time.charAt(3)-'0';
        array[3] = time.charAt(4)-'0';
        
        Arrays.sort(array);
        
        StringBuilder sb = new StringBuilder(time);
        
        int index = findIt(array, sb.charAt(4) - '0');
        if(index < 3){
            sb.setCharAt(4, (char)(array[index+1]+'0'));
            return sb.toString();
        }else{
            sb.setCharAt(4, (char)(array[0]+'0'));
        }
        
        index = findIt(array, sb.charAt(3)-'0');
        if(index < 3 && array[index+1] <= 5){
            sb.setCharAt(3, (char)(array[index+1]+'0'));
            return sb.toString();
        }else{
            sb.setCharAt(3, (char)(array[0]+'0'));
        }
        
        index = findIt(array, sb.charAt(1)-'0');
        if(index < 3 ){
            
            if(sb.charAt(0) == '2' && array[index+1] > 3){
               sb.setCharAt(1, (char)(array[0]+'0')); 
            }else{
                sb.setCharAt(1, (char)(array[index+1]+'0'));
                return sb.toString();
            }
     
        }else{
            sb.setCharAt(1, (char)(array[0]+'0'));
        }
        
        index = findIt(array, sb.charAt(0)-'0');
        if(index < 3 && array[index+1] <=2){
            sb.setCharAt(0, (char)(array[index+1]+'0'));
            return sb.toString();
        }else{
            sb.setCharAt(0, (char)(array[0]+'0'));
        }
        
        return sb.toString();
        
    }
    
    private int findIt(int[] array, int num){
        
        for(int i = 3; i >=0; i--){
            if(array[i] == num){
                return i;
            }
        }
        
        return -1;
        
    }
}
