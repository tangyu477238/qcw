package com.bootdo.gc.service.impl;

import com.bootdo.common.utils.DateUtils;
import com.bootdo.gc.dao.KehuDao;
import com.bootdo.gc.dao.SijiDao;
import com.bootdo.gc.dao.SijiItemDao;
import com.bootdo.gc.domain.*;
import com.bootdo.gc.service.SijiItemAminvoiceService;
import com.bootdo.gc.service.SijiItemService;
import com.bootdo.gc.service.SijiService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
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


	@Autowired
	private SijiItemAminvoiceService sijiItemAminvoiceService;


	@Override
	public SijiItemDO get(Long id){
		SijiItemDO sijiItemDO = sijiItemDao.get(id);
		SijiDO sijiDO = sijiDao.getPid(sijiItemDO.getPid());
		sijiItemDO.setDeptId(sijiDO.getDeptId());
		Map map = new HashMap();
		map.put("pid",sijiItemDO.getPid());
		List<SijiItemAminvoiceDO> list = sijiItemAminvoiceService.getLastAminvoice(map);
		if (list!=null && !list.isEmpty()){
			sijiItemDO.setYue(list.get(0).getYue());
		} else {
			sijiItemDO.setYue(sijiItemDO.getTrancost());
		}


		return sijiItemDO;
	}

	@Override
	public SijiItemDO getItemDo(Long id){
		return sijiItemDao.getItemDo(id);
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
	public int daiduizhanglistCount(Map<String, Object> map){
		return sijiItemDao.daiduizhanglistCount(map);
	}



	
	@Override
	public int save(SijiItemDO sijiItem){

		SijiDO sijiDO = sijiDao.getPid(sijiItem.getPid());
		if (sijiDO==null){
			return sijiItemDao.save(sijiItem);
		}
		KehuDO kehuDO = kehuDao.getOrder(sijiDO.getOrderNo());
		if (kehuDO==null){
			return sijiItemDao.save(sijiItem);
		}
		if ("有".equals(kehuDO.getReceipt())||"预有".equals(kehuDO.getReceipt())){
			return 0;
		}


		int flag = sijiItemDao.save(sijiItem);


		updateKehu(kehuDO,sijiItem.getPid());




		return flag;
	}


	public void updateKehu(KehuDO kehuDO,String pid){

		kehuDO.setTonnage(new BigDecimal(0));
		Map map = new HashMap();
		map.put("pid", pid);
		List<SijiItemDO> list = sijiItemService.list(map);
		for (SijiItemDO sijiItemDO : list){
			kehuDO.setTonnage(kehuDO.getTonnage().add(sijiItemDO.getTonnage())); //吨位
		}

		BigDecimal ad = new BigDecimal(0);
		if(kehuDO.getAdjusttonnage()!=null){
			ad = kehuDO.getAdjusttonnage();
		}

		if (kehuDO.getTonnage()!=null){
			kehuDO.setTonnage(kehuDO.getTonnage().setScale(1, BigDecimal.ROUND_DOWN)); //吨位保留一位小数
			kehuDO.setSettletonnage(kehuDO.getTonnage().subtract(ad)); //结算吨位=吨位-调吨
		}

		BigDecimal t1 = kehuDO.getSettletonnage().multiply(kehuDO.getTranscost()); //结算吨位*运价

		if (kehuDO.getInforfee()==null){
			kehuDO.setInforfee(new BigDecimal(0));
		}
		BigDecimal t2 = t1.subtract(kehuDO.getInforfee()); //（结算吨位*运价）-信息费
		kehuDO.setTransfee(t2); //运费

		if (kehuDO.getFulltrans()==null){
			kehuDO.setFulltrans(new BigDecimal(0));
		}
		if (kehuDO.getBankcard()==null){
			kehuDO.setBankcard(new BigDecimal(0));
		}
		if (kehuDO.getShoushufei()==null){
			kehuDO.setShoushufei(new BigDecimal(0));
		}
		kehuDO.setAcbalance(kehuDO.getTransfee().subtract(kehuDO.getFulltrans()).subtract(kehuDO.getBankcard()).subtract(kehuDO.getShoushufei()));
		kehuDao.update(kehuDO); //信息更新
	}




	@Override
	public int updateItem(SijiItemDO sijiItem){

		int flag = sijiItemDao.update(sijiItem);

		return flag;
	}

	@Override
	public int update(SijiItemDO sijiItem){


		SijiDO sijiDO = sijiDao.getPid(sijiItem.getPid());


		log.info("------------是否对账---------");
		SijiItemDO dz = sijiItemDao.get(sijiItem.getId());
		if (dz.getBilldate()!=null&&!"".equals(dz.getBilldate())){
			return 0;
		}



		KehuDO kehuDO = kehuDao.getOrder(sijiDO.getOrderNo());
		if (kehuDO==null){
			return sijiItemDao.update(sijiItem);
		}
//		if ("有".equals(kehuDO.getReceipt())||"预有".equals(kehuDO.getReceipt())){
//			return 0;
//		}
		int flag = sijiItemDao.update(sijiItem);


		updateKehu(kehuDO,sijiItem.getPid());

		return flag;
	}
	
	@Override
	public int remove(Long id){

		SijiItemDO sijiItem = this.get(id);
		if (sijiItem==null){
			return sijiItemDao.remove(id);
		}
		log.info("------------是否对账---------");
		if (sijiItem.getBilldate()!=null&&!"".equals(sijiItem.getBilldate())){
			return 0;
		}


		SijiDO sijiDO = sijiDao.getPid(sijiItem.getPid());
		KehuDO kehuDO = kehuDao.getOrder(sijiDO.getOrderNo());
        if (kehuDO==null){
            return sijiItemDao.remove(id);
        }
		if ("有".equals(kehuDO.getReceipt())||"预有".equals(kehuDO.getReceipt())){
			return 0;
		}


		int flag = sijiItemDao.remove(id);


		updateKehu(kehuDO,sijiItem.getPid());

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
		List<Map> list = sijiItemDao.querySijiList(map);

		for (Map emap : list){
			Map param = new HashMap();
			param.put("pid",emap.get("pid"));
			List<SijiItemAminvoiceDO> aminvoicelist =
					sijiItemAminvoiceService.getLastAminvoice(param);
			if (aminvoicelist!=null && !aminvoicelist.isEmpty()){
				emap.put("yue",aminvoicelist.get(0).getYue());
			} else {
				emap.put("yue",emap.get("trancost"));
			}
		}



		return list;
	}


	@Override
	public List<Map> daiduizhanglist(Map<String, Object> map) {
		List<Map> list = sijiItemDao.daiduizhanglist(map);

		for (Map emap : list){
			Map param = new HashMap();
			param.put("pid",emap.get("pid"));
			List<SijiItemAminvoiceDO> aminvoicelist =
					sijiItemAminvoiceService.getLastAminvoice(param);
			if (aminvoicelist!=null && !aminvoicelist.isEmpty()){
				emap.put("yue",aminvoicelist.get(0).getYue());
			} else {
				emap.put("yue",emap.get("trancost"));
			}
		}



		return list;
	}








	@Override
	public void importExcel(List<SijiItemImp1> imp1s) {
		for (SijiItemImp1 imp1 : imp1s) {
			SijiItemDO js = sijiItemDao.get(imp1.getId());
			if (js!=null){
				//交单日期之前未填写，并本次有填写
				if ((js.getBilldate()==null||"".equals(js.getBilldate())) && imp1.getBilldate()!=null){
					js.setBilldate(imp1.getBilldate());
					js.setKouling(imp1.getKouling());
					js.setAminvoice(js.getTrancost().subtract(js.getKouling())); //结算金额=运费-扣减金额
					js.setAminvoicedate(DateUtils.getNowDate());
				}

				js.setIssueoffice(imp1.getIssueoffice());
				js.setIssueofficedate(imp1.getIssueofficedate());
				js.setShuilv(imp1.getShuilv());
				js.setShuie(js.getAminvoice().multiply(js.getShuilv()));//税额=结算金额*税率
				js.setPaydate(imp1.getPaydate());
				sijiItemDao.update(js);


			}
		}
	}
	@Override
	public void importExcel2(List<SijiItemImp2> imp2s) {
		for (SijiItemImp2 imp2 : imp2s) {
			SijiItemDO js = sijiItemDao.get(imp2.getId());
			if (js != null && js.getAminvoice()!=null){
				//之前未导入或导入日期是当天，且本次付款方式不为空
				if ((js.getInputdate() == null
						||"".equals(js.getInputdate())
						||DateUtils.getNowDate().equals(js.getInputdate())) && imp2.getCustompay() != null) {
					js.setCustompay(imp2.getCustompay());
					js.setTaxdatepay(imp2.getTaxdatepay());
					js.setTakeamount(imp2.getTakeamount());
					js.setInputdate(DateUtils.getNowDate());
					sijiItemDao.update(js);
				}

			}
		}
	}


	@Override
	public void updatePiliang(Map<String, Object> map) {

		String ids [] = (String[]) map.get("array");

		for (String id : ids){

			SijiItemDO sijiItemDO =  sijiItemDao.get(new Long(id));

			sijiItemDO.setAminvoice(sijiItemDO.getTrancost()); //运费等于结算金额
			sijiItemDO.setKouling(new BigDecimal(0));
			sijiItemDO.setBilldate(map.get("billdate").toString());
			sijiItemDao.update(sijiItemDO);
		}



		if (map.get("kouling")!=null
				&& !"".equals(map.get("kouling").toString())
				&& Double.parseDouble(map.get("kouling").toString())!=0){
			SijiItemDO sijiItemDO =  sijiItemDao.get(new Long(map.get("minId").toString()));
			sijiItemDO.setKouling(new BigDecimal(map.get("kouling").toString()));
			sijiItemDO.setAminvoice(sijiItemDO.getTrancost().subtract(sijiItemDO.getKouling())); //运费等于结算金额
			sijiItemDO.setBilldate(map.get("billdate").toString());
			sijiItemDao.update(sijiItemDO);

		}





	}


	@Override
	public void updatePiliangSteel(Map<String, Object> map) {
		String ids [] = (String[]) map.get("array");
		for (String id : ids){
			SijiItemDO sijiItemDO =  sijiItemDao.get(new Long(id));
			if (StringUtils.isNotBlank(map.get("steelnum").toString())){
				sijiItemDO.setSteelnum(map.get("steelnum").toString());
			}
			if (StringUtils.isNotBlank(map.get("specs").toString())){
				sijiItemDO.setSpecs(map.get("specs").toString());
			}
			sijiItemDao.update(sijiItemDO);
		}
	}

	@Override
	public void updatePiliangMemo(Map<String, Object> map) {
		String ids [] = (String[]) map.get("array");
		for (String id : ids){
			SijiItemDO sijiItemDO =  sijiItemDao.get(new Long(id));
			if (StringUtils.isNotBlank(map.get("memo").toString())){
				sijiItemDO.setRemark(map.get("memo").toString());
			}
			sijiItemDao.update(sijiItemDO);
		}
	}




	@Override
	public Map<String, Object>  editPiliang(String idstr) {

		String ids [] = idstr.split(",");
		BigDecimal amount = new BigDecimal(0);
		BigDecimal dunwei = new BigDecimal(0);
//		Long minId = null;
		Long currId ;
		for (String id : ids){
			currId = new Long(id);
			SijiItemDO sijiItemDO =  sijiItemDao.get(currId);
			amount = amount.add(sijiItemDO.getTrancost()); //运费
			dunwei = dunwei.add(sijiItemDO.getTonnage());
//			if (minId == null || minId > currId){
//				minId = currId;
//			}
		}
		Map<String, Object> map = new HashMap<>();
		map.put("dunwei", dunwei);
		map.put("amount", amount);
		map.put("minId", ids[ids.length-1]);
		return map;
	}




}
