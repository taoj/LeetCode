package Issues;

import java.util.LinkedList;

public class Q529 implements IIssueTemplate {

	 char[][] self;
	    int rows = 0;
	    int cols = 0;
	    
	    
	    public char[][] updateBoard(char[][] board, int[] click) {
	        self = board;
	        rows = board.length-1;
	        cols = board[0].length-1;
	        
	        
	        LinkedList<int[]> coords = new LinkedList();
	        
	        if(board[click[0]][click[1]] == 'M'){
	            board[click[0]][click[1]] = 'X';
	            return board;
	        }else{
	            coords.add(new int[]{click[0], click[1]});
	            process(board, coords);
	        }
	        
	        return board;
	        
	    }
	    
	    private void process(char[][]board, LinkedList<int[]> coords){
	        
	        while(!coords.isEmpty()){
	            int[] tmp = coords.poll();
	            if(board[tmp[0]][tmp[1]] == 'E'){
	                int count = countMine(tmp[0], tmp[1]);
	                if(count == 0){
	                    board[tmp[0]][tmp[1]] = 'B';
	                    // check neighbores
	                    if(tmp[0]>0 && board[tmp[0]-1][tmp[1]] == 'E'){
	                        coords.offer(new int[]{tmp[0]-1, tmp[1]});
	                    }
	                    if(tmp[0] < rows && board[tmp[0]+1][tmp[1]] == 'E'){
	                        coords.offer(new int[]{tmp[0]+1, tmp[1]});
	                    }
	                    
	                    if(tmp[1] >0 && board[tmp[0]][tmp[1]-1] == 'E'){
	                        coords.offer(new int[]{tmp[0],tmp[1]-1});
	                    }
	                    
	                    if(tmp[1] < cols && board[tmp[0]][tmp[1]+1] == 'E'){
	                        coords.offer(new int[]{tmp[0], tmp[1]+1});
	                    }
	                    
	                }else{
	                    board[tmp[0]][tmp[1]] = (char)(count+48);
	                }
	            }
	        }
	    }
	    
	    
	    private int countMine(int row, int col){
	        int res = 0;
	        
	        if(row >0 && col > 0 && self[row-1][col-1] == 'M'){
	            res ++;
	        }
	        if(row >0 && self[row-1][col] == 'M'){
	            res ++;
	        }
	        if(row > 0 && col < cols && self[row-1][col+1] == 'M'){
	            res ++;
	        }
	        
	        if(col > 0 && self[row][col-1] == 'M'){
	            res++;
	        }
	        
	        if(col < cols && self[row][col+1] == 'M'){
	            res ++;
	        }
	        
	        if(row < rows && col > 0 && self[row+1][col-1] == 'M'){
	            res++;
	        }
	        if(row < rows && self[row+1][col] == 'M'){
	            res++;
	        }
	        if(row < rows && col < cols && self[row+1][col+1] == 'M'){
	            res++;
	        }
	        return res;
	        
	    }
	
	
	@Override
	public void go() {
		
//		["EEEEEEEE","EEEEEEEM","EEMEEEEE","MEEEEEEE","EEEEEEEE","EEEEEEEE","EEEEEEEE","EEMMEEEE"]
				
		
		// TODO Auto-generated method stub
		char[][] board = new char[][]{"EEEEEEEE".toCharArray(),
			"EEEEEEEM".toCharArray(),
			"EEMEEEEE".toCharArray(),
			"MEEEEEEE".toCharArray(),
			"EEEEEEEE".toCharArray(),
			"EEEEEEEE".toCharArray(),
			"EEEEEEEE".toCharArray(),
			"EEMMEEEE".toCharArray()};
			
			char[][] result = updateBoard(board,new int[]{0,0});

	}

}
