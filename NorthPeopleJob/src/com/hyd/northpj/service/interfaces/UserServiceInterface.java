package com.hyd.northpj.service.interfaces;

import com.hyd.northpj.entity.User;

public interface UserServiceInterface {

	/**
	 * �û�ע��
	 * 
	 * @param user
	 * @return �ɹ�����0��ʧ�ܷ��ط�0
	 * @throws Exception
	 */
	public int register(User user) throws Exception;

	/**
	 * �û���¼
	 * 
	 * @param user
	 * @return �ɹ�����0��ʧ�ܷ��ط�0
	 * @throws Exception
	 */
	public int login(User user) throws Exception;

	/**
	 * �û���������
	 * 
	 * @param user
	 * @return �ɹ�����0��ʧ�ܷ��ط�0
	 * @throws Exception
	 */
	public int changePassword(User user, String newPassword) throws Exception;

	/**
	 * �û��ǼǸ�����Ϣ
	 * 
	 * @param user
	 * @return �ɹ�����0��ʧ�ܷ��ط�0
	 * @throws Exception
	 */
	public int setInformation(User user) throws Exception;

	/**
	 * ��ȡ�û��ĸ�����Ϣ
	 * 
	 * @param username
	 * @return һ���û�
	 * @throws Exception
	 */
	public User getInformation(String username) throws Exception;

	/**
	 * ��ʼ���û��������
	 * 
	 * @param user
	 * @return �ɹ�����0��ʧ�ܷ��ط�0
	 * @throws Exception
	 */
	public int initialiseAcceptionProgress(User user) throws Exception;

	/**
	 * ��ʼ���Ǽ�ʱ��
	 * 
	 * @param user
	 * @return �ɹ�����0��ʧ�ܷ��ط�0
	 * @throws Exception
	 */
	public int initialiseApplicationTime(User user) throws Exception;

	/**
	 * ����û��İ������
	 * 
	 * @param user
	 * @return �ɹ�����0��ʧ�ܷ��ط�0
	 * @throws Exception
	 */
	public int changeAcceptionProgress(User user) throws Exception;

	/**
	 * ��ʼ��ԤԼʱ��
	 * 
	 * @param user
	 * @return �ɹ�����0��ʧ�ܷ��ط�0
	 * @throws Exception
	 */
	public int changeAppointmentTime(User user) throws Exception;

}
