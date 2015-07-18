package com.hyd.northpj.action;

import com.hyd.northpj.entity.Answer;
import com.hyd.northpj.entity.Question;
import com.hyd.northpj.service.impl.AnswerService;
import com.hyd.northpj.service.impl.QuestionService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AnswerQuestionPageSubmitAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1344904021439220859L;
	private String from;
	private String id;
	private String type;

	private String option;
	private Question question;

	@Override
	public String execute() throws Exception {

		QuestionService questionService = new QuestionService();

		if (from == null && id == null && type == null && option == null) {

			question = questionService.getFirstQuestionByType("age");
			setFrom("begin");
			setId(question.getId());
			setType("age");
			return SUCCESS;

		} else if (from != null && id != null && type != null
				&& option.substring(2, option.length()).equals("end")) {

			String answerQuestionResult = answerThisQuestion(questionService);
			if (answerQuestionResult != null) {
				return answerQuestionResult;
			}

			type = questionService.changeQuestionTypeToChinese(type);
			if (type.equals("守法诚信")) {
				AnswerService answerService = new AnswerService();
				if (answerService.getUnFinishedType().equals("")) {
					return "end";
				}else{
					return "begin";
				}
			} else {
				type = questionService.getNextQuestionType(type);
				type = questionService.changeQuestionTypeToEnglish(type);

				question = questionService.getFirstQuestionByType(type);

				while (question == null) {

					type = questionService.changeQuestionTypeToChinese(type);

					if (!type.equals("守法诚信")) {
						type = questionService.getNextQuestionType(type);
						type = questionService
								.changeQuestionTypeToEnglish(type);
						question = questionService.getFirstQuestionByType(type);
					}

					if (type.equals("守法诚信") && question == null) {
						AnswerService answerService = new AnswerService();
						if (answerService.getUnFinishedType().equals("")) {
							return "end";
						}else{
							return "begin";
						}
					}
				}
			}
			setFrom(getId());
			id = question.getId();
			setType(questionService.changeQuestionTypeToEnglish(questionService
					.getQuestion(getId()).getType()));
			return SUCCESS;
		} else if (from == null && id == null && type != null && option == null) {

			question = questionService.getFirstQuestionByType(type);

			while (question == null) {

				if (!type.equals("守法诚信")) {
					type = questionService.getNextQuestionType(type);
					question = questionService.getFirstQuestionByType(type);
				}

				if (type.equals("守法诚信") && question == null) {
					AnswerService answerService = new AnswerService();
					if (answerService.getUnFinishedType().equals("")) {
						return "end";
					}else{
						return "begin";
					}
				}
			}
			setFrom(getId());
			id = question.getId();
			setType(questionService.changeQuestionTypeToEnglish(questionService
					.getQuestion(getId()).getType()));
			return SUCCESS;
		}

		else {

			String answerQuestionResult = answerThisQuestion(questionService);
			if (answerQuestionResult != null) {
				return answerQuestionResult;
			}

			prepareNextQuestion(questionService);
			return SUCCESS;
		}

	}

	private String answerThisQuestion(QuestionService questionService)
			throws Exception {
		AnswerService answerService = new AnswerService();

		question = questionService.getQuestion(id);
		if (question == null) {
			return "input";
		}
		if (question.getIsFirst() != null) {
			if (question.getIsFirst().equals("on")) {
				try {
					answerService.deleteQuestionByPeopleAndType(
							ActionContext.getContext().getSession()
									.get("NorthPeopleJob_username").toString(),
							question.getType());
				} catch (Exception e) {
					return "overtime";
				}
			}
		}

		Answer answer = new Answer();
		answer.setQuestionId(id);
		try {

			answer.setUsername(ActionContext.getContext().getSession()
					.get("NorthPeopleJob_username").toString());

		} catch (Exception e) {
			return "overtime";
		}
		answer.setAnswer(option.substring(0, 1));
		answer.setQuestionSn(question.getSn());
		answer.setQuestionType(question.getType());
		answer.setQuestionQuestion(question.getQuestion());
		answer.setQuestionFrom(from);
		if (option.substring(0, 1).equals("A")) {
			answer.setQuestionChoice(question.getChoiceA());
			answer.setQuestionGoto(question.getGotoA());
			answer.setQuestionScore(question.getScoreA());
			answer.setQuestionObjective(question.getObjectiveA());
			answer.setQuestionFile(question.getFileA());
			answer.setQuestionDepartment(question.getDepartmentA());
			answer.setQuestionHint(question.getHintA());
		}
		if (option.substring(0, 1).equals("B")) {
			answer.setQuestionChoice(question.getChoiceB());
			answer.setQuestionGoto(question.getGotoB());
			answer.setQuestionScore(question.getScoreB());
			answer.setQuestionObjective(question.getObjectiveB());
			answer.setQuestionFile(question.getFileB());
			answer.setQuestionDepartment(question.getDepartmentB());
			answer.setQuestionHint(question.getHintB());
		}
		if (option.substring(0, 1).equals("C")) {
			answer.setQuestionChoice(question.getChoiceC());
			answer.setQuestionGoto(question.getGotoC());
			answer.setQuestionScore(question.getScoreC());
			answer.setQuestionObjective(question.getObjectiveC());
			answer.setQuestionFile(question.getFileC());
			answer.setQuestionDepartment(question.getDepartmentC());
			answer.setQuestionHint(question.getHintC());
		}
		if (option.substring(0, 1).equals("D")) {
			answer.setQuestionChoice(question.getChoiceD());
			answer.setQuestionGoto(question.getGotoD());
			answer.setQuestionScore(question.getScoreD());
			answer.setQuestionObjective(question.getObjectiveD());
			answer.setQuestionFile(question.getFileD());
			answer.setQuestionDepartment(question.getDepartmentD());
			answer.setQuestionHint(question.getHintD());
		}
		if (option.substring(0, 1).equals("E")) {
			answer.setQuestionChoice(question.getChoiceE());
			answer.setQuestionGoto(question.getGotoE());
			answer.setQuestionScore(question.getScoreE());
			answer.setQuestionObjective(question.getObjectiveE());
			answer.setQuestionFile(question.getFileE());
			answer.setQuestionDepartment(question.getDepartmentE());
			answer.setQuestionHint(question.getHintE());
		}
		if (option.substring(0, 1).equals("F")) {
			answer.setQuestionChoice(question.getChoiceF());
			answer.setQuestionGoto(question.getGotoF());
			answer.setQuestionScore(question.getScoreF());
			answer.setQuestionObjective(question.getObjectiveF());
			answer.setQuestionFile(question.getFileF());
			answer.setQuestionDepartment(question.getDepartmentF());
			answer.setQuestionHint(question.getHintF());
		}

		answerService.answerQuestion(answer);
		return null;
	}

	private void prepareNextQuestion(QuestionService questionService)
			throws Exception {
		setFrom(getId());
		setId(option.substring(2, option.length()));
		setType(questionService.changeQuestionTypeToEnglish(questionService
				.getQuestion(getId()).getType()));
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

}
