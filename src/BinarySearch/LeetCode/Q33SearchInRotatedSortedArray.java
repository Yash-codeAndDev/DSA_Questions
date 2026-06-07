package BinarySearch.LeetCode;

public class Q33SearchInRotatedSortedArray {

    static void main(String[] args) {

        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        int eleIndex = searchElement(nums,target);

        System.out.println("element " + target + " is found at index " + eleIndex);
    }

    static  int searchElement(int[] nums, int target) {

        int low = 0 , high = nums.length-1;

        while(low <= high){
            int mid = low + (high-low)/2;

            // check if element found at index mid
            if(nums[mid]==  target)
            {
                return mid;
            }

            // check if sorted part of nums of form low to mid
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target < nums[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
            // check if sorted part of nums of form low to mid
            else{
                if(nums[mid] <= target && target <= nums[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
