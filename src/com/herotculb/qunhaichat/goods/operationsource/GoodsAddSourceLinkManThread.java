package com.herotculb.qunhaichat.goods.operationsource;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.herotculb.qunhaichat.R;
import com.herotculb.qunhaichat.util.QNPermissionApiImpl;

public class GoodsAddSourceLinkManThread extends Thread {
	private Activity context;
	private String id;
	private Handler handler;
	
	public GoodsAddSourceLinkManThread(Activity context, String id,
			Handler handler) {
		super();
		this.context = context;
		this.id = id;
		this.handler = handler;
	}

	@Override
	public void run() {
		super.run();
		Looper.prepare();
		
//		BootstrapEditText idtext =(BootstrapEditText) context.findViewById(R.id.goods_add_linkman_id);
		BootstrapEditText nametext =(BootstrapEditText) context.findViewById(R.id.goods_add_linkman_name);
		BootstrapEditText phonetext =(BootstrapEditText) context.findViewById(R.id.goods_add_linkman_phone);
		BootstrapEditText birthdaytext =(BootstrapEditText) context.findViewById(R.id.goods_add_linkman_birthday);
		
//		String id = idtext.getText().toString();
		String linkname = nametext.getText().toString();
		String phone = phonetext.getText().toString();
		String linkManBirthday = birthdaytext.getText().toString();
				
		QNPermissionApiImpl qnpAPi=new QNPermissionApiImpl(context);
		List<Map<String, Object>> list=qnpAPi.addGoodSourceLinkMan(id, linkManBirthday, linkname, phone);
		Map<String,Object> map=list.iterator().next();
		Message sendmsg = Message.obtain();  
        sendmsg.obj = map;   //利用Message.obj把子线程的handle传递给主线程。  
        handler.sendMessage(sendmsg);  
	}
	
}
