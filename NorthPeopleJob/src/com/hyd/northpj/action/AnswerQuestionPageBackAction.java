package com.hyd.northpj.action;

import com.hyd.northpj.entity.Answer;
import com.hyd.northpj.service.impl.AnswerService;
import com.hyd.northpj.service.impl.QuestionService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AnswerQuestionPageBackAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String from;
	private String id;
	private String type;

	public String execute() throws Exception {
		AnswerService answerService = new AnswerService();
		QuestionService questionService = new QuestionService();
		Answer answer = new Answer();

		if (!(from.equals("") || from.equals("begin") || from == null) && id != null
				&& type != null) {
			try {
				answerService.deleteQuestionByPeopleAndQuestionId(
						ActionContext.getContext().getSession()
								.get("NorthPeopleJob_username").toString(),
						getId());

				answer = answerService.getAnswer(
						ActionContext.getContext().getSession()
								.get("NorthPeopleJob_username").toString(),
						getFrom());

			} catch (Exception e) {
				return "overtime";
			}

			setId(getFrom());
			setFrom(answer.getQuestionFrom());
			setType(questionService.changeQuestionTypeToEnglish(answer
					.getQuestionType()));
			return SUCCESS;
		} else {

			setId(null);
			setFrom(null);
			setType(null);
			return "input";
		}
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
