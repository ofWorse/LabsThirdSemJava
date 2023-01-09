package sorting.algorithms;

import sorting.SortingAlgorithm;

public class HeapSort extends SortingAlgorithm {

    private boolean isAsc;

    public HeapSort(boolean isAsc) {
        this.isAsc = isAsc;
    }

    @Override
    public void sort(double[] array) {
        if(isAsc) sortAsc(array);
        else sortDesc(array);
    }

    @Override
    public void sortAsc(double[] array) {
        int len = array.length;

        for(int i = len / 2 - 1; i >= 0; i--)
            heapify(array, len, i);
        for(int i = len - 1; i >= 0; i--) {
            double temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    @Override
    public void sortDesc(double[] array) {
        sortAsc(array);
    }

    private static void heapify(double[] array, int len, int i) {
        int largest = i, left = 2*i + 1, right = 2*i + 2;

        if(left < len && array[left] > array[largest])
            largest = left;
        if(right < len && array[right] > array[largest])
            largest = right;
        if(largest != i) {
            double temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heapify(array, len, largest);
        }
    }

    @Override
    public String getAlgName() {
        return HeapSort.class.getSimpleName();
    }
}
