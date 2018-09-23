import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    private static <T> void printArray(ArrayList<T> a) {
        for (T t : a) {
            System.out.println(t);
        }
    }

    public static void main(String[] arg) {

        int startTime = (int) System.currentTimeMillis();
        int i = 0;
        ArrayList<Movie> movie = new ArrayList<>();
        Scanner scanner;
        try {
            String filePath = "F:\\Програмування\\AlgLabs\\LabAlg1\\src\\text.txt";
            scanner = new Scanner(new FileReader(filePath));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");

                movie.add(new Movie(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println("Початковий список всіх фільмів:");


        System.out.println("Алгоритм 'Bubble' за кількістю відгуків по спаданню.");

        System.out.println("До сортування:");
        printArray(movie);

        System.out.println("Після Сортування:");
        MovieMain.bubbleSort(movie);
        printArray(movie);

        System.out.println("Алгоритм 'Merge'  для сортування за тривалістю по зростанню");


        movie = MovieMain.mergeSort(movie);
        System.out.println("Після мердж сорт");
        printArray(movie);


        int endTime = (int) System.currentTimeMillis();
        System.out.println("Час виконання роботи: " + (endTime - startTime) + " мілісекунди.");
    }
}
