package sorting.algorithms;

import sorting.SortingAlgorithm;

public class InsertionSort extends SortingAlgorithm {

    private boolean isAsc;

    public  InsertionSort(boolean isAsc) {
        this.isAsc = isAsc;
    }

    @Override
    public void sort(double[] array) {
        if(isAsc) sortAsc(array);
        else sortDesc(array);
    }

    @Override
    public void sortAsc(double[] array) {
        for(int i = 1; i < array.length; i++) {
            double temp = array[i];
            int j = i - 1;
            while(j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    @Override
    public void sortDesc(double[] array) {
        for(int i = 1; i < array.length; i++) {
            double temp = array[i];
            int j = i - 1;
            while(j >= 0 && array[j] < temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    @Override
    public String getAlgName() {
        return InsertionSort.class.getSimpleName();
    }
}
