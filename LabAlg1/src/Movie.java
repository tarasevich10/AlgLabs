import java.util.ArrayList;

public class Movie {

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.println(i + " ");
        }
        System.out.println();
    }


    //we use bubblesort for sorting by duration
    public static void bubbleSort(ArrayList<MovieMain> list) {
        MovieMain temp;
        int comparison = 0;
        int swap = 0;
        if (list.size() > 1) {
            for (int x = 0; x < list.size(); x++) {
                for (int i = 0; i < list.size() - x - 1; i++) {
                    comparison++;
                    if (list.get(i).compareTo(list.get(i + 1)) > 0) {
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


    //    public static ArrayList<MovieMain> sortMerge(ArrayList<MovieMain> numOfResponse) {
//        if (numOfResponse.size() <= 1) return numOfResponse;
//
//        int mid = numOfResponse.size()/2;
//        ArrayList<MovieMain> left = new ArrayList<>(mid);
//        
//        int mid = numOfResponse.length / 2;
//        int[] left_array = new int[mid];
//        int[] right_array = new int[numOfResponse.length - mid];
//
//        for (int i = 0; i < mid; i++) {
//            left_array[i] = numOfResponse[i];
//        }
//
//        int x = 0;
//        for (int j = 0; j < right_array.length; j++) {
//            right_array[j] = numOfResponse[mid + j];
//        }
//        int[] result_array = new int[numOfResponse.length];
//        left_array = sortMerge(left_array);
//        right_array = sortMerge(right_array);
//        result_array = merge(left_array, right_array);
//
//        return result_array;
//    }
    public static ArrayList<MovieMain> mergeSort(ArrayList<MovieMain> numOfResponse) {
        if (numOfResponse.size() <= 1) {
            return numOfResponse;
        }
        ArrayList<MovieMain> newList = new ArrayList<MovieMain>();

        ArrayList<MovieMain> left = new ArrayList<MovieMain>();
        ArrayList<MovieMain> right = new ArrayList<MovieMain>();
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

        newList = merge(left, right);
        return newList;
    }

    static ArrayList<MovieMain> merge(ArrayList<MovieMain> left, ArrayList<MovieMain> right) {
        ArrayList<MovieMain> mergedList = new ArrayList<>();
        while (left.size() > 0 || right.size() > 0) {
            if (left.size() > 0 && right.size() > 0) {
                if (left.get(0).compareTo(right.get(0))) {
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

