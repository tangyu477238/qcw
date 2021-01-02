package com.bootdo.gc.service.impl;

import com.bootdo.gc.dao.KehuDao;
import com.bootdo.gc.dao.SijiDao;
import com.bootdo.gc.domain.*;
import com.bootdo.gc.service.CustomService;
import com.bootdo.gc.service.SijiItemService;
import com.bootdo.gc.service.SijiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service
public class SijiServiceImpl  implements SijiService {
	@Autowired
	private SijiDao sijiDao;


	@Autowired
	private SijiItemService sijiItemService;

	@Autowired
	private KehuDao kehuDao;

	@Autowired
	private CustomService customService;



	@Override
	public SijiDO get(Long id){
		return sijiDao.get(id);
	}
	
	@Override
	public List<SijiDO> list(Map<String, Object> map){
		return sijiDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sijiDao.count(map);
	}

	@Override
	public int updatePiliangPrice(Map<String, Object> map){
		return sijiDao.updatePiliangPrice(map);
	}

	@Override
	public int updatePiliangShuilv(Map<String, Object> map){
		return sijiDao.updatePiliangShuilv(map);
	}




	@Override
	public Map getDunSum(String [] ids){

		return sijiDao.getDunSum(ids);
	}





	@Override
	public int save(SijiDO siji){


		CustomDO custom = new CustomDO();
		custom.setDeptId(siji.getDeptId());
		custom.setShuilv(new BigDecimal(siji.getOrderNo()));

		custom.setStype("fhdw");
		custom.setName(siji.getForwunit());
		customService.updateCustomLv(custom);

		custom.setStype("fkdw");
		custom.setName(siji.getInforfee());
		customService.updateCustomLv(custom);

		custom.setStype("station");
		custom.setName(siji.getArrivstation());
		customService.updateCustomLv(custom);

		return sijiDao.save(siji);
	}
	
	@Override
	public int update(SijiDO siji){


		SijiDO sijiDO = sijiDao.getPid(siji.getPid());
		KehuDO kehuDO = kehuDao.getOrder(sijiDO.getOrderNo());
		if (kehuDO==null){
			return sijiDao.update(siji);
		}
//		if ("有".equals(kehuDO.getReceipt())||"预有".equals(kehuDO.getReceipt())){
//			return 0;
//		}

		kehuDO.setBizdate(siji.getBizdate());
		kehuDO.setCarnum(siji.getCarnum());
		kehuDO.setPayer(siji.getInforfee());
		kehuDO.setStation(siji.getArrivstation());

		Map map = new HashMap();
		kehuDO.setTonnage(new BigDecimal(0));
		map.put("pid",siji.getPid());
		List<SijiItemDO> list = sijiItemService.list(map);
		for (SijiItemDO sijiItemDO : list){
			kehuDO.setTonnage(kehuDO.getTonnage().add(sijiItemDO.getTonnage())); //吨位
		}

		if (kehuDO.getAdjusttonnage()==null){
			kehuDO.setAdjusttonnage(new BigDecimal(0));
		}

		if (kehuDO.getTonnage()!=null){
			kehuDO.setTonnage(kehuDO.getTonnage().setScale(1, BigDecimal.ROUND_DOWN)); //吨位保留一位小数
			kehuDO.setSettletonnage(kehuDO.getTonnage().subtract(kehuDO.getAdjusttonnage())); //结算吨位=吨位-调吨
		}

		if (kehuDO.getTranscost()==null){
			kehuDO.setTranscost(new BigDecimal(0));
		}

		if (kehuDO.getInforfee()==null){
			kehuDO.setInforfee(new BigDecimal(0));
		}
		if (kehuDO.getTransfee()==null){
			kehuDO.setTransfee(new BigDecimal(0));
		}

		if (kehuDO.getFulltrans()==null){
			kehuDO.setFulltrans(new BigDecimal(0));
		}
		if (kehuDO.getBankcard()==null){
			kehuDO.setBankcard(new BigDecimal(0));
		}
		if (kehuDO.getShoushufei()==null){
			kehuDO.setShoushufei(new BigDecimal(0));
		}

		BigDecimal t1 = kehuDO.getSettletonnage();
		BigDecimal t2 = t1.multiply(kehuDO.getTranscost());
		BigDecimal t3 = t2.subtract(kehuDO.getInforfee());
		kehuDO.setTransfee(t3); //运费

		kehuDO.setAcbalance(kehuDO.getTransfee().subtract(kehuDO.getFulltrans()).subtract(kehuDO.getBankcard()).subtract(kehuDO.getShoushufei()));
		kehuDao.update(kehuDO); //信息更新


		return sijiDao.update(siji);
	}


	
	@Override
	public int remove(Long id){
		SijiDO sijiDO = sijiDao.get(id);

		KehuDO kehuDO = kehuDao.getOrder(sijiDO.getOrderNo());
		if (kehuDO!=null){
			return 0;
		}
		return sijiDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		for (Long id :ids){
			SijiDO sijiDO = sijiDao.get(id);
			KehuDO kehuDO = kehuDao.getOrder(sijiDO.getOrderNo());
			if (kehuDO!=null){
				return 0;
			}
		}

		return sijiDao.batchRemove(ids);
	}



	@Override
	public SijiDO getOrder(String orderNo){

		SijiDO sijiDO = sijiDao.getOrder(orderNo);

		return sijiDO;
	}



	@Override
	public List<SijiDO> getExcelList(Map<String, Object> map){

		return sijiDao.getExcelList(map);
	}


	@Override
	public List<Map> queryTotal(Map map) {


		return sijiDao.queryTotal(map);
	}

	@Override
	public List<Map> excelTotal(Map map) {


		return sijiDao.excelTotal(map);
	}


	@Override
	public List<LirunDO> queryLirun(Map map) {


		return sijiDao.queryLirun(map);
	}

	@Override
	public List<Map> arrivstation(Map map) {


		return sijiDao.arrivstation(map);
	}


}
