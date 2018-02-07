package com.pointwest.manager;

import java.util.List;

import org.apache.log4j.Logger;

import com.pointwest.beans.UsersBean;
import com.pointwest.dao.PLSDAO;
import com.pointwest.ui.HomePageUI;
import com.pointwest.ui.WelcomeAndLoginUI;
import com.pointwest.utility.ExceptionsClass;

public class WelcomeAndLoginPageManager {
	PLSDAO plsDAO = new PLSDAO();
	Logger logger = Logger.getLogger(WelcomeAndLoginPageManager.class);

	public void pressEnterKeyToContinue() {
		// System.out.println("Press Enter key to continue...");
		try {
			System.in.read();
		} catch (Exception e) {
		}
	}

	public void processLoginPage(String username, String password) throws ExceptionsClass {
		logger.info("START");
		List<UsersBean> usersRecords = plsDAO.getAllUsersRecList();
		WelcomeAndLoginUI welcomeAndLoginUI = new WelcomeAndLoginUI();
		HomePageUI homePageUI = new HomePageUI();
		for (UsersBean userRec : usersRecords) {
			if ((userRec.getUser_username().equals(username) && (userRec.getUser_password().equals(password)))) {
				logger.info("Comparing inputted Username/Password to database: SUCCESSFUL");
				System.out.println("----------Login Successful!----------");
				homePageUI.displayPLSHomePage(userRec);
				return;
			}

			logger.info("Comparing inputted Username/Password to database: FAILED");
		}
		UsersBean.numOfLoginAttemptsCounter++;
		System.out.println("Login failed!");
		logger.info("Login failed!");
		logger.info("Attempt(s): " + UsersBean.numOfLoginAttemptsCounter + "/3");
		System.out.println("Attempt(s): " + UsersBean.numOfLoginAttemptsCounter + "/3");

		if (UsersBean.numOfLoginAttemptsCounter >= 3) {
			welcomeAndLoginUI.displayLoginFailedEndProgram();
		}
		welcomeAndLoginUI.displayLoginPage();
		logger.info("END");
	}

}
