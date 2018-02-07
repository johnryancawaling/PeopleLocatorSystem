package com.pointwest.manager;

import org.apache.log4j.Logger;

import com.pointwest.beans.UsersBean;
import com.pointwest.ui.HomePageUI;
import com.pointwest.ui.SearchPageUI;
import com.pointwest.ui.ViewSeatPlanPageUI;

public class HomePageManager {
	Logger logger = Logger.getLogger(HomePageManager.class);


	public void processMainMenuOption(UsersBean userRec, int in_mainMenuOption) {
		logger.info("START");
		logger.info("variable in_mainMenuOption: " + in_mainMenuOption);
		
		logger.info("Process user's option in main menu");
		try {
		HomePageUI homePageUI = new HomePageUI();
		SearchPageUI searchPageUI = new SearchPageUI();
		ViewSeatPlanPageUI viewSeatPlanPageUI = new ViewSeatPlanPageUI();
		
		
		switch (in_mainMenuOption) {
		case 1:
			logger.info("Calling method searchPageUI.displaySearchPage()");
			logger.info("END");
			searchPageUI.displaySearchPage(userRec);
			break;
		case 2:
			logger.info("Calling method viewSeatPlanPageUI.displayViewSeatplanMenu(userRec)");
			logger.info("END");
			viewSeatPlanPageUI.displayViewSeatplanMenu(userRec);
			break;
		case 3:
			logger.info("Calling method homePageUI.displayLogout()");
			logger.info("END");
			homePageUI.displayLogout();
			break;
		}
		}catch(Exception e) {
			logger.error("-=Error encountered=-");
			logger.error(e.getMessage());
		}
		
	}

}
