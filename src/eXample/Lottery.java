package eXample;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lottery {
	
	static ArrayList<String> buyers = new ArrayList<String>(50);
	static double[] winningPercentages = {0.75, 0.15, 0.10};
	static ArrayList<String> winners = new ArrayList<String>();

	public static void main(String[] args) {
		mainMenu();
	}
	
	public static void mainMenu() {
		System.out.println("Welcome to Lottery System");
		System.out.println("Press 1 to purchase Lottery");
		System.out.println("Press 2 to draw a winner");
		System.out.println("Press 3 to display winners");
		
		Scanner choice_scanner = new Scanner(System.in);
		int choice = choice_scanner.nextInt();
		
		switch(choice) {
			case 1:
				purchase();
				break;
			case 2:
				draw();
				break;
			case 3:
				displayWinners();
				break;
			default:
				System.out.println("Invalid input");
				mainMenu();
		}
	}
	
	public static void purchase() {
		System.out.println("Enter the name of the buyer: ");
		Scanner buyer_scanner = new Scanner(System.in);
		String buyer = buyer_scanner.nextLine();
		buyers.add(buyer);
		System.out.println(buyer + "'s lottery number is " + buyers.size());
		mainMenu();
	}
	
	public static void draw() {
		if(buyers.size() < 3)
		{
			System.out.println("Atleast 3 lotteries need to purchased before drawing a winner");
			mainMenu();
		}
		else
		{
			winners.clear();
			for(int i = 0; i <=2; i++)
			{
				Random lucky_no_generator = new Random();	
				int lucky_no = (int) (Math.random() * ( buyers.size() - 1 ));
				String winner = buyers.get(lucky_no);
				double amount = winnerAmount(i);
				System.out.println("Winner number " + (i+1) + " is " + winner + " and winning amount is " + amount);
				winners.add("Winner number " + (i+1) + " is " + winner + " and winning amount is " + amount);
				buyers.remove(lucky_no);
			}
			buyers.clear();
			mainMenu();
		}
	}
	
	public static double winnerAmount(int winnerNo) {
		double amount = ((buyers.size() * 10) / 2) * winningPercentages[winnerNo];
		return amount;
	}
	
	public static void displayWinners() {
		for(int i = 0; i <=2; i++)
		{
			System.out.println(winners.get(i));
		}
		mainMenu();
	}

}
