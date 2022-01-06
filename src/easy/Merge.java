package easy;

public class Merge {
    public static void main(String[] args) {
        int [] a = {1,2,3,0,0,0};
        int [] b = {2,5,6};
        merge(a, 3, b, 3);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || nums2.length == 0) {
            return;
        }
//        if (nums1.length == nums2.length) {
//            for (int i = 0; i < nums2.length; i++) {
//                nums1[i] = nums2[i];
//            }
//        }
        int loc = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                swap(nums1,nums1, loc--, m--);
            } else {
                swap(nums1,nums2,loc--, n--);
            }
        }

        while (n >= 0) {
            swap(nums1, nums2, loc--, n--);
        }
    }

    public static void swap(int[] a, int[] b, int pa, int pb) {
        int temp = a[pa];
        a[pa] = b[pb];
        b[pb] = temp;
    }
}
