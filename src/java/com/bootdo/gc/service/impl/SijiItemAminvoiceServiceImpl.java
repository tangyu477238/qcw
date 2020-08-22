package com.bootdo.gc.service.impl;

import com.bootdo.common.utils.DateUtils;
import com.bootdo.gc.dao.KehuDao;
import com.bootdo.gc.dao.SijiDao;
import com.bootdo.gc.dao.SijiItemAminvoiceDao;
import com.bootdo.gc.domain.*;
import com.bootdo.gc.service.CustomService;
import com.bootdo.gc.service.SijiItemAminvoiceService;
import com.bootdo.gc.service.SijiItemService;
import com.bootdo.gc.service.SijiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class SijiItemAminvoiceServiceImpl implements SijiItemAminvoiceService {

	@Autowired
	private SijiDao sijiDao;

	@Autowired
	private SijiItemAminvoiceDao SijiItemAminvoiceDao;


	@Autowired
	private KehuDao kehuDao;

	@Autowired
	private SijiItemService sijiItemService;


	@Autowired
	private SijiService sijiService;

	@Autowired
	private CustomService customService;

	@Override
	public SijiItemAminvoiceDO get(Long id){
		return SijiItemAminvoiceDao.get(id);
	}

	@Override
	public List<SijiItemAminvoiceDO> getLastAminvoice(Map<String, Object> map){
		return SijiItemAminvoiceDao.getLastAminvoice(map);
	}




	@Override
	public SijiItemAminvoiceDO getItemDo(Long id){
		return SijiItemAminvoiceDao.getItemDo(id);
	}



	@Override
	public List<SijiItemAminvoiceDO> list(Map<String, Object> map){
		return SijiItemAminvoiceDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return SijiItemAminvoiceDao.count(map);
	}

	@Override
	public int querySijiListCount(Map<String, Object> map){
		return SijiItemAminvoiceDao.querySijiListCount(map);
	}



	
	@Override
	public int save(SijiItemAminvoiceDO sijiItem){

		SijiDO sijiDO = sijiDao.getPid(sijiItem.getPid());
		if (sijiDO==null){
			return SijiItemAminvoiceDao.save(sijiItem);
		}
		KehuDO kehuDO = kehuDao.getOrder(sijiDO.getOrderNo());
		if (kehuDO==null){
			return SijiItemAminvoiceDao.save(sijiItem);
		}
		if ("有".equals(kehuDO.getReceipt())||"预有".equals(kehuDO.getReceipt())){
			return 0;
		}


		int flag = SijiItemAminvoiceDao.save(sijiItem);


//		kehuDO.setForwunit(siji.getForwunit());
//		kehuDO.setStation(siji.getArrivstation());
//		kehuDO.setBizdate(siji.getBizdate());

		kehuDO.setTonnage(new BigDecimal(0));
		Map map = new HashMap();
		map.put("pid", sijiItem.getPid());
		List<SijiItemAminvoiceDO> list = sijiItemService.list(map);
		for (SijiItemAminvoiceDO SijiItemAminvoiceDO : list){
			kehuDO.setTonnage(kehuDO.getTonnage().add(SijiItemAminvoiceDO.getTonnage())); //吨位
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
	public int updateItem(SijiItemAminvoiceDO sijiItem){


		SijiItemAminvoiceDao.updateState(sijiItem);//更新是否最新结算


		sijiItem.setYue(sijiItem.getYue().subtract(sijiItem.getTakeamount()));
		sijiItem.setState(1);
		int flag = SijiItemAminvoiceDao.save(sijiItem);

		return flag;
	}

	@Override
	public int update(SijiItemAminvoiceDO sijiItem){


		SijiDO sijiDO = sijiDao.getPid(sijiItem.getPid());

		KehuDO kehuDO = kehuDao.getOrder(sijiDO.getOrderNo());
		if (kehuDO==null){
			return SijiItemAminvoiceDao.update(sijiItem);
		}
//		if ("有".equals(kehuDO.getReceipt())||"预有".equals(kehuDO.getReceipt())){
//			return 0;
//		}

		int flag = SijiItemAminvoiceDao.update(sijiItem);

		try {
			kehuDO.setTonnage(new BigDecimal(0));
			Map map = new HashMap();
			map.put("pid", sijiItem.getPid());
			List<SijiItemAminvoiceDO> list = sijiItemService.list(map);
			for (SijiItemAminvoiceDO SijiItemAminvoiceDO : list) {
				kehuDO.setTonnage(kehuDO.getTonnage().add(SijiItemAminvoiceDO.getTonnage())); //吨位
			}
			if (kehuDO.getTonnage() != null) {
				kehuDO.setSettletonnage(kehuDO.getTonnage().setScale(1, BigDecimal.ROUND_DOWN)); //结算吨位
			}

			BigDecimal t1 = kehuDO.getSettletonnage().subtract(kehuDO.getAdjusttonnage());
			BigDecimal t2 = t1.multiply(kehuDO.getTranscost()).subtract(kehuDO.getInforfee());
			kehuDO.setTransfee(t2); //运费

			kehuDO.setAcbalance(kehuDO.getTransfee().subtract(kehuDO.getFulltrans()).subtract(kehuDO.getBankcard()));
			kehuDao.update(kehuDO); //信息更新

		}catch (Exception e){
			e.printStackTrace();
		}

		return flag;
	}



	@Override
	public int removeBill(String id){
		Map map = new HashMap();
		map.put("pid",id);

		int count  = SijiItemAminvoiceDao.count(map); //已开票
		if (count > 0) {
			return 0 ;
		}
		int flag = SijiItemAminvoiceDao.removeBill(map);

		return flag;

	}



	@Override
	public int removeAdmin(Long id){
		SijiItemAminvoiceDO sijiItemAminvoiceDo = SijiItemAminvoiceDao.get(id);
		if (sijiItemAminvoiceDo.getState()!=1){
			return -1 ;
		}

		List<Map<String, Object>> invoiceList = SijiItemAminvoiceDao.getInvoiceList(id);
		if (invoiceList != null && !invoiceList.isEmpty()) {
			return 0 ;
		}

		int maxid = SijiItemAminvoiceDao.getMaxId(id);
		if(maxid>0){
			SijiItemAminvoiceDao.updateLastState(maxid);
		}

		int flag = SijiItemAminvoiceDao.remove(id);

		return flag;

	}

	@Override
	public int remove(Long id){

		SijiItemAminvoiceDO sijiItemAminvoiceDo = SijiItemAminvoiceDao.get(id);
		if (!DateUtils.getNowDate().equals(sijiItemAminvoiceDo.getInputdate())){
			return -2 ;
		}
		int flag = this.removeAdmin(id);

		return flag;

	}

	@Override
	public int heDui(Long id){
		return SijiItemAminvoiceDao.heDui(id);
	}

	@Override
	public int batchRemove(Long[] ids){
		return SijiItemAminvoiceDao.batchRemove(ids);
	}

	@Override
	public List<SijiItemAminvoiceVO> querySijiList(Map<String, Object> map) {

		return SijiItemAminvoiceDao.querySijiList(map);
	}

	@Override
	public List<Map<String, Object>> getIssueoffice(Map<String, Object> map) {

		return customService.getCustomList(map);
	}

	@Override
	public void getBilldateArray(Map<String, Object> map) {

		List<SijiItemAminvoiceDO> list = SijiItemAminvoiceDao.getBilldateArray(map);
		for (SijiItemAminvoiceDO sijiItem : list){

			SijiItemAminvoiceDO  si = getBillInfoByPid(sijiItem.getPid());
			sijiItem.setIssueoffice(map.get("issueoffice").toString());
			sijiItem.setIssueofficedate(map.get("issueofficedate").toString());
			sijiItem.setInputdate(DateUtils.getNowDate());
			sijiItem.setTakeamount(si.getYue());
			sijiItem.setYue(new BigDecimal(0));
			sijiItem.setState(1);
			SijiItemAminvoiceDao.updateState(sijiItem);//更新是否最新结算
			int flag = SijiItemAminvoiceDao.save(sijiItem);
		}
	}

	@Override
	public List<SijiItemAminvoiceDO> getBilldateList(Map<String, Object> map) {

		return SijiItemAminvoiceDao.getBilldateList(map);
	}


	@Override
	public List<SijiItemAminvoiceDO> getDuizhangList(Map<String, Object> map) {

		return SijiItemAminvoiceDao.getDuizhangList(map);
	}

	@Override
	public int getDuizhangListCount(Map<String, Object> map) {

		return SijiItemAminvoiceDao.getDuizhangListCount(map);
	}



	@Override
	public SijiItemAminvoiceDO getBillInfoByPid(String pid) {

		Map map = new HashMap();
		map.put("pid",pid);
		SijiItemAminvoiceDO sijiItemAminvoiceDO = new SijiItemAminvoiceDO();
		List<SijiItemAminvoiceDO> list = SijiItemAminvoiceDao.getBilldateList(map);
		if (!list.isEmpty()){
			sijiItemAminvoiceDO = list.get(0);
		}
		return sijiItemAminvoiceDO;
	}


	@Override
	public void importExcel(List<SijiItemImp1> imp1s) {
		for (SijiItemImp1 imp1 : imp1s) {
			SijiItemAminvoiceDO js = SijiItemAminvoiceDao.get(imp1.getId());
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
				SijiItemAminvoiceDao.update(js);


			}
		}
	}
	@Override
	public void importExcel2(List<SijiItemImp2> imp2s) {
		for (SijiItemImp2 imp2 : imp2s) {
			SijiItemAminvoiceDO js = SijiItemAminvoiceDao.get(imp2.getId());
			if (js != null && js.getAminvoice()!=null){
				//之前未导入或导入日期是当天，且本次付款方式不为空
				if ((js.getInputdate() == null
						||"".equals(js.getInputdate())
						||DateUtils.getNowDate().equals(js.getInputdate())) && imp2.getCustompay() != null) {
					js.setCustompay(imp2.getCustompay());
					js.setTaxdatepay(imp2.getTaxdatepay());
					js.setTakeamount(imp2.getTakeamount());
					js.setInputdate(DateUtils.getNowDate());
					SijiItemAminvoiceDao.update(js);
				}

			}
		}
	}


}
