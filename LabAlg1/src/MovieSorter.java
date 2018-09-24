import java.util.ArrayList;
import java.util.List;

public class MovieSorter {

    //we use bubblesort for sorting by duration
    public static void bubbleSort(List<Movie> list) {
        Movie temp;
        int comparison = 0;
        int swap = 0;
        if (list.size() > 1) {
            for (int x = 0; x < list.size(); x++) {
                for (int i = 0; i < list.size() - x - 1; i++) {
                    comparison++;
                    if (list.get(i).compareToNumOfDuration(list.get(i + 1)) > 0) {
                        swap++;
                        temp = list.get(i);
                        list.set(i, list.get(i + 1));
                        list.set(i + 1, temp);
                    }
                }
            }
        }
        System.out.println("Bubblesort, number of swaps: " + swap + " , and number of comparisons: " + comparison);
    }

    public static List<Movie> mergeSort(List<Movie> numOfResponse) {
        if (numOfResponse.size() <= 1) {
            return numOfResponse;
        }


        List<Movie> left = new ArrayList<>();
        List<Movie> right = new ArrayList<>();
        int middle = numOfResponse.size() / 2;
        //Splits the array into unsortedList size lists of size one
        for (int i = 0; i < numOfResponse.size(); i++) {
            if (i < middle) {
                left.add(numOfResponse.get(i));
            } else {
                right.add(numOfResponse.get(i));
            }
        }
        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    static List<Movie> merge(List<Movie> left, List<Movie> right) {
        List<Movie> mergedList = new ArrayList<>();

        while (left.size() > 0 || right.size() > 0) {
            if (left.size() > 0 && right.size() > 0) {
                if (left.get(0).compareToNumOfResponse(right.get(0)) > 0) {
                    mergedList.add(left.get(0));
                    left.remove(0);
                } else {
                    mergedList.add(right.get(0));
                    right.remove(0);
                }
            } else if (left.size() > 0) {
                mergedList.add(left.get(0));
                left.remove(0);
            } else if (right.size() > 0) {
                mergedList.add(right.get(0));
                right.remove(0);
            }
        }
        return mergedList;
    }
}
