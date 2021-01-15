package cn.bfay.datastructure;

import org.junit.Test;
import sun.security.util.Length;

/**
 * MinHeapTest.
 *
 * @author wangjiannan
 * @since 2021/1/13
 */
public class MinHeapTest {
    @Test
    public void testMinHeap() {
        int[] arr = {1, 9, 8, 2, 7, 3, 6, 4, 5};

        int num = 5;
        for (int i = 0; i < num; i++) {
            creatTree(arr, arr.length - i);
            int temp = arr[0];
            arr[0] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
            System.out.println(arr[arr.length - 1 - i]);
        }
    }

    public void creatTree(int[] arr, int length) {
        for (int i = length / 2 - 1; i >= 0; i--) {
            adjustTree(arr, i, length);
        }
    }

    public void adjustTree(int[] arr, int i, int length) {
        int j = 2 * i + 1;
        if (j + 1 < length && arr[j] > arr[j + 1]) {
            j++;
        }

        if (arr[i] > arr[j]) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
