/*
 * File name: GroceryShoppingApp.java
 *
 * Programmer: Emma ROUGER
 * ULID: erouger 
 * 
 * Date: Sep 22, 2019
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
 * <give the summary order with price and taxes for the Grocery Order>
 *
 * @author Emma ROUGER
 *
 */
public class GroceryShoppingApp
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner scan = new Scanner (System.in);
		
		// set all variables
		String vege;
		String fruit;
		double vPrice;
		double fPrice;
		
		//set both tables
		String table1 ="Vegetable Name\t\tPrice Per Pound\n"
				+ "Broccoli\t\t$3.12\n"
				+ "Yellow Onion\t\t$1.15\n"
				+ "Chili Pepper\t\t$4.58\n"
				+ "Greens Bundle\t\t$2.82\n"
				+ "---------------------------------------\n"
				+ "Table 1: Vegetable names with corresponding price per pound";
		String table2 = "\n---------------------------------------\n"
				+ "Fruit Name\t\tPrice Per Pound\n"
				+ "Apple\t\t\t$1.73\n"
				+ "Grape\t\t\t$2.15\n"
				+ "Key Lime\t\t$2.58\n"
				+ "Navel Orange\t\t$1,86\n"
				+ "---------------------------------------\n"
				+ "Table 2: Fruit Name with corresponding price per pound\n";
		
		
		//print table 1 ad ask to input the vegetable of their choice with the price 
		System.out.println(table1);
		System.out.print("Please select the vegetable from table 1: ");
		vege = scan.nextLine();
		System.out.print("Please enter the Price of the selected vegetable: ");
		vPrice = scan.nextDouble();
		scan.nextLine();
			
		
		//print table 2 ad ask to input the fruit of their choice with the price
		System.out.println(table2);
		System.out.print("Please select the fruit from table 2: ");
		fruit = scan.nextLine();
		System.out.print("Please enter the Price of the Fruit selected: ");
		fPrice = scan.nextDouble();
		
		
		//Display the menu with the information about the vegetable and the fruit ordered
		String menu = "\n---------------------------------------\n"
				+ "Grocery Shopping Menu\n\n"
				+ "Name:\t\t\tPrice Per Pound:\n"
				+ vege +"\t\t"+vPrice
				+"\n"+fruit+"   " +"\t\t"+fPrice
				+"\n---------------------------------------\n";
		System.out.println(menu);
		
		//Ask for how many pound each are ordered 
		GroceryShopping gs = new GroceryShopping(vege,vPrice,fPrice,fruit);
		System.out.print("Enter the Pound of the "+gs.getVegetable()+" ordered: ");
		gs.setVegeOrdered(scan.nextDouble());
		System.out.print("Enter the Pound of the "+gs.getFruit()+" ordered: ");
		gs.setFruitOrdered(scan.nextDouble());
		
		//Display of the summary of the order
		System.out.println("\n");
		gs.displayOrderSummary();
		scan.close();

	}

}
