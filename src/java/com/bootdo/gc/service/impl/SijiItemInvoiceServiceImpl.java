package com.bootdo.gc.service.impl;

import com.bootdo.common.utils.DateUtils;
import com.bootdo.gc.dao.KehuDao;
import com.bootdo.gc.dao.SijiDao;
import com.bootdo.gc.dao.SijiItemInvoiceDao;
import com.bootdo.gc.domain.*;
import com.bootdo.gc.service.SijiItemInvoiceService;
import com.bootdo.gc.service.SijiItemService;
import com.bootdo.gc.service.SijiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class SijiItemInvoiceServiceImpl implements SijiItemInvoiceService {

	@Autowired
	private SijiDao sijiDao;

	@Autowired
	private SijiItemInvoiceDao SijiItemInvoiceDao;


	@Autowired
	private KehuDao kehuDao;

	@Autowired
	private SijiItemService sijiItemService;





	@Override
	public SijiItemInvoiceDO get(Long id){
		return SijiItemInvoiceDao.get(id);
	}

	@Override
	public List<SijiItemInvoiceDO> getInvoiceList(Map<String, Object> map){
		return SijiItemInvoiceDao.getInvoiceList(map);
	}




	@Override
	public SijiItemInvoiceDO getItemDo(Long id){
		return SijiItemInvoiceDao.getItemDo(id);
	}



	@Override
	public List<SijiItemInvoiceDO> list(Map<String, Object> map){
		return SijiItemInvoiceDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map){
		return SijiItemInvoiceDao.count(map);
	}

	@Override
	public int querySijiListCount(Map<String, Object> map){
		return SijiItemInvoiceDao.querySijiListCount(map);
	}


	@Override
	public void getInvoicedateArray(Map<String, Object> map) {

		List<Map> list = SijiItemInvoiceDao.querySijiArray(map);


		Map papms = new HashMap();
		for (Map itemMap : list){


			papms.put("id", itemMap.get("id"));
			SijiItemInvoiceDO sijiItemInvoiceDO = new SijiItemInvoiceDO();
			List<SijiItemInvoiceDO> invoiceList = SijiItemInvoiceDao.getAminvoicefoById(papms);
			if (!invoiceList.isEmpty()){
				sijiItemInvoiceDO = invoiceList.get(0);
			}


			SijiItemInvoiceDao.updateState(sijiItemInvoiceDO);//更新是否最新结算

			sijiItemInvoiceDO.setCustompay(map.get("custompay").toString());
			sijiItemInvoiceDO.setTaxdatepay(map.get("taxdatepay").toString());
			sijiItemInvoiceDO.setInputdate(DateUtils.getNowDate());

			sijiItemInvoiceDO.setTakeamount(sijiItemInvoiceDO.getYue());

			sijiItemInvoiceDO.setYue(new BigDecimal(0));
			sijiItemInvoiceDO.setState(1);
			int flag = SijiItemInvoiceDao.save(sijiItemInvoiceDO);
		}


	}

	@Override
	public int save(SijiItemInvoiceDO sijiItem){

		SijiDO sijiDO = sijiDao.getPid(sijiItem.getPid());
		if (sijiDO==null){
			return SijiItemInvoiceDao.save(sijiItem);
		}
		KehuDO kehuDO = kehuDao.getOrder(sijiDO.getOrderNo());
		if (kehuDO==null){
			return SijiItemInvoiceDao.save(sijiItem);
		}
		if ("有".equals(kehuDO.getReceipt())||"预有".equals(kehuDO.getReceipt())){
			return 0;
		}


		int flag = SijiItemInvoiceDao.save(sijiItem);


//		kehuDO.setForwunit(siji.getForwunit());
//		kehuDO.setStation(siji.getArrivstation());
//		kehuDO.setBizdate(siji.getBizdate());

		kehuDO.setTonnage(new BigDecimal(0));
		Map map = new HashMap();
		map.put("pid", sijiItem.getPid());
		List<SijiItemInvoiceDO> list = sijiItemService.list(map);
		for (SijiItemInvoiceDO SijiItemInvoiceDO : list){
			kehuDO.setTonnage(kehuDO.getTonnage().add(SijiItemInvoiceDO.getTonnage())); //吨位
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
	public int updateItem(SijiItemInvoiceDO sijiItem){


		SijiItemInvoiceDao.updateState(sijiItem);//更新是否最新结算


		sijiItem.setYue(sijiItem.getYue().subtract(sijiItem.getTakeamount()));
		sijiItem.setState(1);
		int flag = SijiItemInvoiceDao.save(sijiItem);

		return flag;
	}

	@Override
	public int update(SijiItemInvoiceDO sijiItem){


		SijiDO sijiDO = sijiDao.getPid(sijiItem.getPid());

		KehuDO kehuDO = kehuDao.getOrder(sijiDO.getOrderNo());
		if (kehuDO==null){
			return SijiItemInvoiceDao.update(sijiItem);
		}
//		if ("有".equals(kehuDO.getReceipt())||"预有".equals(kehuDO.getReceipt())){
//			return 0;
//		}

		int flag = SijiItemInvoiceDao.update(sijiItem);

		try {
			kehuDO.setTonnage(new BigDecimal(0));
			Map map = new HashMap();
			map.put("pid", sijiItem.getPid());
			List<SijiItemInvoiceDO> list = sijiItemService.list(map);
			for (SijiItemInvoiceDO SijiItemInvoiceDO : list) {
				kehuDO.setTonnage(kehuDO.getTonnage().add(SijiItemInvoiceDO.getTonnage())); //吨位
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
	public int removeAdmin(Long id){
		SijiItemInvoiceDO sijiItemInvoiceDO = SijiItemInvoiceDao.get(id);
		if (sijiItemInvoiceDO.getState()!=1){
			return -1 ;
		}

		int maxid = SijiItemInvoiceDao.getMaxId(id);
		if(maxid>0){
			SijiItemInvoiceDao.updateLastState(maxid);
		}

		int flag = SijiItemInvoiceDao.remove(id);
		return flag;
	}

	@Override
	public int remove(Long id){

		SijiItemInvoiceDO sijiItemInvoiceDO = SijiItemInvoiceDao.get(id);
		if (!DateUtils.getNowDate().equals(sijiItemInvoiceDO.getInputdate())){
			return -2 ;
		}
		int flag = this.removeAdmin(id);
		return flag;

	}

	@Override
	public int heDui(Long id){
		return SijiItemInvoiceDao.heDui(id);
	}

	@Override
	public int batchRemove(Long[] ids){
		return SijiItemInvoiceDao.batchRemove(ids);
	}

	@Override
	public List<Map> querySijiList(Map<String, Object> map) {

		return SijiItemInvoiceDao.querySijiList(map);
	}


	@Override
	public List<SijiItemInvoiceDO> getBilldateList(Map<String, Object> map) {

		return SijiItemInvoiceDao.getBilldateList(map);
	}







	@Override
	public SijiItemInvoiceDO getAminvoicefoById(String id) {

		Map map = new HashMap();
		map.put("id",id);
		SijiItemInvoiceDO SijiItemInvoiceDO = new SijiItemInvoiceDO();
		List<SijiItemInvoiceDO> list = SijiItemInvoiceDao.getAminvoicefoById(map);
		if (!list.isEmpty()){
			SijiItemInvoiceDO = list.get(0);
		}
		return SijiItemInvoiceDO;
	}


	@Override
	public SijiItemInvoiceDO getBillInfoByPid(String pid) {

		Map map = new HashMap();
		map.put("pid",pid);
		SijiItemInvoiceDO SijiItemInvoiceDO = new SijiItemInvoiceDO();
		List<SijiItemInvoiceDO> list = SijiItemInvoiceDao.getBilldateList(map);
		if (!list.isEmpty()){
			SijiItemInvoiceDO = list.get(0);
		}
		return SijiItemInvoiceDO;
	}


	@Override
	public void importExcel(List<SijiItemImp1> imp1s) {
		for (SijiItemImp1 imp1 : imp1s) {
			SijiItemInvoiceDO js = SijiItemInvoiceDao.get(imp1.getId());
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
				SijiItemInvoiceDao.update(js);


			}
		}
	}
	@Override
	public void importExcel2(List<SijiItemImp2> imp2s) {
		for (SijiItemImp2 imp2 : imp2s) {
			SijiItemInvoiceDO js = SijiItemInvoiceDao.get(imp2.getId());
			if (js != null && js.getAminvoice()!=null){
				//之前未导入或导入日期是当天，且本次付款方式不为空
				if ((js.getInputdate() == null
						||"".equals(js.getInputdate())
						||DateUtils.getNowDate().equals(js.getInputdate())) && imp2.getCustompay() != null) {
					js.setCustompay(imp2.getCustompay());
					js.setTaxdatepay(imp2.getTaxdatepay());
					js.setTakeamount(imp2.getTakeamount());
					js.setInputdate(DateUtils.getNowDate());
					SijiItemInvoiceDao.update(js);
				}

			}
		}
	}


}
