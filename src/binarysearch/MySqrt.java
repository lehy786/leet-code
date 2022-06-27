package binarysearch;

/**
 * Created by luozhenzhao on 2022/3/14
 * description: 69. x 的平方根
 */
public class MySqrt {
	public static int mySqrt(int x) {
		Double l = new Double(0);
		Double r = new Double(x);
		Double mid = new Double(x);
		while (Math.abs(r-l) > 0.0000000001) {
			if (mid * mid < x) {
				l = mid;
			}
			else if (mid * mid > x) {
				r = mid;
			}
			else {
				return mid.intValue();
			}
			mid = l + (r - l) / 2;
		}
		int re = r.intValue();
		return re * re > x ? re - 1 : re;
	}

	public static void main(String[] args) {
		System.out.println(mySqrt(9));
	}
}
