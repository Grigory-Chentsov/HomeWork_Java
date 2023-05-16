import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/* 1.Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
   Постараться не обращаться к листу по индексам.
   2.Реализуйте очередь с помощью LinkedList со следующими методами: enqueue() - помещает элемент в конец очереди,
   dequeue() - возвращает первый элемент из очереди и удаляет его, first() - возвращает первый элемент из очереди,
   не удаляя.
   3.Найдите сумму всех элементов LinkedList, сохраняя все элементы в списке. Используйте итератор
   * реализовать вторую задачу через собственный класс используя в основе массив */
public class Main {
    public static void main(String[] args) {
//        task1("Пусть дан LinkedList с элементами. Создайте метод, который вернет “перевернутый” список.");
//        task2();
        System.out.println(task3());
    }
    static void task1(String text) {
        LinkedList<String> list = new LinkedList<>();
        String[] words = text.replace(".","").split(" ");
        for (String word: words) {
            list.add(word);
        }
        System.out.println(list.toString());
        LinkedList<String> list_reversed = new LinkedList<>();
        for (String item: list) {
            list_reversed.addFirst(item);
        }
        System.out.println(list_reversed.toString());
    }

    static void task2() {
        MyQueue myQueue = new MyQueue();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        System.out.println(myQueue.first());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.first());
        System.out.println(myQueue);
    }

    static Integer task3() {
        LinkedList<Integer> list = new LinkedList<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(r.nextInt(100));
        }
        System.out.println(list);
        int sum = 0;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object item = iterator.next();
            if (item instanceof Integer) {
                sum += (int) item;
            }
        }
        return sum;
    }
}