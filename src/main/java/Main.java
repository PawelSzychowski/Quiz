import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
             ApiStarter.StartUp();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
