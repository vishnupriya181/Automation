package com.vishnu.controller;

import java.sql.SQLException;

import com.vishnu.daoimpl.UserImplementDao;
import com.vishnu.model.User;


public class UserController {

	UserImplementDao userimpDao=null;
	User user;
	public UserController() throws ClassNotFoundException, SQLException{
		userimpDao = new UserImplementDao();
		user = new User();
	}
	
	public User checkLogin(String UID) {
		user.setUserId(UID);
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
			userimpDao.UpdateProfile(user);
			return user;
		}
		
		public void addUserSkill(String UID,String SN) {
			user.setUserId(UID);
			user.setSkill(SN);	
			userimpDao.addUserSkill(user);
		}
}
