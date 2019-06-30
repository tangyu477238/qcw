package com.bootdo.gc.service.impl;

import com.bootdo.gc.dao.KehuDao;
import com.bootdo.gc.dao.SijiDao;
import com.bootdo.gc.domain.KehuDO;
import com.bootdo.gc.domain.SijiDO;
import com.bootdo.gc.service.SijiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.gc.dao.SijiItemDao;
import com.bootdo.gc.domain.SijiItemDO;
import com.bootdo.gc.service.SijiItemService;



@Service
public class SijiItemServiceImpl implements SijiItemService {

	@Autowired
	private SijiDao sijiDao;

	@Autowired
	private SijiItemDao sijiItemDao;


	@Autowired
	private KehuDao kehuDao;

	@Autowired
	private SijiItemService sijiItemService;


	@Autowired
	private SijiService sijiService;



	@Override
	public SijiItemDO get(Long id){
		return sijiItemDao.get(id);
	}
	
	@Override
	public List<SijiItemDO> list(Map<String, Object> map){
		return sijiItemDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sijiItemDao.count(map);
	}

	@Override
	public int querySijiListCount(Map<String, Object> map){
		return sijiItemDao.querySijiListCount(map);
	}



	
	@Override
	public int save(SijiItemDO sijiItem){

		SijiDO sijiDO = sijiDao.getPid(sijiItem.getPid());
		if (sijiDO==null){
			return sijiItemDao.save(sijiItem);
		}
		KehuDO kehuDO = kehuDao.getOrder(sijiDO.getOrderNo());
		if ("有".equals(kehuDO.getReceipt())||"预有".equals(kehuDO.getReceipt())){
			return 0;
		}


		int flag = sijiItemDao.save(sijiItem);


//		kehuDO.setForwunit(siji.getForwunit());
//		kehuDO.setStation(siji.getArrivstation());
//		kehuDO.setBizdate(siji.getBizdate());

		kehuDO.setTonnage(new BigDecimal(0));
		Map map = new HashMap();
		map.put("pid", sijiItem.getPid());
		List<SijiItemDO> list = sijiItemService.list(map);
		for (SijiItemDO sijiItemDO : list){
			kehuDO.setTonnage(kehuDO.getTonnage().add(sijiItemDO.getTonnage())); //吨位
		}
		if (kehuDO.getTonnage()!=null){
			kehuDO.setSettletonnage(kehuDO.getTonnage().setScale(1, BigDecimal.ROUND_DOWN)); //结算吨位
		}

		BigDecimal t1 = kehuDO.getSettletonnage().subtract(kehuDO.getAdjusttonnage());
		BigDecimal t2 = t1.multiply(kehuDO.getTranscost()).subtract(kehuDO.getInforfee());
		kehuDO.setTransfee(t2); //运费

		kehuDO.setAcbalance(kehuDO.getTransfee().subtract(kehuDO.getFulltrans()).subtract(kehuDO.getBankcard()));
		kehuDao.update(kehuDO); //信息更新


		return flag;
	}
	
	@Override
	public int update(SijiItemDO sijiItem){
		return sijiItemDao.update(sijiItem);
	}
	
	@Override
	public int remove(Long id){

		SijiItemDO sijiItem = this.get(id);
		if (sijiItem==null){
			return sijiItemDao.remove(id);
		}
		SijiDO sijiDO = sijiDao.getPid(sijiItem.getPid());

		KehuDO kehuDO = kehuDao.getOrder(sijiDO.getOrderNo());
		if ("有".equals(kehuDO.getReceipt())||"预有".equals(kehuDO.getReceipt())){
			return 0;
		}


		int flag = sijiItemDao.remove(id);


//		kehuDO.setForwunit(siji.getForwunit());
//		kehuDO.setStation(siji.getArrivstation());
//		kehuDO.setBizdate(siji.getBizdate());

		kehuDO.setTonnage(new BigDecimal(0));
		Map map = new HashMap();
		map.put("pid", sijiItem.getPid());
		List<SijiItemDO> list = sijiItemService.list(map);
		for (SijiItemDO sijiItemDO : list){
			kehuDO.setTonnage(kehuDO.getTonnage().add(sijiItemDO.getTonnage())); //吨位
		}
		if (kehuDO.getTonnage()!=null){
			kehuDO.setSettletonnage(kehuDO.getTonnage().setScale(1, BigDecimal.ROUND_DOWN)); //结算吨位
		}

		BigDecimal t1 = kehuDO.getSettletonnage().subtract(kehuDO.getAdjusttonnage());
		BigDecimal t2 = t1.multiply(kehuDO.getTranscost()).subtract(kehuDO.getInforfee());
		kehuDO.setTransfee(t2); //运费

		kehuDO.setAcbalance(kehuDO.getTransfee().subtract(kehuDO.getFulltrans()).subtract(kehuDO.getBankcard()));
		kehuDao.update(kehuDO); //信息更新


		return flag;


	}

	@Override
	public int heDui(Long id){
		return sijiItemDao.heDui(id);
	}

	@Override
	public int batchRemove(Long[] ids){
		return sijiItemDao.batchRemove(ids);
	}

	@Override
	public List<Map> querySijiList(Map<String, Object> map) {

		return sijiItemDao.querySijiList(map);
	}

}
