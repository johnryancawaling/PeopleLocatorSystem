package com.pointwest.ui;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.pointwest.beans.EmployeesBean;
import com.pointwest.beans.UsersBean;
import com.pointwest.manager.SearchPageManager;
import com.pointwest.utility.ConstantsClass;
import com.pointwest.utility.ExceptionsClass;
import com.pointwest.utility.UtilityClass;

public class SearchPageUI {
	Logger logger = Logger.getLogger(SearchPageUI.class);
	Scanner MyScanner = new Scanner(System.in);
	SearchPageManager searchPageManager = new SearchPageManager();
	UtilityClass utilityClass = new UtilityClass();

	public void displaySearchPage(UsersBean userRec) {
		logger.info("START");
		System.out.println("#####################################");
		System.out.println("----------###SEARCH PAGE###----------");
		System.out.println("MENU:--------------------------------");
		System.out.println("[1] By Employee ID-------------------");
		System.out.println("[2] By Name--------------------------");
		System.out.println("[3] By Project-----------------------");
		System.out.println("[4] Go back to Home Page-------------");
		System.out.print("--> Enter Choice: ");
		logger.info("Calling method: utilityClass.scanAndValidateIntInput(4)");
		int in_searchPageOption = utilityClass.scanAndValidateIntInput(4);
		System.out.println("#####################################");
		logger.info("variable in_searchPageOption = " + in_searchPageOption);
		
		try {
			searchPageManager.processSearchPageOption(userRec, in_searchPageOption);
			logger.info("Calling method: searchPageManager.processSearchPageOption(userRec, in_searchPageOption)");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e);
			System.out.println(e);
			e.printStackTrace();
		}
	}

	public void displaySearchByEmployeeID(UsersBean userRec) {
		logger.info("START");
		System.out.println("#####################################");
		System.out.println("-----###SEARCH - By Employe ID###----");
		System.out.print("Enter Choice Employee ID: ");
		logger.info("Calling method: utilityClass.scanAndValidateIntInput(" + ConstantsClass.MAX_POSSIBLE_EMP_ID + ")");
		int in_empIDToSearch = utilityClass.scanAndValidateIntInput(ConstantsClass.MAX_POSSIBLE_EMP_ID);
		logger.info("variable in_empIDToSearch = " + in_empIDToSearch);
		System.out.println("#####################################");
		logger.info("Calling method: searchPageManager.searchByEmployeeID(userRec, in_empIDToSearch)");
		logger.info("END");
		try {
			searchPageManager.searchByEmployeeID(userRec, in_empIDToSearch);
		} catch (ExceptionsClass e) {
			// TODO Auto-generated catch block
			logger.error(e);
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	public void displaySearchByEmployeeName(UsersBean userRec) {
		logger.info("START");
		System.out.println("#####################################");
		System.out.println("-----###SEARCH - By Employe Name###----");
		System.out.print("Enter Employee Name: ");
		logger.info("Scanning Employee Name to search");
		String in_empNameToSearch = MyScanner.next();
		System.out.println("#####################################");
		logger.info("variable in_empNameToSearch = " + in_empNameToSearch);
		logger.info("Calling method: searchPageManager.searchByEmployeeName(userRec, in_empNameToSearch)");
		logger.info("END");
		try {
			searchPageManager.searchByEmployeeName(userRec, in_empNameToSearch);
		} catch (ExceptionsClass e) {
			// TODO Auto-generated catch block
			logger.error(e);
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	public void displaySearchByEmployeeProject(UsersBean userRec) {
		logger.info("START");
		System.out.println("#####################################");
		System.out.println("--###SEARCH - By Employe Project###--");
		logger.info("Scanning Employee Project to search");
		System.out.print("Enter Employee Project: ");
		String in_empProjToSearch = MyScanner.next();
		System.out.println("#####################################");
		logger.info("variable in_empProjToSearch = " + in_empProjToSearch);
		logger.info("Calling method: searchPageManager.searchByEmployeeProj(userRec, in_empProjToSearch)");
		logger.info("END");
		try {
			searchPageManager.searchByEmployeeProj(userRec, in_empProjToSearch);
		} catch (ExceptionsClass e) {
			// TODO Auto-generated catch block
			logger.error(e);
			System.out.println(e);
			e.printStackTrace();
		}
	}

	public void displaySearchResult(UsersBean userRec, List<EmployeesBean> searchedEmpInfoLocRecords) {
		logger.info("START");
		System.out.println("#####################################");
		System.out.println("-Search - Employee Information Record");
		System.out.println("-----(" + searchedEmpInfoLocRecords.size() + ") result(s) found");
		int numCtr = 1;
		System.out.println("Employee ID | First Name | Last Name | Seat | Local | Shift | Project(s)");

		if (searchedEmpInfoLocRecords.size() != 0) {
		for (EmployeesBean employeeRec : searchedEmpInfoLocRecords) {
			System.out.print("[" + numCtr + "] ");
			System.out.print(employeeRec.getEmp_idkey());
			System.out.print(" | ");
			System.out.print(employeeRec.getEmp_firstName());
			System.out.print(" | ");
			System.out.print(employeeRec.getEmp_lastName());
			System.out.print(" | ");
			System.out.print(employeeRec.getEmp_location());
			System.out.print(" | ");
			if (employeeRec.getEmp_localNumber() == 0) {
				System.out.print("N/A");
			} else {
				System.out.print(employeeRec.getEmp_localNumber());
			}
			System.out.print(" | ");
			System.out.print(employeeRec.getEmp_shift());
			System.out.print(" | ");
			if (employeeRec.getEmp_projName().equalsIgnoreCase("PROJECT NEVER EXIST")) {
				System.out.print("N/A");
			} else {
				System.out.print(employeeRec.getEmp_projName());
			}
			System.out.print(" | ");
			System.out.println("");
			numCtr++;

		}}
		System.out.println("------------end of result------------");
		System.out.println("Actions: [1] Search Again [2] Home --");
		System.out.print("--> Enter Choice: ");
		logger.info("Calling method: utilityClass.scanAndValidateIntInput(2)");
		int in_searchResultAction = utilityClass.scanAndValidateIntInput(2);
		System.out.println("#####################################");
		logger.info("variable in_searchResultAction = " + in_searchResultAction);
		logger.info("Calling method: searchPageManager.processSearchByEmployeeIDResultAction(userRec, in_searchResultAction);");
		logger.info("END");
		searchPageManager.processSearchByEmployeeIDResultAction(userRec, in_searchResultAction);
	}

}
