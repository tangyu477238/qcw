package com.bootdo.biz.service.impl;

import com.bootdo.biz.domain.MonthTicketUserDO;
import com.bootdo.biz.service.MonthTicketUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

import com.bootdo.biz.dao.SellerInfoDao;
import com.bootdo.biz.domain.SellerInfoDO;
import com.bootdo.biz.service.SellerInfoService;



@Service
public class SellerInfoServiceImpl implements SellerInfoService {
	@Autowired
	private SellerInfoDao sellerInfoDao;

	@Autowired
	private MonthTicketUserService monthTicketUserService;

	@Override
	public SellerInfoDO getByCardNo(String cardNo) {
		Map map = new HashMap();
		map.put("cardNo", cardNo);
		List<SellerInfoDO> lists = this.list(map);
		if (lists.isEmpty()){
			return null;
		}
		return lists.get(0);
	}

	@Override
	public SellerInfoDO get(String sellerId){
		return sellerInfoDao.get(sellerId);
	}
	
	@Override
	public List<SellerInfoDO> list(Map<String, Object> map){
		return sellerInfoDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sellerInfoDao.count(map);
	}
	
	@Override
	public int save(SellerInfoDO sellerInfo){

		SellerInfoDO lists = this.getByCardNo(sellerInfo.getCardNo());
		if (lists!=null){
			return 0;
		}
		sellerInfo.setSellerId(UUID.randomUUID().toString().replace("-",""));
		sellerInfo.setUsername(UUID.randomUUID().toString().replace("-",""));
		sellerInfo.setPassword(UUID.randomUUID().toString().replace("-",""));
		sellerInfo.setOpenid(UUID.randomUUID().toString().replace("-",""));
		sellerInfo.setCreateTime(new Date());
		sellerInfo.setUpdateTime(new Date());


		MonthTicketUserDO monthTicketUserDO = new MonthTicketUserDO();
		monthTicketUserDO.setOrderNo(sellerInfo.getCardNo());
		monthTicketUserDO.setCreateTime(new Date());
		monthTicketUserDO.setUpdateTime(new Date());
		monthTicketUserDO.setCreateUser(sellerInfo.getSellerId());
		monthTicketUserDO.setPrice(sellerInfo.getAmount());
		monthTicketUserDO.setPtypeName(sellerInfo.getCardType());
		monthTicketUserDO.setRemark("1");
		monthTicketUserService.save(monthTicketUserDO);

		return sellerInfoDao.save(sellerInfo);
	}
	
	@Override
	public int update(SellerInfoDO sellerInfo){
		return sellerInfoDao.update(sellerInfo);
	}

	@Override
	public int chongzhi(SellerInfoDO sellerInfo) {

		SellerInfoDO seller = getByCardNo(sellerInfo.getCardNo());
		MonthTicketUserDO monthTicketUserDO = new MonthTicketUserDO();
		monthTicketUserDO.setOrderNo(seller.getCardNo());
		monthTicketUserDO.setCreateTime(new Date());
		monthTicketUserDO.setUpdateTime(new Date());
		monthTicketUserDO.setCreateUser(seller.getSellerId());
		monthTicketUserDO.setPrice(sellerInfo.getCzje());
		monthTicketUserDO.setPtypeName(seller.getCardType());
		monthTicketUserDO.setRemark("1");
		monthTicketUserService.save(monthTicketUserDO);

		return sellerInfoDao.chongzhi(sellerInfo);
	}

	@Override
	public int remove(String sellerId){
		return sellerInfoDao.remove(sellerId);
	}
	
	@Override
	public int batchRemove(String[] sellerIds){
		return sellerInfoDao.batchRemove(sellerIds);
	}
	
}
