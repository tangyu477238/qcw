package com.bootdo.gc.service.impl;

import com.bootdo.gc.dao.KehuDao;
import com.bootdo.gc.dao.SijiDao;
import com.bootdo.gc.domain.KehuDO;
import com.bootdo.gc.domain.SijiDO;
import com.bootdo.gc.service.KehuService;
import com.bootdo.gc.service.SijiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class SijiServiceImpl  implements SijiService {
	@Autowired
	private SijiDao sijiDao;


	@Autowired
	private KehuService kehuService;

	@Autowired
	private KehuDao kehuDao;




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
	public int save(SijiDO siji){
		return sijiDao.save(siji);
	}
	
	@Override
	public int update(SijiDO siji){
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


}
