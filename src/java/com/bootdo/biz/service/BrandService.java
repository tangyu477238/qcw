package com.bootdo.biz.service;

import com.bootdo.biz.domain.BrandDO;

import java.util.List;
import java.util.Map;

/**
 * InnoDB free: 10240 kB
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-03-26 23:04:52
 */
public interface BrandService {

	BrandDO getBrand(Map<String, Object> map);

	BrandDO get(Long id);

	List<BrandDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(BrandDO brand);
//
//	int update(BrandDO brand);
//
//	int remove(Long id);
//
//	int batchRemove(Long[] ids);
}
