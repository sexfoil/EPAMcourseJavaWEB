package p06streams;

import utility.DataExamples;
import utility.UserInterface;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Part06Runner {
    /*
     7.6. Напишите консольное приложение, которое:

         − описывает класс Person с полями: имя, возраст и пол, методами: getter() и setter(),
         конструктором и переопределенным методом toString();

         − создает коллекцию объектов типа Person и, используя Stream,
         выбирает и выводит на консоль всех военнообязанных мужчин;

         − определяет для коллекции объектов типа Person средний возраст женщин с использованием Stream.

    */
    public void run() {
        System.out.println(UserInterface.BORDER);

        List<Integer> intList = Stream
                .iterate(10, num -> num + 10)
                .limit(10)
                .map(num -> num / 2)
                .collect(Collectors.toList());
        System.out.println(intList);

        System.out.println(UserInterface.BORDER);

        Person[] peoples = DataExamples.persons;
        //Arrays.stream(peoples).filter()

        System.out.println(UserInterface.BORDER);



        System.out.println(UserInterface.BORDER);
    }
}
