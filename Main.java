import java.util.*;

/* 1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
   2. Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин,
   Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова,
   Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов. Написать программу, которая найдет и выведет повторяющиеся
   имена с количеством повторений. Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.
   * Реализовать алгоритм пирамидальной сортировки (HeapSort)
   ** На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. */
public class Main {
    public static void main(String[] args) {
//        task1();
        task2();
    }

    static void task1() {
        Map<String, String> phone_book = new HashMap<>();
        phone_book.put("123456", "Grigor");
        System.out.println(phone_book);
        phone_book.put("234567", "Grigor");
        phone_book.put("345678", "Grigor");
        System.out.println(phone_book);
    }

    static void task2() {
        List<String> employees = Arrays.asList(
                "Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова", "Иван Юрин",
                "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина",
                "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"
        );

        Map<String, Integer> nameCounts = new TreeMap<>();

        for (String employee : employees) {
            nameCounts.put(employee.split(" ")[0], nameCounts.getOrDefault(employee.split(" ")[0], 0) + 1);
        }

        nameCounts.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);
    }

}