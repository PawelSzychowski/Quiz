import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CreatQuestions {
    private CreatQuestions() {
    }

    public static void addQestion() {
        File plik = new File("pytania/Własne_pytania");
        Scanner scanner = new Scanner(System.in);
        String command;

        try (
                PrintWriter printWriter = new PrintWriter(new FileWriter(plik, true))) {
                do {
                    System.out.println("Podaj treść pytania");
                    String questionContent = scanner.nextLine();
                    printWriter.println(questionContent);
                    System.out.println("Podaj ilość odpowidzi");
                    String numberOfAnswer = scanner.nextLine();
                    printWriter.println(numberOfAnswer);
                    System.out.println("Podaj swoje odpowiedzi, pamiętaj że pierwsza odpowiedź jest oznaczona jako prawidłowa.");
                    for (int i = 0; i <Integer.parseInt(numberOfAnswer) ; i++) {
                        String answer = scanner.nextLine();
                        printWriter.println(answer);
                    }
                    System.out.println("aby zakonczyć wpisz koniec jeśli chcesz dodawać dalej pytania wciśnij enter");
                    command = scanner.nextLine();
                    printWriter.close();
                }while(!command.equalsIgnoreCase("koniec"));
        } catch (
                IOException ioe) {
            System.out.println("error " + ioe.getMessage());
        }
    }
}
