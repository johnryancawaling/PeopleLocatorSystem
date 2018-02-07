package com.pointwest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.pointwest.beans.EmployeesBean;
import com.pointwest.beans.UsersBean;
import com.pointwest.utility.ConstantsClass;
import com.pointwest.utility.ExceptionsClass;

public class PLSDAO {

	Logger logger = Logger.getLogger(PLSDAO.class);

	public Connection connect() throws ExceptionsClass {
		logger.info("START");
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String db = ConstantsClass.DATABASE;
			String user = ConstantsClass.DB_USER;
			String password = ConstantsClass.DB_PASSWORD;
			logger.info("Variable db = " + db);
			logger.info("Variable user = " + user);
			logger.info("Variable password = " + password);
			conn = DriverManager.getConnection(db, user, password);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("-=Connection Error encountered=-");
			logger.error(e.getMessage());
			throw new ExceptionsClass();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw new ExceptionsClass();
		}
		logger.info("END");
		logger.info("Return conn");
		return conn;

	}

	public List<UsersBean> getAllUsersRecList() throws ExceptionsClass {
		logger.info("START");
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = connect();
		List<UsersBean> usersRecList = null;

		String query = "SELECT * FROM plsdb.employee";
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			usersRecList = new ArrayList<UsersBean>();
			while (rs.next()) {
				UsersBean userRecord = new UsersBean();
				logger.info("Adding userRecord to usersRecList");
				userRecord.setUser_username(rs.getString("username"));
				userRecord.setUser_password(rs.getString("password"));
				userRecord.setUser_firstName(rs.getString("first_name"));
				userRecord.setUser_lastName(rs.getString("last_name"));
				userRecord.setUser_role(rs.getString("role"));
				usersRecList.add(userRecord);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("Connection Error encountered");
			logger.error(e.getMessage());
		}
		logger.info("Return usersRecList");
		logger.info("END");
		return usersRecList;

	}

	public List<EmployeesBean> getEmployeeInfoLocRecList() throws ExceptionsClass {
		logger.info("START");
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = connect();
		List<EmployeesBean> employeesInfoLocRecList = null;

		String query = "SELECT\r\n" + "employee.emp_id,\r\n" + "employee.first_name,\r\n" + "employee.last_name,\r\n"
				+ "CONCAT(seat.bldg_id,floor_number,'F',quadrant,row_number,'-',column_number) as location,\r\n"
				+ "seat.local_number,\r\n" + "employee.shift,\r\n" + "project.proj_name,\r\n"
				+ "location.bldg_address\r\n" + "\r\n" + "FROM\r\n"
				+ "employee, seat, employee_project, employee_seat, project, location\r\n" + "\r\n" + "where\r\n"
				+ "employee.emp_id = employee_project.employee_id AND\r\n"
				+ "employee_seat.emp_id = employee.emp_id AND\r\n" + "employee_seat.seat_id = seat.seat_id AND\r\n"
				+ "employee_project.proj_alias = project.proj_alias AND\r\n" + "seat.bldg_id = location.bldg_id";
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			employeesInfoLocRecList = new ArrayList<EmployeesBean>();
			while (rs.next()) {
				logger.info("Adding employeeInfoLocRecord to employeesInfoLocRecList");
				EmployeesBean employeeInfoLocRecord = new EmployeesBean();
				employeeInfoLocRecord.setEmp_idkey(rs.getInt("emp_id"));
				employeeInfoLocRecord.setEmp_firstName(rs.getString("first_name"));
				employeeInfoLocRecord.setEmp_lastName(rs.getString("last_name"));
				employeeInfoLocRecord.setEmp_location(rs.getString("location"));
				employeeInfoLocRecord.setEmp_localNumber(rs.getInt("local_number"));
				employeeInfoLocRecord.setEmp_shift(rs.getString("shift"));
				employeeInfoLocRecord.setEmp_projName(rs.getString("proj_name"));
				employeeInfoLocRecord.setEmp_bldgAddress(rs.getString("bldg_address"));
				employeesInfoLocRecList.add(employeeInfoLocRecord);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("Connection Error encountered");
			logger.error(e.getMessage());
		}
		logger.info("Return employeesInfoLocRecList");
		logger.info("END");
		return employeesInfoLocRecList;

	}

}
