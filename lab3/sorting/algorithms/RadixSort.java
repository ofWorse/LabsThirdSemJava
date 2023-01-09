package sorting.algorithms;

import sorting.SortingAlgorithm;

public class RadixSort extends SortingAlgorithm {

    private boolean isAsc;

    public RadixSort(boolean isAsc) {
        this.isAsc = isAsc;
    }

    @Override
    public void sort(double[] array) {
        if(isAsc) sortAsc(array);
        else sortDesc(array);
    }

    @Override
    public void sortAsc(double[] array) {
        double max = array[0];
        for(int i = 1; i < array.length; i++)
            if(max < array[i])
                max = array[i];
        for(int i = 1; max / i > 0; i *= 10)
            countSort(array, i);
    }

    @Override
    public void sortDesc(double[] array) {
        double max = array[0];
        for(int i = 1; i < array.length; i++)
            if(max > array[i])
                max = array[i];
        for(int i = 1; max / i > 0; i *= 10)
            countSort(array, i);
    }

    @Override
    public String getAlgName() {
        return RadixSort.class.getSimpleName();
    }

    private static void countSort(double[] array, int s) {
        double[] countArray = new double[array.length];

        for(int i = 0; i < array.length; i++)
            countArray[(int)((array[i] / s) % 10)]++;
        for(int i = 1; i < 10; i++)
            countArray[i] += countArray[i - 1];

        double[] outputArray = new double[array.length];

        for(int i = array.length - 1; i >= 0; i--)
            outputArray[(int)(--countArray[(int)((array[i] / s) % 10)])] = array[i];
        for(int i = 0; i < array.length; i++)
            array[i] = outputArray[i];
    }
}
