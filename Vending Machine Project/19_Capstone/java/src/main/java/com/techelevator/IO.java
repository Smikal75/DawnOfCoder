package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class IO {

	/// This class contains all Input and Output functions for the program

// IO.initialize reads from a file to generate the starting inventory of the vendingMachine	
	public static Scanner initialize() {

		File file = new File("vendingmachine.csv");

		Scanner fileInput = null;
		try {
			fileInput = new Scanner(file);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		System.out.println("Initializing system.");
		return fileInput;
	}

	public static Map<String, Items> createInventory() {
		Map<String, Items> inventory = new LinkedHashMap<>();
		Scanner fileInput = IO.initialize();
		while (fileInput.hasNextLine()) {

			// sample data : A1|Potato Crisps|3.05|Chip
			String vendingData = fileInput.nextLine();
			// System.out.println(vendingData);

			String[] parseData = vendingData.split("\\|");
			// System.out.println(parseData[0]+ " "+ parseData[1] + " " + parseData[2] + " "
			// +parseData[3]);
			if (parseData[3].equals("Gum")) {

				Items item = new Gum(BigDecimal.valueOf(Double.parseDouble(parseData[2])), parseData[1], parseData[0]);
				inventory.put(parseData[0], item);
			} else if (parseData[3].equals("Chip")) {

				Items item = new Chip(BigDecimal.valueOf(Double.parseDouble(parseData[2])), parseData[1], parseData[0]);
				inventory.put(parseData[0], item);
			} else if (parseData[3].equals("Drink")) {
				Items item = new Drink(BigDecimal.valueOf(Double.parseDouble(parseData[2])), parseData[1],
						parseData[0]);
				inventory.put(parseData[0], item);
			} else if (parseData[3].equals("Candy")) {
				Items item = new Candy(BigDecimal.valueOf(Double.parseDouble(parseData[2])), parseData[1],
						parseData[0]);
				inventory.put(parseData[0], item);
			} else {
				System.out.println("Data Error: please check 'vendingdata.csv' and restart the application.");
				System.exit(0);
			}

		} // end while
		System.out.println("Inventory: OK");
		return inventory;
	}// end initialize

	public static boolean createLog() {

		File logFile = new File("log.txt");
		if (logFile.exists() == false) {
			try {
				logFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("log.txt created");
		}
		FileWriter logFileWrit = null;
		PrintWriter logWriter = null;
		try {
			logFileWrit = new FileWriter("log.txt", true);
			logWriter = new PrintWriter(logFileWrit);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String bootLog = "\n" + IO.timeStamp() + ",BOOT UP, $0.00 , $ 0.00";

		logWriter.append(bootLog);
		logWriter.close();

		return logFile.exists();
	}

	public static String enterToLog(String action, BigDecimal startingBalance, BigDecimal endingBalance) {
		FileWriter logFileWrit = null;
		PrintWriter logWriter = null;
		try {
			logFileWrit = new FileWriter("log.txt", true);
			logWriter = new PrintWriter(logFileWrit);
		} catch (IOException e) {

			e.printStackTrace();
		}
		String bootLog = "\n" + IO.timeStamp() + " , " + action + " , $"
				+ startingBalance.setScale(2, BigDecimal.ROUND_DOWN) + " , $"
				+ endingBalance.setScale(2, BigDecimal.ROUND_DOWN);

		logWriter.append(bootLog);
		logWriter.close();
		return bootLog;
	}

	public static String timeStamp() {
		String yyyy = String.format("%04d", LocalDateTime.now().getYear());
		String mm = String.format("%02d", LocalDateTime.now().getMonthValue());
		String dd = String.format("%02d", LocalDateTime.now().getDayOfMonth());
		String hhmmss = String.format("%8s", LocalTime.now() + "");
		String dateTime = mm + "/" + dd + "/" + yyyy + ", " + hhmmss;
		return dateTime;
	}
	
	public static String salesReport(Map <String, Items> inventory ) {
		String yyyy = String.format("%04d", LocalDateTime.now().getYear());
		String mm = String.format("%02d", LocalDateTime.now().getMonthValue());
		String dd = String.format("%02d", LocalDateTime.now().getDayOfMonth());
		String fileName = "Sales Report " + mm+dd+yyyy + ".txt"; 
		FileWriter reportFW = null;
		PrintWriter reportPW = null;
		File newReport= new File (fileName);
		
		try {
			newReport.createNewFile();
			reportFW = new FileWriter(fileName, true);
			reportPW = new PrintWriter(reportFW);
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		for (String key : inventory.keySet()) {
		String sales = inventory.get(key).getQuantity().equals("SOLD OUT") ? "5" :
			(5 -Integer.valueOf(inventory.get(key).getQuantity()))+"";
		String bootLog = inventory.get(key).getName() +"\\|"+sales +"\n";

		reportPW.append(bootLog);
		}
		reportPW.close();
		
		return fileName;
		}
} /// class boundary
