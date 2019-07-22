package com.bootdo.gc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.gc.dao.JiesuanDao;
import com.bootdo.gc.domain.JiesuanDO;
import com.bootdo.gc.service.JiesuanService;



@Service
public class JiesuanServiceImpl implements JiesuanService {
	@Autowired
	private JiesuanDao jiesuanDao;
	
	@Override
	public JiesuanDO get(Long id){
		return jiesuanDao.get(id);
	}
	
	@Override
	public List<JiesuanDO> list(Map<String, Object> map){
		return jiesuanDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return jiesuanDao.count(map);
	}
	
	@Override
	public int save(JiesuanDO jiesuan){
		return jiesuanDao.save(jiesuan);
	}

	@Override
	public JiesuanDO getItem(String payer) {
		return jiesuanDao.getItem(payer);
	}

	@Override
	public int update(JiesuanDO jiesuan){
		return jiesuanDao.update(jiesuan);
	}
	
	@Override
	public int remove(Long id){
		return jiesuanDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return jiesuanDao.batchRemove(ids);
	}

	@Override
	public void importExcel(List<JiesuanDO> jiesuanDOList) {
		for (JiesuanDO jiesuan : jiesuanDOList) {
			JiesuanDO js = jiesuanDao.getByInvoice(jiesuan.getInvoice());
			if (js!=null){
				jiesuanDao.remove(js.getId());
			}
			jiesuanDao.save(jiesuan);
		}
	}
}
