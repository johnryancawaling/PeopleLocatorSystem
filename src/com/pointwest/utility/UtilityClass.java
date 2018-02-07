package com.pointwest.utility;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.pointwest.manager.HomePageManager;

public class UtilityClass {
	Scanner MyScanner = new Scanner(System.in);
	Logger logger = Logger.getLogger(HomePageManager.class);

	public int scanAndValidateIntInput(int maxChoice) {
		logger.info("START");
		
		int number;
		boolean isInputGood = false;
		
		logger.info("Variable maxChoice = " + maxChoice);

		do {
			while (!MyScanner.hasNextInt()) {
				System.out.print("Please enter a number from 1-" + maxChoice + " only. Enter Choice again:");
				MyScanner.next();
			}
			number = MyScanner.nextInt();
			if (number >= 1 && number <= maxChoice) {
				logger.info("number to return: " + maxChoice);
				logger.info("END");
				return number;
			}
			System.out.print("Please enter a number from 1-" + maxChoice + " only. Enter Choice again:");
		} while (!isInputGood);
		logger.info("Return number [" + number + "]");
		return number;

	}

}
