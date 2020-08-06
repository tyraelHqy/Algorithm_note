public class SelectionSort {

    private SelectionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 选择arr[i...n) 中最小值的索引
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 4, 3, 5, 6};
        SelectionSort.sort(arr);
        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();

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
    }
}
