package Issues;

public class Q418 {
    public int wordsTyping(String[] sentence, int rows, int cols) {

        return smartWay(sentence, rows, cols);

    }

    int smartWay(String[] sentence, int rows, int cols){

        int[] counts = new int[sentence.length];
        int[] goTo = new int[sentence.length];

        for(int i = 0; i < sentence.length; i++){
            int times = 0;
            int index = i;
            int remain = cols;
            while(remain >= sentence[index].length()){
                remain -= sentence[index].length() +1;
                if(index == sentence.length-1){
                    index = 0;
                    times++;
                }else{
                    index ++;
                }
            }

            counts[i] = times;
            goTo[i] = index;
        }

        int index = 0;
        int result = 0;
        for(int row = 0; row < rows; row++){
            result += counts[index];
            index = goTo[index];
        }

        return result;
    }

    int bruteForce(String[] sentence, int rows, int cols){
        int[] sizes = new int[sentence.length];
        for(int i = 0; i < sentence.length; i++){
            sizes[i] = sentence[i].length();
        }

        int result = 0;

        int range = sentence.length;

        int index = 0;

        for(int i = 0 ;i < rows; i++){
            int remain = cols;


            while(remain >= sizes[index]){
                remain -= sizes[index] +1;
                if(index == range-1){
                    result ++;
                }

                index = (index+1)%range;
            }
        }

        return result;
    }
}
