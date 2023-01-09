package task9;

public class ArrayOfTwoArrays {
	public static void main(String[] args) {
		int[] arr1, arr2, arr3;
		arr1 = CreateArray();
		System.out.println("Первый массив: ");
		PrintArray(arr1);
		arr2 = CreateArray();
		System.out.println("Второй массив: ");
		PrintArray(arr2);
		arr3 = CombineTwoArrays(arr1, arr2);
		System.out.println("Третий, отсортированый "+
		"массив из двух предыдущих:");
		PrintArray(arr3);
		System.out.println("Программа завершена");
	}
	public static int[] CreateArray() {
			int size = (int) Math.round(Math.random()*10);
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
	public static int[] CombineTwoArrays(int[] arr1, int[] arr2) {
		int len = arr1.length+arr2.length;
		int[] arr3 = new int[len];

		for(int i = 0; i < arr1.length; i++) 
			arr3[i] = arr1[i];
		for(int i = 0; i < arr2.length; i++)
			arr3[i+arr1.length] = arr2[i];
	
		SortArray(arr3);
		
		return arr3;
	}
	private static void SortArray(int[] array) {
		for(int out = array.length-1; out >= 1; out--) {
			for(int in = 0; in < out; in++)
				if(array[in] > array[in+1]) {
					int temp = array[in];
					array[in] = array[in+1];
					array[in+1] = temp;
				}	
		}
	}
}
