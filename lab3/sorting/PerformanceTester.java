package sorting;


import java.util.Formatter;

public class PerformanceTester {
    double[] array;
    int[] numElems;
    double[][] timeResults;

    public PerformanceTester() {
        numElems = new int[]{100, 1_000, 10_000, 100_000, 1_000_000};
        timeResults = new double[7][5];
    }


    public void test(SortingAlgorithm ...algorithms) {


        long sum;
        long start, end;
        double average;
        int[] numElems;
        int[] iters;
        AlgorithmCorrector corrector;
        int alg = 0;

        for (SortingAlgorithm algorithm : algorithms) {
            System.out.println("Алгоритм: " + algorithm.getAlgName());

            corrector = new AlgorithmCorrector(algorithm);
            iters = corrector.getIters();
            numElems = corrector.getNumElems();

            for(int i = 0; i < numElems.length; i++) {
                System.out.print("сортирует: " + numElems[i] + " элементов. Итераций: " + iters[i] + "... ");
                corrector.checkForLongTimeOperation(algorithm, numElems[i]);
                sum = 0;
                for (int j = 0; j < iters[i]; j++) {
                    fillArray(numElems[i]);

                    start = System.currentTimeMillis();
                    algorithm.sort(array);
                    end = System.currentTimeMillis();

                    sum += end - start;
                    array = null;
                }
                System.out.println("> Отсортировал!");

                average = (sum) / ((double) iters[i]);
                timeResults[alg][i] = average;


                System.out.println("размер: " + numElems[i] + ", время: " + average);
            }
            System.out.println("\n\n");
            alg++;
        }
    }

    private void fillArray(int size) {
        array = new double[size];
        for(int i = 0; i < size; i++)
            array[i] = Math.round(Math.random()*100);
    }

    public void showResults() {

        Formatter formatter = new Formatter();
        System.out.println(formatter.format("%20s| %s", "Количество элементов", "Время (мс)."));
        Formatter formatter1 = new Formatter();
        System.out.println(formatter1.format("%20s %20s %20s %20s %20s %20s %20s %20s","", "BubbleSort", "InsertionSort", "SelectionSort", "MergeSort", "HeapSort", "QuickSort", "RadixSort"));

        for (int y = 0; y < numElems.length; y++) {
            formatter = new Formatter();
            System.out.println(formatter.format("%20s| %20s %20s %20s %20s %20s %20s %20s", numElems[y], timeResults[0][y],
                    timeResults[1][y],
                    timeResults[2][y],
                    timeResults[3][y],
                    timeResults[4][y],
                    timeResults[5][y],
                    timeResults[6][y]));
        }

    }
}
