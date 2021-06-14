package com.vishnu.controller;

import java.sql.SQLException;

import com.vishnu.model.Admin;
import com.vishnu.model.AdminImplementDao;

public class AdminController {
		AdminImplementDao adminimpDao=null;
		Admin admin;
		
		public AdminController() throws ClassNotFoundException, SQLException{
			adminimpDao = new AdminImplementDao();
			admin = new Admin();
		}
		
		public Admin checkLogin(String UID) {
			admin.setUserId(UID);
			adminimpDao.checkAdminLogin(admin);
			return admin;
		}
		
		public Admin deleteUser(String UID) {
			admin.setUserId(UID);
			adminimpDao.deleteUser(admin);
			return admin;
		}
		
		public Admin viewUser(String UID) {
			admin.setUserId(UID);
			adminimpDao.viewUser(admin);
			return admin;
		}
		
		public Admin deleteAppliedJob(int RID) {
			admin.setId(RID);
			adminimpDao.deleteAppliedJob(admin);
			return admin;
		}
		
		public Admin rejectReq(int RID) {
			admin.setId(RID);
			adminimpDao.rejectReq(admin);
			return admin;
		}

		public Admin selectReq(int RID) {
			admin.setId(RID);
			adminimpDao.selectReq(admin);
			return admin;
		}
}
