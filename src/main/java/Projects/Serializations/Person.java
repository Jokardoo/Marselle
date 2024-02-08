package Projects.Serializations;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int age;
    private int power;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", power=" + power +
                '}';
    }

    public Person(String name, int age, int power) {
        this.name = name;
        this.age = age;
        this.power = power;
    }
}
