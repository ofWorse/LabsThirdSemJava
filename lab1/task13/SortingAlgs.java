package task13;

public class SortingAlgs {
	
	public static void main(String[] args) {
		int[] array = CreateArray();
		PrintArray(array);
		RadixSort(array); /* выберите любую из предложеных сортировок */
		PrintArray(array);
		System.out.println("Программа завершена.");
	}
	
	public static void BubbleSort(int[] array) {
		for(int out = array.length-1; out >= 1; out--) {
			for(int in = 0; in < out; in++)
				if(array[in] > array[in+1]) {
					int temp = array[in];
					array[in] = array[in+1];
					array[in+1] = temp;
				}	
		}
	}
	
	public static void InsertionSort(int[] array) {
		for(int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j = i - 1;
			while(j >= 0 && array[j] > temp) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = temp;
		}
	}
	
	public static void SelectionSort(int[] array) {
		for(int i = 0; i < array.length - 1; i++) {
			int min = i;
			for(int j = i + 1; j < array.length; j++) {
				if(array[min] > array[j])
					min = j;
			}
			
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
	}
	
	public static void MergeSort(int[] array) {
		int len = array.length;
		if(len <= 1) return;
		
		int middle = len / 2;
		int[] leftArray = new int[middle];
		int[] rightArray = new int[len - middle];
		
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
		
		MergeSort(leftArray);
		MergeSort(rightArray);
		Merge(leftArray, rightArray, array);
	}
	
	private static void Merge(int[] leftArray, int[] rightArray, int[] array) {
		int leftSize = array.length / 2;
		int rightSize = array.length - leftSize;
		int i = 0, l = 0, r = 0;
		
		while(l < leftSize && r < rightSize) {
			if(leftArray[l] < rightArray[r]) {
				array[i] = leftArray[l];
				i++;
				l++;
			}
			else {
				array[i] = rightArray[r];
				i++;
				r++;
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
	
	public static void HeapSort(int[] array) {
		int len = array.length;
		
		for(int i = len / 2 - 1; i >= 0; i--)
			Heapify(array, len, i);
		for(int i = len - 1; i >= 0; i--) {
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			
			Heapify(array, i, 0);
		}
	}
	
	private static void Heapify(int[] array, int len, int i) {
		int largest = i, left = 2*i + 1, right = 2*i + 2;
		
		if(left < len && array[left] > array[largest])
			largest = left;
		if(right < len && array[right] > array[largest])
			largest = right;
		if(largest != i) {
			int temp = array[i];
			array[i] = array[largest];
			array[largest] = temp;
			
			Heapify(array, len, largest);
		}
	}
	
	public static void QuickSort(int[] array, int start, int end) {
		if(end <= start) return;
		
		int pivot = Partition(array, start, end);
		QuickSort(array, start, pivot - 1);
		QuickSort(array, pivot + 1, end);
	}
	private static int Partition(int[] array, int start, int end) {
		int pivot = array[end];
		int i = start - 1;
		
		for(int j = start; j <= end - 1; j++) {
			if(array[j] < pivot) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		i++;
		int temp = array[i];
		array[i] = array[end];
		array[end] = temp;
		
		return i;
	}

	public static void RadixSort(int[] array) {
		int max = array[0];
		for(int i = 1; i < array.length; i++)
			if(max < array[i])
				max = array[i];
		for(int i = 1; max / i > 0; i *= 10)
			CountSort(array, i);
	}

	private static void CountSort(int[] array, int s) {
		int[] countArray = {0,0,0,0,0,0,0,0,0,0};

		for(int i = 0; i < array.length; i++)
			countArray[(array[i] / s) % 10]++;
		for(int i = 1; i < 10; i++)
			countArray[i] += countArray[i - 1];

		int[] outputArray = {0,0,0,0,0,0,0,0,0,0,};

		for(int i = array.length - 1; i >= 0; i--)
			outputArray[--countArray[(array[i] / s) % 10]] = array[i];
		for(int i = 0; i < array.length; i++)
			array[i] = outputArray[i];
	}

	public static int[] CreateArray() {
		int size = (int) Math.round(Math.random()*10) + 1;
		int[] array = new int[size];
		array = new int[size];
		for(int i = 0; i < size; i++)
			array[i] = (int) Math.round(Math.random()*100);
		return array;
	}
	
	public static void PrintArray(int[] array) {
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
}