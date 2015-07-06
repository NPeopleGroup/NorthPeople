package com.hyd.northpj.dao.interfaces;

import java.util.ArrayList;

import com.hyd.northpj.entity.Answer;
import com.hyd.northpj.model.EvaluationFile;
import com.hyd.northpj.model.EvaluationScore;

public interface AnswerDaoInterface {
	/**
	 * ����һ����
	 * 
	 * @param adminUser
	 * @return �ɹ�����0��ʧ�ܷ��ط�0
	 * @throws Exception
	 */
	public int insertAnswer(Answer answer) throws Exception;

	/**
	 * ��ȡ�û������۷�������
	 * 
	 * @param username
	 * @return ���۷������ϣ��������ͣ������͵ĳɼ�
	 * @throws Exception
	 */
	public ArrayList<EvaluationScore> selectEvaluationScore(String username)
			throws Exception;

	/**
	 * ��ȡ�û������۲��ϼ���
	 * 
	 * @param username
	 * @return ���۲��ϼ��ϣ����۲��ϣ��ò�����������
	 * @throws Exception
	 */
	public ArrayList<EvaluationFile> selectEvaluationFile(String username) throws Exception;

}
