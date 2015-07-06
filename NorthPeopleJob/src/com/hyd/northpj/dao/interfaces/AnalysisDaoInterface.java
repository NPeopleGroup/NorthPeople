package com.hyd.northpj.dao.interfaces;

import java.util.ArrayList;
import java.util.Date;

import com.hyd.northpj.entity.User;

public interface AnalysisDaoInterface {

	/**
	 * ��ѯʱ����ڵ�һ���û�
	 *
	 * @param beginDate
	 * @param endDate
	 * @return һ���û�
	 * @throws Exception
	 */
	public ArrayList<User> selectUserList(Date beginDate, Date endDate)
			throws Exception;

	/**
	 * ��ѯʱ����ڵ��û��ĵ÷����
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return �÷����(һ��<����,�ɼ�>�ԣ����磺120��11��125��8��130��4)
	 * @throws Exception
	 */
	public ArrayList<String> selectScoreCountList(Date beginDate, Date endDate)
			throws Exception;

	/**
	 * ��ѯʱ����ڵ��û��İ���������
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return �������(һ��<����,�ɼ�>�ԣ����磺���룬11�����ڰ���8���ɹ���4)
	 * @throws Exception
	 */
	public ArrayList<String> selectProgressCountList(Date beginDate,
			Date endDate) throws Exception;
}
