package com.vishnu.controller;

import java.sql.SQLException;

import com.vishnu.model.User;
import com.vishnu.model.UserImplementDao;

public class UserController{

	UserImplementDao userimpDao=null;
	User user;
	public UserController() throws ClassNotFoundException, SQLException{
		userimpDao = new UserImplementDao();
		user = new User();
	}
	
	public User checkLogin(String UID) {
		user.setUserId(UID);
		//user.setUserId(UP);
		userimpDao.checkUserLogin(user);
		return user;
	}
	
	
	public void addUser(String UID, String UFN, String ULN, String UP, String UPN, String UG)
	{
		user.setUserId(UID);
		user.setFirstName(UFN);
		user.setLastName(ULN);
		user.setPassword(UP);
		user.setPhoneNumber(UPN);
		user.setGender(UG);
		userimpDao.addUser(user);
	}
	
/*	public User activateEmployee(int EID) {
		emp.setEmpId(EID);
		empDao.activateEmployee(emp);
		return emp;
	}
	
	public User deactivateEmployee(int EID) {
		emp.setEmpId(EID);
		empDao.deactivateEmployee(emp);
		return emp;
	}*/
	
	public User viewUser(int EID) {
		user.setId(EID);
		userimpDao.viewUser(user);
		return user;
	} 
	
		public User UpdateProfile(String UID, String UFN, String ULN, String UP, String UPN, String UG) {
			User user = new User();
			user.setUserId(UID);
			user.setFirstName(UFN);
			user.setLastName(ULN);
			user.setPassword(UP);
			user.setPhoneNumber(UPN);
			user.setGender(UG);
		//	user.setSkill(US);
			userimpDao.UpdateProfile(user);
			return user;
		}
		
	/*	public User deleteEmployee(int EID) {
			emp.setEmpId(EID);
			empDao.deleteEmployee(emp);
			return emp;
		}
	*/	
		public void addUserSkill(String UID,String SN) {
			user.setUserId(UID);
			user.setSkill(SN);	
			userimpDao.addUserSkill(user);
		}
}

