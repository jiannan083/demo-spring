package cn.bfay.datastructure;

import org.junit.Test;

/**
 * MaxHeapTest.
 *
 * @author wangjiannan
 * @since 2021/1/13
 */
public class MaxHeapTest {

    /**
     * 1.二叉树的最后一个非叶子节点，计算公式是：array.length / 2 - 1
     * <p>
     * 2.非叶子节点都是相邻的，这就是为什么buildMaxHeap方法中的i的步进方式是减1
     * <p>
     * 3.父节点的左子节点的计算公式是：2 * i + 1
     * <p>
     * 4.父节点的右子节点的计算公式是：2 * i + 2
     * <p>
     * 5.buildMaxHeap方法的length参数意义：因为构建大顶堆后，根节点就成了最大值，此时将根节点和数组尾元素交换，就能将最大值移动到数组末尾，
     * 那么第一大的值已经确定，现在需要确定第二大的值，那么就需要在剩下的元素当中再次构建大顶堆，所以就需要控制后续构建大顶堆时的数组长度，也就是length
     */
    @Test
    public void testMaxHeap() {
        int[] arr = {1, 9, 8, 2, 7, 3, 6, 4, 5};

        int num = 3;
        for (int i = 0; i < num; i++) {
            //buildMaxHeap(arr, arr.length - i);
            buildMaxHeap11(arr, arr.length - i);
            int temp1 = arr[0];
            arr[0] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp1;
            System.out.println(arr[arr.length - i - 1]);
        }


        //buildMaxHeap(arr, arr.length);
        //int temp1 = arr[0];
        //arr[0] = arr[arr.length - 1];
        //arr[arr.length - 1] = temp1;
        //System.out.println(arr[arr.length - 1]);
        //
        //buildMaxHeap(arr, arr.length - 1);
        //int temp2 = arr[0];
        //arr[0] = arr[arr.length - 2];
        //arr[arr.length - 2] = temp2;
        //System.out.println(arr[arr.length - 2]);
        //
        //
        //buildMaxHeap(arr, arr.length - 2);
        //int temp3 = arr[0];
        //arr[0] = arr[arr.length - 3];
        //arr[arr.length - 3] = temp3;
        //System.out.println(arr[arr.length - 3]);
    }

    @Test
    public void test1aa() {
        int[] arr = {1, 9, 8, 2, 7, 3, 6, 4, 5};
        //buildMaxHeap(arr, arr.length);
        buildMaxHeap11(arr, arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    ////构建出来的不是大顶堆
    //private void buildMaxHeap(int[] array, int length) {
    //    // 从最后一个非叶子节点开始，往前。
    //    for (int i = length / 2 - 1; i >= 0; i--) {
    //        adjustHeap(array, i, length);
    //    }
    //}
    //
    //private void adjustHeap(int[] arr, int i, int length) {
    //    // 获取当前非叶子节点的值
    //    //int j = 2 * i + 1;
    //    int
    //
    //
    //    for (int j = 2 * i + 1; j < length; j = 2 * j + 1) {
    //
    //        if (j + 1 < length && arr[j] < arr[j + 1]) {
    //            j++;
    //        }
    //
    //        if (arr[j] > arr[i]) {
    //            int temp = arr[i];
    //            arr[i] = arr[j];
    //            arr[j] = temp;
    //        } else {
    //            break;
    //        }
    //    }
    //}

    /**
     * 构建大顶堆
     *
     * @param array  原始数组
     * @param length 需要构建的长度
     */
    private void buildMaxHeap11(int[] array, int length) {
        //从最后一个非叶子节点开始
        for (int i = length / 2 - 1; i >= 0; i--) {
            adjustHeap11(array, i, length);
        }
    }

    /**
     * 调整大顶堆
     *
     * @param array  被调整数组
     * @param i      非叶子节点
     * @param length 需要调整的长度
     */
    private void adjustHeap11(int[] array, int i, int length) {
        //获取当前非叶子节点的值
        int temp = array[i];
        //依次遍历非叶子节点的左子节点
        for (int j = 2 * i + 1; j < length; j = 2 * j + 1) {
            //让j指向左右子节点较大的哪个
            if (j + 1 < length && array[j] < array[j + 1]) {
                j++;
            }
            //如果子节点>父节点
            if (array[j] > temp) {
                //让当前非叶子节点的值等于子节点的值
                array[i] = array[j];
                //让当前非叶子节点的下标指向当前字节点的下标
                i = j;
            } else {
                //int abc=100;
                //因为大顶堆是从下到上构建的，所以如果父节点是最大的那个的话就可以直接退出循环
                break;
            }
            //让大的子节点等于之前非叶子节点的值
            array[j] = temp;
        }
    }
}
