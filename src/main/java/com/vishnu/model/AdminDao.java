package com.vishnu.model;

public interface AdminDao {
	Admin checkAdminLogin(Admin admin);
	Admin deleteUser(Admin admin);
	Admin viewUser(Admin admin);
	void deleteAppliedJob(Admin admin);
	void rejectReq(Admin admin);
	void selectReq(Admin admin);
}
