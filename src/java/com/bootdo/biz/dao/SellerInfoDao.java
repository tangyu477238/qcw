package com.bootdo.biz.dao;

import com.bootdo.biz.domain.SellerInfoDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 人员信息表
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2021-05-27 06:32:46
 */
@Mapper
public interface SellerInfoDao {

	SellerInfoDO get(String sellerId);
	
	List<SellerInfoDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SellerInfoDO sellerInfo);
	
	int update(SellerInfoDO sellerInfo);
	
	int remove(String seller_id);
	
	int batchRemove(String[] sellerIds);

	int chongzhi(SellerInfoDO sellerInfo);
}
