public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();

        for (int i = 0; i < 4; i++) {
            arrayStack.push(i);
        }
        arrayStack.pop();

        System.out.println(arrayStack);
    }
}
