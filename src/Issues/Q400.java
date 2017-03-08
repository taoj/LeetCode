package Issues;

public class Q400 implements IIssueTemplate {

public int findNthDigit(int n) {
       
        int base = 1;
        int length = 1;
        // this is the key point long !!!!!
        long count = 9;
//        int tmp = 0;
        
        while( count*length < n){
            n -= count*length;
            base *= 10;
            count *=10;
            length++;
        }
        
        int number = base + (n-1)/length;
        String str = Integer.toString(number);
        
        return Character.getNumericValue(str.charAt((n-1)%length));
        
        
    }
    
/*	
	public int findNthDigit(int n) {
		int len = 1;
		long count = 9;
		int start = 1;

		while (n > len * count) {
			n -= len * count;
			len += 1;
			count *= 10;
			start *= 10;
		}

		start += (n - 1) / len;
		String s = Integer.toString(start);
		return Character.getNumericValue(s.charAt((n - 1) % len));
	}
*/
	@Override
	public void go() {
		System.out.println(findNthDigit(1000000000));

	}

}
