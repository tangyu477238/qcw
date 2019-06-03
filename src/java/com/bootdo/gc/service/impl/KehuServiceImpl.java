package com.bootdo.gc.service.impl;

import com.bootdo.gc.dao.KehuDao;
import com.bootdo.gc.domain.KehuDO;
import com.bootdo.gc.domain.SijiDO;
import com.bootdo.gc.service.KehuService;
import com.bootdo.gc.service.SijiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class KehuServiceImpl implements KehuService {
	@Autowired
	private KehuDao kehuDao;

	@Autowired
	private SijiService sijiService;
	
	@Override
	public KehuDO get(Long id){
		return kehuDao.get(id);
	}

	@Override
	public KehuDO getOrder(String orderNo){
		KehuDO kehuDO = new KehuDO();

		SijiDO sijiDO = sijiService.getOrder(orderNo);
		if (kehuDO==null) {
			return null;
		}
		kehuDO.setBizdate(sijiDO.getBizdate());
		kehuDO.setCarnum(sijiDO.getCarnum());
		kehuDO.setForwunit(sijiDO.getForwunit());
		kehuDO.setStation(sijiDO.getArrivstation());
		//kehuDO.setTranscost(sijiDO.getTrancost());


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
		return kehuDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return kehuDao.batchRemove(ids);
	}
	
}
