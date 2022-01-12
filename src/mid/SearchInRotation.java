package mid;

public class SearchInRotation {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int idx = findLargest(nums);
        if (target < nums[0]) {
            return find(nums, target, idx + 1, nums.length - 1);
        } else {
            return find(nums, target, 0, idx);
        }
    }

    public static int find(int[] nums, int target, int l, int r) {
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static int findLargest(int[] nums) {
        int l = 0, r = nums.length, last = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] > nums[last]) {
                if (nums[mid + 1] > nums[last]) {
                    l = mid + 1;
                } else {
                    return mid;
                }
            } else {
                r = mid - 1;
            }
        }
        return last;
    }

    public static void main(String[] args) {
        int [] a = {4,5,6,7,0,1,2};
        System.out.println(search(a, 0));
    }
}
