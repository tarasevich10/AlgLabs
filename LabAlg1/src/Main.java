import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    private static <T> void printArray(ArrayList<T> a) {
        for (T t : a) {
            System.out.println(t);
        }
    }

    public static void main(String[] arg) {

        int startTime = (int) System.currentTimeMillis();
        int i=0;
        ArrayList<MovieMain> movieMain = new ArrayList<>();
        Scanner scanner;
        try{
            String filePath = "F:\\IdeaProgramming\\LabAlg1\\src\\text.txt";
            scanner = new Scanner(new FileReader(filePath));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");

                movieMain.add(new MovieMain(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println("Початковий список всіх фільмів:");



        System.out.println("Алгоритм 'Bubble' за кількістю відгуків по спаданню.");

        System.out.println("До сортування:");
        printArray(movieMain);

        System.out.println("Після Сортування:");
        Movie.bubbleSort(movieMain);
        printArray(movieMain);

        System.out.println("Алгоритм 'Merge'  для сортування за тривалістю по зростанню");


        Movie.mergeSort(movieMain);
        System.out.println("Після мердж сорт");
        printArray(movieMain);


        int endTime = (int) System.currentTimeMillis();
        System.out.println("Час виконання роботи: " + (endTime - startTime) + "мілісекундию");
    }
}
