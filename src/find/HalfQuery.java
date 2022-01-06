package find;

public class HalfQuery {
    public static void main(String[] args) {
        int [] a = {2,4,5,5,5,7,8,8,9};
//        System.out.println(halfQuery(a, 9, 2));
//        System.out.println(halfQueryFirstEqual(a, 9, 8));
//        System.out.println(halfQueryLastEqual(a, 9, 5));
//        System.out.println(halfQueryFirstGreaterEqual(a, 9, 6));
        System.out.println(halfQueryFirstLessEqual(a, 9, 6));
    }

    // 基本
    static int halfQuery(int [] a, int n, int value) {
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] > value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 以下为变种二分查找
     */

    // 第一个值等于给定值的元素
    static int halfQueryFirstEqual(int [] a, int n, int value) {
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (a[mid] == value) {
                if (mid == 0 || a[mid - 1] != value)
                    return mid;
                else
                    right = mid - 1;
            } else if (a[mid] > value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // 最后一个值等于给定值的元素
    static int halfQueryLastEqual(int [] a, int n, int value) {
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (a[mid] == value) {
                if (mid == n - 1 || a[mid + 1] != value)
                    return mid;
                else
                    left = mid + 1;
            } else if (a[mid] > value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // 第一个值大于等于给定值的元素
    static int halfQueryFirstGreaterEqual(int [] a, int n, int value) {
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (a[mid] >= value) {
                if (mid == 0 || a[mid - 1] < value)
                    return mid;
                else
                    right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // 最后一个值小于等于给定值的元素
    static int halfQueryFirstLessEqual(int [] a, int n, int value) {
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (a[mid] <= value) {
                if (mid == n - 1 || a[mid + 1] > value)
                    return mid;
                else
                    left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
