/*
 * File name: Auto.java
 *
 * Programmer: Emma ROUGER
 * ULID: erouger 
 * 
 * Date: Sep 26, 2019
 *
 * Class: IT168
 * Lecture Section: 16 
 * Lecture instructor: Tonya Pierce
 * Lab session: 17
 * Lab instructor: Kushal Sharma
 */
package edu.ilstu;

/**
 * <insert class description here>
 *
 * @author Emma ROUGER
 *
 */
public class Auto
{
	private int year;
	private String make;
	private String model;
	private double mileage;
	private double price;
	
	
	
	/**
	 * @param year
	 * @param make
	 * @param model
	 */
	public Auto(int year, String make, String model)
	{
		this.year = year;
		this.make = make;
		this.model = model;
	}
	/**
	 * @return the mileage
	 */
	public double getMileage()
	{
		return mileage;
	}
	/**
	 * @param mileage the mileage to set
	 */
	public void setMileage(double mileage)
	{
		this.mileage = mileage;
	}
	/**
	 * @return the price
	 */
	public double getPrice()
	{
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price)
	{
		this.price = price;
	}
	/**
	 * @return the year
	 */
	public int getYear()
	{
		return year;
	}
	/**
	 * @return the make
	 */
	public String getMake()
	{
		return make;
	}
	/**
	 * @return the model
	 */
	public String getModel()
	{
		return model;
	}
	
	public String toString()
	{
		return year + " "+ make + " "+ model;
	}
	
}
