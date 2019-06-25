package com.bootdo.gc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.gc.dao.SijiItemDao;
import com.bootdo.gc.domain.SijiItemDO;
import com.bootdo.gc.service.SijiItemService;



@Service
public class SijiItemServiceImpl implements SijiItemService {
	@Autowired
	private SijiItemDao sijiItemDao;
	
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
		return sijiItemDao.save(sijiItem);
	}
	
	@Override
	public int update(SijiItemDO sijiItem){
		return sijiItemDao.update(sijiItem);
	}
	
	@Override
	public int remove(Long id){
		return sijiItemDao.remove(id);
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
