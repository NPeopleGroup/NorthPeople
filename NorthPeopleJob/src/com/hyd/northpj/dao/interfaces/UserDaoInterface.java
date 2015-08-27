package com.hyd.northpj.dao.interfaces;

import java.util.List;

import com.hyd.northpj.entity.User;

public interface UserDaoInterface {
	/**
	 * �����û�
	 * 
	 * @param user
	 * @return �ɹ�����0��ʧ�ܷ��ط�0
	 * @throws Exception
	 */
	public int insertUser(User user) throws Exception;

	/**
	 * ��ȡ�û�����
	 * 
	 * @param user
	 * @return �û�����
	 * @throws Exception
	 */
	public String selectUserPassword(String username) throws Exception;

	/**
	 * �����û�����
	 * 
	 * @param user
	 * @return �ɹ�����0��ʧ�ܷ��ط�0
	 * @throws Exception
	 */
	public int updateUserPassword(User user) throws Exception;

	/**
	 * �����û���Ϣ
	 * 
	 * @param user
	 * @return �ɹ�����0��ʧ�ܷ��ط�0
	 * @throws Exception
	 */
	public int updateUserInformation(User user) throws Exception;

	/**
	 * ��ȡ�û���Ϣ
	 * 
	 * @param user
	 * @return �û���Ϣ
	 * @throws Exception
	 */
	public User selectUserInformation(String username) throws Exception;

	/**
	 * �����û��Ǽ�ʱ��
	 * 
	 * @param user
	 * @return �ɹ�����0��ʧ�ܷ��ط�0
	 * @throws Exception
	 */
	public int updateUserApplicationTime(User user) throws Exception;

	/**
	 * �����û����½���
	 * 
	 * @param user
	 * @return �ɹ�����0��ʧ�ܷ��ط�0
	 * @throws Exception
	 */
	public int updateUserAcceptionProgress(User user) throws Exception;

	/**
	 * �����û�ԤԼʱ��
	 * 
	 * @param user
	 * @return �ɹ�����0��ʧ�ܷ��ط�0
	 * @throws Exception
	 */
	public int updateUserAppointmentTime(User user) throws Exception;

	// /**
	// * ��ȡ����ĸ��˲����б�
	// *
	// * @param user
	// * @return ���˲����б�ÿ������һ��string
	// * @throws Exception
	// */
	// public ArrayList<String> selectFileList(User user) throws Exception;
	//
	// /**
	// * ��ȡ�û��Ĵ���ɼ��б�(һ��<����,�ɼ�>�Զ������磺���䣬35��ס����40���籣��45����)
	// *
	// * @param user
	// * @return ����ɼ��б�(һ��<����,�ɼ�>�ԣ����磺���䣬35��ס����40���籣��45����)
	// * @throws Exception
	// */
	// public ArrayList<String> selectEvaluationScore(User user) throws
	// Exception;
	//
	// /**
	// * ��ѯʱ����ڵ��û��ĵ÷����
	// *
	// * @param beginDate
	// * @param endDate
	// * @return �÷����(һ��<����,�ɼ�>�ԣ����磺120��11��125��8��130��4)
	// * @throws Exception
	// */
	// public ArrayList<String> selectUsersByScore(Date beginDate, Date endDate)
	// throws Exception;
	//
	// /**
	// * ��ѯʱ����ڵ��û��İ���������
	// *
	// * @param beginDate
	// * @param endDate
	// * @return �������(һ��<����,�ɼ�>�ԣ����磺���룬11�����ڰ���8���ɹ���4)
	// * @throws Exception
	// */
	// public ArrayList<String> selectUsersByProgress(Date beginDate, Date
	// endDate)
	// throws Exception;

	// /**
	// * ��ѯʱ����ڵ�һ���û�
	// *
	// * @param beginDate
	// * @param endDate
	// * @return һ���û�
	// * @throws Exception
	// */
	// public ArrayList<User> getUsersByDate(Date beginDate, Date endDate)
	// throws Exception;
	//
	// /**
	// * ���ݽ��Ȼ�ȡһ���û�
	// *
	// * @param progress
	// * @return һ���û�
	// * @throws Exception
	// */
	// public ArrayList<User> getUsersByProgress(String progress) throws
	// Exception;
	/**
	 * ��ȡ�����û�
	 * @return ����ɹ�����0��ʧ���򷵻ط�0
	 * @throws Exception
	 */
	public List<User> selectAllUser() throws Exception;
	
	/**
	 * ���ݰ������ɸѡ�û�
	 * @param type ��Ҫɸѡ���û�����
	 * @return ����ɸѡ�����������û�
	 * @throws Exception
	 */
	public List<User> selectUserByProgress(String type) throws Exception;
}
