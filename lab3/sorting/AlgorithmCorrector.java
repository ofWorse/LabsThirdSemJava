package sorting;

import sorting.algorithms.BubbleSort;
import sorting.algorithms.InsertionSort;

public class AlgorithmCorrector {

    private int[] numElems;
    private int[] iters;
    public int size;

    public AlgorithmCorrector(SortingAlgorithm algorithm) {
        numElems = new int[5];
        iters = new int[5];
        size = 4;
        fillArrayLists(numElems, iters);

        if(isSlowSort(algorithm)) {
            numElems[4] = 0;
            iters[4] = 0;
            size = 3;
        }
    }

    public int[] getNumElems() {
        return this.numElems;
    }

    public int[] getIters() {
        return this.iters;
    }


    public void checkForLongTimeOperation(SortingAlgorithm algorithm, int numElements) {
        if(isSlowSort(algorithm) && numElements >= 10_000)
            System.out.println("ВНИМАНИЕ: текущая операция может занять длительное время!");
    }


    private void fillArrayLists(int[] numElems, int[] iters) {
        for(int i = 0, k = 100; i < 5; i++, k *= 10)
            numElems[i] = k;
        iters[0] = 1000;
        iters[1] = 1000;
        iters[2] = 100;
        iters[3] = 100;
        iters[4] = 10;
    }


    private boolean isSlowSort(SortingAlgorithm algorithm) {
        return (algorithm.getAlgName().equals(BubbleSort.class.getSimpleName()) ||
                algorithm.getAlgName().equals(InsertionSort.class.getSimpleName()));
    }

}
