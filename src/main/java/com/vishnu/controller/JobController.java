package com.vishnu.controller;

import java.sql.SQLException;

import com.vishnu.model.ImplementJobDao;
import com.vishnu.model.Job;
import com.vishnu.model.User;

public class JobController {
	
	ImplementJobDao jobDao;
	Job job;
	User user;	
	
	public JobController() throws ClassNotFoundException, SQLException {
		jobDao = new ImplementJobDao();
		job = new Job();
		user = new User();
	}
	
	public void addJob(String JT, String JD, String CN,String LOC, String KS, String SAL, String EXP ) {
				
				job.setJobTitle(JT);
				job.setJobDescription(JD);
				job.setCompanyName(CN);
				job.setLocation(LOC);
				job.setKeySkill(KS);
				job.setSalary(SAL);
				job.setExperience(EXP);
				jobDao.addJob(job);
			}
			
	
	
			public void updateJob(int JID,String LOC,String SAL,String EXP) {
						job.setJobId(JID);
						job.setLocation(LOC);
						job.setSalary(SAL);
						job.setExperience(EXP);
						jobDao.updateJob(job);
					}
			
			public void ViewJobId(int JID) {
				job.setJobId(JID);
				jobDao.ViewJobId(job);
			}
			
			public void activateJob(int ID) {
				job.setJobId(ID);
				jobDao.activateJob(job);
			}

	
			public void deactivateJob(int ID) {
				job.setJobId(ID);
				jobDao.deactivateJob(job);
			}

			
			public void deleteJob(int ID) {
					job.setJobId(ID);
					jobDao.deleteJob(job);
			}
		
			public void addAppliedJob(int JID,String JT,String JD,String CN,String KS, String LOC, String SAL,String EXP, int ID, String N, String PN, String G, String SK) {
				job.setJobId(JID);
				job.setJobTitle(JT);
				job.setJobDescription(JD);
				job.setCompanyName(CN);
				job.setKeySkill(KS);
				job.setLocation(LOC);
				job.setSalary(SAL);
				job.setExperience(EXP);
				user.setId(ID);
				user.setName(N);
				user.setPhoneNumber(PN);
				user.setGender(G);
				user.setSkill(SK);
				jobDao.addAppliedJob(job, user);
			}
			
}
