package com.hyd.northpj.action;

import com.hyd.northpj.entity.User;
import com.hyd.northpj.service.impl.UserService;
import com.hyd.northpj.util.PrintDataToAjax;

public class RegisterAction extends ModelAction<User> {

	/**
	 * �û�ע��
	 */
	private static final long serialVersionUID = -8081117062425041492L;

	private User user = new User();

	public User getModel() {
		return user;
	}

	public String execute() throws Exception {
		PrintDataToAjax PrintDataToAjax = new PrintDataToAjax();
		try {
			UserService userService = new UserService();

			if (0 == userService.register(user)) {

				if (0 == PrintDataToAjax.print(SUCCESS)) {
					request.getSession().setMaxInactiveInterval(3600);
					request.getSession().setAttribute(
							"NorthPeopleJob_username", user.getUsername());
					return SUCCESS;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		PrintDataToAjax.print(INPUT);
		return INPUT;
	}
}
