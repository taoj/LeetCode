package Issues;

public class Q7 implements IIssueTemplate {

	public int reverse(int x) {
	       
		// in case overflow
		long result = 0;
		
		while(x != 0){
			// first make space
			result *= 10;
			// second assign value
			result += x%10;
			
			// third move source
			x /= 10;
			
			// check overflow
			if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
				return 0;
			}
			
			
		}
		
		 return (int)result;
		 
	}
	@Override
	public void go() {
		// TODO Auto-generated method stub
		
		reverse(1534236469);

	}

}
