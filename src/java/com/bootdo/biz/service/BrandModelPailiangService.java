package com.bootdo.biz.service;

import com.bootdo.biz.domain.BrandModelPailiangDO;

import java.util.List;
import java.util.Map;

/**
 * 汽车排量; InnoDB free: 10240 kB
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-04-03 23:03:56
 */
public interface BrandModelPailiangService {

    BrandModelPailiangDO getBrandModelPailiang(Map<String, Object> map);


//	BrandModelPailiangDO get(Long id);
//
	List<BrandModelPailiangDO> list(Map<String, Object> map);
//
//	int count(Map<String, Object> map);
//
	int save(BrandModelPailiangDO brandModelPailiang);
//
//	int update(BrandModelPailiangDO brandModelPailiang);
//
//	int remove(Long id);
//
//	int batchRemove(Long[] ids);
}
