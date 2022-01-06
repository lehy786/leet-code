package easy;

/**
 * Created by luozhenzhao on 2021/9/2
 * description:
 */
public class LargestOddNumber {
    public static void main(String[] args) {
        System.out.println(largestOddNumber("52"));
    }

    public static String largestOddNumber(String num) {
        if (num == null || "".equals(num)) {
            return "";
        }
        for (int i = num.length()-1; i >= 0; i--){
            int cur = num.charAt(i) - '0';
            if (cur % 2 == 1){
                return num.substring(0, i+1);
            }
        }
        return "";
    }
}
