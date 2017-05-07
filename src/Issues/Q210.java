package Issues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Q210 implements IIssueTemplate {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] parent = new int[numCourses];
        
        List<List<Integer>> adjList = new ArrayList();
        for(int i = 0; i < numCourses; i++){
            parent[i] = -1;
            adjList.add(new ArrayList());
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        
        List<Integer> res = new ArrayList(numCourses);
//        Set<Integer> visited = new HashSet();

        for(int i = 0; i < numCourses; i++){
            if(adjList.get(i).size() == 0){
                parent[i] = -2;
                res.add(i);
                process(adjList, i, parent, res);
            }
        }
        if(cycle){
            return new int[0];
        }
        int[] result = new int[numCourses];
        
        for(int i = 0; i < numCourses ;i++){
            result[i] = res.get(i);
        }
        
        return result;
        
        
    }
    boolean cycle = false;
    void process(List<List<Integer>> adjList, int index, int[] parent, List<Integer> res){
        
        if(cycle){
            return;
        }
        
        List<Integer> neighbors = adjList.get(index);
        
        for(int to : neighbors){
            if(parent[to] == -1){
                parent[to] = index;
//                visited.add(to);
                res.add(to);
                process(adjList, to, parent, res);
            }
            else if(parent[to] != index){
                cycle = true;
                return;
            }
        }
        
        
    }
	
	
	
	@Override
	public void go() {
		// TODO Auto-generated method stub

		int [][] a = new int[][]{{1,0}};
		
		int[] res = findOrder(2, a);
		
		System.out.println("HI");
	}

}
