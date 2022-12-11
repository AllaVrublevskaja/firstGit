import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
/*
1. Склонировать репозиторий себе https://github.com/IlyaBikmeev/streamsJava
2. Создать новую ветку и перейти на неё.
3. В своей ветке сделать следующие изменения:


1.Добавить фамилию и емейл в данный класс Person
2. В классе PeopleTest поправить создание объектов с учетом добавленных полей
3. Заново сгенерить csv файл data set.csv в формате: firstname,lastname,email,age
4. Закомитить данные изменения в вашей ветке.
5. Создать пустой репозиторий на github.com
6. У локального репозитория, в котором вы сделали изменения вам нужно будет поменять origin
(это URL удаленного репозитория) на ваш свежесозданный репозиторий на гитхаб.
7.  Запушить обе ветке в ваш удаленный репозиторий. Сначала ветку main, потом ту,
 в которой вы делали изменения.

 */
public class PeopleTest {
    public static void main(String[] args) {
        List<Person> people = null;

        try(BufferedReader reader = new BufferedReader(
                new FileReader("myFile0.csv"))) {
            people = reader.lines()
                    .skip(1)
                    .map(str -> str.split(","))         //Теперь у нас Stream<String[]>
                    .map(data -> new Person(
                            data[0], data[1], data[2],
                            Integer.parseInt(data[3])))      //Теперь у нас Stream<Person>
                    .collect(Collectors.toList());
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

        //Средний возраст
//        int averageAge = people.stream()
//                .map(Person::getAge)         //Преобразуем всех людей в возраста (Person -> Integer)
//                .reduce(0, Integer::sum) / people.size();

        OptionalDouble averageAge = people.stream()
                .mapToInt(Person::getAge)
                .average();

        if(averageAge.isPresent()) {
            System.out.println(averageAge.getAsDouble());
        }
        else {
            System.out.println("Something went wrong :(((");
        }
    }
}
