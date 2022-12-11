import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.*;

public class Program {
    public static void main(String[] args) {
        //1. Stream можно преобразовать в коллекцию
        List<Integer> numbers = Arrays.asList(13, -5, 13, -7, -13, 64, 42, 64, 647, 134, 123,15);

        //Список нечетных чисел
        List<Integer> oddNumbers = numbers.stream()
                .filter(number -> Math.abs(number) % 2 == 1)
                .collect(Collectors.toList());

        Set<Integer> uniqueOddNumbers = numbers.stream()
                .filter(number -> Math.abs(number) % 2 == 1)
                .collect(Collectors.toSet());

        int sum_1 = numbers.stream()
                .reduce(0, Integer::sum);       //Вместо Integer::sum можно написать (a, b) -> a + b

        int sum_2 = 0;
        for(Integer number : numbers) {
            sum_2 += number;
        }

        //Среднее значение:
        int average = numbers.stream()
                .reduce(0, Integer::sum) / numbers.size();

        //Медиана:
        int mean = numbers.stream()
                .sorted()
                .skip(numbers.size() / 2 - (numbers.size() + 1) % 2)
                .limit(numbers.size() % 2 == 1 ? 1 : 2)   //В потоке осталась один или два элемента
                .reduce(0, Integer::sum) / (numbers.size() % 2 == 0 ? numbers.size() : 1);  //а делим на
        // общее количество элементов массива, если в массиве numbers нечетное количество элементов ??????
        System.out.println(mean);
    }
}
