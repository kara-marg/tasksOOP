package task1;

import java.io.Serializable;

public class Person implements Serializable {
    static String[] names = {"Bob", "Rob", "Mark", "Tony", "Tor"};
    static String[] countries = {"Ukraine","Poland","US","Armenia"};

    private String name;
    private int age;
    private String country;

    public Person(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", country=" + country +
                '}';
    }

    public static Person createRandomPerson(){
        String name = names[(int)(names.length * Math.random())];
        String country = countries[(int)(countries .length * Math.random())];
        return new Person(name, (int)Math.random()*50, country);
    }
}
