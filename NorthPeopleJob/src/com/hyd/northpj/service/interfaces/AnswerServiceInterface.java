package com.hyd.northpj.service.interfaces;

import java.util.ArrayList;

import com.hyd.northpj.entity.Answer;
import com.hyd.northpj.model.EvaluationFile;
import com.hyd.northpj.model.EvaluationScore;

public interface AnswerServiceInterface {

	/**
	 * �ش�һ������
	 * 
	 * @param userName
	 * @param questionId
	 * @param answer
	 * @return ��ȷ��ɻش�����򷵻�0
	 * @throws Exception
	 */
	public int answerQuestion(Answer answer)
			throws Exception;

	/**
	 * ��ȡ�û������۷�������
	 * 
	 * @param username
	 * @return ���۷������ϣ��������ͣ������͵ĳɼ�
	 * @throws Exception
	 */
	public ArrayList<EvaluationScore> getEvaluationScore(String username)
			throws Exception;

	/**
	 * ��ȡ�û������۲��ϼ���
	 * 
	 * @param username
	 * @return ���۲��ϼ��ϣ����۲��ϣ��ò�����������
	 * @throws Exception
	 */
	public ArrayList<EvaluationFile> getEvaluationFile(String username) throws Exception;



}
