package Issues;

public class Q370 implements IIssueTemplate {

	 public int[] getModifiedArray(int length, int[][] updates) {

		 int[] result = new int[length];
		 
		 for(int i = 0; i < updates.length; i++){
			 result[updates[i][0]] += updates[i][2];
			 
			 if(updates[i][1] < length-1){
				 result[updates[i][1]+1] += updates[i][2];
			 }
		 }
		 int sum = 0;
		 for(int i = 0; i < length; i++){
			 sum+=result[i];
			 result[i] = sum;
		 }
		 
		 return result;
		 
		 
	 }
	@Override
	public void go() {
		// TODO Auto-generated method stub

	}

}
