package com.hyd.northpj.service.interfaces;

import java.util.List;

import com.hyd.northpj.entity.Material;

/**
 * @author Search
 *
 */
public interface MaterialServiceInterface {
	
	/**
	 * �����Ӳ���
	 * @return �ɹ�����0�����򷵻ط�0
	 * @throws Exception
	 */
	public int addMaterial(Material materialInfo) throws Exception;
	
	
	/** ɾ�����в���
	 * @param materialName
	 * @return �ɹ�����0��δͨ��У�鷵��1������ʧ�ܷ���2
	 * @throws Exception
	 */
	public int deleteMaterial(int materialId) throws Exception;
	
	/** ��ѯ���в���
	 * @return �����б�
	 * @throws Exception
	 */
	public List<Material> getMaterialList() throws Exception;
	
	
	public Material getMaterialInfo(int materialId) throws Exception;

}
