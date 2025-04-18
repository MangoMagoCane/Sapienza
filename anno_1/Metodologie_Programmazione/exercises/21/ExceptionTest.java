import java.io.*;

public class ExceptionTest {
    ExceptionTest() {
        int v = 1/0;
    }


    public static void main(String[] args) {
        // ExceptionTest foo = new ExceptionTest();
        FileReader file = new FileReader("fake.txt");
    }
}
