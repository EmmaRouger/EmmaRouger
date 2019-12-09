/*
 * File name: NetflixApp.java
 *
 * Programmer: Emma ROUGER
 * ULID: erouger 
 * 
 * Date: Nov 24, 2019
 *
 * Class: IT168
 * Lecture Section: 16 
 * Lecture instructor: Tonya Pierce
 * Lab session: 17
 * Lab instructor: Kushal Sharma
 */
package edu.ilstu;

import java.util.Scanner;

/**
 * <App using a data base basing on netflix movie>
 *
 * @author Emma ROUGER
 *
 */
public class NetflixApp
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		NetflixHandler net= new NetflixHandler();
		net.read();//read all the data from the file
		
		menu();
		while(!scan.hasNextInt())//make sure the input is an integer
		{
			System.out.println("Please provide a valid input: ");
			scan.hasNextInt();
		}
		int choice=scan.nextInt();//ask for the number of their choice corresponding to an action 
		
		while(choice!=5)
		{
			while (choice<1||choice>5)//make sure the number enter is meeting the reauirement
			{
				System.out.println("Please provide a valid input: ");
				choice=scan.nextInt();//ask for a new number
			}
			switch(choice)
			{
			case 1:
				net.displayAllMovie();//display all the movies by using the method 
				break;
			case 2:
				net.searchTitle();//use search title method
				break;
			case 3:
				net.searchYear();//use search year method
				break;
			case 4:
				net.recommendation();//use recommendation method
				break;
			}
			menu();
			choice=scan.nextInt();
		
		}
		System.out.println("Thank you for using the database. Please come back next time.");
		System.exit(0);//exit the system after printing a good bye message
		
		scan.close();
		
		

	}
	/**
	 * print the menu of the app
	 */
	private static void menu()
	{
		String menu="\t\t\t\t\t    Welcome to the Netflix Database\n"
				+   "\t\t\t\t\t==========================================\n"
				+   "\t\t\t\t\t   1. Browse all movies.\n"
				+   "\t\t\t\t\t   2. Search a movie based on title.\n"
				+   "\t\t\t\t\t   3. Search movies based on year.\n"
				+   "\t\t\t\t\t   4. Top movies recommendation.\n"
				+   "\t\t\t\t\t   5. Exit.\n"
				+   "\t\t\t\t\t==========================================";
		System.out.println(menu);
		System.out.print("Please make your choice: ");
	}
	
	

}
