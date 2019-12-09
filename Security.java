/*
 * File name: Security.java
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

/**
 * <will develop a simple tool that helps users generate strong passwords, 
 * encrypt and decrypt data using some cyphering techniques>
 *
 * @author Emma ROUGER
 *
 */
public class Security
{
	/*
	 * take a phrase that the person want to put as a password, the method will turn it to a strong password
	 */
	public static void generatePassword(String phrase)
	{
		
		int length = phrase.length();
		
		
		for (int i=0;i<phrase.length();i+=2)
		{
			String replace = phrase.substring(i, i+1);
			replace=replace.toUpperCase();
			
			phrase=phrase.substring(0,i)+replace+phrase.substring(i+1);
		}
		for (int i=1;i<phrase.length();i+=2)
		{
			String replace = phrase.substring(i, i+1);
			replace=replace.toLowerCase();
			
			phrase=phrase.substring(0,i)+replace+phrase.substring(i+1);
		}
		phrase=phrase.replace('s', '$');
		phrase=phrase.replace('S','$');
		phrase=phrase.replace(' ', '_');
		phrase=phrase.replace('o','0');
		phrase=phrase.replace('O', '0');
		phrase=phrase.replace('a', '@');
		phrase=phrase.replace('A', '@');
		phrase=phrase.replace('e', '3');
		phrase=phrase.replace('E', '3');
		if (phrase.contains("@"))
		{
			phrase=phrase+Integer.toString(length);
		}
		else if (phrase.contains("#"))
		{
			phrase=phrase+Integer.toString(length);
		}
		else if (phrase.contains("$"))
		{
			phrase=phrase+Integer.toString(length);
		}
		else if (phrase.contains("%"))
		{
			phrase=phrase+Integer.toString(length);
		}
		else if (phrase.contains("^"))
		{
			phrase=phrase+Integer.toString(length);
		}
		else if (phrase.contains("&"))
		{
			phrase=phrase+Integer.toString(length);
		}
		else if (phrase.contains("*")) 
		{
			phrase=phrase+Integer.toString(length);
		}
		else if (phrase.contains("!"))
		{
			phrase=phrase+Integer.toString(length);
		}
		else 
		{
			phrase=phrase+"!"+Integer.toString(length);
		}
		System.out.println("Your Password is: "+phrase);
			
	}
	/*
	 *  It will take a phrase and an offset and will encrypt the phrase using Caesar cipher encryption method
	 */
	public static void caesarEncrypt(String phrase2,int key1)
	{
		
		phrase2=phrase2.toUpperCase();
		
		String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		for (int i = 0;i<phrase2.length();i++)
		{
			String replace2=phrase2.substring(i,i+1);
			int x = (int)(phrase2.charAt(i));
			int y =(x+key1);
			if (y>90)
			{
				y=(y-26)%65;
			}
			else
			{
				y=y%65;
			}
			replace2=replace2.replace(replace2.charAt(0), alpha.charAt(y));
			phrase2=phrase2.substring(0,i)+replace2+phrase2.substring(i+1);
		}
		System.out.println("Here is your Encrypted phrase: "+phrase2);
		
	}
	/*
	 * It will take a phrase and a key and will encrypt the phrase using Vigenère cipher encryption method
	 */
	public static void vigenerEncrypt(String phrase3,String key2)
	{
		phrase3=phrase3.toUpperCase();
		key2=key2.toUpperCase();
		String replace;
		String key3="";
		String alpha2="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int p =0; p<phrase3.length();p++)
		{
			if (p<key2.length())
			{
				replace=key2.substring(p, p+1);
			}
			else
			{
				replace=key2.substring(p%key2.length(),p%key2.length()+1);
			}
			key3=key3+replace;
			
		}
		for (int m=0;m<phrase3.length();m++)
		{
			String replace2=phrase3.substring(m,m+1);
			int x = (int)(phrase3.charAt(m));
			int y=(int)(key3.charAt(m))-65;
			int z=x+y;
			if (z>90)
			{
				z=(z-26)%65;
			}
			else
			{
				z=z%65;
			}
			replace2=replace2.replace(replace2.charAt(0), alpha2.charAt(z));
			phrase3=phrase3.substring(0,m)+replace2+phrase3.substring(m+1);
		}
		System.out.println("Here is your Encrypted phrase: "+phrase3);
	}
	/*
	 * It will take a phrase and an offset and will decrypt the phrase using Caesar cipher decryption method
	 */
	public static void caesarDecrypt(String phrase4,int key3)
	{
		phrase4=phrase4.toUpperCase();
		
		String alpha3="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		for (int i = 0;i<phrase4.length();i++)
		{
			String replace2=phrase4.substring(i,i+1);
			int x = (int)(phrase4.charAt(i));
			int y =(x-key3);
			if (y<65)
			{
				y=(y+26)%65;
			}
			else
			{
				y=y%65;
			}
			replace2=replace2.replace(replace2.charAt(0), alpha3.charAt(y));
			phrase4=phrase4.substring(0,i)+replace2+phrase4.substring(i+1);
		}
		System.out.println("Here is your Decrypted phrase: "+phrase4);
	}
	/*
	 * It will take a phrase and a key and will decrypt the phrase using Vigenère cipher decryption method
	 */
	public static void vigenerDecrypt(String phrase5,String key4)
	{
		phrase5=phrase5.toUpperCase();
		key4=key4.toUpperCase();
		String replace;
		String key5="";
		String alpha4="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int p =0; p<phrase5.length();p++)
		{
			if (p<key4.length())
			{
				replace=key4.substring(p, p+1);
			}
			else
			{
				replace=key4.substring(p%key4.length(),p%key4.length()+1);
			}
			key5=key5+replace;
			
		}
		for (int m=0;m<phrase5.length();m++)
		{
			String replace2=phrase5.substring(m,m+1);
			int x = (int)(phrase5.charAt(m));
			int y=(int)(key5.charAt(m))-65;
			int z=x-y;
			if (z<65)
			{
				z=(z+26)%65;
			}
			else
			{
				z=z%65;
			}
			replace2=replace2.replace(replace2.charAt(0), alpha4.charAt(z));
			phrase5=phrase5.substring(0,m)+replace2+phrase5.substring(m+1);
		}
		System.out.println("Here is your Decrypted phrase: "+phrase5);
	}
	
}
