package sorting.algorithms;

import sorting.SortingAlgorithm;

public class BubbleSort extends SortingAlgorithm {

    private boolean isAsc;

    public BubbleSort(boolean isAsc) {
        this.isAsc = isAsc;
    }

    @Override
    public void sort(double[] array) {
        if(isAsc) sortAsc(array);
        else sortDesc(array);
    }

    @Override
    public void sortAsc(double[] array) {
        for(int out = array.length-1; out >= 1; out--) {
            for (int in = 0; in < out; in++)
                if (array[in] > array[in + 1]) {
                    double temp = array[in];
                    array[in] = array[in + 1];
                    array[in + 1] = temp;
                }
        }
    }

    @Override
    public void sortDesc(double[] array) {
        for(int out = array.length-1; out >= 1; out--) {
            for (int in = 0; in < out; in++)
                if (array[in] < array[in + 1]) {
                    double temp = array[in];
                    array[in] = array[in + 1];
                    array[in + 1] = temp;
                }
        }
    }

    @Override
    public String getAlgName() {
        return BubbleSort.class.getSimpleName();
    }
}
