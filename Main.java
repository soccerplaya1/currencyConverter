//1. Gebruik minstens 7 classes. Een ervan moet abstract zijn. Elke klasse moet zijn eigen verantwoordelijkheid hebben. 
//2. Gebruik minstens 2 interfaces.
//3. 80% van de methoden zal een ander returntype moeten hebben dan void.
//4. 40% van de parameters moet van een objectType zijn, dus geen primitive of String.
//5. 7 keer moet een interface OF het returntype zijn OF het parameterType.
//6. Er moet een zelfverzonnen ExceptionType (van het type checked) zijn in je programma.
//7. Er moet 3 keer een Exception gethrowd worden in je programma.
//8. Er moet een Constructor worden overgeload.
//9. Er moet 1 keer een Constructor worden geredirect.
//10. Je zult 4 keer een methode moeten overriden.
//11. Je zult 1 keer een methode moeten overriden die jouw Exception throwt.
//12. 1 Constructor zal een Exception moeten throwen.
//13. Gebruik alleen native Java GEEN Spring, Swing of andere frameworks. Het moet een console applicatie zijn.


package weekOpdracht2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		StartProgram start = new StartProgram();
		
		while (start.chooseToStart(scan)) {
			ChooseCurrency cc = new ChooseCurrency();
			cc.chooseCurrency(scan);
		}
		
		System.exit(0);

	}

}

interface CurrencyConvertible {
	double convertCurrency(); // By default, public and abstract.
}

interface Printable {
	void printToScreen(); // By default, public and abstract.
}

class StartProgram {
	int selectionFromUser = 0;
	boolean chooseToStart(Scanner obj) {
		System.out.println("Do you want to convert money?");
		System.out.println("Press 0 to exit program");
		System.out.println("Press 1 to convert money");
		selectionFromUser = obj.nextInt();
		if (selectionFromUser == 1) {
			System.out.println("Select which currency to convert:	");
			System.out.println("1: Euro 2: Pound 3: Yen 4: Dollar 5: Ruble");
			return true;
		} else {
			System.out.println("Exiting system");
			return false;
		}
	}
}

class ChooseCurrency {
	static public String currency;
	int chooseCurrency(Scanner obj) {
		int currencySelection = obj.nextInt();
		return currencySelection;
		//ChooseCurrency.setCurrency(currencySelection);
	}
	static String setCurrency (int choice) {
		int currentyChoice = choice;
	    String chosenCurrenty;
	    switch (currentyChoice) {
	        case 1:	chosenCurrenty = "Euro";
	        		currency = chosenCurrenty;
	        		System.out.println(currency);
	        		return chosenCurrenty;
	        case 2:	chosenCurrenty = "Pound";
	        		currency = chosenCurrenty;
	        		System.out.println(currency);
	        		return chosenCurrenty;
	        case 3:	chosenCurrenty = "Yen";
	        		currency = chosenCurrenty;
	        		System.out.println(currency);
	        		return chosenCurrenty;
	        case 4:	chosenCurrenty = "Dollar";
	        		currency = chosenCurrenty;
	        		System.out.println(currency);
	        		return chosenCurrenty;
	        case 5:	chosenCurrenty = "Ruble";
	        		currency = chosenCurrenty;
	        		System.out.println(currency);
	        		return chosenCurrenty;
	        default:chosenCurrenty = "Invalid choice";
	        		currency = chosenCurrenty;
	        		return chosenCurrenty;
	    }    
    }
}

abstract class Currency implements CurrencyConvertible {
	String currencyName;
	String currencyDesired;
	double currencyAmount;
	Currency(String name, String desired, double amount) {
		this.currencyName = name;
		this.currencyDesired = desired;
		this.currencyAmount = amount;
		System.out.println("Selected currenty:	" + currencyName);
	}
//	double convertCurrency() {
//		return 0.0;
//	}
}

class Euro extends Currency {
	double euroExchangeRate = 1.00;
	Euro (String name, String converted, double amount) {
		super(name, converted, amount);
		this.currencyAmount = amount;
		this.currencyDesired = converted;
		System.out.println(name + currencyAmount + currencyDesired);
	}	

	@Override
	public double convertCurrency() {
		// TODO Auto-generated method stub
		return 0;
	}
}

//class Pound extends Currency implements CurrencyConvertable {
//	
//}
//
//class Yen extends Currency implements CurrencyConvertable {
//	
//}
//
//class Dollar extends Currency implements CurrencyConvertable {
//	
//}
//
//class Ruble extends Currency implements CurrencyConvertable {
//	
//}

class IntegerNotFoundException extends Exception {}

