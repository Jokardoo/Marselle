package Projects.Serializations;

import java.io.*;

public class ArrayMain {
    public static void main(String[] args) {

        Person[] people = {new Person("John", 20, 20),
                new Person("Jack", 23, 22),
                new Person("Polly", 32, 16)};

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("people.bin"))) {
            oos.writeInt(people.length);

            for (Person p : people) {
                oos.writeObject(p);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
