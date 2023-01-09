package sorting.algorithms;

import sorting.SortingAlgorithm;

//TODO переделать!
public class QuickSort extends SortingAlgorithm {

    private int start;
    private int end;
    private boolean isAsc;

    public QuickSort(boolean isAsc) {
        this.isAsc = isAsc;
    }

    @Override
    public void sort(double[] array) {
        if(isAsc) sortAsc(array);
        else sortDesc(array);
    }

    @Override
    public void sortAsc(double[] array) {
        start = 0; end = array.length - 1;
        quickSort(array, start, end);
    }

    @Override
    public void sortDesc(double[] array) {
        sortAsc(array);
    }

    private void quickSort(double[] array, int start, int end) {
        if(end <= start) return;

        int pivot = Partition(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    @Override
    public String getAlgName() {
        return QuickSort.class.getSimpleName();
    }

    private int Partition(double[] array, int start, int end) {
        double pivot = array[end];
        int i = start - 1;

        for(int j = start; j <= end - 1; j++) {
            if(isAsc) {
                if (array[j] < pivot) {
                    i++;
                    double temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            else {
                if (array[j] > pivot) {
                    i++;
                    double temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        i++;
        double temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        return i;
    }

}