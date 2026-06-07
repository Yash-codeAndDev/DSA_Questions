package BinarySearch.LeetCode;

public class Q153_Find_Minimum_In_Rotated_Sorted_Array {
    static void main(String[] args) {

        int[] nums = {4,5,6,7,0,1,2};

        int min_element  = findMin(nums);
        System.out.println("Minimum element is "+min_element);
    }
    public static int findMin(int[] nums) {

        int low = 0;
        int high = nums.length-1;

        while (low < high) {
            int mid = low + (high-low)/2;
            if (nums[mid] <= nums[high]) {
                high = mid;
            }else {
                low = mid+1;
            }
        }
        return nums[low];
    }
}
