package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by luozhenzhao on 2021/8/10
 * description:
 */
public class ContainsNearbyDuplicate {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k <= 0) {
            return false;
        }
        Set<Integer> kBucket = new HashSet<>(k);
        for (int i = 0; i < k && i < nums.length; i++) {
            if (kBucket.contains(nums[i])) {
                return true;
            }
            kBucket.add(nums[i]);
        }
        for (int i = 0, j = k; i < nums.length && j < nums.length; i++, j++) {
            if (kBucket.contains(nums[j])) {
                return true;
            }
            kBucket.remove(nums[i]);
            kBucket.add(nums[j]);
            if (kBucket.contains(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }
}
