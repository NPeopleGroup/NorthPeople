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
			myLogger.error("读取数据库问题列表出现错误！");
		}
		return myQuestionList;
	}

	@Override
	public List<Question> getQuestionList(String questionType) throws Exception {
		// TODO Auto-generated method stub
		List<Question> myQuestionList = null;
		myQuestionList = myQuestionDao.selectQuestionList(questionType);
		if (myQuestionList == null) {
			myLogger.error("读取数据库问题列表出现错误！");
		}
		return myQuestionList;
	}

	@Override
	public int addQuestion(Question question) throws Exception {
		// TODO Auto-generated method stub
		if (ValidateUtil.validateQuestionId(question) != 0) {
			myLogger.error("要增添的实例,questionId通过验证！");
			return 1;
		}
		if (myQuestionDao.insertQuestion(question) != 0) {
			myLogger.error("增添question实例操作出现错误！-->questionInfo:"
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
			myLogger.error("要查询的实例,questionId通过验证！--->questionId:" + id);
			return null;
		}
		return myQuestionDao.selectQuestion(id);
	}

	@Override
	public Question getQuestionByType(String id, String type) throws Exception {
		System.out.println("getQuestionByType:" + id + "--" + type);
		Question question = new Question();

		if (!ValidateUtil.isPassSqlFilter(id)) {
			myLogger.error("要查询的实例,questionId通过验证！--->questionId:" + id);
			return null;
		}
		if (!ValidateUtil.isPassSqlFilter(type)) {
			myLogger.error("要查询的实例,questionType通过验证！--->questionType:" + type);
			return null;
		}

		if (id == null && type == null) {
			question = myQuestionDao.selectFirstQuestionByType("年龄");// 开始答题

			while (question == null) {
				question = myQuestionDao
						.selectFirstQuestionByType(getNextQuestionType(changeQuestionTypeToChinese(type)));
			}

			return question;

		} else if ((id.equals("end") || id == null)
				&& !type.equals(changeQuestionTypeToEnglish("守法诚信"))) {
			System.out.println(changeQuestionTypeToEnglish("守法诚信"));
			System.out.println(1);
			System.out.println(type);
			type = getNextQuestionType(changeQuestionTypeToChinese(type));
			System.out.println(type);
			question = myQuestionDao.selectFirstQuestionByType(type);// 正常跳转下一部分

			while (question == null) {
				System.out.println(2);
				System.out.println(type);
				if (!type.equals("守法诚信")) {
					type = getNextQuestionType(type);
				}
				System.out.println(type);

				question = myQuestionDao.selectFirstQuestionByType(type);
				if (type.equals("守法诚信") && question == null) {
					System.out.println(3);
					return null;
				}
			}

			return question;
		} else if ((id.equals("end") || id == null)
				&& type.equals(changeQuestionTypeToEnglish("守法诚信"))) {// 答题结束
			System.out.println(4);
			return null;

		}
		// TODO Auto-generated method stub
		else {
			return myQuestionDao.selectQuestion(id);// 正常答题
		}
	}

	@Override
	public int setQuestion(Question question) throws Exception {
		// TODO Auto-generated method stub
		// TODO 这里有private 属性的问题 暂时先注释掉
		// if (ValidateUtil.validateQuestionAllProperty(question) != 0) {
		// myLogger.error("要修改的实例属性通过验证！--->question:" + question.toString());
		// return 1;
		// }
		int updateResult = myQuestionDao.updateQuestion(question);
		if (updateResult != 0) {
			myLogger.error("要修改的实例信息出现错误！");
		}
		return updateResult;
	}

	@Override
	public int deleteQuestion(String id) throws Exception {
		// TODO Auto-generated method stub
		if (!ValidateUtil.isPassSqlFilter(id)) {
			myLogger.error("要增添的实例,questionId通过验证！");
			return 1;
		}
		int deleteResult = myQuestionDao.deleteQuestion(id);
		if (deleteResult != 0) {
			myLogger.error("删除实例信息时出现错误！--->questionId:" + id);
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
			questionTypeChinese = "年龄";
			break;
		case "education":
			questionTypeChinese = "教育";
			break;
		case "skills_title":
			questionTypeChinese = "技能(职称)";
			break;
		case "skills_qualifications":
			questionTypeChinese = "技能(职业资格)";
			break;
		case "housing":
			questionTypeChinese = "住房";
			break;
		case "security":
			questionTypeChinese = "社保";
			break;
		case "settled_area":
			questionTypeChinese = "落户地区";
			break;
		case "career":
			questionTypeChinese = "职业";
			break;
		case "investment_tax":
			questionTypeChinese = "投资纳税";
			break;
		case "awards_honor":
			questionTypeChinese = "奖项荣誉";
			break;
		case "marital_status":
			questionTypeChinese = "婚姻状况";
			break;
		case "working_years":
			questionTypeChinese = "工作年限";
			break;
		case "law_integrity":
			questionTypeChinese = "守法诚信";
			break;

		default:
			questionTypeChinese = "年龄";
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
		case "年龄":
			questionTypeEnglish = "age";
			break;
		case "教育":
			questionTypeEnglish = "education";
			break;
		case "技能(职称)":
			questionTypeEnglish = "skills_title";
			break;
		case "技能(职业资格)":
			questionTypeEnglish = "skills_qualifications";
			break;
		case "住房":
			questionTypeEnglish = "housing";
			break;
		case "社保":
			questionTypeEnglish = "security";
			break;
		case "落户地区":
			questionTypeEnglish = "settled_area";
			break;
		case "职业":
			questionTypeEnglish = "career";
			break;
		case "投资纳税":
			questionTypeEnglish = "investment_tax";
			break;
		case "奖项荣誉":
			questionTypeEnglish = "awards_honor";
			break;
		case "婚姻状况":
			questionTypeEnglish = "marital_status";
			break;
		case "工作年限":
			questionTypeEnglish = "working_years";
			break;
		case "守法诚信":
			questionTypeEnglish = "law_integrity";
			break;

		default:
			questionTypeEnglish = "年龄";
			break;
		}

		return questionTypeEnglish;
	}

	@Override
	public String getNextQuestionType(String questionType) throws Exception {
		// TODO Auto-generated method stub
		String nextQuestionType;
		switch (questionType) {
		case "年龄":
			nextQuestionType = "教育";
			break;
		case "教育":
			nextQuestionType = "技能(职称)";
			break;
		case "技能(职称)":
			nextQuestionType = "技能(职业资格)";
			break;
		case "技能(职业资格)":
			nextQuestionType = "住房";
			break;
		case "住房":
			nextQuestionType = "社保";
			break;
		case "社保":
			nextQuestionType = "落户地区";
			break;
		case "落户地区":
			nextQuestionType = "职业";
			break;
		case "职业":
			nextQuestionType = "投资纳税";
			break;
		case "投资纳税":
			nextQuestionType = "奖项荣誉";
			break;
		case "奖项荣誉":
			nextQuestionType = "婚姻状况";
			break;
		case "婚姻状况":
			nextQuestionType = "工作年限";
			break;
		case "工作年限":
			nextQuestionType = "守法诚信";
			break;
		case "守法诚信":
			nextQuestionType = "年龄";
			break;

		default:
			nextQuestionType = "年龄";
			break;
		}

		return nextQuestionType;
	}

}
