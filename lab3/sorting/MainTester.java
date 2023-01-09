package sorting;

import sorting.algorithms.*;

import java.util.Random;

public class MainTester {
    private PerformanceTester tester;

    public MainTester() {
        tester = new PerformanceTester();
    }

    public void startTest() {
        var isAsc = new Random().nextBoolean();

        var quickSort = new QuickSort(isAsc);
        var radixSort = new RadixSort(isAsc);
        var selectionSort = new SelectionSort(isAsc);
        var mergeSort = new MergeSort(isAsc);
        var insertionSort = new InsertionSort(isAsc);
        var heapSort = new HeapSort(isAsc);
        var bubbleSort = new BubbleSort(isAsc);

        tester.test(bubbleSort, insertionSort, selectionSort, mergeSort, heapSort, quickSort, radixSort);
        tester.showResults();
    }
}
