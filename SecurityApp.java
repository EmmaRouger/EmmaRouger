/*
 * File name: SecurityApp.java
 *
 * Programmer: Emma ROUGER
 * ULID: erouger 
 * 
 * Date: Oct 13, 2019
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
 * <will develop a simple tool that helps users generate strong passwords, 
 * encrypt and decrypt data using some cyphering techniques>
 *
 * @author Emma ROUGER
 *
 */
public class SecurityApp
{
	static Scanner scan = new Scanner(System.in);
	
	/**
	 * Initiate the program, manage the flow of execution
	 * @param args
	 */
	public static void main(String[] args)
	{
		//prompt the mqin menu, following the the result it will generate the password, encrypt or decrypt a phrase.
		int chose=mainMenu();
		switch (chose)
		{
		case 1:
			passwordSelected();
			break;
		case 2:
			encryptionSelected();
			break;
		case 3:
			decryptionSelected();
			break;
		default:
		}
		
	}
	/*
	 * Display a welcome message and a list of the available tools
	 * Prompt the user to select a tool
	 */
	public static int mainMenu()
	{
		//
		String welcome="------------------------------------------------\n" + 
				"Thank you for choosing the IT-168 Security tool!\r\n" + 
				"------------------------------------------------\n" + 
				"Please select a tool from the options below:\n" + 
				"1. Password Generator\n" + 
				"2. Encryption Tool\n" + 
				"3. Decryption Tool";
		System.out.println(welcome);
		System.out.print("Your Selection(1,2,3)>");
		int chose = scan.nextInt();
		scan.nextLine();
		return chose;
	}
	
	/*
	 * It will prompt the user to enter a phrase 
	 * Once we get that phrase, we will generate the strong password
	 */
	public static void passwordSelected()
	{
		//ask for the phrase
		System.out.print("Please Enter a phrase that is at least 8 characters long>");
		String phrase = scan.nextLine();
		int length = phrase.length();
		//verify the length is at least 8 caracters
		while (length<8)
		{
			System.out.println("The phrase must be at least 8 characters long!");
			System.out.print("Please Enter a phrase that is at least 8 characters long>");
			phrase=scan.nextLine();
			length=phrase.length();
		}
		//generate the password
		Security.generatePassword(phrase);
	}
	
	/*
	 * It will prompt the user to select the encryption type(Caesar or vigener)
	 * It will ask the user to enter the phrase we need to encrypt
	 * It will encrypt the phrase
	 */
	public static void encryptionSelected()
	{
		//ask for which encryption
		String selectionMenu="Please select the type of Encryption from the options below:\n" + 
				"1. Caeser Encryption\n" + 
				"2. Vigener Encryption";

		System.out.println(selectionMenu);
		System.out.print ("Your Selection(1,2)> ");
		int chose2=scan.nextInt();
		scan.nextLine();
		//promt the phrase and the key then generate the encryption
		if (chose2!=1&&chose2!=2)
		{
			System.out.println("Incorrect outputm please select for 1 or 2.");
			System.out.print ("Your Selection(1,2)> ");
			chose2=scan.nextInt();
			scan.nextLine();
		}
		if (chose2==1)
		{
			System.out.print("Please Enter the phrase you want to encrypt>");
			String phrase2=scan.nextLine();
			System.out.print("Please Enter the key you want to use for encryption>");
			int key1=scan.nextInt();
			scan.nextLine();
			Security.caesarEncrypt(phrase2, key1);
		}
		else if (chose2==2)
		{
			System.out.print("Please Enter the phrase you want to encrypt>");
			String phrase3=scan.nextLine();
			System.out.print("Please Enter the key you want to use for encryption>");
			String key2=scan.nextLine();
			Security.vigenerEncrypt(phrase3, key2);
		}
		
	}
	
	/*
	 * It will prompt the user to select the decryption type(Caesar or vigener).
	 * It will ask the user to enter the phrase we need to decrypt.
	 * It will decrypt the phrase 
	 */
	public static void decryptionSelected()
	{
		//ask for the chosen decryption
		String selectionMenu="Please select the type of Encryption from the options below:\n" + 
				"1. Caeser Decryption\n" + 
				"2. Vigener Decryption";

		System.out.println(selectionMenu);
		System.out.print ("Your Selection(1,2)> ");
		int chose2=scan.nextInt();
		scan.nextLine();
		//prompt for the phrase and the key then generate the decryption
		if (chose2!=1&&chose2!=2)
		{
			System.out.println("Incorrect outputm please select for 1 or 2.");
			System.out.print ("Your Selection(1,2)> ");
			chose2=scan.nextInt();
			scan.nextLine();
		}
		if (chose2==1)
		{
			System.out.print("Please Enter the phrase you want to Decrypt>");
			String phrase2=scan.nextLine();
			System.out.print("Please Enter the key you want to use for decryption>");
			int key1=scan.nextInt();
			scan.nextLine();
			Security.caesarDecrypt(phrase2, key1);
		}
		else if (chose2==2)
		{
			System.out.print("Please Enter the phrase you want to Decrypt>");
			String phrase3=scan.nextLine();
			System.out.print("Please Enter the key you want to use for decryption>");
			String key2=scan.nextLine();
			Security.vigenerDecrypt(phrase3, key2);
		}
	}

}
