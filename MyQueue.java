import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
    private LinkedList<Integer> list = new LinkedList<Integer>();

    void enqueue(int item) {
        list.add(item);
    }
    int dequeue() {
        return list.remove();
    }
    int first() {
        return list.peek();
    }
}
