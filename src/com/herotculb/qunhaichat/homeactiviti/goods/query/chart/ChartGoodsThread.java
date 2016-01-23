package com.herotculb.qunhaichat.homeactiviti.goods.query.chart;

import java.util.List;
import java.util.Map;

import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class ChartGoodsThread extends Thread{
	private Context context;
	private Handler handler;
	private String id,endDate,startDate;
	private int type;
	public static final int TYPE_SALER=1;//销售统计
	public static final int TYPE_INGOOD=2;//进货统计
	public static final int TYPE_PRICE=3;//价格趋势
	public static final int TYPE_NUM=4;//仓库存放量
	public ChartGoodsThread(Context context,Handler handler,int type,String id,String startDate,String endDate){
		this.id=id;
		this.type=type;
		this.handler=handler;
		this.context=context;
		this.endDate=endDate;
		this.startDate=startDate;
	}
	@Override
	public void run() {
		Looper.prepare();
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=null;
		switch (type) {
		case TYPE_SALER:
			list=qnpAPi.querySaleChat(startDate, endDate, id);
			break;
		case TYPE_INGOOD:
			list=qnpAPi.queryInGoods(startDate, endDate, id);
					break;
		case TYPE_PRICE:
			list=qnpAPi.priceChar(startDate, endDate, id);
			break;
		case TYPE_NUM:
			list=qnpAPi.queryStoreHouseChat(id);
			break;
		default:
			break;
		}
		
		Map<String,Object> map=list.iterator().next();
		boolean b=(Boolean) map.get("success");
		if(b){
			Message sendmsg = Message.obtain();
            sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
            handler.sendMessage(sendmsg); 
		}else{
			//获取数据失败
			Message sendmsg = Message.obtain();  
            sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
            handler.sendMessage(sendmsg);  
		}
	}
}
