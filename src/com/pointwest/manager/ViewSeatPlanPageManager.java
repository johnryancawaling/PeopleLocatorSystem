package com.pointwest.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.pointwest.beans.EmployeesBean;
import com.pointwest.beans.UsersBean;
import com.pointwest.dao.PLSDAO;
import com.pointwest.ui.HomePageUI;
import com.pointwest.ui.ViewSeatPlanPageUI;
import com.pointwest.utility.ExceptionsClass;

public class ViewSeatPlanPageManager {
	Logger logger = Logger.getLogger(ViewSeatPlanPageManager.class);

	public void processViewSeaPlanPageMenuOption(UsersBean userRec, int in_viewSeatPlanPageMenuOption) {
		logger.info("START");
		ViewSeatPlanPageUI viewSeatPlanPageUI = new ViewSeatPlanPageUI();
		HomePageUI homePageUI = new HomePageUI();

		switch (in_viewSeatPlanPageMenuOption) {
		case 1:
			logger.info("Calling method viewSeatPlanPageUI.displayViewSeatPlanByLocation(userRec)");
			logger.info("END");
			viewSeatPlanPageUI.displayViewSeatPlanByLocation(userRec);
			break;
		case 2:
			logger.info("Calling method viewSeatPlanPageUI.displayViewSeatPlanByQuadrant(userRec)");
			logger.info("END");
			viewSeatPlanPageUI.displayViewSeatPlanByQuadrant(userRec);
			break;
		case 3:
			logger.info("Calling method homePageUI.displayPLSHomePage(userRec)");
			logger.info("END");
			homePageUI.displayPLSHomePage(userRec);
			break;
		}

	}

	public void processViewSeatPlanByLocation(UsersBean userRec, String in_location, int in_floorLevel) throws ExceptionsClass {
		logger.info("START");
		ViewSeatPlanPageUI viewSeatPlanPageUI = new ViewSeatPlanPageUI();
		PLSDAO plsDAO = new PLSDAO();
		String stringEmpLocation = null;
		String stringfloorToSearch = new Integer(in_floorLevel).toString();
		String seatLocationToSearch = in_location.toUpperCase() + stringfloorToSearch + "F";

		List<EmployeesBean> employeesInfoLocRecords = plsDAO.getEmployeeInfoLocRecList();
		List<EmployeesBean> searchedEmpInfoLocRecords = new ArrayList<EmployeesBean>();

		for (EmployeesBean employeeRec : employeesInfoLocRecords) {
			
			stringEmpLocation = employeeRec.getEmp_location();
			if (stringEmpLocation.contains(seatLocationToSearch)) {
				logger.info("Adding employeeRec to searchedEmpInfoLocRecords");
				searchedEmpInfoLocRecords.add(employeeRec);
			}
		}

		logger.info("Calling method viewSeatPlanPageUI.displayViewSeatPlanResult(userRec, searchedEmpInfoLocRecords)");
		logger.info("END");
		viewSeatPlanPageUI.displayViewSeatPlanResult(userRec, searchedEmpInfoLocRecords);
	}

	public void processViewSeatPlanByQuadrant(UsersBean userRec, String in_location, int in_floorLevel,
			char in_quadrant) throws ExceptionsClass {
		logger.info("START");
		ViewSeatPlanPageUI viewSeatPlanPageUI = new ViewSeatPlanPageUI();
		PLSDAO plsDAO = new PLSDAO();
		String stringEmpLocation = null;
		String stringfloorToSearch = new Integer(in_floorLevel).toString();
		String seatLocationToSearch = in_location.toUpperCase() + stringfloorToSearch + "F"
				+ Character.toUpperCase(in_quadrant);

		List<EmployeesBean> employeesInfoLocRecords = plsDAO.getEmployeeInfoLocRecList();
		List<EmployeesBean> searchedEmpInfoLocRecords = new ArrayList<EmployeesBean>();

		for (EmployeesBean employeeRec : employeesInfoLocRecords) {
			stringEmpLocation = employeeRec.getEmp_location();
			if (stringEmpLocation.contains(seatLocationToSearch)) {
				searchedEmpInfoLocRecords.add(employeeRec);
				logger.info("Adding employeeRec to searchedEmpInfoLocRecords");
			}
		}

		logger.info("Calling method viewSeatPlanPageUI.displayViewSeatPlanResult(userRec, searchedEmpInfoLocRecords)");
		logger.info("END");
		viewSeatPlanPageUI.displayViewSeatPlanResult(userRec, searchedEmpInfoLocRecords);
	}

	public void processViewSeatPlanResult(UsersBean userRec, int in_viewSeatPlanResult) {
		logger.info("START");
		ViewSeatPlanPageUI viewSeatPlanPageUI = new ViewSeatPlanPageUI();
		HomePageUI homePageUI = new HomePageUI();
		switch (in_viewSeatPlanResult) {
		case 1:
			logger.info("Calling method viewSeatPlanPageUI.displayViewSeatplanMenu(userRec)");
			logger.info("END");
			viewSeatPlanPageUI.displayViewSeatplanMenu(userRec);
			break;
		case 2:
			logger.info("Calling method homePageUI.displayPLSHomePage(userRec)");
			logger.info("END");
			homePageUI.displayPLSHomePage(userRec);
			break;
		}
	}

}
