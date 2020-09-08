import java.util.Arrays;

public class MergeSort {
    private MergeSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {
        sort2(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort2(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        // 区间中的元素个数不大于16
//        if (r - l <= 15) {
//            InsertionSort.sort(arr, l, r);
//            return;
//        }
        int mid = (l + r) / 2;
        sort2(arr, l, mid);
        sort2(arr, mid + 1, r);

        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
    }


    // 合并两个有序的区间 arr[l,mid] 和 arr[mid+1,r]
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {

        // 临时备份的数组,需要复制arr[l,r+1)
        E[] temp = Arrays.copyOfRange(arr, l, r + 1);

        // i 和 j 分别指向两个区间的头元素
        int i = l, j = mid + 1;

        // 每轮循环为 arr[k] 赋值
        for (int k = l; k <= r; k++) {

            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
                arr[k] = temp[i - l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }
        }
    }


    public static <E extends Comparable<E>> void sort3(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        sort3(arr, 0, arr.length - 1, temp);
    }

    private static <E extends Comparable<E>> void sort3(E[] arr, int l, int r, E[] temp) {
        if (l >= r) {
            return;
        }

        // 区间中的元素个数不大于16
//        if (r - l <= 15) {
//            InsertionSort.sort(arr, l, r);
//            return;
//        }
        int mid = (l + r) / 2;
        sort3(arr, l, mid, temp);
        sort3(arr, mid + 1, r, temp);

        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge3(arr, l, mid, r, temp);
        }
    }


    // 合并两个有序的区间 arr[l,mid] 和 arr[mid+1,r]
    private static <E extends Comparable<E>> void merge3(E[] arr, int l, int mid, int r, E[] temp) {

        System.arraycopy(arr, l, temp, l, r - l + 1);

        // i 和 j 分别指向两个区间的头元素
        int i = l, j = mid + 1;

        // 每轮循环为 arr[k] 赋值
        for (int k = l; k <= r; k++) {

            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i].compareTo(temp[j]) <= 0) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {

        int n = 100000;

        Integer[] arr = ArrayGenerator.generatorRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        Integer[] arr4 = Arrays.copyOf(arr, arr.length);
        Integer[] arr5 = Arrays.copyOf(arr, arr.length);


        SortingHelper.sortTest("SelectionSort", arr);
        SortingHelper.sortTest("InsertionSort1", arr2);
        SortingHelper.sortTest("MergeSort", arr3);
        SortingHelper.sortTest("MergeSort2", arr4);
        SortingHelper.sortTest("MergeSort3", arr5);
    }
}
