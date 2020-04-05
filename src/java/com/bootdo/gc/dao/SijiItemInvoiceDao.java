package com.bootdo.gc.dao;

import com.bootdo.gc.domain.SijiItemAminvoiceDO;
import com.bootdo.gc.domain.SijiItemInvoiceDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 *
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-06-02 12:28:23
 */
@Mapper
public interface SijiItemInvoiceDao {

	SijiItemInvoiceDO get(Long id);

	SijiItemInvoiceDO getItemDo(Long id);


	List<SijiItemInvoiceDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int getMaxId(Long id);

	int save(SijiItemInvoiceDO sijiItem);

	int update(SijiItemInvoiceDO sijiItem);

	int updateState(SijiItemInvoiceDO sijiItem);

	int updateLastState(int id);

	int remove(Long id);

	int batchRemove(Long[] ids);



	List<Map> querySijiList(Map<String, Object> map);

	int querySijiListCount(Map<String, Object> map);

	int heDui(Long id);


	List<SijiItemInvoiceDO> getInvoiceList(Map<String, Object> map);

	List<SijiItemInvoiceDO> getBilldateList(Map<String, Object> map);


	List<SijiItemInvoiceDO> getAminvoicefoById(Map<String, Object> map);


	List<Map> querySijiArray(Map<String, Object> map);


}
