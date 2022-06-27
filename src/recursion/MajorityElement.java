package recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by luozhenzhao on 2022/2/28
 * description: 169. 多数元素
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int maxEle = Integer.MIN_VALUE, maxCount = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            if (maxCount < map.get(num)) {
                maxEle = num;
                maxCount = map.get(maxEle);
            }
        }
        return maxEle;
    }
}
