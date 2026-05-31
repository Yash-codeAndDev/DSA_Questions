package BinarySearch.LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class Q34_Find_First_and_Last_Position_Of_Element_In_Array
{
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();
        System.out.println("Enter the elements in the array");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter element to find its first and last occurrence ");
        int target = sc.nextInt();

        int[] range = searchRange(arr, target);

        System.out.println("First occurrence is " + range[0]+" ;  Last occurrence is " + range[1]);

    }

    static int[] searchRange(int[] arr, int target) {
        if (arr.length == 0) {
            return new int[] {-1, -1};
        }

        // Find first occurrence of target
        int first = binarySearch(arr, target, true);

        // If first position is not found, target doesn't exist
        if (first == -1) {
            return new int[] {-1, -1};
        }

        // Find last occurrence of target
        int last = binarySearch(arr, target, false);

        return new int[] {first, last};
    }
    public  static int binarySearch(int[] arr, int target, boolean findFirst) {
        int left = 0, right = arr.length - 1;
        int result = -1; // If not found

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;

                if (findFirst) {
                    right = mid - 1;  // Keep searching LEFT for first occurrence
                } else {
                    left = mid + 1;   // Keep searching RIGHT for last occurrence
                }
            }
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return result;
    }
}
