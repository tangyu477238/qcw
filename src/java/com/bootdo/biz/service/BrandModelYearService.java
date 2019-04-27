package com.bootdo.biz.service;

import com.bootdo.biz.domain.BrandModelYearDO;

import java.util.List;
import java.util.Map;

/**
 * 汽车年份; InnoDB free: 10240 kB
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-04-03 23:03:59
 */
public interface BrandModelYearService {

    BrandModelYearDO getBrandModelYear(Map<String, Object> map);

//	BrandModelYearDO get(Long id);
//
	List<BrandModelYearDO> list(Map<String, Object> map);
//
//	int count(Map<String, Object> map);
//
	int save(BrandModelYearDO brandModelYear);
//
//	int update(BrandModelYearDO brandModelYear);
//
//	int remove(Long id);
//
//	int batchRemove(Long[] ids);
}
