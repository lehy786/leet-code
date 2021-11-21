package sort;

/**
 * Created by luozhenzhao on 2021/11/17
 * description: 冒泡排序
 */
public class Bubble {
    static int [] a = {4,3,8,5,2,8,4,0};

    public static void main(String[] args) {
        bubbleSort(a, a.length);
        for (int i : a) {
            System.out.println(i);
        }
    }

    static void bubbleSort(int [] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i -1; j++){
                // 大于才交换，等于不交换，则为稳定排序算法
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                // 一轮当中都没有数据交换，则排序已完成，可以提前退出
                break;
            }
        }
    }
}
