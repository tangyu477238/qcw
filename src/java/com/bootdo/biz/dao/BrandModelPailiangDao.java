package com.bootdo.biz.dao;

import com.bootdo.biz.domain.BrandModelPailiangDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 汽车排量; InnoDB free: 10240 kB
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2019-04-03 23:03:56
 */
@Mapper
public interface BrandModelPailiangDao {

    BrandModelPailiangDO getBrandModelPailiang(Map<String, Object> map);

//	BrandModelPailiangDO get(Long id);
//
	List<BrandModelPailiangDO> list(Map<String, Object> map);
//
//	int count(Map<String, Object> map);

	int save(BrandModelPailiangDO brandModelPailiang);

//	int update(BrandModelPailiangDO brandModelPailiang);
//
//	int remove(Long id);
//
//	int batchRemove(Long[] ids);
}
