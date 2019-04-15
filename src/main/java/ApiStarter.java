import java.io.FileNotFoundException;
import java.util.Scanner;

public class ApiStarter {
    public static void StartUp() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String command;

        do {
            System.out.println("Aby zagrać wpisz start, aby dodać pytanie wpisz dodaj");
            command = scanner.nextLine();
            if (command.equalsIgnoreCase("start")) {
                QuizLogic.startApi();
            } else if (command.equalsIgnoreCase("dodaj")) {
                CreatQuestions.addQestion();
            }
        } while (!command.equalsIgnoreCase("koniec"));
    }
}
