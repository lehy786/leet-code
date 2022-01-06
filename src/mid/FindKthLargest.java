package mid;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        // 构建大顶堆
        for (int i = nums.length / 2; i >= 0; i--) {
            percDown(nums, i, nums.length);
        }

        // 取出堆顶
        for (int i = nums.length - 1; i >= nums.length - k; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            // 重新调整堆顶元素
            percDown(nums, 0, i);
        }

        // 返回倒数第k个元素
        return nums[nums.length - k];
    }

    /**
     * 将a下标处的节点沉到二叉树的正确位置
     * @param nums
     * @param a
     */
    public void percDown(int [] nums, int a, int size) {
        int temp = nums[a];
        int child;
        for (; leftChild(a) < size; a = child) {
            child = leftChild(a);
            // 如果有右孩子，并且右孩子元素值更大
            if (child < size - 1 && nums[child + 1] > nums[child]) {
                // 选取右孩子来进行比较
                child++;
            }
            // 与孩子节点比较
            if (temp < nums[child]) {
                nums[a] = nums[child];
            } else {
                break;
            }
        }
        nums[a] = temp;
    }

    public int leftChild(int i) {
        return 2 * i + 1;
    }

}
