package com.bootdo.biz.service;

import com.bootdo.biz.domain.SellerInfoDO;

import java.util.List;
import java.util.Map;

/**
 * 人员信息表
 * 
 * @author tzy
 * @email tangzhiyu@vld-tech.com
 * @date 2021-05-27 06:32:46
 */
public interface SellerInfoService {
	
	SellerInfoDO get(String sellerId);
	
	List<SellerInfoDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SellerInfoDO sellerInfo);
	
	int update(SellerInfoDO sellerInfo);
	
	int remove(String sellerId);
	
	int batchRemove(String[] sellerIds);

	SellerInfoDO getByCardNo(String cardNo);

	int chongzhi(SellerInfoDO sellerInfo);
}
