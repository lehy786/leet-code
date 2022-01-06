package sort;

public class QuickSort {
    public static int[] sortArray(int[] nums) {
        return null;
    }

//    public static int[] sort(int[] nums, int start, int end) {
//        if (start >= end) {
//            return nums;
//        }
//        int temp = nums[end];
//        int p = end;
//        while (start < end) {
//            while (start < end && nums[start] <= temp) {
//                start++;
//            }
//            nums[p] = nums[start];
//            end--;
//            p = start;
//            while (start < end && nums[end] >= temp) {
//                end--;
//            }
//            nums[p] = nums[end];
//            start++;
//            p = end;
//        }
//        nums[p] = temp;
//        return nums;
//    }

    public static int[] sort(int[] nums, int start, int end) {
        if (start >= end) {
            return nums;
        }
        int l = start, r = end;
        int temp = nums[end];
        while (start < end) {
            while (start < end && nums[start] < temp) {
                start++;
            }
            if (start < end) {
                nums[end--] = nums[start];
            }
            while (start < end && nums[end] > temp) {
                end--;
            }
            if (start < end) {
                nums[start++] = nums[end];
            }
        }
        nums[end] = temp;
        sort(nums, l, end - 1);
        sort(nums, end + 1, r);
        return nums;
    }

    public static void main(String[] args) {
        int[] a = {5,2,3,1};
        int[] b = sort(a, 0, a.length - 1);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
    }
}
