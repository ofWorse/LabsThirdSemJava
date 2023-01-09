package task4;

import java.util.Scanner;

public class ZodiacSign {
	public static void main(String[] args) {
		int day, mounth;
		String[] names = {"","Козерог","Водолей","Рыбы","Овен","Телец",
				"Близнецы","Рак","Лев","Дева","Весы","Скорпион","Стрелец"};
		
		System.out.println("Введите день и месяц рождения\n" +
				"для выявления знака зодиака");
		
		try(Scanner scan = new Scanner(System.in)) {
			day = scan.nextInt();
			mounth = scan.nextInt();
		}
		
		if(day < 22)
			System.out.println("Месяц по счету: " + mounth + ", Вы: " + names[mounth]);
		else {
			mounth++;
			System.out.println("Месяц по счету: " + mounth + ", Вы: " + names[mounth]);
		}
		System.out.println("Программа завершена");
	}
}
