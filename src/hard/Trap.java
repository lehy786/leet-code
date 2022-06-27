package hard;

/**
 * Created by luozhenzhao on 2022/3/15
 * description: 42. 接雨水
 */
public class Trap {
	public static int trap(int[] height) {
		int max = height[0], start = 0, sum = 0;
		// 从左往右扫，记录当前最高柱子，直到遇到比自己大的，计算中间收集到的水
		// 然后从当前位置记录max，并更新当前位置为收集水的左边界
		for (int i = 1; i < height.length; i++) {
			if (height[i] >= max) {
				for (int j = start + 1; j < i; j++) {
					sum += (max - height[j]);
				}
				max = height[i];
				start = i;
			}
		}
		max = -1;
		start = height.length - 1;
		// 同样一遍操作，从右往左扫，遇到比自己大的，计算中间收集的水
		for (int i = height.length - 1; i >= 0; i--) {
			// height[i] == max的情况，从左往右扫的时候已经计算过一遍，因此此处只有大于时才计算，不是>=
			if (height[i] > max) {
				for (int j = start -1; j > i; j--) {
					sum += (max - height[j]);
				}
				max = height[i];
				start = i;
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		int [] num = {2,0,2};
		System.out.println(trap(num));
	}
}
