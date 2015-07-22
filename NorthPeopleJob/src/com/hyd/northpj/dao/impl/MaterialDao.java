package com.hyd.northpj.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hyd.northpj.dao.interfaces.MaterialDaoInterface;
import com.hyd.northpj.entity.Material;
import com.hyd.northpj.util.HibernateSessionFactory;

public class MaterialDao implements MaterialDaoInterface {


	@Override
	public int addNewMaterial(Material materialInfo) throws Exception {
		// TODO Auto-generated method stub
		
		Session mySession=null;
		Transaction tx=null;
		Query myQuery=null;
		try{
			mySession=HibernateSessionFactory.getSession();
			tx=mySession.beginTransaction();
			myQuery = mySession.createQuery("from Material as p where p.name=?");
			myQuery.setString(0, materialInfo.getName());
			@SuppressWarnings("unchecked")
			List<Material> list = myQuery.list();
			for (Material Answer : list) {
				mySession.delete(Answer);
			}

			mySession.save(materialInfo);
			tx.commit();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			if(mySession!=null)
			{
				mySession.close();
			}
		}	
		return 0;
	}

	@Override
	public int deleteMaterial(int materialId) throws Exception {
		// TODO Auto-generated method stub
		
		Session mySession=null;
		Transaction tx=null;
		Query myQuery=null;
		try{
			mySession=HibernateSessionFactory.getSession();
			tx=mySession.beginTransaction();
			String deleteSql = "delete from Material where sn=?";
			myQuery = mySession.createQuery(deleteSql);
			myQuery.setInteger(0, materialId);
			myQuery.executeUpdate();
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(mySession!=null)
			{
				mySession.close();
			}
		}
		return 0;
	}

	@Override
	public List<Material> getMaterialList() {
		// TODO Auto-generated method stub
		Session mySession=null;
		Query myQuery=null;
		String sqlStatement = "from Material";
		List<Material> myMaterialList=null;
		try{
			mySession=HibernateSessionFactory.getSession();
			myQuery = mySession.createQuery(sqlStatement);
			myMaterialList = myQuery.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(mySession!=null)
			{
				mySession.close();
			}
		}
		return myMaterialList;
	}

	@Override
	public Material getMaterialInfo(int materialId) throws Exception {
		// TODO Auto-generated method stub
		
		Session mySession=null;
		String sqlStatement = "from Material where sn=" + materialId;
		Material queryResult=null;
		try{
			mySession=HibernateSessionFactory.getSession();
			queryResult = (Material) mySession.createQuery(sqlStatement).uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(mySession!=null)
			{
				mySession.close();
			}
		}
		return queryResult;
	}

}
