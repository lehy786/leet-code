package easy;

public class AddStrings {
    public static String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null)
            return "0";
        int up = 0;
        int m = num1.length() - 1,  n = num2.length() - 1;
        StringBuilder sb = new StringBuilder();

        while (m >= 0 || n >= 0) {
            int a = m >= 0 ? num1.charAt(m--) - 48 : 0;
            int b = n >= 0 ? num2.charAt(n--) - 48 : 0;
            int v = (a + b + up) % 10;
            up = (a + b + up) / 10;
            sb.insert(0, v);
        }
        if (up > 0)
            sb.insert(0, up);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("9", "99"));
    }
}
