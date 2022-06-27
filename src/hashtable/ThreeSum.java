package hashtable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {1,2,-2,-1};
        List<List<Integer>> lists = threeSum(nums);
        lists.forEach(v -> {
            System.out.println("[");
            v.forEach(e -> {
                System.out.print(e + " ");
            });
            System.out.println("]");
        });
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return Collections.emptyList();
        }

        int n = nums.length;
        nums = sort(nums, 0, n - 1);
        List<List<Integer>> resList = new ArrayList<>();
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < n; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                int third = n - 1;
                while (second < third && nums[first] + nums[second] + nums[third] > 0) {
                    third--;
                }
                if (second == third) {
                    break;
                }
                if (nums[first] + nums[second] + nums[third] == 0) {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[first]);
                    res.add(nums[second]);
                    res.add(nums[third]);
                    resList.add(res);
                }
            }
        }
        return resList;
    }

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
}
