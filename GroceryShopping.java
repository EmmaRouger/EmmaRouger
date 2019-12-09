/*
 * File name: GroceryShopping.java
 *
 * Programmer: Emma ROUGER
 * ULID: erouger 
 * 
 * Date: Sep 18, 2019
 *
 * Class: IT168
 * Lecture Section: 16 
 * Lecture instructor: Tonya Pierce
 * Lab session: 17
 * Lab instructor: Kushal Sharma
 */
package edu.ilstu;

import java.text.DecimalFormat;

/**
 * <Calculate the total price amount  about a grocery ordered>
 *
 * @author Emma ROUGER
 *
 */
public class GroceryShopping
{
	private String fruit;
	private String vegetable;
	private double vegePrice;
	private double fruitPrice;
	private double vegeOrdered;
	private double fruitOrdered;
	
	public double SERVICE_RATE = 0.035;
	public int DELIVERY_FEE = 5;
	DecimalFormat df = new DecimalFormat ("###,###.00");
	
	/**
	 * Constructor
	 * 
	 * @param vegetable
	 *            The vegetable chosen
	 * @param vegePrice
	 *            The price's vegetable
	 * @param fruitPrice
	 *            The price's fruit
	 * @param fruit
	 * 			  The fruit chosen
	 */
	public GroceryShopping ( String vegetable, double vegePrice, double fruitPrice, String fruit)
	{
		this.vegetable=vegetable;
		this.fruit=fruit;
		this.vegePrice=vegePrice;
		this.fruitPrice=fruitPrice;
		
	}
	
	/**
	 * @return The chosen fruit
	 */
	public String getFruit()
	{
		return fruit;
	}
	
	/**
	 * @return The chosen vegetable
	 */
	public String getVegetable()
	{
		return vegetable;
	}
	
	/**
	 * @return The price's vegetable
	 */
	public double getVegePrice()
	{
		return vegePrice;
	}
	
	/**
	 * @return The price's fruit
	 */
	public double getFruiyPrice()
	{
		return fruitPrice;
	}
	
	/**
	 * @return The number of pound ordered of vegetable
	 */
	public double getVegeOrdered()
	{
		return vegeOrdered;
	}
	
	/**
	 * @return The number of pound ordered of fruit
	 */
	public double getFruitOrdered()
	{
		return fruitOrdered;
	}
	
	/**
	 * @param FruitOrdered
	 *            The fruit pound ordered to set
	 */
	public void setFruitOrdered (double fruitOrdered)
	{
		this.fruitOrdered=fruitOrdered;
	}
	
	/**
	 * @param firstName
	 *            The vegetable pound ordered to set
	 */
	public void setVegeOrdered (double vegeOrdered)
	{
		this.vegeOrdered=vegeOrdered;
	}
	
	/**
	 * @return the subtotal, without the additional fees
	 */
	public double calculateSubtotal ()
	{
		double subtotal = fruitPrice * fruitOrdered + vegePrice *vegeOrdered;
		return subtotal;
	}
	
	/**
	 * @return The additional fees, the service rate plus the delivery fee
	 */
	public double calculateAdditionalFee ()
	{
		double additionalFee = this.calculateSubtotal()*SERVICE_RATE + DELIVERY_FEE;
		return additionalFee;
	}
	
	/**
	 * Display all information about the order and the total amount of the order
	 */
	public void displayOrderSummary()
	{
		
		double total = this.calculateSubtotal()+this.calculateAdditionalFee();
		String summary ="----------------------------------------\n" +
						"Grocery Shopping Order Summary"+
						"\n"+						
						"\nName:\t\t\tPounds Ordered:"+
						"\n"+vegetable+"\t\t"+df.format(vegeOrdered)+
						"\n"+fruit+"   \t\t"+df.format(fruitOrdered)+
						"\n"+
						"\nSub-total:\t\t$"+df.format(this.calculateSubtotal())+
						"\nAdditional Fee:\t\t$"+df.format(this.calculateAdditionalFee())+
						"\nTotal Bill:\t\t$"+df.format(total)+
						"\n----------------------------------------";
		System.out.println(summary);
		
	}
}
