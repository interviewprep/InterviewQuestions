public class RunningMedianStream{
    public static final int K  = 5;
    public static int map[] = new int[2 * K]; 

    public static void accept(int n) {
        int start = 1;
        int end = K;
        int index = 0;
        map[0] = map[0] + 1;
        while (start != end) {
            int mid = (start + end) / 2;
            if (n <= mid) {
                // go to left child 
                index = index * 2 + 1; 
                end = mid;
            } else {
                // go to right child 
                index = index * 2 + 2;
                start = mid + 1;
            }
            map[index] = map[index] + 1;
        }
    }
    
    public static int getMedian() {
        int curr = 0;
        int n = (map[curr] + 1 )/2;
        int start = 1;
        int end = K;
        while (start != end) {
            int mid = (start + end)/2;
            //is median in the left half or right half? 
            if (map[curr * 2 + 1] >= n) {
                //median is towards left
                curr = curr * 2 + 1;
                end = mid;
            } else {
                //median is towards right
                n = n - map[curr * 2 + 1];
                start = mid + 1;
                curr = curr * 2 + 2;
            }
        }
        return start;
    }


   public static void main(String []args) {
         int num[] = {4, 5, 5, 5, 3, 3, 3, 3, 3, 3, 3, 3};
         for (int i : num) {
             System.out.println(" Reading number from stream " + i);
             accept(i);
         }
        System.out.println("median " + getMedian());
     }
}
