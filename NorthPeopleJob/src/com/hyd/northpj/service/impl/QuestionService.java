package com.hyd.northpj.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.hyd.northpj.dao.impl.QuestionDao;
import com.hyd.northpj.entity.Question;
import com.hyd.northpj.service.interfaces.QuestionServiceInterface;
import com.hyd.northpj.util.ValidateUtil;

public class QuestionService implements QuestionServiceInterface {
	private QuestionDao myQuestionDao = new QuestionDao();
	private Logger myLogger = Logger.getLogger(this.getClass());

	@Override
	public List<Question> getQuestionList() throws Exception {
		// TODO Auto-generated method stub
		List<Question> myQuestionList = null;
		myQuestionList = myQuestionDao.selectQuestionList();
		if (myQuestionList == null) {
			myLogger.error("��ȡ���ݿ������б���ִ���");
		}
		return myQuestionList;
	}

	public List<Question> getQuestionList(String questionType) throws Exception {
		// TODO Auto-generated method stub
		List<Question> myQuestionList = null;
		myQuestionList = myQuestionDao.selectQuestionList(questionType);
		if (myQuestionList == null) {
			myLogger.error("��ȡ���ݿ������б���ִ���");
		}
		return myQuestionList;
	}
	
	@Override
	public int addQuestion(Question question) throws Exception {
		// TODO Auto-generated method stub
		if (ValidateUtil.validateQuestionId(question) != 0) {
			myLogger.error("Ҫ�����ʵ��,questionIdͨ����֤��");
			return 1;
		}
		if (myQuestionDao.insertQuestion(question) != 0) {
			myLogger.error("����questionʵ���������ִ���-->questionInfo:"
					+ question.toString());
			return 2;
		}
		;
		return 0;
	}

	@Override
	public Question getQuestion(String id) throws Exception {
		// TODO Auto-generated method stub
		if (!ValidateUtil.isPassSqlFilter(id)) {
			myLogger.error("Ҫ��ѯ��ʵ��,questionIdͨ����֤��--->questionId:" + id);
			return null;
		}
		return myQuestionDao.selectQuestion(id);
	}

	@Override
	public int setQuestion(Question question) throws Exception {
		// TODO Auto-generated method stub
		// TODO ������private ���Ե����� ��ʱ��ע�͵�
		// if (ValidateUtil.validateQuestionAllProperty(question) != 0) {
		// myLogger.error("Ҫ�޸ĵ�ʵ������ͨ����֤��--->question:" + question.toString());
		// return 1;
		// }
		int updateResult = myQuestionDao.updateQuestion(question);
		if (updateResult != 0) {
			myLogger.error("Ҫ�޸ĵ�ʵ����Ϣ���ִ���");
		}
		return updateResult;
	}

	@Override
	public int deleteQuestion(String id) throws Exception {
		// TODO Auto-generated method stub
		if (!ValidateUtil.isPassSqlFilter(id)) {
			myLogger.error("Ҫ�����ʵ��,questionIdͨ����֤��");
			return 1;
		}
		int deleteResult = myQuestionDao.deleteQuestion(id);
		if (deleteResult != 0) {
			myLogger.error("ɾ��ʵ����Ϣʱ���ִ���--->questionId:" + id);
		}
		return 0;
	}

}
