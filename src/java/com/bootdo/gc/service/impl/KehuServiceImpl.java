package com.bootdo.gc.service.impl;

import com.bootdo.common.utils.DateUtils;
import com.bootdo.gc.dao.KehuDao;
import com.bootdo.gc.domain.FukuanDo;
import com.bootdo.gc.domain.KehuDO;
import com.bootdo.gc.domain.SijiDO;
import com.bootdo.gc.domain.SijiItemDO;
import com.bootdo.gc.service.KehuService;
import com.bootdo.gc.service.SijiItemService;
import com.bootdo.gc.service.SijiService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service
public class KehuServiceImpl implements KehuService {
	@Autowired
	private KehuDao kehuDao;

	@Autowired
	private SijiItemService sijiItemService;


	@Autowired
	private SijiService sijiService;
	
	@Override
	public KehuDO get(Long id){
		return kehuDao.get(id);
	}

	@Override
	public KehuDO getOrder(String orderNo){

		//存在此单直接返回
		KehuDO kehu = kehuDao.getOrder(orderNo);
		if (kehu!=null) {
			return kehu;
		}

		KehuDO kehuDO = new KehuDO();
		SijiDO sijiDO = sijiService.getOrder(orderNo);
		if (sijiDO==null) {
			kehuDO.setOrderNo(orderNo);
			return kehuDO;
		}
		kehuDO.setBizdate(sijiDO.getBizdate());
		kehuDO.setCarnum(sijiDO.getCarnum());
		kehuDO.setForwunit(sijiDO.getForwunit());
		kehuDO.setStation(sijiDO.getArrivstation());
		kehuDO.setKpid(sijiDO.getPid());
		kehuDO.setPayer(sijiDO.getInforfee());
		Map map = new HashMap();
		map.put("pid",sijiDO.getPid());
		kehuDO.setTonnage(new BigDecimal(0));
		List<SijiItemDO> list = sijiItemService.list(map);
		for (SijiItemDO sijiItemDO : list){
			kehuDO.setTonnage(kehuDO.getTonnage().add(sijiItemDO.getTonnage())); //吨位
		}


		try {
			if (kehuDO.getTonnage()!=null){
				kehuDO.setSettletonnage(kehuDO.getTonnage().setScale(1, BigDecimal.ROUND_DOWN)); //结算吨位
			}

			kehuDO.setTonnage(kehuDO.getSettletonnage()); //吨位

			//kehuDO.setAdjusttonnage(sijiDO.getTonnage()); //调整吨位
		} catch (Exception e){

		}



		return kehuDO;
	}

	
	@Override
	public List<KehuDO> list(Map<String, Object> map){
		return kehuDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return kehuDao.count(map);
	}
	
	@Override
	public int save(KehuDO kehu){
		return kehuDao.save(kehu);
	}
	
	@Override
	public int update(KehuDO kehu){
		return kehuDao.update(kehu);
	}
	
	@Override
	public int remove(Long id){

		KehuDO kehuDO = kehuDao.get(id);
		boolean flag = "有".equals(kehuDO.getReceipt())||"预有".equals(kehuDO.getReceipt());
		if (flag && !DateUtils.getNowDate().equals(kehuDO.getReceiptdate())) {
			return 0;
		} else {
			return kehuDao.remove(id);
		}
	}

	@Override
	public int adminRemove(Long id){
		return kehuDao.remove(id);
	}

	
	@Override
	public int batchRemove(Long[] ids){
		for (Long id :ids){
			KehuDO kehuDO = kehuDao.get(id);
			boolean flag = "有".equals(kehuDO.getReceipt())||"预有".equals(kehuDO.getReceipt());
			if (flag && !DateUtils.getNowDate().equals(kehuDO.getReceiptdate())) {
				return 0;
			}
		}

		return kehuDao.batchRemove(ids);
	}


	@Override
	public List<Map> queryKehu(Map map) {

		return   kehuDao.queryKehu(map);
	}

	@Override
	public List<Map> queryKehu1(Map map) {
		List<Map> list = new ArrayList<>();
		for (int i = 0; i <12 ; i++) {
			map.put("startDate",DateUtils.getNowMonth(-i)+"-01");
			map.put("endDate",DateUtils.getNowMonth(-i)+"-31");
			list.add(kehuDao.queryKehu1(map));

		}
		return  list;
	}

	@Override
	public List<FukuanDo> getFukuan(Map params) {

		return kehuDao.getFukan(params);
	}

	@Override
	public int fukuanCount(Map<String, Object> map) {
		return kehuDao.fukuanCount(map);
	}

	@Override
	public void updatePayAccount(String account, String name, String oAccount, String oName) {
		kehuDao.updatePayAccount(account,name,oAccount,oName);
	}


}
