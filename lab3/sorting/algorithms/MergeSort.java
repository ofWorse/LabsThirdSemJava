package sorting.algorithms;

import sorting.SortingAlgorithm;


public class MergeSort extends SortingAlgorithm {

    private boolean isAsc;

    public MergeSort(boolean isAsc) {
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
        if(len <= 1) return;

        int middle = len / 2;
        double[] leftArray = new double[middle];
        double[] rightArray = new double[len - middle];

        int i = 0; // l arr
        int j = 0; // r arr

        for(; i < len; i++) {
            if(i < middle)
                leftArray[i] = array[i];
            else {
                rightArray[j] = array[i];
                j++;
            }
        }

        sortAsc(leftArray);
        sortAsc(rightArray);
        Merge(leftArray, rightArray, array);
    }

    @Override
    public void sortDesc(double[] array) {
        sortAsc(array);
    }

    @Override
    public String getAlgName() {
        return MergeSort.class.getSimpleName();
    }

    private void Merge(double[] leftArray, double[] rightArray, double[] array) {
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r = 0;

        while(l < leftSize && r < rightSize) {

            if (isAsc) {
                if (leftArray[l] < rightArray[r]) {
                    array[i] = leftArray[l];
                    i++;
                    l++;
                } else {
                    array[i] = rightArray[r];
                    i++;
                    r++;
                }
            } else {
                if (leftArray[l] > rightArray[r]) {
                    array[i] = leftArray[l];
                    i++;
                    l++;
                } else {
                    array[i] = rightArray[r];
                    i++;
                    r++;
                }
            }

        }
        while(l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while(r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }
}
