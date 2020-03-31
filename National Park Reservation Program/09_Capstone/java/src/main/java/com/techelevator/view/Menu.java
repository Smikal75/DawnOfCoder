package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import com.techelevator.CampgroundCLI;

public class Menu {

private PrintWriter out;
private Scanner in;

public Menu(InputStream input, OutputStream output) {
    this.out = new PrintWriter(output);
    this.in = new Scanner(input);
}

public Object getChoiceFromOptions(Object[] options) {
    Object choice = null;
    while(choice == null) {
        displayMenuOptions(options);
        choice = getChoiceFromUserInput(options);
    }
    return choice;
}

private Object getChoiceFromUserInput(Object[] options) {
    Object choice = null;
    String userInput = in.nextLine();
    try {
    	  if (userInput.toUpperCase().equals("Q") )
  		{System.out.println("Thank You for using the NPCRS! Exiting Program");
		  System.exit(0);}
    	  if (userInput.toUpperCase().equals("R")) {
    		System.out.println("Returning to Start!");
    			  }
        int selectedOption = Integer.valueOf(userInput);
         if (selectedOption <= options.length) {
            choice = options[selectedOption - 1];
        }
    } catch(NumberFormatException e) {
        // eat the exception, an error message will be displayed below since choice will be null
    }
    if(choice == null) {
        out.println("\n*** "+userInput+" is not a valid option ***\n");
    }
    return choice;
}

private void displayMenuOptions(Object[] options) {
    out.println();
    for(int i = 0; i < options.length; i++) {
        int optionNum = i+1;
        out.println(optionNum+") "+options[i].toString());
    }
    out.print("\nPlease choose an option >>> ");
    out.flush();
}
}
