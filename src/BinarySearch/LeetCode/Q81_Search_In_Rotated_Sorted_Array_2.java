package BinarySearch.LeetCode;

public class Q81_Search_In_Rotated_Sorted_Array_2 {
    static void main(String[] args) {

        int[] nums = {2,5,6,0,0,1,2};
        int target = 0;

        boolean isElementPresent = elementInArray(nums,target);

        if(isElementPresent){
            System.out.println("Element " + target + " is present in array");
        }else{
            System.out.println("Element " + target + " is not present in array");
        }
    }

    static  boolean elementInArray(int[] nums, int target) {

        int low = 0 , high = nums.length-1;

        while(low <= high){
            int mid = low + (high-low)/2;

            // check if element found at index mid
            if(nums[mid] ==  target)
            {
                return true;
            }

            // handle duplicate case
            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                low++;
                high--;
                continue;
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
                if(nums[mid] <= target && target < nums[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return false;
    }
}
