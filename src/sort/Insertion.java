package sort;

/**
 * Created by luozhenzhao on 2021/11/17
 * description: 插入排序
 */
public class Insertion {
    static int [] a = {4,3,8,5,2,8,4,0};

    public static void main(String[] args) {
        InsertionSort(a, a.length);
        for (int i : a) {
            System.out.println(i);
        }
    }

    private static void InsertionSort(int[] a, int n) {

    }
}
