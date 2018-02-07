package com.pointwest.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.pointwest.beans.EmployeesBean;
import com.pointwest.beans.UsersBean;
import com.pointwest.dao.PLSDAO;
import com.pointwest.ui.HomePageUI;
import com.pointwest.ui.SearchPageUI;
import com.pointwest.utility.ExceptionsClass;

public class SearchPageManager {
	Logger logger = Logger.getLogger(SearchPageManager.class);

	public void processSearchPageOption(UsersBean userRec, int in_searchPageOption) throws Exception{
		logger.info("START");
		try {
		HomePageUI homePageUI = new HomePageUI();
		SearchPageUI searchPageUI = new SearchPageUI();

		switch (in_searchPageOption) {
		case 1:
			logger.info("Calling method: searchPageUI.displaySearchByEmployeeID(userRec)");
			logger.info("END");
			searchPageUI.displaySearchByEmployeeID(userRec);
			break;
		case 2:
			logger.info("Calling method: searchPageUI.displaySearchByEmployeeName(userRec)");
			logger.info("END");
			searchPageUI.displaySearchByEmployeeName(userRec);
			break;
		case 3:
			logger.info("Calling method: searchPageUI.displaySearchByEmployeeProject(userRec)");
			logger.info("END");
			searchPageUI.displaySearchByEmployeeProject(userRec);
			break;
		case 4:
			logger.info("Calling method: homePageUI.displayPLSHomePage(userRec)");
			logger.info("END");
			homePageUI.displayPLSHomePage(userRec);
			break;
		}}
		catch(Exception e) {
			logger.error("Search Page Error");
			logger.error(e.getMessage());
			new Exception();
		}
	}

	public void searchByEmployeeID(UsersBean userRec, int in_empIDToSearch) throws ExceptionsClass {
		logger.info("START");
		SearchPageUI searchPageUI = new SearchPageUI();
		PLSDAO plsDAO = new PLSDAO();
		String stringEmpID = null;
		String stringEmpIDToSearch = new Integer(in_empIDToSearch).toString();

		List<EmployeesBean> employeesInfoLocRecords = plsDAO.getEmployeeInfoLocRecList();
		List<EmployeesBean> searchedEmpInfoLocRecords = new ArrayList<EmployeesBean>();

		for (EmployeesBean employeeRec : employeesInfoLocRecords) {
			stringEmpID = new Integer(employeeRec.getEmp_idkey()).toString();

			if (stringEmpID.contains(stringEmpIDToSearch)) {
				searchedEmpInfoLocRecords.add(employeeRec);
			}
		}
		searchPageUI.displaySearchResult(userRec, searchedEmpInfoLocRecords);
	}

	public void searchByEmployeeName(UsersBean userRec, String in_empNameToSearch) throws ExceptionsClass {
		logger.info("START");
		SearchPageUI searchPageUI = new SearchPageUI();
		PLSDAO plsDAO = new PLSDAO();

		String stringEmpName;

		List<EmployeesBean> employeesInfoLocRecords = plsDAO.getEmployeeInfoLocRecList();
		List<EmployeesBean> searchedEmpInfoLocRecords = new ArrayList<EmployeesBean>();

		for (EmployeesBean employeeRec : employeesInfoLocRecords) {
			stringEmpName = employeeRec.getEmp_firstName() + " " + employeeRec.getEmp_lastName();

			if (stringEmpName.toUpperCase().contains(in_empNameToSearch.toUpperCase())) {
				logger.info("Adding employeeRec to searchedEmpInfoLocRecords");
				searchedEmpInfoLocRecords.add(employeeRec);
			}
		}
		logger.info("Calling method: searchPageUI.displaySearchResult(userRec, searchedEmpInfoLocRecords)");
		logger.info("END");
		searchPageUI.displaySearchResult(userRec, searchedEmpInfoLocRecords);
	}
	
	public void searchByEmployeeProj(UsersBean userRec, String in_empProjToSearch) throws ExceptionsClass {
		logger.info("START");
		SearchPageUI searchPageUI = new SearchPageUI();
		PLSDAO plsDAO = new PLSDAO();

		String stringEmpProj;

		List<EmployeesBean> employeesInfoLocRecords = plsDAO.getEmployeeInfoLocRecList();
		List<EmployeesBean> searchedEmpInfoLocRecords = new ArrayList<EmployeesBean>();

		for (EmployeesBean employeeRec : employeesInfoLocRecords) {
			stringEmpProj = employeeRec.getEmp_projName();

			if (stringEmpProj.equalsIgnoreCase(in_empProjToSearch)) {
				logger.info("Adding employeeRec to searchedEmpInfoLocRecords");
				searchedEmpInfoLocRecords.add(employeeRec);
			}
		}
		logger.info("Calling method: searchPageUI.displaySearchResult(userRec, searchedEmpInfoLocRecords)");
		logger.info("END");
		searchPageUI.displaySearchResult(userRec, searchedEmpInfoLocRecords);
	}

	// Method for processing of action after searching by Employee ID
	public void processSearchByEmployeeIDResultAction(UsersBean userRec, int in_searchResultAction) {
		logger.info("START");
		SearchPageUI searchPageUI = new SearchPageUI();
		HomePageUI homePageUI = new HomePageUI();

		switch (in_searchResultAction) {		
		case 1:
			logger.info("Calling method: searchPageUI.displaySearchPage(userRec)");
			logger.info("END");
			searchPageUI.displaySearchPage(userRec);
			break;
		case 2:
			logger.info("Calling method: homePageUI.displayPLSHomePage(userRec)");
			logger.info("END");
			homePageUI.displayPLSHomePage(userRec);
			break;
		}

	}

}
