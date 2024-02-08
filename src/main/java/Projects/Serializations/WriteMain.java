package Projects.Serializations;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteMain {
    public static void main(String[] args) {
        Person person1 = new Person("Stan", 25, 10);
        Person person2 = new Person("John", 31, 9);
        Person person3 = new Person("Kenzie", 22, 4);
        try {
            FileOutputStream fos = new FileOutputStream("people.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(person1);
            oos.writeObject(person2);
            oos.writeObject(person3);

            oos.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
