package Issues;

import java.util.LinkedList;

public class Q346 implements IIssueTemplate{
    @Override
    public void go() {

        Q346 q = new Q346();
        q.MovingAverage(3);
        q.next(1);
        q.next(10);
       double a = q.next(3);
        q.next(5);
    }

    LinkedList<Integer> list;
    int count = 0;
    double sum = 0;
    int size = 0;

    /** Initialize your data structure here. */
    public void MovingAverage(int size) {

        list = new LinkedList();
        this.size = size;
    }

    public double next(int val) {
        if(count < size){
            count++;
            sum += val;
            list.offer(val);
            return sum / count;
        }

        int out = list.poll();
        sum -= out;
        sum += val;
        list.offer(val);
        return sum/size;
    }
}
