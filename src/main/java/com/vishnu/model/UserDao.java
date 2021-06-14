package com.vishnu.model;

public interface UserDao {

	 void addUser(User user);
	 User checkUserLogin(User user);
	 User addUserSkill(User user);
	 //void deactivateuserloyee(User user);
	 void viewUser(User user);
	 void UpdateProfile(User user);
	 //void deleteuserloyee(User user);
}
