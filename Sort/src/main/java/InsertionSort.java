import java.util.Arrays;

/**
 * @author Tyrael
 */
public class InsertionSort {
    private InsertionSort() {
    }

    /**
     * 循环不变量：arr[0，i）已排好序；arr[i...n）未排序
     *
     * @param arr
     * @param <E>
     */
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

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        for (int i = l; i <= r; i++) {

            // 将 arr[i] 进行暂存
            E t = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && t.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

    /**
     * 插入排序算法的改进版本，不使用swap，使用移位的方式
     *
     * @param arr
     * @param <E>
     */
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

    /**
     * 循环不变量：arr[0，i）未排好序；arr[i...n）排序
     *
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort3(E[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {

            // 将 arr[i] 进行暂存
            E t = arr[i];
            int j;
            for (j = i; j + 1 < arr.length && t.compareTo(arr[j + 1]) > 0; j++) {
                arr[j] = arr[j + 1];
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
            System.out.println("Random Array : ");
            Integer[] arrs = ArrayGenerator.generatorRandomArray(n, n);
            Integer[] arrs2 = Arrays.copyOf(arrs, arrs.length);
            Integer[] arrs3 = Arrays.copyOf(arrs, arrs.length);
            SortingHelper.sortTest("InsertionSort2", arrs);
            SortingHelper.sortTest("SelectionSort", arrs2);
            SortingHelper.sortTest("InsertionSort3", arrs3);
            System.out.println();

            System.out.println("Order Array : ");
            arrs = ArrayGenerator.generatorOrderedArray(n);
            arrs2 = Arrays.copyOf(arrs, arrs.length);
            SortingHelper.sortTest("InsertionSort2", arrs);
            SortingHelper.sortTest("SelectionSort", arrs2);
            System.out.println();
        }
    }
}
