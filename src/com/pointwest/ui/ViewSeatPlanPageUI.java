package com.pointwest.ui;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.pointwest.beans.EmployeesBean;
import com.pointwest.beans.UsersBean;
import com.pointwest.manager.ViewSeatPlanPageManager;
import com.pointwest.utility.ExceptionsClass;
import com.pointwest.utility.UtilityClass;

public class ViewSeatPlanPageUI {
	Scanner MyScanner = new Scanner(System.in);
	ViewSeatPlanPageManager viewSeatPlanPageManager = new ViewSeatPlanPageManager();
	UtilityClass utilityClass = new UtilityClass();
	Logger logger = Logger.getLogger(ViewSeatPlanPageUI.class);

	public void displayViewSeatplanMenu(UsersBean userRec) {

		logger.info("START");
		System.out.println("#####################################");
		System.out.println("------###VIEW SEAT PLAN PAGE###------");
		System.out.println("MENU:--------------------------------");
		System.out.println("[1] By Location----------------------");
		System.out.println("[2] By Quadrant----------------------");
		System.out.println("[3] Go back to Home Page-------------");
		System.out.print("--> Enter Choice: ");
		logger.info("Calling method: utilityClass.scanAndValidateIntInput(4)");
		int in_viewSeatPlanPageMenuOption = utilityClass.scanAndValidateIntInput(4);
		System.out.println("#####################################");
		logger.info("variable in_viewSeatPlanPageMenuOption = " + in_viewSeatPlanPageMenuOption);
		logger.info(
				"Calling method: viewSeatPlanPageManager.processViewSeaPlanPageMenuOption(userRec, in_viewSeatPlanPageMenuOption)");
		logger.info("END");
		viewSeatPlanPageManager.processViewSeaPlanPageMenuOption(userRec, in_viewSeatPlanPageMenuOption);

	}

	public void displayViewSeatPlanByLocation(UsersBean userRec) {
		logger.info("START");
		System.out.println("#####################################");
		System.out.println("--##VIEW SEAT PLAN - By Location##---");
		System.out.println("-------------------------------------");
		System.out.print("| Enter Location: ");
		logger.info("Scanning Location to search");
		String in_location = MyScanner.next();
		System.out.print("| Enter Floor Level: ");
		logger.info("Scanning Floor to search");
		logger.info("Calling method: utilityClass.scanAndValidateIntInput(12)");
		int in_floorLevel = utilityClass.scanAndValidateIntInput(12);
		logger.info("variable in_floorLevel = " + in_floorLevel);
		System.out.println("#####################################");
		logger.info(
				"Calling method: viewSeatPlanPageManager.processViewSeatPlanByLocation(userRec, in_location, in_floorLevel)");
		logger.info("END");
		try {
			viewSeatPlanPageManager.processViewSeatPlanByLocation(userRec, in_location, in_floorLevel);
		} catch (ExceptionsClass e) {
			// TODO Auto-generated catch block
			logger.error(e);
			System.out.println(e);
			e.printStackTrace();
		}

	}

	public void displayViewSeatPlanByQuadrant(UsersBean userRec) {
		logger.info("START");
		System.out.println("#####################################");
		System.out.println("--##VIEW SEAT PLAN - By Quadrant##---");
		System.out.println("-------------------------------------");
		System.out.print("| Enter Location: ");
		logger.info("Scanning Location to search");
		String in_location = MyScanner.next();
		System.out.print("| Enter Floor Level: ");
		logger.info("Scanning Floor to search");
		int in_floorLevel = utilityClass.scanAndValidateIntInput(12);
		System.out.print("| Enter Quadrant: ");
		char in_quadrant = MyScanner.next(".").charAt(0);
		System.out.println("#####################################");
		logger.info(
				"Calling method: viewSeatPlanPageManager.processViewSeatPlanByQuadrant(userRec, in_location, in_floorLevel, in_quadrant)");
		logger.info("END");
		try {
			viewSeatPlanPageManager.processViewSeatPlanByQuadrant(userRec, in_location, in_floorLevel, in_quadrant);
		} catch (ExceptionsClass e) {
			// TODO Auto-generated catch block
			logger.error(e);
			System.out.println(e);
			e.printStackTrace();
		}

	}

	public void displayViewSeatPlanResult(UsersBean userRec, List<EmployeesBean> searchedEmpInfoLocRecords) {
		logger.info("START");
		System.out.println("#####################################");
		System.out.println("--##VIEW SEAT PLAN - Result Page##---");
		
		if (searchedEmpInfoLocRecords.size() != 0) {
		String locationDBValue = searchedEmpInfoLocRecords.get(0).getEmp_location();
		String locationString = locationDBValue.substring(0, Math.min(locationDBValue.length(), 3));
		String city = searchedEmpInfoLocRecords.get(0).getEmp_bldgAddress();
		String floorDBValue = searchedEmpInfoLocRecords.get(0).getEmp_location();
		char a_floor = floorDBValue.charAt(3);
		char b_floor = floorDBValue.charAt(4);
		String floorString = a_floor + "" + "" + b_floor;

		
		System.out.println("Location: " + locationString + "[" + city + "], FLOOR: " + floorString);
		System.out.println("-------------------------------------");

		
			for (EmployeesBean employeeRec : searchedEmpInfoLocRecords) {
				System.out.print(employeeRec.getEmp_location());
				System.out.print("\n");
				System.out.print(employeeRec.getEmp_firstName());
				System.out.print(" ");
				System.out.print(employeeRec.getEmp_lastName());
				System.out.print("\n");
				if (employeeRec.getEmp_localNumber() == 0) {
					System.out.print("N/A");
				} else {
					System.out.print(employeeRec.getEmp_localNumber());

				}
				System.out.println("\n");

			}
		}
		System.out.println("------------end of result------------");
		System.out.println("Actions: [1] Search Again [2] Home --");
		System.out.print("--> Enter Choice: ");
		int in_viewSeatPlanResult = utilityClass.scanAndValidateIntInput(2);
		logger.info("Variable in_viewSeatPlanResult = " + in_viewSeatPlanResult);
		System.out.println("#####################################");
		logger.info("END");
		logger.info(
				"Calling method: viewSeatPlanPageManager.processViewSeatPlanResult(userRec, in_viewSeatPlanResult)");
		viewSeatPlanPageManager.processViewSeatPlanResult(userRec, in_viewSeatPlanResult);

	}
}
