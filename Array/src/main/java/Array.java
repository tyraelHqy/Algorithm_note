public class Array {

    private int[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 无参的构造函数，默认数组的容量是Capacity=10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组中的元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断数组是不是为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向整个数组的最后添加一个新元素
     */
    public void addLast(int e) {
        add(size, e);
    }

    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * 向第index个位置插入一个新元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("Add failed,Array is full");
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,Require index >= 0 and index < size");
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }
}
