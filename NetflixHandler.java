/*
 * File name: NetflixHandler.java
 *
 * Programmer: Emma ROUGER
 * ULID: erouger 
 * 
 * Date: Nov 23, 2019
 *
 * Class: IT168
 * Lecture Section: 16 
 * Lecture instructor: Tonya Pierce
 * Lab session: 17
 * Lab instructor: Kushal Sharma
 */
package edu.ilstu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * <data base of Netflix movie plus actions about this data base>
 *
 * @author Emma ROUGER
 *
 */
public class NetflixHandler
{
	private static Scanner scan = new Scanner(System.in);
	private Movie[] data;
	private int actualSize;
	public final static int SIZE=500;
	
	/**
	 * Constructor
	 * set data to a new array
	 * set the size of this array to 0
	 */
	public NetflixHandler()
	{
		data= new Movie[SIZE];
		actualSize=0;
	}
	
	/**
	 * read all data from "netflix.cvs" file and enter them in an array
	 */
	public void read() 
	{
		try
		{
			Scanner input = new Scanner(new File ("netflix.csv"));
			input.nextLine();
			input.useDelimiter(",");
			for (int i =0;input.hasNext();i++)
			{
				String title=input.next();
				String rating=input.next();
				int year=Integer.parseInt(input.next());
				int score = Integer.parseInt(input.nextLine().substring(1));
				
				data[i]=new Movie(title,rating,year,score);
				actualSize++;			
			}
			input.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File can not be found");
		}
	}
	
	/**
	 * display all the movies that are in the data array
	 */
	public void displayAllMovie()
	{
		System.out.println("Title\t\t\t\t\t\t\t\t\tYear\t\tRating\t\tScore");
		for (int i=0;i<actualSize;i++)
		{
			System.out.println(data[i]);
		}
	}
	
	/**
	 * return the information of a movie base on a given title
	 */
	public void searchTitle()
	{
		System.out.print("Please provide a title: ");
		String title = scan.nextLine();
			
		for (int i =0;i<actualSize;i++)
		{
			if (title.equalsIgnoreCase(data[i].getTitle()))
			{
				System.out.println("Title\t\t\t\t\t\t\t\t\tYear\t\tRating\t\tScore\n"+data[i]);
			}
		}
		System.out.println("The title does not match any of the movies.");
	}
	
	/**
	 * will display all the movie that were released on the given year 
	 */
	public void searchYear()
	{
		System.out.print("Please provide a year: ");
		while(!scan.hasNextInt())
		{
			System.out.print("Please enter an integer: ");
			scan.hasNext();
		}
		
		int year = scan.nextInt();
			
		String movieTitle="";
		for (int i =0;i<actualSize;i++)
		{
			if (year==(data[i].getYear()))
			{
				movieTitle=movieTitle +data[i]+"\n";
			}
		}
		if(movieTitle.equalsIgnoreCase(""))
		{
			System.out.println("The year does not match any of the movies.");
		}
		else
		{
			System.out.println("Title\t\t\t\t\t\t\t\t\tYear\t\tRating\t\tScore\n"+movieTitle);
		}
		
		
	}
	
	/**
	 * Will sort the data array based on the score of each movie and rank them from the best score to the worst
	 * @param movie
	 * @param size
	 */
	public void sort(Movie[]movie,int size)
	{
		Movie temp;
		int index;
		Movie[]temp2=new Movie[size];
		for(int g=0;g<size;g++)
		{
			temp2[g]=movie[g];
		}
		
		for (int i =0;i<size;i++)
		{
			index=i;
			temp=temp2[i];
			for (int j=i+1;j<size;j++)
			{
				
				if (temp2[index].getScore()<temp2[j].getScore())
				{
					
					index=j;
				}
			}
			temp2[i]=temp2[index];
			temp2[index]=temp;
			
		}
		for (int i=0;i<size;i++)
		{
			data[i]=temp2[i];
		}
	}
	
	/**
	 * will print on a file the recommendation. If the user chose recommendation based on rating 
	 * it will be the 5 movies that have the best score and that have the rating
	 * if it's only based on the score it will print the top 20 movies (movies that have the best scores)
	 */
	public void recommendation()
	{
		sort(data,actualSize);
		System.out.println("Do you want the recommendations based on ratings or scores?");
		System.out.println("1. Ratings");
		System.out.println("2. Scores");
		
			int choice=scan.nextInt();
			while(choice!=1&&choice!=2)
			{
				System.out.println("Please provide a valid input: ");
				while (!scan.hasNextInt())
				{
					System.out.println("Please provide a valid input: ");
					scan.hasNextInt();
				}
				choice=scan.nextInt();
				
			}
			scan.nextLine();
			switch(choice)
			{
			case 1:
				try
				{
					FileWriter file = new FileWriter("top_5_movies.txt",false);
					PrintWriter pw = new PrintWriter(file);
					System.out.println("Please provide a rating: ");
					String rating =scan.nextLine();
					int count=0;
					for (int i=0;i<actualSize&&count<5;i++)
					{
						if (data[i].getRating().equalsIgnoreCase(rating))
						{
							pw.println(data[i]);
							count++;
						}
					}
					if (count==0)
					{
						System.out.println("The rating does not match any of the movies.");
					}
					else
					{
						System.out.println("Recommendations made successfully! Top 5 movies found!");
					}
					pw.close();
				}
				catch(IOException e)
				{
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				FileWriter file;
				PrintWriter pw;
				try
				{
					file = new FileWriter("top_20_movies.txt",false);
					pw = new PrintWriter(file);
					for (int i =0;i<20;i++)
					{
						pw.println(data[i]);
					}
					System.out.println("Recommendations made successfully! Top 20 movies found!");
					pw.close();
				}
				catch(IOException e)
				{
					System.out.println(e.getMessage());
				}
			}
		

	}

	
	
}
