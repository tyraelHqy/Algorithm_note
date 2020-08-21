public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();

        for (int i = 0; i < 4; i++) {
            arrayStack.push(i);
        }
        System.out.println(arrayStack);
    }
}
