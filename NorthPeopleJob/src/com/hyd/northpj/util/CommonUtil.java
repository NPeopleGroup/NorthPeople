package com.hyd.northpj.util;

import java.lang.reflect.Field;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.hyd.northpj.entity.User;
import com.hyd.northpj.service.impl.UserService;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

public class CommonUtil {

	/**
	 * ���ݴ�����б����б��ڵ�����ת��Ϊjson���ݷ��ص�ǰ̨
	 * @param list
	 * @param total
	 * @throws Exception
	 */
	public static void toBeJson(List list, int total) throws Exception {
		JsonConfig myJsonConfig = new JsonConfig();
//		myJsonConfig.setJsonPropertyFilter(new PropertyFilter() {
//
//			@Override
//			public boolean apply(Object source, String name, Object value) {
//				// TODO Auto-generated method stub
//				if (name.equals("users"))
//					return true;
//				else
//					return false;
//			}
//		});
		HttpServletResponse myResponse = ServletActionContext.getResponse();
		JSONObject myJsonObject = new JSONObject();
		myJsonObject.accumulate("total", total, myJsonConfig);
		myJsonObject.accumulate("rows", list, myJsonConfig);
		myResponse.setCharacterEncoding("UTF-8");
		myResponse.getWriter().write(myJsonObject.toString());
	}


	/**
	 * ���������ڱ���ʵ�н�����ַ�������ת��Ϊjson���ͷ��ص�ǰ̨ 
	 * @param result
	 * @throws Exception
	 */
	public static void toBeJsonResult(String result) throws Exception {
		JsonConfig myJsonConfig = new JsonConfig();
		HttpServletResponse myResponse = ServletActionContext.getResponse();
		JSONObject myJsonObject = new JSONObject();
		myJsonObject.accumulate("result", result, myJsonConfig);
		myResponse.setCharacterEncoding("UTF-8");
		myResponse.getWriter().write(myJsonObject.toString());
	}
	
	
	public static int construcUserInfo(User myUser,List<Relations> myRelationList,UserService myUserService,String username) throws Exception {
		copyProperty(myUser,myUserService.getInformation(username));
		if(myUser.getRelation1()!=null)
			myRelationList.add(new Relations(myUser.getRelation1(), myUser.getRelationName1(), myUser.getRelationIDCard1(), myUser.getRelationdegree1()));
		if(myUser.getRelation2()!=null)
			myRelationList.add(new Relations(myUser.getRelation2(), myUser.getRelationName2(), myUser.getRelationIDCard2(), myUser.getRelationdegree2()));
		if(myUser.getRelation3()!=null)
			myRelationList.add(new Relations(myUser.getRelation3(), myUser.getRelationName3(), myUser.getRelationIDCard3(), myUser.getRelationdegree3()));
		if(myUser.getRelation4()!=null)
			myRelationList.add(new Relations(myUser.getRelation4(), myUser.getRelationName4(), myUser.getRelationIDCard4(), myUser.getRelationdegree4()));
		if(myUser.getRelation5()!=null)
			myRelationList.add(new Relations(myUser.getRelation5(), myUser.getRelationName5(), myUser.getRelationIDCard5(), myUser.getRelationdegree5()));
		if(myUser.getRelation6()!=null)
			myRelationList.add(new Relations(myUser.getRelation6(), myUser.getRelationName6(), myUser.getRelationIDCard6(), myUser.getRelationdegree6()));
		return 1;
	}
	
	private static void copyProperty(User oldUser, User newUser)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {
		// �µ�class
		Class newClass = newUser.getClass();
		// �ϵ�class
		Class oldClass = oldUser.getClass();
		// �������е�����
		Field[] newFields = newClass.getDeclaredFields();
		// �µ�����
		Field newField = null;
		// �ϵ�����
		Field oldField = null;
		for (Field f : newFields) {
			// ���е���������
			String fieldName = f.getName();
			// ͨ���������ƻ�ȡ����
			newField = newClass.getDeclaredField(fieldName);
			// ��ȡ���Ե�ֵʱ��Ҫ����Ϊ true ��ָʾ����Ķ�����ʹ��ʱӦ��ȡ�� Java ���Է��ʼ�顣
			// ֵΪ false ��ָʾ����Ķ���Ӧ��ʵʩ Java ���Է��ʼ�顣
			newField.setAccessible(true);
			// �������Ի�ȡ�����ϵ�ֵ
			Object newObject = newField.get(newUser);
			oldField = oldClass.getDeclaredField(fieldName);
			oldField.setAccessible(true);
			oldField.set(oldUser, newObject);
		}
	}
}
