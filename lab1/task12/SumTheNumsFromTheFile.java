package task12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SumTheNumsFromTheFile {
	public static void main(String[] args) {		
		
		HelloMenu();
		CreatePathAndFile();
		
		System.out.println("Программа завершена.");
	}
	
	public static void CollectNums(File file) {
		int sum = 0;
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while((line = br.readLine()) != null) {
				
				/* Внимание: лютый хардкод! */ 
				
				for(int i = 0; i < line.length(); i++) {
					if(isInteger(line.charAt(i))) 
						sum += line.charAt(i) - 48;
				}
			}
			br.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}

		System.out.println("Сумма всех чисел в\n" +
				"данном файле равна " + sum);
	}
	
	public static void HelloMenu() {
		System.out.println("Введите полный путь к файлу в зависимости от вашей файловой системы.");
		System.out.println("Пример на windows: \\User\\username\\file.txt");
		System.out.println("Пример на unix: /user/username/file.txt");
		System.out.print("-> ");
	}
	
	public static void CreatePathAndFile() {
		try (Scanner scanThePath = new Scanner(System.in)) {
			String path = scanThePath.nextLine();
			File file = new File(path);
			while(!CheckForExistence(file)) {
				System.out.println("Неверно введен путь к файлу или файла не существует.");
				System.out.println("Попробуйте еще раз:");
				System.out.print("-> ");
				path = scanThePath.nextLine();
				file = new File(path);
			}
			CollectNums(file);
			AskForShowFile(path);
			scanThePath.close();
		}
	}
	
	public static void AskForShowFile(String path) {
		System.out.println("Вывести данные из файла? (да/нет)");
		System.out.print("-> ");
		String choose;
		Scanner scan = new Scanner(System.in);
		choose = scan.nextLine();
		
		switch(choose) {
		case "да":
			printFile(path); break;
		case "нет": break;
		}
	}
	
	private static void printFile(String path) {
		File file = new File(path);
		System.out.println("\nСодержимое файла: ");
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
			System.out.println();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private static boolean CheckForExistence(File file) {
		if(file.isFile())
			return true;
		else return false;
	}
	
	private static boolean isInteger(char c) {
		for(int i = 48; i < 58; i++) {
			if(c == i)
				return true;
			else continue;
		}
		return false;
	}
}
