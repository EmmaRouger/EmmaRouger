/*
 * File name: Candidates.java
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

/**
 * <initiate the information of a candidate>
 *
 * @author Emma ROUGER
 *
 */
public class Candidate
{
	private String first;
	private String last;
	private String runOffice;
	private String party;
	private int totVote=0;
	private boolean won;
	
	/**
	 * Constructor
	 * @param first
	 * @param last
	 * @param runOffice
	 * @param party
	 */
	public Candidate (String first, String last, String runOffice, String party)
	{
		this.first=first;
		this.last=last;
		this.runOffice=runOffice;
		this.party=party;
	}
	
	/**
	 * Constructor
	 * @param candidate
	 */
	public Candidate (Candidate candidate)
	{
		this.first=candidate.getFirst();
		this.last=candidate.getLast();
		this.party=candidate.getParty();
		this.runOffice=candidate.getRunOffice();		
	}

	/**
	 * @return the totVote
	 */
	public int getTotVote()
	{
		return totVote;
	}

	/**
	 * add the given integer to the previous value of totVote
	 * @param Vote 
	 * 		set the totVote
	 */
	public void setTotVote(int Vote)
	{
		this.totVote=totVote+Vote;
	}

	/**
	 * @return the won
	 */
	public boolean isWon()
	{
		return won;
	}

	/**
	 * @param won the won to set
	 */
	public void setWon(boolean won)
	{
		this.won = won;
	}

	/**
	 * @return the first
	 */
	public String getFirst()
	{
		return first;
	}

	/**
	 * @return the last
	 */
	public String getLast()
	{
		return last;
	}

	/**
	 * @return the runOffice
	 */
	public String getRunOffice()
	{
		return runOffice;
	}

	/**
	 * @return the party
	 */
	public String getParty()
	{
		return party;
	}
	
	/**
	 * @return the won
	 */
	public boolean getWon()
	{
		return won;
	}
	
	/**
	 * determine if the Candidate entered is the same as the Candidate  
	 * @param candidate
	 * @return the result
	 */
	public boolean Equal(Candidate candidate)
	{
		if (first.equalsIgnoreCase(candidate.getFirst()))
		{
			if (last.equalsIgnoreCase(candidate.getLast()))
			{
				if (party.equalsIgnoreCase(candidate.getParty()))
				{
					return true;
				}
				
			}
			
		}
		return false;
	}
	
	/**
	 * @return the toString
	 */
	public String toString()
	{
		return "Candidate: "+first+" "+last
				+"\nOffice: "+runOffice
				+"\nCandidateParty: "+party
				+"\nTotal Votes: "+totVote
				+"\n************************";
	}
}
