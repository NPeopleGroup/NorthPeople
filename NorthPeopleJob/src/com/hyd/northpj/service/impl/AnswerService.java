package com.hyd.northpj.service.impl;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.hyd.northpj.dao.impl.AnswerDao;
import com.hyd.northpj.entity.Answer;
import com.hyd.northpj.model.EvaluationFile;
import com.hyd.northpj.model.EvaluationScore;
import com.hyd.northpj.service.interfaces.AnswerServiceInterface;
import com.hyd.northpj.util.ValidateUtil;

public class AnswerService implements AnswerServiceInterface {
	private Logger myLogger = Logger.getLogger(this.getClass());
	private AnswerDao myAnswerDao = new AnswerDao();

	@Override
	public int answerQuestion(Answer answer) throws Exception {
		// TODO Auto-generated method stub
		int validateResult = ValidateUtil.validateAnswer(answer);
		if (validateResult != 0) {
			myLogger.error("answer��ϢΪͨ����֤,--->������Ϣ:" + validateResult);
			return validateResult;
		}
		int insertResult = myAnswerDao.insertAnswer(answer);
		if (insertResult != 0) {
			myLogger.error("����answer��Ϣ����,--->������Ϣ:" + answer.toString());
			return 7;
		}
		return 0;
	}

	@Override
	public Answer getAnswer(String username, String questionId)
			throws Exception {
		// TODO Auto-generated method stub
		if (!ValidateUtil.isPassSqlFilter(username)) {
			myLogger.error("userNameδͨ����֤,--->userName:" + username);
		}
		if (!ValidateUtil.isPassSqlFilter(questionId)) {
			myLogger.error("questionIdδͨ����֤,--->questionId:" + questionId);
		}
		return myAnswerDao.selectAnswer(username, questionId);
	}

	@Override
	public int deleteQuestionByPeopleAndQuestionId(String username,
			String questionId) throws Exception {
		// TODO Auto-generated method stub
		if (!ValidateUtil.isPassSqlFilter(username)) {
			myLogger.error("userNameδͨ����֤,--->userName:" + username);
		}
		if (!ValidateUtil.isPassSqlFilter(questionId)) {
			myLogger.error("questionIdδͨ����֤,--->questionId:" + questionId);
		}
		int deleteResult = myAnswerDao.deleteQuestionByPeopleAndQuestionId(
				username, questionId);
		if (deleteResult != 0) {
			myLogger.error("ɾ��answer��Ϣ����,--->�����û�:" + username + "��������ID:"
					+ questionId);
			return 7;
		}
		return 0;
	}

	@Override
	public int deleteQuestionByPeopleAndType(String username, String type)
			throws Exception {
		// TODO Auto-generated method stub
		if (!ValidateUtil.isPassSqlFilter(username)) {
			myLogger.error("userNameδͨ����֤,--->userName:" + username);
		}
		if (!ValidateUtil.isPassSqlFilter(type)) {
			myLogger.error("typeδͨ����֤,--->type:" + type);
		}
		int deleteResult = myAnswerDao.deleteAnswerByPeopleAndType(username,
				type);
		if (deleteResult != 0) {
			myLogger.error("ɾ��answer��Ϣ����,--->�����û�:" + username + "��������:" + type);
			return 7;
		}
		return 0;
	}

	@Override
	public ArrayList<EvaluationScore> getEvaluationScore(String username)
			throws Exception {
		// TODO Auto-generated method stub
		if (!ValidateUtil.isPassSqlFilter(username)) {
			myLogger.error("userNameδͨ����֤,--->userName:" + username);
		}
		return myAnswerDao.selectEvaluationScore(username);
	}

	@Override
	public ArrayList<EvaluationFile> getEvaluationFile(String username)
			throws Exception {
		// TODO Auto-generated method stub
		if (!ValidateUtil.isPassSqlFilter(username)) {
			myLogger.error("userNameδͨ����֤,--->userName:" + username);
		}
		return myAnswerDao.selectEvaluationFile(username);
	}

	@Override
	public String getUnFinishedType() throws Exception {
		// TODO Auto-generated method stub

		return myAnswerDao.selectUnFinishedType();
	}

}
