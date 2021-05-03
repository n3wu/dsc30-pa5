import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SortsTest {

    Sorts<Integer> intSorts;
    ArrayList<Integer> intList;
    ArrayList<Integer> intTest;

    Sorts<Double> doubleSorts;
    ArrayList<Double> doubleList;
    ArrayList<Double> doubleTest;

    Sorts<Character> charSorts;
    ArrayList<Character> charList;
    ArrayList<Character> charTest;

    @Before
    public void setUp() {
        intSorts = new Sorts<>();
        intList = new ArrayList<>();
        intList.add(3);
        intList.add(5);
        intList.add(1);
        intList.add(4);
        intList.add(6);
        intList.add(2);
        // SORTED = [1,2,3,4,5,6]
        intTest = new ArrayList<>();
        intTest.add(1);
        intTest.add(2);
        intTest.add(3);
        intTest.add(4);
        intTest.add(5);
        intTest.add(6);

        doubleSorts = new Sorts<Double>();
        doubleList = new ArrayList<>();
        doubleList.add(2.4);
        doubleList.add(5.4);
        doubleList.add(3.3);
        doubleList.add(10.0);
        doubleList.add(2.3);
        doubleList.add(2.2);
        // SORTED = [2.2,2.3,2.4,3.3,5.4,10.0]
        doubleTest = new ArrayList<>();
        doubleTest.add(2.2);
        doubleTest.add(2.3);
        doubleTest.add(2.4);
        doubleTest.add(3.3);
        doubleTest.add(5.4);
        doubleTest.add(10.0);

        charSorts = new Sorts<Character>();
        charList = new ArrayList<>();
        charList.add('Y');
        charList.add('A');
        charList.add('Z');
        charList.add('X');
        charList.add('B');
        charList.add('C');
        // SORTED = [A,B,C,X,Y,Z]
        charTest = new ArrayList<>();
        charTest.add('A');
        charTest.add('B');
        charTest.add('C');
        charTest.add('X');
        charTest.add('Y');
        charTest.add('Z');
    }

    @Test
    public void insertionSort() {
        intSorts.InsertionSort(intList, 0, intList.size() - 1);
        assertEquals(intTest, intList);

        doubleSorts.InsertionSort(doubleList, 0, doubleList.size() - 1);
        assertEquals(doubleTest, doubleList);

        charSorts.InsertionSort(charList, 0, charList.size() - 1);
        assertEquals(charTest, charList);
    }

    @Test
    public void mergeSort() {
        intSorts.MergeSort(intList, 0, intList.size() - 1);
        assertEquals(intTest, intList);

        doubleSorts.MergeSort(doubleList, 0, doubleList.size() - 1);
        assertEquals(doubleTest, doubleList);

        charSorts.MergeSort(charList, 0, charList.size() - 1);
        assertEquals(charTest, charList);
    }

    @Test
    public void quickSort() {
        intSorts.QuickSort(intList, 0, intList.size() - 1);
        assertEquals(intTest, intList);

        doubleSorts.QuickSort(doubleList, 0, doubleList.size() - 1);
        assertEquals(doubleTest, doubleList);

        charSorts.QuickSort(charList, 0, charList.size() - 1);
        assertEquals(charTest, charList);
    }

    @Test
    public void modified_QuickSort() {
        intSorts.InsertionSort(intList, 0, intList.size() - 1);
        assertEquals(intTest, intList);

        doubleSorts.InsertionSort(doubleList, 0, doubleList.size() - 1);
        assertEquals(doubleTest, doubleList);

        charSorts.InsertionSort(charList, 0, charList.size() - 1);
        assertEquals(charTest, charList);
    }

    @Test
    public void cocktailSort() {
        intSorts.cocktailSort(intList, 0, intList.size() - 1);
        assertEquals(intTest, intList);

        doubleSorts.cocktailSort(doubleList, 0, doubleList.size() - 1);
        assertEquals(doubleTest, doubleList);

        charSorts.cocktailSort(charList, 0, charList.size() - 1);
        assertEquals(charTest, charList);
    }
}