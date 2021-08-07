package com.bootdo.biz.service.impl;

import com.bootdo.biz.domain.SeatOrderDO;
import com.bootdo.biz.domain.SellerInfoDO;
import com.bootdo.biz.service.HxzService;
import com.bootdo.biz.service.SeatOrderService;
import com.bootdo.biz.service.SellerInfoService;
import com.bootdo.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class HxzServiceImpl implements HxzService {
	@Autowired
	private SeatOrderService seatOrderService;

	@Autowired
	private SellerInfoService sellerInfoService;



	@Override
	public SeatOrderDO consumTransactions(String orderNo, String cardNo) {
		Map map = new HashMap();
		map.put("orderNo", orderNo);
		List<SeatOrderDO> lists = seatOrderService.list(map);
		if (!lists.isEmpty()){
			return null; //已扣款
		}
		SeatOrderDO seatOrderDO = new SeatOrderDO();
		seatOrderDO.setOrderNo(orderNo);
		seatOrderDO.setBizDate(DateUtils.getNowDate());
		seatOrderDO.setPrice(new BigDecimal(2));
		seatOrderDO.setNum(new BigDecimal(1));
		seatOrderDO.setAmout(seatOrderDO.getNum().multiply(seatOrderDO.getPrice()));
		seatOrderDO.setCreateTime(new Date());
		seatOrderDO.setUpdateTime(new Date());

		SellerInfoDO sellerInfoDO = sellerInfoService.getByCardNo(cardNo);
		if (sellerInfoDO==null){
			seatOrderDO.setInfo("无效卡");
			seatOrderDO.setAmout(new BigDecimal(0));
			seatOrderDO.setRemark("未知");
			seatOrderDO.setState(26); //无效卡
			return seatOrderDO;
		}
		sellerInfoDO.setAmount(sellerInfoDO.getAmount().subtract(seatOrderDO.getAmout())); //扣款
		seatOrderDO.setCreateUser(sellerInfoDO.getSellerId());
		seatOrderDO.setState(1);

		seatOrderDO.setUserName(sellerInfoDO.getName());
		seatOrderDO.setUserMobile(sellerInfoDO.getMobile());
		seatOrderDO.setInfo(sellerInfoDO.getCardType()); //卡类型
		seatOrderDO.setRemark("余额:"+sellerInfoDO.getAmount());
//		seatOrderDO.setFromStation();
//		seatOrderDO.setToStation();

		if (sellerInfoDO.getAmount().intValue()<0){
			seatOrderDO.setRemark("余额:"+(sellerInfoDO.getAmount().add(seatOrderDO.getAmout())));
			seatOrderDO.setAmout(new BigDecimal(0));
			seatOrderDO.setState(25); //余额不足
			return seatOrderDO;
		}
		seatOrderService.save(seatOrderDO);
		sellerInfoService.update(sellerInfoDO);

		if ("学生卡".equals(seatOrderDO.getInfo())){
			seatOrderDO.setState(29); //学生卡
		} else if ("老年卡".equals(seatOrderDO.getInfo())){
			seatOrderDO.setState(30); //老年卡
		} else {
			seatOrderDO.setState(22); //谢谢
		}
		return seatOrderDO;
	}
}
