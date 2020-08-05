/**
 * @author Tyrael
 */
public class LinearSearch {

    private LinearSearch(){}

    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] dataSize = {1000000,10000000};
        for(int n:dataSize) {
            Integer[] data = ArrayGenerator.generatorOrderedArray(n);

            long start = System.nanoTime();
            for (int i = 0; i < 100; i++) {
                LinearSearch.search(data, n);
            }
            long end = System.nanoTime();
            double time = (end - start) / 1000000000.0;
            System.out.println("n = " + n + " , 100 runs: " + time + " s");
        }

//        int res2 = LinearSearch.search(data, 666);
//        System.out.println(res2);
//
//        Student[] students = {new Student("Alice"),new Student("Leo")};
//        Student leo = new Student("Leo");
//        int res3 = LinearSearch.search(students,leo);
//        System.out.println(res3);
    }
}
