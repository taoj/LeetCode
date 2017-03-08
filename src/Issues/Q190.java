package Issues;

public class Q190 implements IIssueTemplate {
	/*
	 * -2147483648 -> 10000000  00000000  00000000  00000000
	 *  2147483647 -> 01111111  11111111  11111111  11111111
	 *  
	 *  the loop should go 32 times 
	 *  make sure do shift bit first, then assign, the order does matter!!!!!
	 */

	public int reverseBits(int n) {
				
        int result = 0;
        
        for(int i =1 ;i <=32 ; i++){          
            result <<= 1;
            result |= (n & 1);
            n >>>= 1;
            System.out.println(Integer.toBinaryString(n));
            System.out.println("             "+Integer.toBinaryString(result));
        }
        return result;
    }
	@Override
	public void go() {

		System.out.println(reverseBits(-2147483648));

	}

}
