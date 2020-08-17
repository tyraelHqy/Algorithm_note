import java.util.Arrays;

/**
 * @author Tyrael
 */
public class InsertionSort {
    private InsertionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {

            // 将 arr[i] 插入到合适的位置
            for (int j = i; j - 1 >= 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
//            for (int j = i; j - 1 >= 0 && arr[j].compareTo(arr[j - 1]) < 0; j++) {
//                swap(arr, j, j - 1);
//            }

        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for (int i = 0; i < arr.length; i++) {

            // 将 arr[i] 进行暂存
            E t = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && t.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }


    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arrs = ArrayGenerator.generatorRandomArray(n, n);
            Integer[] arrs2 = Arrays.copyOf(arrs, arrs.length);
            SortingHelper.sortTest("InsertionSort1", arrs);
            SortingHelper.sortTest("InsertionSort2", arrs2);
        }
    }
}
