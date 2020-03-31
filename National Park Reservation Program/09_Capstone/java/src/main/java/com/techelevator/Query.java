package com.techelevator;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Query {

	
	
	
	public Query () {
		
	}
	
	public static String ask (String userPrompt){
		Scanner input = new Scanner (System.in);
		String userResponse = new String();
		
		try {
		System.out.println(userPrompt);
		userResponse = input.nextLine();
		return userResponse;
		}
		catch (NoSuchElementException e) {
			System.out.println("Failed due to NoSuchElementException.");
		}
		return userResponse;
	}
	
	public static int askInt (String userPrompt) {
		int userInt = 0;
		Scanner input = new Scanner (System.in);
		System.out.println(userPrompt);
		String userResponse =input.nextLine();
		try
		{
			userInt = Integer.parseInt(userResponse);
		}
		catch (NumberFormatException e) {
			System.out.println("Response must be an integer. Please try again.");
			askInt(userPrompt);
		}
		catch (Exception e) { 
			System.out.println(e.fillInStackTrace());
		}
				
		
		return userInt;
	}
	public static double askDouble (String userPrompt) {
		double userDouble = 0;
		Scanner input = new Scanner (System.in);
		System.out.println(userPrompt);
		String userResponse =input.nextLine();
		try
		{
			userDouble = Double.parseDouble(userResponse);
		}
		catch (NumberFormatException e) {
			System.out.println("Response must be a decimal number. Please try again.");
			askInt(userPrompt);
		}
		catch (Exception e) { 
			System.out.println("Aborting due to catastrophic failure. Please panic. ERR Code: 0-CRAP");
			System.exit(0);
		}
				
		
		return userDouble;
	}
	
	
	public static String askValid (String userPrompt, String[] validResponses) {
		Scanner input = new Scanner (System.in);
		System.out.println(userPrompt);
		String userResponse =input.nextLine();
		try { boolean valid=false;
			for (String validResponse : validResponses) {
				if( userResponse.equals(validResponse)) {
					valid=true;
				}}
			if (!valid) {
				System.out.println("Invalid respose. Please try again.");
				askValid(userPrompt, validResponses);
			}
			
			}
		catch (Exception e) {
			System.out.println("Aborting due to catastrophic failure. Please panic. ERR Code: 0-CRAP");
			System.exit(0);
		}
		
		
		return userResponse;
	}
		public static LocalDate askDate (String userPrompt){
			Scanner input = new Scanner (System.in);
			String userResponse = new String();
			LocalDate userResponseParsed = LocalDate.now();
			while (true) {
				
						
			try {
			System.out.println(userPrompt);
			userResponse = input.nextLine();
			userResponseParsed = LocalDate.parse(userResponse);
						}
			catch (NoSuchElementException e) {
				System.out.println("Failed due to NoSuchElementException.");
			}
			catch (Exception e) {
				System.out.println("Invalid Entry: Please try again;");
				
			}
			return userResponseParsed;
		}}
	}
