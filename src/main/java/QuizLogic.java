import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class QuizLogic {


    public static Set<Questions> drawQestions(List<Questions> lista, int numberOfQestions) {
        Set<Questions> listOfDrawQestions = new HashSet<>();
        Random random = new Random();
        while (listOfDrawQestions.size() < numberOfQestions) {
            int liczbaPytan = random.nextInt(lista.size());
            listOfDrawQestions.add(lista.get(liczbaPytan));
        }
        return listOfDrawQestions;
    }


    public static Map<String, List<Questions>> QestionsMap() throws FileNotFoundException {
        Map<String, List<Questions>> mapOfQestions = new HashMap<>();
        List<Questions> allQestions = new ArrayList<>();
        File file = new File("pytania");
        File[] titleOfQestions = file.listFiles();
        for (int i = 0; i < titleOfQestions.length; i++) {
            List<Questions> questions = ReadQestions.qestionList(titleOfQestions[i]);
            mapOfQestions.put(titleOfQestions[i].getName(), questions);
            allQestions.addAll(questions);
        }
        mapOfQestions.put("wszystkie", allQestions);

        return mapOfQestions;
    }

    public static void startApi() throws FileNotFoundException {
        int counter = 0;
        int questionCounter = 0;
        Scanner scanner = new Scanner(System.in);
        String category;
        String numberOfQestions;
        Map<String, List<Questions>> mojePytania = QestionsMap();
        List<String> listOfCategory = new ArrayList<>(mojePytania.keySet());
        for (int i = 0; i < listOfCategory.size(); i++) {
            System.out.println((i + 1) + " -> " + listOfCategory.get(i));
        }
        int categoryNumber;
        int howManyQestion;
        do {
            System.out.println("Podaj Kategorie");
            category = scanner.nextLine();

            try {
                categoryNumber = Integer.parseInt(category);
            } catch (NumberFormatException e) {
                categoryNumber = -1;
            }
        } while (categoryNumber > listOfCategory.size() || categoryNumber < 0);
        do {
            System.out.println("Podaj liczbe pytań");
            numberOfQestions = scanner.nextLine();
            try {
                howManyQestion = Integer.parseInt(numberOfQestions);
            } catch (NumberFormatException e) {
                howManyQestion = -1;
            }
        } while (howManyQestion <= 0);
        List<Questions> qestionsFromCategory = mojePytania.get(listOfCategory.get(Integer.parseInt(category) - 1));
        List<Questions> questions = new ArrayList<>(drawQestions(qestionsFromCategory, Integer.parseInt(numberOfQestions)));
        for (int i = 0; i < questions.size(); i++) {

            List<String> shuffleQuestions = questions.get(i).getAnswer();
            String correctAnswer = questions.get(i).getAnswer().get(0);
            Collections.shuffle(shuffleQuestions);
            System.out.println(questions.get(i).getQuestion());
            char chose = 65;
            HashSet<Character> legalneOdpowiedzi = new HashSet<>();
            for (int j = 0; j < questions.get(i).getAnswer().size(); j++) {
                System.out.println(chose + " -> " + shuffleQuestions.get(j));
                legalneOdpowiedzi.add(chose);
                chose++;
            }
            System.out.println();
            String myAnswer;
            Character odp;
            do {
                System.out.println("Podaj odpowiedź:");
                 myAnswer = scanner.nextLine();
                 try{
                     odp = myAnswer.charAt(0);
                 }catch (StringIndexOutOfBoundsException e){
                     odp = 'x';
                 }

            }while (!legalneOdpowiedzi.contains(odp));
            char goodLetter = myAnswer.charAt(0);
            int indexOfAnswer = goodLetter - 65;
            questionCounter++;
            if (correctAnswer.equalsIgnoreCase(shuffleQuestions.get(indexOfAnswer))) {
                counter++;
                System.out.println("Prawidłowa Odpowiedź, liczba punktów " + counter);
            } else {
                System.out.println("Zła odpowiedź, liczba punktów " + counter + " prawidłowa odpowiedź to: " + correctAnswer);
                System.out.println();
            }
        }
        System.out.println("twój wynik to: " + counter + "/" + questionCounter);

    }
}
