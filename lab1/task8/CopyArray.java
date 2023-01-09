package task8;

public class CopyArray {
	public static void main(String[] args) {
		int[] array = CreateArray();
		CopyArr(array);
	}
	
	public static int[] CreateArray() {
		int size;
		size = (int)Math.round(Math.random()*10);
		int[] array = new int[size];
		
		for(int i = 0; i < array.length; i++)
			array[i] = ((int)Math.round(Math.random()*100));
		
		System.out.println("Массив был создан: ");
		PrintArray(array);
		
		return array;
	}
	
	private static void PrintArray(int[] array) {
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
	
	public static void CopyArr(int[] array) {
		int[] copy = new int[array.length];
		for(int i = 0; i < array.length; i++)
			copy[i] = array[i];
		System.out.println("Массив был скопирован: ");
		PrintArray(copy);
	}
}
