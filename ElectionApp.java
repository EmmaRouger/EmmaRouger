/*
 * File name: ElectionApp.java
 *
 * Programmer: Emma ROUGER
 * ULID: erouger 
 * 
 * Date: Nov 16, 2019
 *
 * Class: IT168
 * Lecture Section: 16 
 * Lecture instructor: Tonya Pierce
 * Lab session: 17
 * Lab instructor: Kushal Sharma
 */
package edu.ilstu;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <do the election>
 *
 * @author Emma ROUGER
 *
 */
public class ElectionApp
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Results result = new Results();
		int choice =0;
		try
		{
			do
			{
				outputMenu();
				choice = scan.nextInt();
				scan.nextLine();
				// depending on the choice of the user the program will run the election, to close the user has to press 6
				switch (choice)
				{
				case 1:
					result.addCandidate(scan);//add a candidate
					break;
				case 2:
					result.addVote(scan);//add votes to each candidate
					break;
				case 3:
					result.determinWinner(scan);// determine the winner for the given office
					break;
				case 4:
					System.out.println(result.toString());// output all the candidate
					break;
				case 5:
					result.displayWinner();//display the winner per office
					break;
				}
			}
			while (choice !=6);
			System.out.println("\nGoodbye!");
			System.exit(0);
		}
		catch(InputMismatchException ex)
		{
			//catch the input that are not at the right data type
			System.out.println("You didn't enter the right data type,\nPlease restart the program");
			System.exit(0);
		}
		scan.close();
		

	}
	
	/**
	 * display the menu of the election
	 */
	private static void outputMenu()
	{
		String menu="\nChoose from the following options:\n" + 
				"1- Add a candidate\n" + 
				"2- Add votes\n" + 
				"3- Determine winner\n" + 
				"4- Display a list of candidates\n" + 
				"5- Display winners\n" + 
				"6- Exit\n" + 
				"Your choice? ";
		System.out.print(menu);
	}

}
