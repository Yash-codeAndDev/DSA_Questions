package BinarySearch.LeetCode;

public class Q275_H_Index_2 {
    static void main(String[] args) {
//        int citations[] = {5,10,11,15};
        int citations[] = {0,1,3,5,6};
        int ans = hIndex(citations);
        System.out.println(ans);
    }

    public static int hIndex(int[] citations) {
        int n = citations.length;
        int high = n-1;
        int low = 0;
        while(low<= high)
        {
            int mid = low + (high-low)/2;

            if( citations[mid] == n-mid )
            {
                return n-mid;
            }
            else if(citations[mid] > n-mid){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return n-low;
    }
}
