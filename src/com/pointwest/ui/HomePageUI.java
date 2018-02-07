package com.pointwest.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.pointwest.beans.UsersBean;
import com.pointwest.manager.HomePageManager;
import com.pointwest.utility.UtilityClass;

public class HomePageUI {
	Logger logger = Logger.getLogger(HomePageUI.class);
	HomePageManager homePageManager = new HomePageManager();
	UtilityClass utilityClass = new UtilityClass();
	Scanner MyScanner = new Scanner(System.in);

	public UsersBean displayPLSHomePage(UsersBean userRec) {
		logger.info("START");
		System.out.println("#####################################");
		System.out.println("-------------###HOME###--------------");
		System.out.println("Welcome " + userRec.getUser_firstName() + " " + userRec.getUser_lastName() + " ["
				+ userRec.getUser_role() + "]!");
		System.out.println("-------------------------------------");
		System.out.println("MENU:--------------------------------");
		System.out.println("[1] Search---------------------------");
		System.out.println("[2] View Seatplan--------------------");
		System.out.println("[3] Logout---------------------------");
		System.out.print("--> Enter Choice: ");
		int in_mainMenuOption;
		logger.info("Calling method: utilityClass.scanAndValidateIntInput(3)");
		in_mainMenuOption = utilityClass.scanAndValidateIntInput(3);
		
		System.out.println("#####################################");
		logger.info("Calling method: homePageManager.processMainMenuOption(userRec, in_mainMenuOption)");
		logger.info("END");
		homePageManager.processMainMenuOption(userRec, in_mainMenuOption);

		return userRec;
	}
	

	public void displayLogout() {
		System.out.println("#####################################");
		System.out.println("-------------------------------------");
		System.out.println("----Goodbye! Thank you for using-----");
		System.out.println("--Pointwest's People Locator System--");
		System.out.println("----------------(END)----------------");
		System.out.println("-------------------------------------");
		System.out.println("#####################################");
		MyScanner.close();
		System.exit(0);
	}

}
