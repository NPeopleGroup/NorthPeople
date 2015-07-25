package com.hyd.northpj.action;

import com.hyd.northpj.entity.User;
import com.hyd.northpj.service.impl.UserService;
import com.hyd.northpj.util.PrintDataToAjax;

public class ChangePasswordAction extends ModelAction<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3757014914864064554L;
	private User userNew = new User();
	private String newPassword;

	public User getModel() {
		return userNew;
	}

	public String execute() throws Exception {
		PrintDataToAjax PrintDataToAjax = new PrintDataToAjax();
		System.out.println(userNew.toString());
		System.out.println(newPassword);
		try {
		
			UserService userService = new UserService();
			
			
				if (0 == userService.changePassword(userNew, newPassword)) {

					if (0 == PrintDataToAjax.print(SUCCESS)) {
						return SUCCESS;
				}
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		PrintDataToAjax.print(INPUT);
		return INPUT;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}
