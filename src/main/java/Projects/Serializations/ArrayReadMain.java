package Projects.Serializations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ArrayReadMain {
    public static void main(String[] args) {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("people.bin"))) {

            int count =  ois.readInt();
            Person[] people = new Person[count];
            System.out.println(count);

            for (int i = 0; i < count; i++) {
                Person p = (Person) ois.readObject();
                System.out.println(p);

            }

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        }
    }
}
