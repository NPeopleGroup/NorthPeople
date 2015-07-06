package com.hyd.northpj.service.impl;

import org.apache.log4j.Logger;

import com.hyd.northpj.dao.impl.UserDao;
import com.hyd.northpj.entity.User;
import com.hyd.northpj.service.interfaces.UserServiceInterface;
import com.hyd.northpj.util.ValidateUtil;

public class UserService implements UserServiceInterface {

	private UserDao myUserDao = new UserDao();
	private Logger myLogger = Logger.getLogger(this.getClass());

	@Override
	public int register(User user) throws Exception {

		// ���û���Ч�Խ�����
		int validateResult = ValidateUtil.validUser(user);
		// ����ֵ��Ϊ0����ʾ�������س����־
		if (validateResult != 0) {
			return validateResult;
		}
		return myUserDao.insertUser(user) == 0 ? 0 : 5;
	}

	@Override
	public int login(User user) throws Exception {

		// ���û���Ч�Խ�����
		int validateResult = ValidateUtil.validUser(user);
		// ����ֵ��Ϊ0����ʾ�������س����־
		if (validateResult != 0) {
			return validateResult;
		}

		String realPassword = null;
		try {
			realPassword = myUserDao.selectUserPassword(user.getUsername());
		} catch (Exception e) {
			myLogger.error("��ȡ�û������������:" + e.toString());
			return 5;
		}
		if (user.getPassword() == null || user.getPassword().trim().equals("")) {
			myLogger.error("�û���������Ϊ�գ�");
			return 6;
		} else if (!user.getPassword().equals(realPassword)) {
			myLogger.error("�û����벻ƥ�䣡");
			return 7;
		}
		return 0;
	}

	@Override
	public int changePassword(User user, String newPassword) throws Exception {
		// �ж��û���Ч��
		int isUserExist = login(user);
		// ����ֵ��Ϊ0����ʾ�������س����־
		if (isUserExist != 0) {
			myLogger.error("�޷�ͨ���û���Ч����֤,��˶��û����Լ����룡");
			return isUserExist;
		}
		if (user.getPassword().equals(newPassword)) {
			myLogger.error("�����û�������һ��!");
			return 7;
		}

		try {
			user.setPassword(newPassword);
			myUserDao.updateUserPassword(user);
		} catch (Exception e) {
			myLogger.error("�����û������������:" + e.toString());
			return 8;
		}
		return 0;
	}

	@Override
	public int setInformation(User user) throws Exception { 
		// �ж��û���Ч��
		if (ValidateUtil.validateUserAllProperty(user) == 0) {
			myUserDao.updateUserInformation(user);
		} else {
			myLogger.error("�����û���Ϣ���ִ���");
			return 3;
		}
		return 0;
	}

	@Override
	public User getInformation(String username) throws Exception {
		// TODO Auto-generated method stub
		if (username != null && ValidateUtil.isPassSqlFilter(username)) {
			return myUserDao.selectUserInformation(username);
		}
		return null;
	}

	@Override
	public int initialiseAcceptionProgress(User user) throws Exception {
		// TODO Auto-generated method stub
		if (user.getUsername() != null
				&& ValidateUtil.isPassSqlFilter(user.getUsername())) {
			return myUserDao.updateUserAcceptionProgress(user);
		}
		return 0;
	}

	@Override
	public int initialiseApplicationTime(User user) throws Exception {
		// TODO Auto-generated method stub
		if (user.getUsername() != null
				&& ValidateUtil.isPassSqlFilter(user.getUsername())) {
			return myUserDao.updateUserApplicationTime(user);
		}
		return 0;
	}

	@Override
	public int changeAcceptionProgress(User user) throws Exception {
		// TODO Auto-generated method stub
		if (user.getUsername() != null
				&& ValidateUtil.isPassSqlFilter(user.getUsername())) {
			return myUserDao.updateUserAcceptionProgress(user);
		}
		return 0;
	}

	@Override
	public int changeAppointmentTime(User user) throws Exception {
		// TODO Auto-generated method stub
		if (user.getUsername() != null
				&& ValidateUtil.isPassSqlFilter(user.getUsername())) {
			return myUserDao.updateUserAppointmentTime(user);
		}
		return 0;
	}

}
