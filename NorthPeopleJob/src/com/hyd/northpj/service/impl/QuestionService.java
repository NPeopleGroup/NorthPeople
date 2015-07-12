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

	@Override
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
	public Question getQuestionByType(String id, String type) throws Exception {
		System.out.println("getQuestionByType:" + id + "--" + type);
		Question question = new Question();

		if (!ValidateUtil.isPassSqlFilter(id)) {
			myLogger.error("Ҫ��ѯ��ʵ��,questionIdͨ����֤��--->questionId:" + id);
			return null;
		}
		if (!ValidateUtil.isPassSqlFilter(type)) {
			myLogger.error("Ҫ��ѯ��ʵ��,questionTypeͨ����֤��--->questionType:" + type);
			return null;
		}

		if (id == null && type == null) {
			question = myQuestionDao.selectFirstQuestionByType("����");// ��ʼ����

			while (question == null) {
				question = myQuestionDao
						.selectFirstQuestionByType(getNextQuestionType(changeQuestionTypeToChinese(type)));
			}

			return question;

		} else if ((id.equals("end") || id == null)
				&& !type.equals(changeQuestionTypeToEnglish("�ط�����"))) {
			System.out.println(changeQuestionTypeToEnglish("�ط�����"));
			System.out.println(1);
			System.out.println(type);
			type = getNextQuestionType(changeQuestionTypeToChinese(type));
			System.out.println(type);
			question = myQuestionDao.selectFirstQuestionByType(type);// ������ת��һ����

			while (question == null) {
				System.out.println(2);
				System.out.println(type);
				if (!type.equals("�ط�����")) {
					type = getNextQuestionType(type);
				}
				System.out.println(type);

				question = myQuestionDao.selectFirstQuestionByType(type);
				if (type.equals("�ط�����") && question == null) {
					System.out.println(3);
					return null;
				}
			}

			return question;
		} else if ((id.equals("end") || id == null)
				&& type.equals(changeQuestionTypeToEnglish("�ط�����"))) {// �������
			System.out.println(4);
			return null;

		}
		// TODO Auto-generated method stub
		else {
			return myQuestionDao.selectQuestion(id);// ��������
		}
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

	@Override
	public String changeQuestionTypeToChinese(String questionType)
			throws Exception {
		// TODO Auto-generated method stub
		String questionTypeChinese;
		switch (questionType) {
		case "age":
			questionTypeChinese = "����";
			break;
		case "education":
			questionTypeChinese = "����";
			break;
		case "skills_title":
			questionTypeChinese = "����(ְ��)";
			break;
		case "skills_qualifications":
			questionTypeChinese = "����(ְҵ�ʸ�)";
			break;
		case "housing":
			questionTypeChinese = "ס��";
			break;
		case "security":
			questionTypeChinese = "�籣";
			break;
		case "settled_area":
			questionTypeChinese = "�仧����";
			break;
		case "career":
			questionTypeChinese = "ְҵ";
			break;
		case "investment_tax":
			questionTypeChinese = "Ͷ����˰";
			break;
		case "awards_honor":
			questionTypeChinese = "��������";
			break;
		case "marital_status":
			questionTypeChinese = "����״��";
			break;
		case "working_years":
			questionTypeChinese = "��������";
			break;
		case "law_integrity":
			questionTypeChinese = "�ط�����";
			break;

		default:
			questionTypeChinese = "����";
			break;
		}

		return questionTypeChinese;
	}

	@Override
	public String changeQuestionTypeToEnglish(String questionType)
			throws Exception {
		// TODO Auto-generated method stub
		String questionTypeEnglish;
		switch (questionType) {
		case "����":
			questionTypeEnglish = "age";
			break;
		case "����":
			questionTypeEnglish = "education";
			break;
		case "����(ְ��)":
			questionTypeEnglish = "skills_title";
			break;
		case "����(ְҵ�ʸ�)":
			questionTypeEnglish = "skills_qualifications";
			break;
		case "ס��":
			questionTypeEnglish = "housing";
			break;
		case "�籣":
			questionTypeEnglish = "security";
			break;
		case "�仧����":
			questionTypeEnglish = "settled_area";
			break;
		case "ְҵ":
			questionTypeEnglish = "career";
			break;
		case "Ͷ����˰":
			questionTypeEnglish = "investment_tax";
			break;
		case "��������":
			questionTypeEnglish = "awards_honor";
			break;
		case "����״��":
			questionTypeEnglish = "marital_status";
			break;
		case "��������":
			questionTypeEnglish = "working_years";
			break;
		case "�ط�����":
			questionTypeEnglish = "law_integrity";
			break;

		default:
			questionTypeEnglish = "����";
			break;
		}

		return questionTypeEnglish;
	}

	@Override
	public String getNextQuestionType(String questionType) throws Exception {
		// TODO Auto-generated method stub
		String nextQuestionType;
		switch (questionType) {
		case "����":
			nextQuestionType = "����";
			break;
		case "����":
			nextQuestionType = "����(ְ��)";
			break;
		case "����(ְ��)":
			nextQuestionType = "����(ְҵ�ʸ�)";
			break;
		case "����(ְҵ�ʸ�)":
			nextQuestionType = "ס��";
			break;
		case "ס��":
			nextQuestionType = "�籣";
			break;
		case "�籣":
			nextQuestionType = "�仧����";
			break;
		case "�仧����":
			nextQuestionType = "ְҵ";
			break;
		case "ְҵ":
			nextQuestionType = "Ͷ����˰";
			break;
		case "Ͷ����˰":
			nextQuestionType = "��������";
			break;
		case "��������":
			nextQuestionType = "����״��";
			break;
		case "����״��":
			nextQuestionType = "��������";
			break;
		case "��������":
			nextQuestionType = "�ط�����";
			break;
		case "�ط�����":
			nextQuestionType = "����";
			break;

		default:
			nextQuestionType = "����";
			break;
		}

		return nextQuestionType;
	}

}
