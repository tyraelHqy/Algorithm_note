import java.util.Arrays;

public class MergeSort {
    private MergeSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l > r) {
            return;
        }
        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    // 合并两个有序的区间 arr[l,mid] 和 arr[mid+1,r]
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {

        // 临时备份的数组,需要复制arr[l,r+1)
        E[] temp = Arrays.copyOfRange(arr, l, r + 1);

        // i 和 j 分别指向两个区间的头元素
        int i = l, j = mid + 1;

        // 每轮循环为 arr[k] 赋值
        for (int k = 0; k <= r; k++) {

            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (i < mid && j > r) {
                arr[k] = temp[i - l];
                i++;
            } else {
                if (temp[i - l].compareTo(temp[j - l]) <= 0) {
                    arr[k] = temp[i - l];
                    i++;
                } else {
                    arr[k] = temp[j - l];
                    j++;
                }
            }
        }
    }
}
