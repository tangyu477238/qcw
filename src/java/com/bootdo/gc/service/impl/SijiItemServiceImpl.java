package com.bootdo.gc.service.impl;

import com.bootdo.common.utils.DateUtils;
import com.bootdo.gc.dao.KehuDao;
import com.bootdo.gc.dao.SijiDao;
import com.bootdo.gc.domain.*;
import com.bootdo.gc.service.SijiService;
import org.joda.time.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.gc.dao.SijiItemDao;
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


		SijiDO sijiDO = sijiDao.getPid(sijiItem.getPid());

		KehuDO kehuDO = kehuDao.getOrder(sijiDO.getOrderNo());
		if (kehuDO==null){
			return sijiItemDao.update(sijiItem);
		}
		if ("有".equals(kehuDO.getReceipt())||"预有".equals(kehuDO.getReceipt())){
			return 0;
		}

		int flag = sijiItemDao.update(sijiItem);

		try {
			kehuDO.setTonnage(new BigDecimal(0));
			Map map = new HashMap();
			map.put("pid", sijiItem.getPid());
			List<SijiItemDO> list = sijiItemService.list(map);
			for (SijiItemDO sijiItemDO : list) {
				kehuDO.setTonnage(kehuDO.getTonnage().add(sijiItemDO.getTonnage())); //吨位
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
	public int remove(Long id){

		SijiItemDO sijiItem = this.get(id);
		if (sijiItem==null){
			return sijiItemDao.remove(id);
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


         try {
             kehuDO.setTonnage(new BigDecimal(0));
             Map map = new HashMap();
             map.put("pid", sijiItem.getPid());
             List<SijiItemDO> list = sijiItemService.list(map);
             for (SijiItemDO sijiItemDO : list) {
                 kehuDO.setTonnage(kehuDO.getTonnage().add(sijiItemDO.getTonnage())); //吨位
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




	@Override
	public void importExcel(List<SijiItemImp1> imp1s) {
		for (SijiItemImp1 imp1 : imp1s) {
			SijiItemDO js = sijiItemDao.get(imp1.getId());
			if (js!=null){
				//交单日期之前未填写，并本次有填写
				if (js.getBilldate()==null && imp1.getBilldate()!=null){
					js.setBilldate(imp1.getBilldate());
					js.setKouling(imp1.getKouling());
					js.setAminvoice(js.getTrancost().subtract(js.getKouling())); //结算金额=运费-扣减金额
				}

				js.setIssueoffice(imp1.getIssueoffice());
				js.setIssueofficedate(imp1.getIssueofficedate());
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
				//之前未导入，且本次付款方式不为空
				if (js.getCustompay() == null && imp2.getCustompay() != null) {
					js.setCustompay(imp2.getCustompay());
					js.setTaxdatepay(imp2.getTaxdatepay());
					js.setTakeamount(imp2.getTakeamount());
					sijiItemDao.update(js);
				}

			}
		}
	}


}
