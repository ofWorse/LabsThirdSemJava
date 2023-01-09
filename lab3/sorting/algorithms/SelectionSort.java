package sorting.algorithms;

import sorting.SortingAlgorithm;

public class SelectionSort extends SortingAlgorithm {

    private boolean isAsc;

    public SelectionSort(boolean isAsc) {
        this.isAsc = isAsc;
    }

    @Override
    public void sort(double[] array) {
        if(isAsc) sortAsc(array);
        else sortDesc(array);
    }

    @Override
    public void sortAsc(double[] array) {
        for(int i = 0; i < array.length - 1; i++) {
            int min = i;
            for(int j = i + 1; j < array.length; j++) {
                if(array[min] > array[j])
                    min = j;
            }

            double temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }

    @Override
    public void sortDesc(double[] array) {
        for(int i = 0; i < array.length - 1; i++) {
            int min = i;
            for(int j = i + 1; j < array.length; j++) {
                if(array[min] < array[j])
                    min = j;
            }

            double temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }

    @Override
    public String getAlgName() {
        return SelectionSort.class.getSimpleName();
    }
}
