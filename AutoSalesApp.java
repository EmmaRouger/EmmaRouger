/*
 * File name: AutoSalesApp.java
 *
 * Programmer: Emma ROUGER
 * ULID: erouger 
 * 
 * Date: Oct 7, 2019
 *
 * Class: IT168
 * Lecture Section: 16 
 * Lecture instructor: Tonya Pierce
 * Lab session: 17
 * Lab instructor: Kushal Sharma
 */
package edu.ilstu;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * <insert class description here>
 *
 * @author Emma ROUGER
 *
 */
public class AutoSalesApp
{
	//set the auto sales order
	static AutoSalesOrder order = new AutoSalesOrder();
	static DecimalFormat d1=new DecimalFormat("###,##0");
	static DecimalFormat d2=new DecimalFormat("$###,###.00");
	static Scanner scan = new Scanner(System.in);
	
	/**
	 * set the chosen vehicle as the purchase
	 */
	public static void selectVehicule()
	{
		//set the 3 different autos a costumer can purchase
		Auto a1= new Auto(2015,"Toyota","Camary");
		Auto a2 = new Auto(2016,"Ford","F-150");
		Auto a3 = new Auto (2018,"Chevy","Equinox");
		a1.setMileage(34000);
		a1.setPrice(17998.00);
		a2.setMileage(27000);
		a2.setPrice(34600.00);
		a3.setMileage(17000);
		a3.setPrice(22498.00);
		
		//Display a welcome message and the vehicle inventory
		System.out.println("Welcome to Amazing Auto!\n");
		System.out.println("Let us help you find your next automobile.\n");
		String inventory="CHOOSE FROM OUR PROLIFIC VEHICLE INVENTORY ...\n"
			+"--------------------------------------------------\n"
			+"Item#\tVehicle\t\tMiles\t     Price\n"
			+"--------------------------------------------------\n"
			+"1\t"+a1.toString()+"\t"+d1.format(a1.getMileage())+"\t"+d2.format(a1.getPrice())
			+"\n2\t"+a2.toString()+"\t\t"+d1.format(a2.getMileage())+"\t"+d2.format(a2.getPrice())
			+"\n3\t"+a3.toString()+"\t"+d1.format(a3.getMileage())+"\t"+d2.format(a3.getPrice());
		System.out.println(inventory);
		
		//ask which vehicle the costumer want and store all the information
		System.out.print("\nSelect your vehicle by item # (e.g. 1, 2, 3): ");
		
		int vehicule=scan.nextInt();
		scan.nextLine();
		if (vehicule==1)
		{
			order.setVehiculeDescription(a1.toString());
			order.setVehiculePrice(a1.getPrice());
			System.out.println("\nYou've selected the "+order.getVehiculeDescription()+" ... a wise choice!");
		}
		else if (vehicule==2)
		{
			order.setVehiculeDescription(a2.toString());
			order.setVehiculePrice(a2.getPrice());
			System.out.println("You've selected the "+order.getVehiculeDescription()+" ... a wise choice!");
		}
		else if (vehicule==3)
		{
			order.setVehiculeDescription(a3.toString());
			order.setVehiculePrice(a3.getPrice());
			System.out.println("\nYou've selected the "+order.getVehiculeDescription()+" ... a wise choice!");
		}
		else 
		{
			System.out.println("The vehicle you have selected is not in our inventory.");
			System.exit(1);
		}
		
	}
	/**
	 * prompt the service cash and ask the different service the costumer want
	 */
	public static void selectServiceOption()
	{
		//display the invitation to purchase the pre-paid service cash and display the service cash
		System.out.println("\nProtect your purchase with our pre-paid service offering.");
		System.out.println("Today's purchase qualifies for "+d2.format(order.getServiceCash())+" in Service Cash.\n");
		
		//set the different service purchased
		System.out.print("\tAdd our 3-year oil change package for "+d2.format(order.OIL_CHANGE)+" (Y or N)? ");
		String addOil=scan.nextLine();
		if (addOil.equalsIgnoreCase("Y"))
		{
			order.setOilChangeIndi(true);
		}
		else
		{
			order.setOilChangeIndi(false);
		}
		System.out.print("\tAdd our 3-year tire rotation package for "+d2.format(order.TIRE_ROTATION)+" (Y or N)? ");
		String addTire=scan.nextLine();
		if (addTire.equalsIgnoreCase("Y"))
		{
			order.setTireRotationIndi(true);
		}
		else 
		{
			order.setTireRotationIndi(false);
		}
		System.out.print("\tAdd our 3-year car wash package for "+order.CAR_WASH+" (Y or N)? ");
		String addWash=scan.nextLine();
		if (addWash.equalsIgnoreCase("Y"))
		{
			order.setCarWashIndi(true);
		}
		else 
		{
			order.setCarWashIndi(false);
		}
		
	}
	/**
	 * Initiate the program, manage the flow of execution and display the auto sales order receipt
	 * @param args
	 */
	
	public static void main(String[] args)
	{
		//call the two other methods to display them
		selectVehicule();
		selectServiceOption();
		
		//display the order receipt
		System.out.println("\nCongratulations on your purchase!\n");
		order.toString();
		
				
	}
	
	

}
	


