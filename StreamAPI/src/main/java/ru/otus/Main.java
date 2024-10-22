package ru.otus;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Task> list = new ArrayList<>();
        for(int i = 1; i < 20; i++)
            list.add(new Task(i, "task", Status.randomStatus()));
        System.out.println("---------------------------------------------------------------");

        list.stream().filter(e -> e.getStatus() == Status.ACTIVE).forEach(System.out::println);

        System.out.println("*****************************************************");

        System.out.println(list.stream().filter(e -> e.getStatus() == Status.CLOSED).count());

        System.out.println("*****************************************************");

        Task element = list.stream()
                .filter(e -> e.getId() == 2)
                .findAny()
                .orElse(null);
        System.out.println(element);

        System.out.println("*****************************************************");

        if(list.size() >= 98)
            list.remove(98);


        Task element99 = list.stream()
                .filter(e -> e.getId() == 99)
                .findAny()
                .orElse(null);
        System.out.println(element99 == null ? "Not found!" : element99);

        System.out.println("*****************************************************");
        // Проверка на удаленый элемент 99
        /*
        for (int i = 0; i <= list.size()-1; i++){
            if(list.get(i).getId() == 99){
                System.out.println("Stream ERROR!");
                break;
            }
            if(i == list.size()-1){
                System.out.println("Not found element ID=99");
                break;
            }
        }
        System.out.println("*****************************************************");
        */

        list.stream()
                .sorted((Comparator.comparing(Task::getStatus)))
                .forEach(System.out::println);

        System.out.println("*****************************************************");

        list.stream()
                .sorted((Comparator.comparing(Task::getStatus).thenComparing(task -> task.getId() % 2)))
                .forEach(System.out::println);

        System.out.println("*****************************************************");

        list.stream()
                .sorted((Comparator.comparing(t -> t.getStatus() != Status.CLOSED)))
                .forEach(System.out::println);
        System.out.println("---------------------------------------------------------------");
    }
}
