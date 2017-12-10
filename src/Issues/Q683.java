package Issues;

public class Q683 implements IIssueTemplate {
    @Override
    public void go() {

    }

    public int kEmptySlots(int[] flowers, int k) {

        return betterThought(flowers, k);
    }

    int betterThought(int[] flowers, int k){

        int[] spots = new int[flowers.length];

        for(int i = 0; i < flowers.length; i++){
            spots[flowers[i]-1] = i+1;
        }

        int start = 0;
        int end = start+k+1;
        int record = Integer.MAX_VALUE;


        for(int i = start; end < spots.length; i++){

            if( i == end){
                record = Math.min(record, Math.max(spots[start], spots[end]));

                start = i;
                end = start+k+1;
                continue;
            }

            if(spots[i] < spots[start] || spots[i] < spots[end] ){

                start = i;
                end = start+k+1;
            }


        }

        return (record == Integer.MAX_VALUE)?-1:record;



    }




    int originalThought(int[] flowers, int k){
        int[] array = new int[flowers.length+1];

        boolean[] isBloom = new boolean[flowers.length+1];

        for(int i = 0; i < flowers.length; i++){

            int pos = flowers[i];

            isBloom[pos] = true;

            int left = pos -k-1;

            //left
            if(left >= 1 && isBloom[left] && array[left] == array[pos]){
                return i+1;
            }

            array[pos]++;
            //right
            int right = pos +k+1;
            if(right < array.length && isBloom[right] && array[pos] == array[right]){
                return i+1;
            }


            for(int j = pos+1; j < array.length; j++){
                array[j] ++;
            }

        }

        return -1;
    }
}
