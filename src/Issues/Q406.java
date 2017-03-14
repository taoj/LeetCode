package Issues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Q406  implements IIssueTemplate{

	public int[][] reconstructQueue(int[][] people) {
        int len = people.length;
        Arrays.sort(people, new Comparator<int[]>(){
        	
        	public int compare(int[] first, int[] second){
                if(first[0] != second[0]){
                    return second[0]-first[0];
                }else{
                    return first[1]-second[1];
                }
            }

        });
        
        
        ArrayList<int[]> result = new ArrayList<int[]>();
        
        
        for(int i = 0; i < len; i++){
            result.add(people[i][1], people[i]);
        }
        
        return result.toArray(new int[len][]);
    }

	@Override
	public void go() {
		
		int[][] input = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		
		int[][] result = reconstructQueue(input);
		System.out.println("1");
	}
}
