/*
 * File name: RandomCalc.java
 *
 * Programmer: Emma ROUGER
 * ULID: erouger 
 * 
 * Date: Sep 4, 2019
 *
 * Class: IT168
 * Lecture Section: 16 
 * Lecture instructor: Tonya Pierce
 * Lab session: 17
 * Lab instructor: Kushal Sharma
 */
package edu.ilstu;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * <make some math calculation based on three random number from 1 to 6>
 *
 * @author Emma ROUGER
 *
 */
public class RandomCalc
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		DecimalFormat df = new DecimalFormat("###,###,###");
		Random random = new Random ();
		// initialize the three random number
		int first = random.nextInt(6)+1;
		int second = random.nextInt(6)+1;
		int third = random.nextInt(6)+1;
		
		// do all the caluculus : add substract multiply
		int add = first + second + third;
		int subtract = first - second - third;
		int multiply = first * second * third;
		
		//do number 1 to the power of number 2 to the power of number 3
		double power = Math.pow(Math.pow(first,second), third);
		
		// output the results
		System.out.println("Sample run:");
		System.out.println(first + " + " + second +" + " + third + " = " + add);
		System.out.println(first + " - " + second +" - " + third + " = " + subtract);
		System.out.println(first + " * " + second +" * " + third + " = " + multiply);
		System.out.println(first + " to the power of " + second + " to the power of "+ third + " = " + df.format(power));
		 
		
		
		
	}
	
}
