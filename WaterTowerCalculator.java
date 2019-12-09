/*
 * File name: WaterTowerCalculator.java
 *
 * Programmer: Emma ROUGER
 * ULID: erouger 
 * 
 * Date: Aug 28, 2019
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
 * <Give you the number of gallon needed to any width read from 
 the keybord. All value are given with 2 decimals.>
 *
 * @author Emma ROUGER
 *
 */
public class WaterTowerCalculator
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		Scanner keyboard = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat ("###,###.00");
		
		final double PI = 3.14;
		final double GALLON = 7.48;
		double width = 0;
		double radius = 0;
		double radius2 = 0;
		double radius3 = 0;
		double area = 0;		//creation of all variable we are going to use
		double areaFt = 0;
		double volume = 0;
		double volumeFt = 0;
		double totGallon = 0;
			
		
		System.out.print ("Enter the width of the sphere: ");
		width = keyboard.nextDouble ();// read and store the width given
		
		radius = width / 2;// calculate the radius by dividing the zidth by 2
		radius2 = radius * radius;// calculate the square of the radius
		radius3 = radius * radius * radius;// calculate the cube of the radius
		
		area = 4 * PI * radius2;// calculate the area in inches
		areaFt = area / 144;//calculate the area in feet
		volume = PI * radius3 * 4/3;//calculate the volume in inches
		volumeFt = volume / 1728;// calculate the volume in feet
		totGallon = volumeFt * GALLON;// calculate the number of gallon needed
		
		System.out.print ("Area in inches: ");
		System.out.println (df.format(area));//print the area in inches
		
		System.out.print ("Area in feet: ");
		System.out.println (df.format(areaFt));//print area in feet
		
		System.out.print ("Volume in inches: ");
		System.out.println (df.format(volume));//print volume in inches
		
		System.out.print ("Volume in feet: ");
		System.out.println (df.format(volumeFt));//print volume in feet
		
		System.out.print ("Gallons of water: ");
		System.out.println (df.format(totGallon));//print number of gallon needed
		
		
		

	}

}
