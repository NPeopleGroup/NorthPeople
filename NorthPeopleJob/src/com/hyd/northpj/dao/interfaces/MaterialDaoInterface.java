package com.hyd.northpj.dao.interfaces;

import java.util.List;

import com.hyd.northpj.entity.Material;

public interface MaterialDaoInterface {

	/**
	 * ����������Ϣ
	 * @param materialInfo
	 * @return �ɹ�����0�����򷵻�1
	 * @throws Exception
	 */
	public int addNewMaterial(Material materialInfo) throws Exception;
	
	/**
	 * ɾ�����в�����Ϣ
	 * @param materialName
	 * @return �ɹ�����0�����򷵻�1
	 * @throws Exception
	 */
	public int deleteMaterial(int materialId) throws Exception;
	
	/**
	 * ��ȡ�����б�
	 * @return
	 */
	public List<Material> getMaterialList();
}
