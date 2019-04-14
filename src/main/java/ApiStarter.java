import java.io.FileNotFoundException;
import java.util.Scanner;

public class ApiStarter {
    public static void StartUp() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String komenda;

        do {
            System.out.println("Aby zagrać wpisz start, aby dodać pytanie wpisz dodaj");
            komenda = scanner.nextLine();
            if (komenda.equalsIgnoreCase("start")) {
                QuizLogic.startApi();
            } else if (komenda.equalsIgnoreCase("dodaj")) {
                CreatQuestions.addQestion();
            }
        } while (!komenda.equalsIgnoreCase("koniec"));
    }
}
