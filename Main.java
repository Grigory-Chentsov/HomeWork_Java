import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

/* 1-Пусть дан произвольный список целых чисел, удалить из него четные числа.
   2-Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка.
     Collections.max()
   3-Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями. Вывести название каждой
     планеты и количество его повторений в списке.
   * Реализовать алгоритм сортировки слиянием */
public class Main {
    public static void main(String[] args) {
//        task1(11);
//        task2(10);
//        task3(18);
        star();
    }

    static void task1(int size) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add((int) (Math.random() * 100));
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
            }
        }
        System.out.println(numbers);
    }

    static void task2(int size) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add((int) (Math.random() * 100));
        }
        double summ = 0;
        for (int i = 0; i < numbers.size(); i++) {
            summ += numbers.get(i);
        }
        System.out.println(numbers);
        System.out.println(Collections.min(numbers));
        System.out.println(Collections.max(numbers));
        System.out.println(summ / numbers.size());
    }

    static void task3(int size) {
        String[] planets = new String[]{"Меркурий", "Венера", "Земля", "Марс", "Юпитер", "Сатурн", "Уран", "Нептун", "Плутон"};
        List<String> list_planets = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list_planets.add(planets[(int) (Math.random() * planets.length)]);
        }
        System.out.println(list_planets);
        int count = 0;
        String planet = "";
        for (int i = 0; i < planets.length; i++) {
            planet = planets[i];
            for (int j = 0; j < list_planets.size(); j++) {
                if (list_planets.get(j).equalsIgnoreCase(planet)) {
                    count++;
                }
            }
            System.out.println(planet + ": " + count);
            count = 0;
        }
//        Map<String, Integer> frequency = list_planets.stream()
//                // собираем элементы листа в карту
//                .collect(Collectors.toMap(
//                        // ключ - строка
//                        e -> e,
//                        // значение - число,
//                        // количество вхождений
//                        e -> 1,
//                        // суммируем количество вхождений
//                        Integer::sum));
//
//        // Обходим карту и выводим содержимое
//        frequency.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    static void star() {
        int[] array1 = {8, 0, -3, 5, 6, 9, 8, -4, 2, -99, 43};
        int[] result = star_mergesort(array1);
        System.out.println(Arrays.toString(result));
    }
    static int[] star_mergesort(int[] array1) {
        int[] buffer1 = Arrays.copyOf(array1, array1.length);
        int[] buffer2 = new int[array1.length];
        int[] result = star_mergesortInner(buffer1, buffer2, 0, array1.length);
        return result;
    }
    static int[] star_mergesortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }
        // уже отсортирован.
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = star_mergesortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = star_mergesortInner(buffer1, buffer2, middle, endIndex);
        // Слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
}