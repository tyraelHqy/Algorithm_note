public class SelectionSort {

    private SelectionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 选择arr[i...n) 中最小值的索引
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }


    // 换个角度实现选择排序的方法
    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for (int i = arr.length - 1; i >= 0 ; i--){
            int maxIndex = i;
            for(int j = i ; j >= 0; j--){
                if(arr[j].compareTo(arr[maxIndex])>0){
                    maxIndex = j;
                }
            }
            swap(arr,i,maxIndex);
        }
    }


    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student("Lihua", 45),
                new Student("YangGuo", 110),
                new Student("GuoJin", 2),
                new Student("DuanYu", 82)
        };
        SelectionSort.sort(students);
        for (Student s : students) {
            System.out.print(s.toString() + " ");
        }
        System.out.println();

        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arrs = ArrayGenerator.generatorRandomArray(n, n);
            SortingHelper.sortTest("SelectionSort", arrs);
        }
    }
}
