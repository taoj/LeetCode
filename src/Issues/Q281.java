package Issues;

import java.util.Iterator;
import java.util.List;

public class Q281 implements IIssueTemplate{


    Iterator<Integer> it;
    Iterator<Integer> it1;
    Iterator<Integer> it2;
    public void ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        it1 = v1.iterator();
        it2 = v2.iterator();

        if(it1.hasNext()){
            it = it1;
        }else{
            it = it2;
        }

    }

    public int next() {

        int res = it.next();

        if(it == it1 && it2.hasNext()){
            it = it2;
        }else if(it == it2 && it1.hasNext()){
            it = it1;
        }
        return res;
    }

    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public void go() {

    }
}
