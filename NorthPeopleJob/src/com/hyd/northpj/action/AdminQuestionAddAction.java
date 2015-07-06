package com.hyd.northpj.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.hyd.northpj.entity.Question;
import com.hyd.northpj.service.impl.QuestionService;

public class AdminQuestionAddAction extends ModelAction<Question> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8604571401832028374L;
	private Question question = new Question();

	public Question getModel() {
		return question;
	}

	private File image; // �ϴ����ļ�
	private String imageContentType; // �ļ�����

	public String execute() throws Exception {

		try {

			if (image != null) {
				String realpath = ServletActionContext.getServletContext()
						.getRealPath("/img");
				File savefile = new File(new File(realpath), "question-"
						+ question.getId() + ".png");
				if (!savefile.getParentFile().exists())
					savefile.getParentFile().mkdirs();
				FileUtils.copyFile(image, savefile);

			}

			QuestionService questionService = new QuestionService();

			if (0 == questionService.addQuestion(question)) {

				return SUCCESS;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return INPUT;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}
}
