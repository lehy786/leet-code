package recursion;

/**
 * Created by luozhenzhao on 2022/2/28
 * description: 50. Pow(x, n)
 */
public class MyPow {
    public static double myPow(double x, int n) {
        if (n == 1)
            return x;
        if (n == 0)
            return 1;
        if (n < 0) {
            return 1 / myPow(x, -n);
        }
        if (n % 2 != 0)
            return x * myPow(x, n-1);
        return myPow(x * x, n / 2);
    }

    public static void main(String[] args) {
        System.out.println(myPow(1, -2147483648));
//        System.out.println(myPow(2, 31));
    }
}
