import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadQestions {
    private ReadQestions() {
    }
    public static List<Questions> qestionList(File file) throws FileNotFoundException {
        List<Questions> questionsList = new ArrayList<>();

        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String pytanieAktualne = scanner.nextLine();
            String liczbaOdpowieszi = scanner.nextLine();
            List<String> odpowidzi = new ArrayList<>();
            for (int i = 0; i < Integer.parseInt(liczbaOdpowieszi); i++) {
                String odp = scanner.nextLine();
                odpowidzi.add(odp);
            }
            Questions noweQuestions = new Questions(pytanieAktualne, odpowidzi);
            questionsList.add(noweQuestions);
        }
        return questionsList;
    }
}
