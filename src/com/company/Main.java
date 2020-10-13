package com.company;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        System.out.println("Singleton Patter in Java");
        Logger.getInstance().show("This is Singleton Pattern", LoggerType.INFO);
        Person person = new Person("Son");
        person.talkToMe(-120);
        person.talkToMe(90);
        person.talkToMe(120);
    }
}
