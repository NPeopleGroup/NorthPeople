package com.hyd.northpj.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hyd.northpj.dao.impl.MaterialDao;
import com.hyd.northpj.entity.Material;
import com.hyd.northpj.service.interfaces.MaterialServiceInterface;
import com.hyd.northpj.util.HibernateSessionFactory;
import com.hyd.northpj.util.ValidateUtil;

public class MaterialService implements MaterialServiceInterface {

	private MaterialDao myMaterialDao=new MaterialDao();
	private Session session = HibernateSessionFactory.getSession();
	private Transaction tx = session.beginTransaction();
	private Query query;
	
	@Override
	public int addMaterial(Material materialInfo) throws Exception {
		// TODO Auto-generated method stub
		
		//对materialInfo进行校验
		if(ValidateUtil.validateMaterialAllProperty(materialInfo)!=0){
			return 1;
		};
		return myMaterialDao.addNewMaterial(materialInfo)==0?0:2;
	}

	@Override
	public int deleteMaterial(int materialId) throws Exception {
		// TODO Auto-generated method stub
		String deleteStatement="delete from Material as p where p.sn=?";
		query=session.createQuery(deleteStatement);
		query.setInteger(0, materialId);
		query.executeUpdate();
		tx.commit();
		return 0;
	}

	@Override
	public List<Material> getMaterialList() throws Exception {
		// TODO Auto-generated method stub
		String sqlStatement="from Material";
		query=session.createQuery(sqlStatement);
		List<Material> myMaterialList=query.list();
		return myMaterialList;
	}

}
