package com.company;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void talkToMe(Integer times) {
        if (times > 100) {
            Logger.getInstance().show("You talk to much", LoggerType.WARNING);
        } else if (times <= 100 && times >=0){
            Logger.getInstance().show("You talk to me" + times + " times", LoggerType.INFO);
        } else {
            Logger.getInstance().show("Times must be >-0", LoggerType.ERROR);
        }
    }
}
