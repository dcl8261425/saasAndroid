package com.herotculb.qunhaichat.homeactiviti.weixin.goods;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class WeiXinGoodsAddThread extends Thread{
	private Context context;
	private Handler handler;
	private String name,type,model,tiaoma,price,inprice,score,pinyin,image1,image2,image3,image4;
	public WeiXinGoodsAddThread(Context context,Handler handler,String name,String type,String model,String tiaoma,String price,String inprice,String score,String pinyin,String image1,String image2,String image3,String image4) {
		super();
		this.context = context;
		this.handler = handler;
		this.name=name;
		this.type=type;
		this.model=model;
		this.tiaoma=tiaoma;
		this.price=price;
		this.inprice=inprice;
		this.score=score;
		this.pinyin=pinyin;
		this.image1=image1;
		this.image2=image2;
		this.image3=image3;
		this.image4=image4;
	}
	@Override
	public void run() {
		Looper.prepare();
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.add(name, type, price, inprice, score, pinyin, model,tiaoma,image1,image2,image3,image4);
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
