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
        String komendy;

        try (
                PrintWriter printWriter = new PrintWriter(new FileWriter(plik, true))) {
                do {
                    System.out.println("Podaj treść pytania");
                    String pytanie = scanner.nextLine();
                    printWriter.println(pytanie);
                    System.out.println("Podaj ilość odpowidzi");
                    String liczbaOdpowiedzi = scanner.nextLine();
                    printWriter.println(liczbaOdpowiedzi);
                    System.out.println("Podaj swoje odpowiedzi, pamiętaj że pierwsza odpowiedź jest oznaczona jako prawidłowa.");
                    for (int i = 0; i <Integer.parseInt(liczbaOdpowiedzi) ; i++) {
                        String odpowiedz = scanner.nextLine();
                        printWriter.println(odpowiedz);
                    }
                    System.out.println("aby zakonczyć wpisz koniec jeśli chcesz dodawać dalej pytania wciśnij enter");
                    komendy = scanner.nextLine();
                    printWriter.close();
                }while(!komendy.equalsIgnoreCase("koniec"));
        } catch (
                IOException ioe) {
            System.out.println("error " + ioe.getMessage());
        }
    }
}
