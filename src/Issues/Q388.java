package Issues;

import java.util.ArrayList;

public class Q388 implements IIssueTemplate {


    public int lengthLongestPath(String input) {

        String[] inputArray = input.split("\n");
        int[] tracker = new int[inputArray.length+1];

        int res = 0;


        for(String str : inputArray){
            String[] elementArray  = str.split("\t");
            int len = elementArray.length;
            String last = elementArray[len-1];

            if(last.contains(".")){//this is a file

                res = Math.max(res, tracker[len-1]+last.length()+len-1);

            }else{ // dir
                tracker[len] = tracker[len-1]+last.length();

            }
        }

        return res;
    }

    @Override
    public void go() {
        String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";

        System.out.println(lengthLongestPath(input));
    }
}
