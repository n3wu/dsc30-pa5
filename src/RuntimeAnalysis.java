/*
 * NAME: Natalie Wu
 * PID:  A16668102
 */
 
import java.util.ArrayList;

/**
 * add class header
 */
public class RuntimeAnalysis {

    private static final int NUM_DATA = 10000;
    private static final int NUM_RUN = 10;
    private static final int NUM_TEST = 5;
    private static final int MIN = 0;
    private static final int MAX = 100000;
    private static final int[] QuickSortCutoffValues = {2,4,8,16,32,64,128};

    /**
     * Returns an ArrayList of random numbers
     *
     * @param size the number of random numbers wanted
     * @param min the min value for random number
     * @param max the max value for random number
     * @return an ArrayList of random numbers
     */
    public static ArrayList<Integer> randomNumbers(int size, int min, int max) {

        ArrayList<Integer> randNums = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            randNums.add((int) (Math.random() * ((max - min) + 1)) + min);
        }
        return randNums;
    }

    /**
     * Returns a deep copy of the input array list.
     *
     * @param data list to copy
     * @return a deep copy of the list
     */
    private static ArrayList<Integer> deepCopyArrayList(ArrayList<Integer> data) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer d : data) {
            result.add(d);
        }
        return result;
    }

    /**
     * Times the insertion sort.
     * @param data list of data to sort
     * @param numRun the number of trials to run
     */
    public static void timeInsertionSort(ArrayList<Integer> data, int numRun) {
        long startTime = 0, endTime = 0, totalTime = 0;
        Sorts<Integer> sorts = new Sorts<>();
        ArrayList<Integer> temp = deepCopyArrayList(data);
        for (int i = 0; i < numRun; i++) {
            data = deepCopyArrayList(temp);
            startTime = System.currentTimeMillis();
            sorts.InsertionSort(data, 0, data.size() - 1);
            endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        System.out.println("Benchmarking insertion sort: ");
        System.out.println("Number of data to sort: " + data.size());
        System.out.println("Average time taken to sort: " + totalTime / numRun + " ms");
        System.out.println();
    }

    /**
     * Times the merge sort.
     * @param data list of data to sort
     * @param numRun the number of trials to run
     */
    public static void timeMergeSort(ArrayList<Integer> data, int numRun) {
        long startTime = 0, endTime = 0, totalTime = 0;
        Sorts<Integer> sorts = new Sorts<>();
        ArrayList<Integer> temp = deepCopyArrayList(data);
        for (int i = 0; i < numRun; i++) {
            data = deepCopyArrayList(temp);
            startTime = System.currentTimeMillis();
            sorts.MergeSort(data, 0, data.size() - 1);
            endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        System.out.println("Benchmarking merge sort: ");
        System.out.println("Number of data to sort: " + data.size());
        System.out.println("Average time taken to sort: " + totalTime / numRun + " ms");
        System.out.println();
    }

    /**
     * Times the Quicksort.
     * @param data list of data to sort
     * @param numRun the number of trials to run
     */
    public static void timeQuickSort(ArrayList<Integer> data, int numRun) {
        long startTime = 0, endTime = 0, totalTime = 0;
        Sorts<Integer> sorts = new Sorts<>();
        ArrayList<Integer> temp = deepCopyArrayList(data);
        for (int i = 0; i < numRun; i++) {
            data = deepCopyArrayList(temp);
            startTime = System.currentTimeMillis();
            sorts.QuickSort(data, 0, data.size() - 1);
            endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        System.out.println("Benchmarking quick sort: ");
        System.out.println("Number of data to sort: " + data.size());
        System.out.println("Average time taken to sort: " + totalTime / numRun + " ms");
        System.out.println();
    }

    /**
     * Times the modified Quicksort.
     * @param data list of data to sort
     * @param numRun the number of trials to run
     * @param param the extra parameter the sorting algorithm takes (cutoff)
     */
    public static void timeModifiedQuickSort(ArrayList<Integer> data, int numRun, int param) {
        long startTime = 0, endTime = 0, totalTime = 0;
        Sorts<Integer> sorts = new Sorts<>();
        ArrayList<Integer> temp = deepCopyArrayList(data);

        for (int i = 0; i < numRun; i++) {
            data = deepCopyArrayList(temp);
            startTime = System.currentTimeMillis();
            sorts.Modified_QuickSort(data, 0, data.size() - 1, param);
            endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        System.out.println("Modified QuickSort Cutoff Value: " + param);
        System.out.println("Benchmarking quick sort: ");
        System.out.println("Number of data to sort: " + data.size());
        System.out.println("Average time taken to sort: " + totalTime / numRun + " ms");
        System.out.println();
    }

    /**
     * Times the cocktail sort.
     * @param data list of data to sort
     * @param numRun the number of trials to run
     */
    public static void timeCocktailSort(ArrayList<Integer> data, int numRun) {
        long startTime = 0, endTime = 0, totalTime = 0;
        Sorts<Integer> sorts = new Sorts<>();
        ArrayList<Integer> temp = deepCopyArrayList(data);
        for (int i = 0; i < numRun; i++) {
            data = deepCopyArrayList(temp);
            startTime = System.currentTimeMillis();
            sorts.cocktailSort(data, 0, data.size() - 1);
            endTime = System.currentTimeMillis();
            totalTime += (endTime - startTime);
        }
        System.out.println("Benchmarking cocktail sort: ");
        System.out.println("Number of data to sort: " + data.size());
        System.out.println("Average time taken to sort: " + totalTime / numRun + " ms");
        System.out.println();
    }

    /**
     * Main method to run the time methods. Modify it as you need.
     * @param args arguments (not used)
     */
    public static void main(String[] args) {
        int numData;

        /* 1 */
        // Insertion Sort
        /* numData = NUM_DATA;
        for (int i = 0; i < NUM_TEST; i++) {
            ArrayList<Integer> data1 = randomNumbers(numData, MIN, MAX);
            timeInsertionSort(data1, NUM_RUN);
            numData += numData;

            ArrayList<Integer> data2 = randomNumbers(numData, MIN, MAX * 2);
            timeInsertionSort(data2, NUM_RUN);
            numData += numData;

            ArrayList<Integer> data3 = randomNumbers(numData, MIN, MAX * 4);
            timeInsertionSort(data3, NUM_RUN);
            numData += numData;

            ArrayList<Integer> data4 = randomNumbers(numData, MIN, MAX * 8);
            timeInsertionSort(data4, NUM_RUN);
            numData += numData;

            ArrayList<Integer> data5 = randomNumbers(numData, MIN, MAX * 16);
            timeInsertionSort(data5, NUM_RUN);
            numData += numData;
        } */

        // Cocktail Sort
        /*
        numData = NUM_DATA;
        for (int i = 0; i < NUM_TEST; i++) {
            ArrayList<Integer> data1 = randomNumbers(numData, MIN, MAX);
            timeCocktailSort(data1, NUM_RUN);
            numData += numData;

            ArrayList<Integer> data2 = randomNumbers(numData, MIN, MAX * 2);
            timeCocktailSort(data2, NUM_RUN);
            numData += numData;

            ArrayList<Integer> data3 = randomNumbers(numData, MIN, MAX * 4);
            timeCocktailSort(data3, NUM_RUN);
            numData += numData;

            ArrayList<Integer> data4 = randomNumbers(numData, MIN, MAX * 8);
            timeCocktailSort(data4, NUM_RUN);
            numData += numData;

            ArrayList<Integer> data5 = randomNumbers(numData, MIN, MAX * 16);
            timeCocktailSort(data5, NUM_RUN);
            numData += numData;
        }
         */

        // Quicksort
        /*
        numData = NUM_DATA;
        for (int i = 0; i < NUM_TEST; i++) {
            ArrayList<Integer> data1 = randomNumbers(numData, MIN, MAX);
            timeQuickSort(data1, NUM_RUN);
            numData += numData;

            ArrayList<Integer> data2 = randomNumbers(numData, MIN, MAX * 2);
            timeQuickSort(data2, NUM_RUN);
            numData += numData;

            ArrayList<Integer> data3 = randomNumbers(numData, MIN, MAX * 4);
            timeQuickSort(data3, NUM_RUN);
            numData += numData;

            ArrayList<Integer> data4 = randomNumbers(numData, MIN, MAX * 8);
            timeQuickSort(data4, NUM_RUN);
            numData += numData;

            ArrayList<Integer> data5 = randomNumbers(numData, MIN, MAX * 16);
            timeQuickSort(data5, NUM_RUN);
            numData += numData;
        }
        */

        /* 2 */
        /*
        numData = NUM_DATA * 100;
        for (int i = 0; i < NUM_TEST; i++) {
            ArrayList<Integer> data = randomNumbers(numData, MIN, MAX * 100);

            timeModifiedQuickSort(data, NUM_RUN, QuickSortCutoffValues[0]);

            timeModifiedQuickSort(data, NUM_RUN, QuickSortCutoffValues[1]);

            timeModifiedQuickSort(data, NUM_RUN, QuickSortCutoffValues[2]);

            timeModifiedQuickSort(data, NUM_RUN, QuickSortCutoffValues[3]);

            timeModifiedQuickSort(data, NUM_RUN, QuickSortCutoffValues[4]);

            timeModifiedQuickSort(data, NUM_RUN, QuickSortCutoffValues[5]);

            timeModifiedQuickSort(data, NUM_RUN, QuickSortCutoffValues[6]);
        }
        */

        /* 3 */
        // Traditional Quicksort
        /*
        int n = 2;
        numData = NUM_DATA * n;
        ArrayList<Integer> data1 = randomNumbers(numData, MIN, MAX * n);
        timeQuickSort(data1, NUM_RUN);
         */


        // Modified Quicksort
        /*
        int n = 6;
        numData = NUM_DATA * n;
        ArrayList<Integer> data1 = randomNumbers(numData, MIN, MAX * n);
        timeModifiedQuickSort(data1, NUM_RUN, QuickSortCutoffValues[3]);
        */
    }
}
