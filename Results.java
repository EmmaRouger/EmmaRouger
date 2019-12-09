/*
 * File name: Results.java
 *
 * Programmer: Emma ROUGER
 * ULID: erouger 
 * 
 * Date: Nov 7, 2019
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
 * <gives the results of the election>
 *
 * @author Emma ROUGER
 *
 */
public class Results
{
	private static int BLOCK_SIZE=3;
	private Candidate [] candidate;
	private int countCandidate;
	private String [] offices;
	private int numOffice;
	
	/**
	 * constructor,
	 * Create new arrays for CANDIDATE and Offices with a size of 3
	 * Assign 0 to the number of Candidate and office entered
	 */
	public Results ()
	{
		this.candidate=new Candidate[BLOCK_SIZE];
		this.offices=new String[BLOCK_SIZE];
		this.numOffice=0;
		this.countCandidate=0;
	}

	/**
	 * @return the countCandidate
	 */
	public int getCountCandidate()
	{
		return countCandidate;
	}

	/**
	 * @return the numOffice
	 */
	public int getNumOffice()
	{
		return numOffice;
	}
	
	/**
	 * @return all the the candidate of the Candidate array
	 */
	public String toString()
	{
		String toString="";
		for (int i =0;i<countCandidate;i++)
		{
			toString=toString+candidate[i]+"\n";
		}
		return toString;
	}
	
	/**
	 * 
	 * @param A candidate
	 * @return if the candidate enter is already in the array
	 */
	public boolean hasCandidate(Candidate o)
	{
		boolean sameCandidate=false;
		for (int i =0;i<countCandidate;i++)
		{
			sameCandidate=o.Equal(candidate[i]);
		}
		return sameCandidate;
	}
	
