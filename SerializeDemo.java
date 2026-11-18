import java.io.*;

public class SerializeDemo {

    public static void main(String[] args) {

        Employee employee = new Employee("John", 30);

        // Serialization
        try (
            ObjectOutputStream oos =
                new ObjectOutputStream(
                    new FileOutputStream("emp.ser")
                )
        ) {

            oos.writeObject(employee);
            System.out.println("Data berhasil disimpan.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Deserialization
        try (
            ObjectInputStream ois =
                new ObjectInputStream(
                    new FileInputStream("emp.ser")
                )
        ) {

            Employee restored =
                (Employee) ois.readObject();

            System.out.println(
                "Name: " + restored.name
            );

            System.out.println(
                "Age: " + restored.age
            );

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}