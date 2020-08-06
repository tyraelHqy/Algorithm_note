public class SortingHelper {
    private SortingHelper() {
    }

    public static <E extends Comparable> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 封装了测试排序算法的公共方法
     * @param sortname
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sortTest(String sortname, E[] arr) {
        long startTime = System.nanoTime();
        if ("SelectionSort".equals(sortname)) {
            SelectionSort.sort2(arr);
        }
        if ("InsertionSort".equals(sortname)) {
            InsertionSort.sort(arr);
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;

        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException(sortname + "SelectionSort failed");
        }
        System.out.println(String.format("%s, n = %d : %f s", sortname, arr.length, time));
    }
}