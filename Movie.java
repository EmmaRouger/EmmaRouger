/*
 * File name: Movie.java
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

/**
 * <information about a movie >
 *
 * @author Emma ROUGER
 *
 */
public class Movie
{
	private String title;
	private String rating;
	private int year;
	private int score;
	
	
	/**
	 * Constructor
	 * @param title
	 * @param rating
	 * @param year
	 * @param score
	 */
	public Movie(String title,String rating,int year, int score)
	{
		this.title=title;
		this.rating=rating;
		this.year=year;
		this.score=score;
	}


	/**
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}


	/**
	 * @return the rating
	 */
	public String getRating()
	{
		return rating;
	}


	/**
	 * @return the year
	 */
	public int getYear()
	{
		return year;
	}


	/**
	 * @return the score
	 */
	public int getScore()
	{
		return score;
	}
	
	/**
	 * @return the toString that output all the information of the movies in a certain way 
	 * to meet a table form requirement
	 */
	public String toString()
	{
		String tab="\t";
		if(title.length()<8)
		{
			tab="\t\t\t\t\t\t\t\t\t";
		}
		else if(title.length()<16)
		{
			tab="\t\t\t\t\t\t\t\t";
		}
		else if (title.length()<24)
		{
			tab="\t\t\t\t\t\t\t";
		}
		else if(title.length()<32)
		{
			tab="\t\t\t\t\t\t";
		}
		else if (title.length()<40)
		{
			tab="\t\t\t\t\t";
		}
		else if (title.length()<48)
		{
			tab="\t\t\t\t";
		}
		else if (title.length()<56)
		{
			tab="\t\t\t";
		}
		else if (title.length()<64)
		{
			tab="\t\t";
		}
		
		String tab2="";
		if (rating.length()<8)
		{
			tab2="\t\t";
		}
		else 
		{
			tab2="\t";
		}
		return title+tab+year+"\t\t"+rating+tab2+score;
	}
}
