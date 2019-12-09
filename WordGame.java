/*
 * File name: WordGame.java
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

import java.util.Scanner;

/**
 * <Game with output words>
 *
 * @author Emma ROUGER
 *
 */
public class WordGame
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// input of the strings
		Scanner scan = new Scanner (System.in);
		
		System.out.print ("Enter a name: ");
		String name = scan.nextLine();
		
		System.out.print ("Enter an age under 18: ");
		String age = scan.nextLine();
		
		System.out.print ("Enter your city: ");
		String city =scan.nextLine();
		
		System.out.print ("Enter the name of a college: ");
		String college = scan.nextLine();
		
		System.out.print ("Enter a profession: ");
		String profession = scan.nextLine();
		
		System.out.print ("Enter an animal: ");
		String animal = scan.nextLine();
		
		System.out.print ("Enter a pet name: ");
		String petName = scan.nextLine();
		
		// display of the story
		System.out.println ("\nThere once was a person named "+ name + " who lived in "+ city +".");
		System.out.println ("Event though " + name + " was only "+age+", "+name+" went to college at "+college+".");
		System.out.println (name+ " graduated and went to work as a "+profession+".");
		System.out.println ("Soon thereafter, "+ name +" adopted a(n) "+ animal +" named "+petName +"." );
		System.out.println (name + " and "+petName + " both lived happily ever after!\n" );
		
		//turn story into string then cut to just have the last word of the sentence
		String sentence1 = "There once was a person named "+ name + " who lived in "+ city +".";
		String sentence2 = "Event though " + name + " was only "+age+", "+name+" went to college at "+college+".";
		String sentence3 = name+ " graduated and went to work as a "+profession+".";
		String sentence4 = "Soon thereafter, "+ name +" adopted a(n) "+ animal +" named "+petName+".";
		String sentence5 = name + " and "+petName + " both lived happily ever after!" ;
		
		
		String first = sentence1.substring(sentence1.length()-city.length()-1,sentence1.length()-1);
		String second = sentence2.substring(sentence2.length()-college.length()-1,sentence2.length()-1);
		String third = sentence3.substring(sentence3.length()-profession.length()-1,sentence3.length()-1);
		String forth = sentence4.substring(sentence4.length()-petName.length()-1,sentence4.length()-1);
		String fifth = sentence5.substring(sentence5.length()-6);
		
		// output of the new phrase
		System.out.print("New phrase is: ");
		System.out.println(first + " "+second+" "+ third +" "+forth+" "+fifth);	
		
		scan.close();
		

	}

}
