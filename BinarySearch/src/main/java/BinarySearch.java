public class BinarySearch {

    private BinarySearch() {
    }

    /**
     * 非递归实现二分查找法
     *
     * @param data
     * @param target
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> int search(E[] data, E target) {
        int l = 0, r = data.length - 1;

        // 在data[l,r]的范围中查找target
        while (l <= r) {
            int mid = l + (l - r) / 2;
            if (data[mid].compareTo(target) == 0) {
                return mid;
            }
            if (data[mid].compareTo(target) < 0) {
                l = mid + 1;
            }
            if (data[mid].compareTo(target) > 0) {
                r = mid - 1;
            }
        }
        return -1;
    }


    /**
     * 递归实现二分查找法
     *
     * @param data
     * @param target
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> int searchR(E[] data, E target) {
        return searchR(data, 0, data.length - 1, target);
    }

    private static <E extends Comparable<E>> int searchR(E[] data, int l, int r, E target) {
        if (l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;

        if (data[mid].compareTo(target) == 0) {
            return mid;
        }
        if (data[mid].compareTo(target) < 0) {
            return searchR(data, mid + 1, r, target);
        }
        if (data[mid].compareTo(target) > 0) {
            return searchR(data, l, mid - 1, target);
        }
        return -1;
    }

    /**
     * 大于target，返回最小值索引
     * 等于target，返回对应的最大索引
     *
     * @param data
     * @param target
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> int ceil(E[] data, E target) {
        int u = upper(data, target);
        if (u - 1 >= 0 && data[u - 1].compareTo(target) == 0) {
            return u - 1;
        }
        return u;
    }


    /**
     * 大于target的最小值索引
     *
     * @param data
     * @param target
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> int upper(E[] data, E target) {
        int l = 0, r = data.length;

        // 在data[l,r]中寻求解
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) <= 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    /**
     * < target的最大值索引
     *
     * @param data
     * @param target
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> int lower(E[] data, E target) {
        int l = -1, r = data.length - 1;

        // 在data[l,r]中寻找解
        while (l < r) {
            int mid = l + (r - l +1) / 2;
            if (data[mid].compareTo(target) < 0) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 1, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i < 8; i++) {
            System.out.print(BinarySearch.upper(arr, i) + " ");
        }
        System.out.println();
        for (int i = 0; i < 8; i++) {
            System.out.print(BinarySearch.ceil(arr, i) + " ");
        }
        System.out.println();
        for (int i = 0; i < 8; i++) {
            System.out.print(BinarySearch.lower(arr, i) + " ");
        }
        System.out.println();
    }

}
