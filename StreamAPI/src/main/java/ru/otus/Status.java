package ru.otus;

import java.util.Random;

public enum Status {
     OPEN,
    ACTIVE,
    CLOSED;

     private static final Random RANG = new Random();

     public static Status randomStatus(){
         Status[] value = values();
         return value[RANG.nextInt(value.length)];
     }
}
