package com.bootdo.gc.service.impl;

import com.bootdo.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.gc.dao.SequenceDao;
import com.bootdo.gc.domain.SequenceDO;
import com.bootdo.gc.service.SequenceService;



@Service
public class SequenceServiceImpl implements SequenceService {
	@Autowired
	private SequenceDao sequenceDao;
	
	@Override
	public SequenceDO get(Long id){
		return sequenceDao.get(id);
	}
	
	@Override
	public List<SequenceDO> list(Map<String, Object> map){
		return sequenceDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sequenceDao.count(map);
	}
	
	@Override
	public int save(SequenceDO sequence){
		return sequenceDao.save(sequence);
	}
	
	@Override
	public int update(SequenceDO sequence){
		return sequenceDao.update(sequence);
	}
	
	@Override
	public int remove(Long id){
		return sequenceDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return sequenceDao.batchRemove(ids);
	}

	@Override
	public String getSequence(String stype){

		String dateStr = DateUtils.format(new Date(), DateUtils.DATE_PATTERN_02);
		SequenceDO sequenceDO = sequenceDao.querySequence(stype, dateStr);
		if (sequenceDO == null){
			sequenceDO = new SequenceDO();
			sequenceDO.setNum(1);
			sequenceDO.setBizDate(dateStr);
			sequenceDO.setStype(stype);
			this.save(sequenceDO);
		}else{
			sequenceDO.setNum(sequenceDO.getNum()+1);
			this.update(sequenceDO);
		}
		StringBuffer sequence = new StringBuffer();
		sequence.append(sequenceDO.getStype())
				.append(dateStr)
				.append(String.format("%03d", sequenceDO.getNum()));

		return sequence.toString();
	}


	
}
