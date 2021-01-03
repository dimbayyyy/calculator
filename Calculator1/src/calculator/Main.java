package calculator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int a=0;
		int a1=0;
		int a2=0;
		boolean roman = false;
		boolean del = false;
		String answer = "";
		String arabicNumerals = "1 2 3 4 5 6 7 8 9 10";
		String romanNumerals = "I II III IV V VI VII VIII IX X";
		String symbol = "+ - * /";
		
		//Принимаем строку с выражением
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите выражение:");
		String equation = scanner.nextLine();
		String[] substr = equation.split(" ");
		// Экспешены не успел изучить
		if ((substr.length != 3) 
			|| (arabicNumerals.contains(substr[0]) && romanNumerals.contains(substr[2]) )
			|| (arabicNumerals.contains(substr[2]) && romanNumerals.contains(substr[0]))
			|| (!symbol.contains(substr[1])) 
			|| (!arabicNumerals.contains(substr[0]) && !romanNumerals.contains(substr[0]) )
			|| (!arabicNumerals.contains(substr[2]) && !romanNumerals.contains(substr[2])))
			 {

			System.out.println("Выражение введено некорректно!");
			return;
			
		}
		
		
		
		if (arabicNumerals.contains(substr[0])) {
			a1 = Integer.parseInt(substr[0]);
			a2 = Integer.parseInt(substr[2]);
		} 
		else if (romanNumerals.contains(substr[0])) {
			
			RomToAr romToAr = new RomToAr();
			a1 = romToAr.transfom(substr[0]);
			a2 = romToAr.transfom(substr[2]);
			roman = true;
		}
		switch (substr[1]) {
		case "+":
			a = a1+a2;
			break;
		case "-":
			a = a1-a2;
			break;
		case "*":
			a = a1*a2;
			break;
		case "/":
			a = a1/a2;
		}
		//System.out.println(a);
		if (a < 50) {
			del = true;
		}
		if (roman) {
			answer = (del) ? ArToRom.convert(a).substring(1) : ArToRom.convert(a);

			if (answer.equals("CL")) {
				System.out.println("C");
			} else {
				System.out.println(answer);
			}
				
			
			
			
		}
		else {
			System.out.println(a);
		}
		

	}

}