	/**
	 * compare the siwe and the length of the candidate array
	 * @return if the Candidate array is full
	 */
	public boolean isCandidateFull()
	{
		if (countCandidate==candidate.length)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * compare the length and the siwe of the office array
	 * @return
	 */
	public boolean isOfficeFull()
	{
		if (numOffice==offices.length)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * prompt for all information about the new candidate 
	 * verify the candidate is not already in the array
	 * call the other addCandidate methode
	 * @param scan
	 */
	public void addCandidate(Scanner scan)
	{
		
		System.out.print("Enter the first name: ");
		String first=scan.nextLine();
		System.out.print("Enter the last name: ");
		String last = scan.nextLine();
		System.out.print("Enter the candidate's office: ");
		String office = scan.nextLine();
		System.out.print("Enter the candidate's party: ");
		String party = scan.nextLine();
		Candidate newCan = new Candidate (first,last,office,party);
		
		if (hasCandidate(newCan))
		{
			System.out.println("Candidate already on ballot.");
		}
		else
		{
			addCandidate(newCan);
		}
		
	}
	
	/**
	 * verify if the candidate array is not full add the candidate and if it's the case a new office
	 * @param Candidate create in the previous addCandidate method
	 */
	private void addCandidate( Candidate o)
	{
		if (isCandidateFull())
		{
			resizeCandidate();
		}
		Candidate newCandidate = new Candidate(o);
		candidate[countCandidate]=newCandidate;
		countCandidate++;
		
		boolean hasOffice=false;
		for (int i =0; i<offices.length;i++)
		{
			if (o.getRunOffice().equalsIgnoreCase(offices[i]))
			{
				hasOffice=true;
			}
		}
		if (!hasOffice)
		{
			if (isOfficeFull())
			{
				resizeOffice();
			}
			offices[numOffice]=o.getRunOffice();
			numOffice++;
		}
	}
	
	/**
	 * resize the candidate array by extending the length with 3 more slot
	 */
	public void resizeCandidate()
	{
		Candidate [] temp=new Candidate[candidate.length+BLOCK_SIZE];
		for (int i =0;i<candidate.length;i++)
		{
			temp[i]=candidate[i];
		}
		candidate=temp;
		temp=null;
	}
	
	/**
	 * resize the office array by extending the length with 3 more slot
	 */
	public void resizeOffice()
	{
		String [] temp=new String [numOffice+BLOCK_SIZE];
		for (int i=0;i<offices.length;i++)
		{
			temp[i]=offices[i];
		}
		offices=temp;
		temp=null;
	}
	
	/**
	 * Add vote to each candidate by the input interger
	 * @param scan
	 */
	public void addVote(Scanner scan)
	{
		
		for (int i =0;i<countCandidate;i++)
		{
			System.out.print("Enter new votes for "+candidate[i].getFirst()+" "+candidate[i].getLast()+": ");
			candidate[i].setTotVote(scan.nextInt());
		}
		
	}
	
	/**
	 * determine the winner by calling the createCandidateListByOffice which will call
	 * the findHighestvote method 
	 * @param scan
	 */
	public void determinWinner(Scanner scan)
	{
		
		System.out.println("Choose an office:");
		int count =1;
		for (int i=0; i<numOffice;i++)
		{
			System.out.println(count+"- "+offices[i]);
			count++;
		}
		int n = scan.nextInt();
		createCandidateListByOffice(n);
		
		
	}
	
	/**
	 * will receive the indicator number of the office chosen to create a list of candidate who only 
	 * run for the chosen office and then call the FindHighestVote method 
	 * @param n, the indicator number of the choosen office
	 */
	private void createCandidateListByOffice(int n)
	{
		Candidate [] temp = new Candidate [countCandidate];
		int numCandidate=0;
		for (int i =0;i<countCandidate;i++)
		{
			if (candidate[i].getRunOffice().equalsIgnoreCase(offices[n-1]))
			{
				temp[numCandidate]=candidate [i];
				numCandidate++;				
			}
		}
		Candidate[]temp2=new Candidate[numCandidate];
		for (int j =0; j<numCandidate;j++)
		{
			temp2[j]=temp[j];
			System.out.println(temp2[j].toString());
		}
				
		findHighestVotes(temp2);
	}
	
	/**
	 * If there is only one candidate running for that office, then the candidate must have at least one vote to win. 
	 * If there is more than one candidate, then it will search the temp array for the most votes for that office. 
	 * Set the boolean won value for the winning candidate to true.
	 * If the scores are equal, then there is no winner.

	 * @param temp
	 */
	private void findHighestVotes(Candidate [] temp)
	{
		if (temp.length==1)
		{
			if(temp[0].getTotVote()>=1)
			{
				temp[0].setWon(true);
				System.out.println("The winner is: "+temp[0].getFirst()+" "+temp[0].getLast());
			}
			else if (temp[0].getTotVote()==0)
			{
				System.out.println("Candidate has no votes. Winner cannot be determined.");
			}
			
			
		}
		else if (temp.length>1)
		{
			int highest=0;
			for (int i =0;i<temp.length;i++)
			{
				if (temp[i].getTotVote()>highest)
				{
					highest=temp[i].getTotVote();
				}
			}
			if (highest==0)
			{
				System.out.println("Candidates has no votes. Winner cannot be determined.");
			}
			else
			{
				int count = 0;
				for (int j=0;j<temp.length;j++)
				{
					if (temp[j].getTotVote()==highest)
					{
						count++;
					}
				}
				if (count >1)
				{
					System.out.println("It is a tie. No winner can be determined.");
				}
				else if (count==1)
				{
					for (int g=0;g<temp.length;g++)
					{
						if (temp[g].getTotVote()==highest)
						{
							System.out.println("The winner is: "+temp[g].getFirst()+" "+temp[g].getLast());
							temp[g].setWon(true);
						}
					}
				}
			
			}
		
		
		
		}
	}
	
	/**
	 * display all the Candidate who has a true value for win
	 */
	public void displayWinner()
	{
		System.out.println("The winners are: ");
		for (int i =0;i<countCandidate;i++)
		{
			if (candidate[i].getWon())
			{
				System.out.println(candidate[i].toString());
			}
		}
	}
	
}
