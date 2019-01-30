package Examples;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectInputStreamExample {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectOutputStream objectOutputStream =
            new ObjectOutputStream(new FileOutputStream("data.bin"));

        List<Student> l = new ArrayList<Student>();
        l.add(new Student("Nicola", "Bicocchi", 2000, 28.0));
        l.add(new Student("Mario", "Rossi", 1999, 27.0));
        l.add(new Student("Luca", "Bianchi", 2001, 29.0));
        objectOutputStream.writeObject(l);
        objectOutputStream.close();

        ObjectInputStream objectInputStream =
            new ObjectInputStream(new FileInputStream("data.bin"));

        l.clear();
        l = (List<Student>) objectInputStream.readObject();
        objectInputStream.close();
        
        for (Student s : l) {
        	System.out.println(s);
        }
    }
}
