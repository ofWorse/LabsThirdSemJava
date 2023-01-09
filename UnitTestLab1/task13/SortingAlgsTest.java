package task13;

import org.junit.jupiter.api.Test;
import task13.SortingAlgs;

import static org.junit.jupiter.api.Assertions.*;

class SortingAlgsTest extends SortingAlgs {

    private int[] unsorted = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    private int[] sorted = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    @Test
    public void BubbleSortTest() {
        BubbleSort(unsorted);
        assertArrayEquals(sorted, unsorted);
    }

    @Test
    void insertionSortTest() {
        InsertionSort(unsorted);
        assertArrayEquals(sorted, unsorted);
    }

    @Test
    void selectionSortTest() {
        SelectionSort(unsorted);
        assertArrayEquals(sorted, unsorted);
    }

    @Test
    void mergeSortTest() {
        MergeSort(unsorted);
        assertArrayEquals(sorted, unsorted);
    }

    @Test
    void heapSortTest() {
        HeapSort(unsorted);
        assertArrayEquals(sorted, unsorted);
    }

    @Test
    void quickSortTest() {
        QuickSort(unsorted, 0, unsorted.length-1);
        assertArrayEquals(sorted, unsorted);
    }

    @Test
    void radixSortTest() {
        RadixSort(unsorted);
        assertArrayEquals(sorted, unsorted);
    }
}