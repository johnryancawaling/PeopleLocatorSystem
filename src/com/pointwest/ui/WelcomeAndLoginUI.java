package com.pointwest.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.pointwest.manager.WelcomeAndLoginPageManager;
import com.pointwest.utility.ExceptionsClass;

public class WelcomeAndLoginUI {
	Logger logger = Logger.getLogger(WelcomeAndLoginUI.class);
	WelcomeAndLoginPageManager welcomeAndLoginPageManager = new WelcomeAndLoginPageManager();
	Scanner MyScanner = new Scanner(System.in);

	public void displayWelcomePage() {
		logger.info("======================================================================");
		logger.info("START OF PROGRAM");
		System.out.println("#####################################");
		System.out.println("-------------------------------------");
		System.out.println("-------------Welcome to--------------");
		System.out.println("--Pointwest's People Locator System--");
		System.out.println("-------------------------------------");
		System.out.println("---(Press [ENTER] key to continue)---");
		System.out.println("-------------------------------------");
		System.out.println("#####################################");
		logger.info("Calling method: welcomeAndLoginPageManager.pressEnterKeyToContinue()");
		welcomeAndLoginPageManager.pressEnterKeyToContinue();
		logger.info("END");
	}

	public void displayLoginPage() {
		logger.info("START");
		System.out.println("#####################################");
		System.out.println("-------------------------------------");
		System.out.println("-------------Login Page--------------");
		System.out.print("| Username: ");
		logger.info("Scanning username");
		String inUsername = MyScanner.next();
		System.out.print("| Password: ");
		logger.info("Variable inUsername = " + inUsername);
		logger.info("Scanning password");
		String inPassword = MyScanner.next();
		logger.info("Variable inPassword = " + inPassword);
		System.out.println("-------------------------------------");
		System.out.println("#####################################");
		logger.info("Calling method: welcomeAndLoginPageManager.processLoginPage(inUsername, inPassword)");
		logger.info("END");
		try {
			welcomeAndLoginPageManager.processLoginPage(inUsername, inPassword);
		} catch (ExceptionsClass e) {
			// TODO Auto-generated catch block
			logger.error(e);
			System.out.println(e);
			e.printStackTrace();
		}

	}

	public void displayLoginFailedEndProgram() {
		logger.info("START");
		System.out.println("#####################################");
		System.out.println("-------------------------------------");
		System.out.println("-Number of Login attempts exceeeded--");
		System.out.println("--Pointwest's People Locator System--");
		System.out.println("---------------(END)-----------------");
		System.out.println("-------------------------------------");
		System.out.println("#####################################");
		MyScanner.close();
		logger.info("END OF PROGRAM");
		System.exit(0);
	}

}
