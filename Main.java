import java.util.List;

/* Дана json строка [{ "фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4",
"предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Задача написать метод(ы), который распарсит строку и выдаст ответ вида:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.

Используйте StringBuilder для подготовки ответа

Исходная json строка это просто String !!! Для работы используйте методы String, такие как replace, split, substring
и т.д. по необходимости

Создать метод, который запишет результат работы в файл. Обработайте исключения и запишите ошибки в лог файл.
2. *Получить исходную json строку из файла, используя FileReader или Scanner
3. *Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл. */
public class Main {
    public static void main(String[] args) {
        parseJson();
    }
    static void parseJson() {
        String jsonString =  "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}, " +
                             "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}, " +
                             "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        // Удаляем квадратные скобки в начале и конце строки
        jsonString = jsonString.substring(1, jsonString.length() - 1);
        // Разбиваем строку на массив строк по запятой и пробелу
        String[] studentStrings = jsonString.split(", ");
        // Создаем StringBuilder для подготовки ответа
        StringBuilder sb = new StringBuilder();
        // Проходим по каждой строке студента
        for (String studentString : studentStrings) {
            // Удаляем кавычки в начале и конце строки
            studentString = studentString.substring(1, studentString.length() - 1);
            // Разбиваем строку на массив строк по двоеточию и пробелу
            String[] keyValueStrings = studentString.split(",|:");
            // Получаем фамилию, оценку и предмет из массива строк
            String surname = keyValueStrings[1].replace("\"", "");
            String mark = keyValueStrings[3].replace("\"", "");
            String subject = keyValueStrings[5].replace("\"", "");
            // Добавляем информацию о студенте в StringBuilder
            sb.append("Студент ")
                    .append(surname)
                    .append(" получил ")
                    .append(mark)
                    .append(" по предмету ")
                    .append(subject)
                    .append(".\n");
        }
        // Выводим ответ
        System.out.println(sb.toString());
    }
}